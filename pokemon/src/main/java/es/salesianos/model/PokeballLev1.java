package es.salesianos.model;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

//Pokeball normal

@Component
@Profile("nivel1")
public class PokeballLev1 extends AbstractPokeball {

	public PokeballLev1() {
		name = "Pokeball";
		cantidad = 2;
		probabilidad = 25;
	}
}
