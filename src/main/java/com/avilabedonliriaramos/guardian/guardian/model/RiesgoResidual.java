package com.avilabedonliriaramos.guardian.guardian.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
public class RiesgoResidual {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Vulnerabilidad vulnerabilidad;
	
	@OneToOne(fetch = FetchType.LAZY)
	@DescriptionsList
	private Responsable responsable;
	
	private String tolerancia;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Control nuevoControl;
	
	private int riesgoResidual;
	
	private String nuevoNivelRiesgo;
}
