package es.salesianos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Ash;
import es.salesianos.model.Equipo;
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
		addRival();
		modelAndView.addObject("ash", this.ash);
		modelAndView.addObject("rival", rival);
		return modelAndView;
	}

	@PostMapping("insert")
	public ModelAndView personInsert(Ash ashForm) {
		ModelAndView modelAndView = new ModelAndView("index");
		addPokemons(ashForm);
		modelAndView.addObject("ash", ash);
		modelAndView.addObject("rival", rival);
		return modelAndView;
	}

	private void addPokemons(Ash ashForm) {

		// Si no hay nombre guardado en el trasto de Ash se mete el que se haya
		// introducido

		if (!StringUtils.isEmpty(ashForm.getName())) {
			ash.setName(ashForm.getName());
		}

		Pokemon pok = new Pokemon();
		List<Pokemon> pokes = new ArrayList<Pokemon>();

		// Si el pokemon tiene vida 0 no lo puedes añadir
		// if (!StringUtils.isEmpty(ashForm.getPokemonAux()) &&
		// ashForm.getPokemonAux().isAlive()) {

//		if (!StringUtils.isEmpty(ashForm.getPokemon()) && ashForm.getPokemon().isAlive()) {
//			if (!StringUtils.isEmpty(ashForm.getPokemon())) {
//				if (ash.getEquipo().getPokemon() != null) {
//					pokes = ash.getEquipo().getPokemon();
//				}
//				pok.setName(ashForm.getPokemon().getName());
//				pok.setVida(ashForm.getPokemon().getVida());
//				pok.setAtaque(ashForm.getPokemon().getAtaque());
//				pok.setDefensa(ashForm.getPokemon().getDefensa());
//
//				if (ash.getEquipo().getPokemon() == null
//						|| ash.getEquipo().getPokemon().size() < ash.getEquipo().getCapacidad()) {
//					System.out.println(ashForm.getPokemon().getVida());
//					pokes.add(pok);
//					ash.getEquipo().setPokemon(pokes);
//				} else {
//					ash.getEquipo().setLimite("No puedes capturar más pokemons");
//				}
//			}
//		}
		// Añadir porcentaje de probabilidad de captura segun la pokeball
		// Si la lista de pokemon estaba vacia SOLO se carga el main, no la lista de
		// pokemons

		if (!StringUtils.isEmpty(ashForm.getPokemon()) && ashForm.getPokemon().isAlive()
				&& ash.getPokeball().getCantidad() > 0) {
			ash.getEquipo().setEstado("");

			// if (ash.getPokeball().calcularProb()) {
			if (ash.getEquipo().getPokemon() != null) {
				pokes = ash.getEquipo().getPokemon();
			}
			pok.setName(ashForm.getPokemon().getName());
			pok.setVida(ashForm.getPokemon().getVida());
			pok.setAtaque(ashForm.getPokemon().getAtaque());
			pok.setDefensa(ashForm.getPokemon().getDefensa());

			if (ash.getEquipo().getMain() == null) {
				pok.setId("1");
				ash.getEquipo().setMain(pok);
				ash.getPokeball().setCantidad(ash.getPokeball().getCantidad() - 1);
			} else if (ash.getEquipo().getPokemon() == null) {
				pok.setId("2");
				pokes.add(pok);
				ash.getEquipo().setPokemon(pokes);
				ash.getPokeball().setCantidad(ash.getPokeball().getCantidad() - 1);
			}

			// si hay main y hay pokemons en el equipo
			else {
				pok.setId((String.valueOf(ash.getEquipo().getPokemon().size() + 2))); // size()+1
				System.out.println(pok.getId());
				pokes.add(pok);
				ash.getEquipo().setPokemon(pokes);
				ash.getPokeball().setCantidad(ash.getPokeball().getCantidad() - 1);
			}

			// }
//			else {
//				ash.getEquipo().setEstado("El pokemon " + ashForm.getPokemon().getName() + " se ha escapado");
//			}

		} else if (ash.getPokeball().getCantidad() == 0) {
			ash.getEquipo().setEstado("No te quedan " + ash.getPokeball().getName());
		}
	}

	private void addRival() {
		rival.setName("Chorizo");
		System.out.println("RIVAL " + rival.getName() + " " + rival.getAtaque() + " " + rival.getDefensa() + " "
				+ rival.getVida());
//		rival.setVida(99);
//		rival.setAtaque(10);
//		rival.setDefensa(20);

		// ash.setRival(rival);
	}

	@PostMapping("combate")
	public ModelAndView combate() {
		ModelAndView modelAndView = new ModelAndView("index");

		// COMBATIR EQUIPO
//		List<Pokemon> equipo;
//		List<Pokemon> debilitados = new ArrayList<Pokemon>();

//		if (!StringUtils.isEmpty(ash.getPokemon())) {
//			System.out.println("HABIA pokemon");
//			rival = ash.getRival();
//			equipo = ash.getPokemon();
//
//			combatir(rival, equipo, debilitados);
//		}

		List<Pokemon> debilitados = new ArrayList<Pokemon>();

		if (ash.getEquipo().getPokemonDeb() != null) {
			debilitados = ash.getEquipo().getPokemonDeb();
		}

		// COMBATIR MAIN Y RIVAL
		combatir(rival, ash.getEquipo(), debilitados);

		modelAndView.addObject("ash", ash);
		modelAndView.addObject("rival", rival);
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

	@PostMapping("changeMain{id}")
	// En el index.jsp el id es el id de Pokemon
	public ModelAndView changeMain(@PathVariable("id") String id) {
		ModelAndView modelAndView = new ModelAndView("index");

		modelAndView.addObject("ash", ash);
		modelAndView.addObject("rival", rival);

		List<Pokemon> pokEquipo = ash.getEquipo().getPokemon();
		Pokemon newMain = new Pokemon();

		System.out.println("tamaño equipo " + pokEquipo.size());

		System.out.println("oldmain " + ash.getEquipo().getMain().getId());

		for (Pokemon pok : pokEquipo) {
			System.out.println(id + " pokactual " + pok.getId());
			if (pok.getId().equals(id)) {
				newMain = pok;

//				pokEquipo.add(ash.getEquipo().getMain());
//				ash.getEquipo().setMain(newMain);
//				pokEquipo.remove(pok);
			}
		}

		pokEquipo.add(ash.getEquipo().getMain());
		ash.getEquipo().setMain(newMain);
		pokEquipo.remove(newMain);

		ash.getEquipo().setPokemon(pokEquipo);

		System.out.println("newmain " + ash.getEquipo().getMain().getId());

		return modelAndView;
	}

	private void capturePokemon(Ash ashForm) {

		Pokemon pok = new Pokemon();
		List<Pokemon> pokes = new ArrayList<Pokemon>();

		// Si el pokemon tiene vida 0 no lo puedes añadir
		// if (!StringUtils.isEmpty(ashForm.getPokemonAux()) &&
		// ashForm.getPokemonAux().isAlive()) {

//		if (!StringUtils.isEmpty(ashForm.getPokemonCapt())) {
//			pok.setName(ashForm.getPokemonCapt().getName());
//			pok.setVida(ashForm.getPokemonCapt().getVida());
//			pok.setAtaque(ashForm.getPokemonAux().getAtaque());
//			pok.setDefensa(ashForm.getPokemonAux().getDefensa());
//
//			if (ash.getPokemon() != null) {
//				pokes = ash.getPokemon();
//			}
//			if (ash.getPokemon() == null || ash.getPokemon().size() < ash.getMaxPokes()) {
//				System.out.println(ashForm.getPokemonAux().getVida());
//				pokes.add(pok);
//				ash.setPokemon(pokes);
//			} else {
//				ash.setLimite("No puedes capturar más pokemons");
//			}
//		}
	}

	private void combatir(Rival rival, Equipo equipo, List<Pokemon> deb) {
		Pokemon main = equipo.getMain(); // equipo de ash

		System.out.println("vida del main " + main.getName() + " " + main.getVida());
		System.out.println("vida del rival " + rival.getName() + " " + rival.getVida());
		System.out.println("------------");

		if (main.isAlive() & main.getAtaque() >= rival.getDefensa()) {
			rival.setVida(rival.getVida() - main.getAtaque());
		}

		if (main.isAlive() && rival.getAtaque() >= main.getDefensa()) {
			main.setVida(main.getVida() - rival.getAtaque());
		}

		if (!main.isAlive()) {
			System.out.println("debilitado " + main.getName() + " " + main.getVida());
			deb.add(main);
			rival.setEstado("Pokemon " + main.getName() + " debilitado!");
			// coger el siguiente pokemon del equipo SI HAY MAS y meterlo a main
			// si no hay mas pues GAME OVER
			// si hay mas pokemons se coge el primero
			if (equipo.getPokemon() != null & equipo.getPokemon().size() != 0) {
				// ash.getEquipo().setMain(equipo.getPokemon().get(0));
				main = equipo.getPokemon().get(0);
				equipo.setMain(main);
				// main = equipo.getPokemon().get(0);
				rival.setEstado("Pokemon " + main.getName() + " ha salido al combate!");
				equipo.getPokemon().remove(0);
				System.out.println("cambio de main " + main.getId());
			} else {
				equipo.setMain(new Pokemon());
				rival.setEstado("Todos tus pokemons se han debilitado");
			}
		}

		if (!rival.isAlive()) {
			rival.setEstado("Has ganado el combate contra " + rival.getName());
		}

		ash.getEquipo().setPokemonDeb(deb);
	}

	// Combatir UN EQUIPO
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

//		ash.setPokemonDeb(debilitados);

		System.out.println(hpEquipo + "   " + rival.getEstado());
	}
}
