package es.salesianos.model;

public interface Pokeball {

	int getProbabilidad();

	String getName();

	void setName(String string);

	int getCantidad();

	void setCantidad(int i);

	boolean calcularProb();

}
