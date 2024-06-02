package com.avilabedonliriaramos.guardian.guardian.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
public class Activo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Required
	private String nombre;
	
	@Required
	private String identificador;
	
	@Required
	private String descripcion;
	
	@Required
	private String tipo;
	
	private String proceso;
	
	private String ubicacion;
	
	private int valorSeguridad;
	
	private int valorPrivacidad;
	
	private int valorReputacion;
	
	private int valorLegal;
	
	private int valorOperaciones;
	
	private int valorEconomico;
	
	private String clasificacion;
	
	@OneToOne(fetch = FetchType.LAZY)
	@DescriptionsList
	private Responsable responsable;
}
