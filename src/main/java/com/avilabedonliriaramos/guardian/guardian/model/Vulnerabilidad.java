package com.avilabedonliriaramos.guardian.guardian.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
public class Vulnerabilidad {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Hidden
	private Long id;
	
	private String riesgoInherente;
	
	private int valorRiesgo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Amenaza amenaza;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Control controlAplicado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Activo activo;
	
	private int nivelVulnerabilidad;
	
	private int nivelAmenaza;
}
