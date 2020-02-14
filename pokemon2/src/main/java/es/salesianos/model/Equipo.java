package es.salesianos.model;

import java.util.List;

public interface Equipo {

	int getCapacidad();

	void setCapacidad(int capacidad);

	List<Pokemon> getPokemon();

	void setPokemon(List<Pokemon> pokemon);

	List<Pokemon> getPokemonDeb();

	void setPokemonDeb(List<Pokemon> pokemonDeb);

	String getEstado();

	void setEstado(String limite);

	Pokemon getMain();

	void setMain(Pokemon main);

}
