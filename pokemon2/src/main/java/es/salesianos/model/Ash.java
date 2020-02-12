package es.salesianos.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Ash {

	@Autowired
	private Equipo equipo;

	private Rival rival;
	private String name;
	private Pokemon pokemon;
//	private Rival rival;
	// Ash tiene un equipo que tiene una lista de pokemon??
	// private Equipo equipo;

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
