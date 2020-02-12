package es.salesianos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Ash;
import es.salesianos.model.Pokeball;
import es.salesianos.model.Pokemon;
import es.salesianos.model.Rival;

@Controller
public class IndexController {

	@Autowired
	private Ash ash;

	@Autowired
	private Pokeball pokeball;

	@Autowired
	private Rival rival;

	// El autowired tiene que ser Pokemon capturar o algo asi
	// El autowired es Pokemon pokemon, tiene que haber un Pokemon rival¿?
	// Y un Pokemon capturar??? / una lista de 6 pokemon para capturar y que luego
	// no haya mas???

	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("ash", this.ash);
		return modelAndView;
	}

	@PostMapping("insert")
	public ModelAndView personInsert(Ash ashForm) {
		ModelAndView modelAndView = new ModelAndView("index");
		addPokemons(ashForm);
		addPokeball();
		addRival();
		modelAndView.addObject("ash", ash);
		return modelAndView;
	}

	private void addPokeball() {
		ash.setMaxPokeball(pokeball.getCantidad());
		ash.setPokeball(pokeball);
	}

	private void addPokemons(Ash ashForm) {

		// Si no hay nombre guardado en el trasto de Ash se mete el que se haya
		// introducido

		if (!StringUtils.isEmpty(ashForm.getName())) {
			ash.setName(ashForm.getName());
		}

		// poner que max se pueden tener 6 pokemones en el equipo (ash.maxPokes)
		// poner otra columna donde los pokemon VIVO / DEBILITADO boolean
		Pokemon pok = new Pokemon();
		List<Pokemon> pokes = new ArrayList<Pokemon>();

		// Si el pokemon tiene vida 0 no lo puedes añadir
		// if (!StringUtils.isEmpty(ashForm.getPokemonAux()) &&
		// ashForm.getPokemonAux().isAlive()) {
		if (!StringUtils.isEmpty(ashForm.getPokemonAux())) {
			if (ash.getPokemon() != null) {
				pokes = ash.getPokemon();
			}
			pok.setName(ashForm.getPokemonAux().getName());
			pok.setVida(ashForm.getPokemonAux().getVida());
			pok.setAtaque(ashForm.getPokemonAux().getAtaque());
			pok.setDefensa(ashForm.getPokemonAux().getDefensa());

			if (ash.getPokemon() == null || ash.getPokemon().size() < ash.getMaxPokes()) {
				System.out.println(ashForm.getPokemonAux().getVida());
				pokes.add(pok);
				ash.setPokemon(pokes);
			} else {
				ash.setLimite("No puedes capturar más pokemons");
			}
		}
	}

	private void addRival() {
		rival.setName("Chorizo");
//		rival.setVida(99);
//		rival.setAtaque(10);
//		rival.setDefensa(20);

		ash.setRival(rival);
	}

	@PostMapping("combate")
	public ModelAndView combate() {
		ModelAndView modelAndView = new ModelAndView("index");
		List<Pokemon> equipo;
		List<Pokemon> debilitados = new ArrayList<Pokemon>();

		if (!StringUtils.isEmpty(ash.getPokemon())) {
			System.out.println("HABIA pokemon");
			rival = ash.getRival();
			equipo = ash.getPokemon();

			combatir(rival, equipo, debilitados);
		}

		modelAndView.addObject("ash", ash);
		System.out.println("combatiendo");
		return modelAndView;
	}

	@PostMapping("capturar")
	public ModelAndView pokCaptura(Ash ashForm) {
		ModelAndView modelAndView = new ModelAndView("index");
		// capturePokemon(ashForm);
		modelAndView.addObject("ash", ash);
		return null;
	}

	private void capturePokemon(Ash ashForm) {

		Pokemon pok = new Pokemon();
		List<Pokemon> pokes = new ArrayList<Pokemon>();

		// Si el pokemon tiene vida 0 no lo puedes añadir
		// if (!StringUtils.isEmpty(ashForm.getPokemonAux()) &&
		// ashForm.getPokemonAux().isAlive()) {

		if (!StringUtils.isEmpty(ashForm.getPokemonCapt())) {
			pok.setName(ashForm.getPokemonCapt().getName());
			pok.setVida(ashForm.getPokemonCapt().getVida());
			pok.setAtaque(ashForm.getPokemonAux().getAtaque());
			pok.setDefensa(ashForm.getPokemonAux().getDefensa());

			if (ash.getPokemon() != null) {
				pokes = ash.getPokemon();
			}
			if (ash.getPokemon() == null || ash.getPokemon().size() < ash.getMaxPokes()) {
				System.out.println(ashForm.getPokemonAux().getVida());
				pokes.add(pok);
				ash.setPokemon(pokes);
			} else {
				ash.setLimite("No puedes capturar más pokemons");
			}
		}
	}

	private void combatir(Rival rival, List<Pokemon> equipo, List<Pokemon> debilitados) {
		int hpEquipo = 0;
		int atEquipo = 0;

		for (Pokemon pok : equipo) {
			System.out.println("vida del pokemon " + pok.getName() + "  " + pok.getVida());
			hpEquipo += pok.getVida();
			atEquipo += pok.getAtaque();

			if (pok.isAlive() & rival.getAtaque() >= pok.getDefensa()) {
				pok.setVida(pok.getVida() - rival.getAtaque());
				hpEquipo -= rival.getAtaque();
			}

			if (!pok.isAlive()) {
				System.out.println("debilitado " + pok.getName() + " " + pok.getVida());
				debilitados.add(pok);
			}
		}

		if (rival.isAlive() & atEquipo >= rival.getDefensa()) {
			rival.setVida(rival.getVida() - atEquipo);
		}

		if (hpEquipo <= 0) {
			rival.setEstado("Tu equipo ha perdido contra " + rival.getName());
		}
		if (!rival.isAlive()) {
			rival.setEstado("Tu equipo ha ganado contra " + rival.getName());
		}

		for (Pokemon pok : debilitados) {
			System.out.println("eliminado " + pok.getName() + " " + pok.getVida());
			equipo.remove(pok);
		}

		ash.setPokemonDeb(debilitados);

		System.out.println(hpEquipo + "   " + rival.getEstado());
	}
}
