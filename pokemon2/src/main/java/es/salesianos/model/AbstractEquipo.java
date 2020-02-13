package es.salesianos.model;

import java.util.List;

public class AbstractEquipo implements Equipo {
	public int capacidad;
	public Pokemon main;
	public List<Pokemon> pokemon;
	public List<Pokemon> pokemonDeb;
	private String limite = "";

	public Pokemon getMain() {
		return main;
	}

	public void setMain(Pokemon main) {
		this.main = main;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public List<Pokemon> getPokemon() {
		return pokemon;
	}

	public void setPokemon(List<Pokemon> pokemon) {
		this.pokemon = pokemon;
	}

	public List<Pokemon> getPokemonDeb() {
		return pokemonDeb;
	}

	public void setPokemonDeb(List<Pokemon> pokemonDeb) {
		this.pokemonDeb = pokemonDeb;
	}

	public String getLimite() {
		return limite;
	}

	public void setLimite(String limite) {
		this.limite = limite;
	}

}
