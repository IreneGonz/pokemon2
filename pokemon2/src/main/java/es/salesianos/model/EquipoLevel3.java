package es.salesianos.model;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("nivel3")
public class EquipoLevel3 extends AbstractEquipo {

	public EquipoLevel3() {
		capacidad = 6;
	}
}
