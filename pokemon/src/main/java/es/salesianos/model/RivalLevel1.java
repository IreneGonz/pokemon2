package es.salesianos.model;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("nivel1")
public class RivalLevel1 extends AbstractRival {

	public RivalLevel1() {
		vida = (int) (Math.random() * 10) + 1;
		ataque = (int) (Math.random() * 10) + 1;
		defensa = (int) (Math.random() * 10) + 1;
	}

}
