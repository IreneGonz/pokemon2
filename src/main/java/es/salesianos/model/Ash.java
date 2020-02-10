package es.salesianos.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Ash {

	private Pokemon pokemonAux;
	private Pokemon pokemonCapt;
	private List<Pokemon> pokemon;
	private List<Pokemon> pokemonDeb;
	private String name;
	private int maxPokes = 6;
	private Pokeball pokeball;
	private int maxPokeball;
	private String limite = "";

	public Pokeball getPokeball() {
		return pokeball;
	}

	public void setPokeball(Pokeball pokeball) {
		this.pokeball = pokeball;
	}

	public int getMaxPokeball() {
		return maxPokeball;
	}

	public void setMaxPokeball(int maxPokeball) {
		this.maxPokeball = maxPokeball;
	}

	public Pokemon getPokemonCapt() {
		return pokemonCapt;
	}

	public void setPokemonCapt(Pokemon pokemonCapt) {
		this.pokemonCapt = pokemonCapt;
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

	public int getMaxPokes() {
		return maxPokes;
	}

	private Rival rival;
//	private String maxPokes;

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
