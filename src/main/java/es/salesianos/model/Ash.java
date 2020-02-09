package es.salesianos.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Ash {

	private Pokemon pokemonAux;
	private List<Pokemon> pokemon;
	private String name;
//	private int maxPokes;
	private Rival rival;
	private String maxPokes;

	public String getMaxPokes() {
		return maxPokes;
	}

	public void setMaxPokes(String maxPokes) {
		this.maxPokes = maxPokes;
	}

	public Rival getRival() {
		return rival;
	}

	public void setRival(Rival rival) {
		this.rival = rival;
	}

	public Pokemon getPokemonAux() {
		return pokemonAux;
	}

	public void setPokemonAux(Pokemon pokemonAux) {
		this.pokemonAux = pokemonAux;
	}

	public List<Pokemon> getPokemon() {
		return pokemon;
	}

	public void setPokemon(List<Pokemon> pokemon) {
		this.pokemon = pokemon;
	}

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
