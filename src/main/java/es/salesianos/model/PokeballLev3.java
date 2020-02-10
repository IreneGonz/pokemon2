package es.salesianos.model;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

//Masterball

@Component
@Profile("nivel3")
public class PokeballLev3 extends AbstractPokeball {

	public PokeballLev3() {
		name = "Masterball";
		cantidad = 6;
		probabilidad = 100;
	}
}
