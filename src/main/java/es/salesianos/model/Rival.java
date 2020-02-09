package es.salesianos.model;

public interface Rival {

	void setName(String string);

	void setVida(int i);

	void setAtaque(int i);

	void setDefensa(int i);

	int getAtaque();

	int getDefensa();

	int getVida();

	boolean isAlive();

	String getName();

	void setEstado(String string);

	String getEstado();

}
