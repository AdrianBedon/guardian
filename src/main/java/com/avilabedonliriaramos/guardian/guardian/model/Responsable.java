package com.avilabedonliriaramos.guardian.guardian.model;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
public class Responsable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Hidden
	private Long id;
	
	@Required
	@Pattern(regexp = "[A-Za-zÁÉÍÓÚáéíóúñÑ ]+", message = "El nombre solo debe contener letras y espacios")
	@Size(min = 1, max = 50, message = "El nombre debe tener entre 1 y 50 caracteres")
	private String nombre;
	
	@Required
	@Pattern(regexp = "[A-Za-zÁÉÍÓÚáéíóúñÑ ]+", message = "La posición solo debe contener letras y espacios")
	@Size(min = 1, max = 50, message = "La posición debe tener entre 1 y 50 caracteres")
	private String posicion;
	
	@Required
	@Email(message = "Debe proporcionar un correo electrónico válido")
	@Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", message = "Debe proporcionar un correo electrónico válido")
	private String email;
}
