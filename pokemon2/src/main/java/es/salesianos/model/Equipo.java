package es.salesianos.model;

import java.util.List;

public interface Equipo {

	int getCapacidad();

	void setCapacidad(int capacidad);

	List<Pokemon> getPokemon();

	void setPokemon(List<Pokemon> pokemon);

	List<Pokemon> getPokemonDeb();

	void setPokemonDeb(List<Pokemon> pokemonDeb);

	String getLimite();

	void setLimite(String limite);

}
