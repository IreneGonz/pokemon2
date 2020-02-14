package es.salesianos.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Ash {

	@Autowired
	private Equipo equipo;

	@Autowired
	private Pokeball pokeball;

	private Rival rival;
	private String name;
	private Pokemon pokemon;

	public Pokeball getPokeball() {
		return pokeball;
	}

	public void setPokeball(Pokeball pokeball) {
		this.pokeball = pokeball;
	}

	public Rival getRival() {
		return rival;
	}

	public void setRival(Rival rival) {
		this.rival = rival;
	}

	public Pokemon getPokemon() {
		return pokemon;
	}

	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

//	private String maxPokes;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public int getMaxPokes() {
//		return maxPokes;
//	}
//
//	public void setMaxPokes(int maxPokes) {
//		this.maxPokes = maxPokes;
//	}

}
