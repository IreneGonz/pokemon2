package es.salesianos.model;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("nivel2")
public class EquipoLevel2 extends AbstractEquipo {

	public EquipoLevel2() {
		capacidad = 4;
	}
}
