package es.salesianos.model;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("nivel2")
public class RivalLevel2 extends AbstractRival {

	public RivalLevel2() {
		vida = (int) (Math.random() * 50) + 1;
		ataque = (int) (Math.random() * 50) + 1;
		defensa = (int) (Math.random() * 50) + 1;
	}
}
