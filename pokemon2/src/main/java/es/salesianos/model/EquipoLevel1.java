package es.salesianos.model;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("nivel1")
public class EquipoLevel1 extends AbstractEquipo {

	public EquipoLevel1() {
		capacidad = 2;
	}

}
