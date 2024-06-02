package com.avilabedonliriaramos.guardian.guardian.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
public class Amenaza {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Required
	private String codigo;
	
	private String tipo;
	
	private Boolean talentoHumano;
	
	private Boolean redes;
	
	private Boolean software;
	
	private Boolean hardware;
	
	private String origen;
}
