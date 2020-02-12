package es.salesianos.model;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

//Superball

@Component
@Profile("nivel2")
public class PokeballLev2 extends AbstractPokeball {

	public PokeballLev2() {
		name = "Superball";
		cantidad = 4;
		probabilidad = 50;
	}
}
