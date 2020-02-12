package es.salesianos.model;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("nivel3")
public class RivalLevel3 extends AbstractRival {

	public RivalLevel3() {
		vida = (int) (Math.random() * 100) + 1;
		ataque = (int) (Math.random() * 100) + 1;
		defensa = (int) (Math.random() * 100) + 1;
	}
}
