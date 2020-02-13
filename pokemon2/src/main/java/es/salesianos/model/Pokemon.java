package es.salesianos.model;

import org.springframework.stereotype.Component;

@Component
public class Pokemon {
	private String name;
	private int vida;
	private int ataque;
	private int defensa;
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public boolean isAlive() {
		if (vida > 0) {
			return true;
		} else {
			this.setVida(0);
			return false;
		}
	}
}
