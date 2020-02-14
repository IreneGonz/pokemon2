package es.salesianos.model;

public abstract class AbstractPokeball implements Pokeball {

	public String name;
	public int cantidad;
	public int probabilidad;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getProbabilidad() {
		return probabilidad;
	}

	public void setProbabilidad(int probabilidad) {
		this.probabilidad = probabilidad;
	}

	public boolean calcularProb() {
		int i = (int) (Math.random() * 100) + 1;
		// if (probabilidad >= (int) (Math.random() * 100) + 1) {
		if (probabilidad >= i) {
			System.out.println(probabilidad + " " + i);
			return true;
		} else {
			System.out.println(probabilidad + " " + i);
			return false;
		}
	}

}
