package com.avilabedonliriaramos.guardian.guardian.model;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;

import com.avilabedonliriaramos.guardian.guardian.enums.*;

import lombok.*;

@Entity
@Getter @Setter
public class Control {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Hidden
	private Long id;
	
	@Required
	@Pattern(regexp = "[A-Z]{3}[0-9]{3}", message = "El código debe seguir el formato XXX123")
	@Size(min = 6, max = 6, message = "El código debe tener exactamente 6 caracteres")
	private String codigo;
	
	@Required
	@Enumerated(EnumType.ORDINAL)
	private Eficiencia eficiencia;
	
	@Required
	@Pattern(regexp = "[A-Za-zÁÉÍÓÚáéíóúñÑ ]+", message = "Las acciones solo deben contener letras y espacios")
	private String acciones;
	
	@Required
	@Pattern(regexp = "[A-Za-zÁÉÍÓÚáéíóúñÑ ]+", message = "La definición solo debe contener letras y espacios")
	private String definicion;
	
	@Required
	@Enumerated(EnumType.STRING)
	private Proposito proposito;
	
	@Required
	@Enumerated(EnumType.STRING)
	private Periodicidad periodicidad;
	
	@Required
	@OneToOne(fetch = FetchType.LAZY)
	@DescriptionsList
	private Responsable responsable;
	
	
}
