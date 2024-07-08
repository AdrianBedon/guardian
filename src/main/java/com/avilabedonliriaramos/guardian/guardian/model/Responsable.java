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
	@Pattern(regexp = "[A-Za-z]+", message = "El nombre solo debe contener letras")
	@Size(min = 1, max = 50, message = "El nombre debe tener entre 1 y 50 caracteres")
	private String nombre;
	
	@Required
	@Pattern(regexp = "[A-Za-z]+", message = "La posici�n solo debe contener letras")
	@Size(min = 1, max = 50, message = "La posici�n debe tener entre 1 y 50 caracteres")
	private String posicion;
	
	@Required
	@Email(message = "Debe proporcionar un correo electr�nico v�lido")
	@Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{4,}$", message = "Debe proporcionar un correo electr�nico v�lido")
	private String email;
}
