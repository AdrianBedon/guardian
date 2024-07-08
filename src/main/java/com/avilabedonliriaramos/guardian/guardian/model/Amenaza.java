package com.avilabedonliriaramos.guardian.guardian.model;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
public class Amenaza {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Hidden
	private Long id;
	
	@Required
	@Pattern(regexp = "[A-Z]{4}-[0-9]{3}", message = "El código debe seguir el formato XXXX-123")
	@Size(min = 8, max = 8, message = "El código debe tener exactamente 8 caracteres")
	private String codigo;
	
	@Required
	@Pattern(regexp = "[A-Za-z]+", message = "El tipo solo debe contener letras")
	@Size(min = 1, max = 50, message = "El tipo debe tener entre 1 y 50 caracteres")
	private String tipo;
	
	private Boolean talentoHumano;
	
	private Boolean redes;
	
	private Boolean software;
	
	private Boolean hardware;
	
	@Required
	@Pattern(regexp = "[A-Za-z]+", message = "El origen solo debe contener letras")
	@Size(min = 1, max = 50, message = "El tipo debe tener entre 1 y 50 caracteres")
	private String origen;
}
