package com.avilabedonliriaramos.guardian.guardian.model;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;

import com.avilabedonliriaramos.guardian.guardian.enums.*;

import lombok.*;

@Entity
@Getter @Setter
public class Activo {
	
	@Id
	@Hidden
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Required
	@Pattern(regexp = "[A-Za-z]+", message = "El nombre solo debe contener letras")
	private String nombre;
	
	@Required
	@Pattern(regexp = "[A-Z]{3}[0-9]{3}", message = "El código debe seguir el formato XXX123")
	@Size(min = 6, max = 6, message = "El código debe tener exactamente 6 caracteres")
	private String identificador;
	
	@Required
	@Size(min = 5, max = 50, message = "La descripción debe tener entre 5 y 50 caracteres")
	@Pattern(regexp = "[A-Za-z]+", message = "La descripción solo debe contener letras")
	private String descripcion;
		
	@Required
	@Enumerated(EnumType.STRING)
	private TipoActivo tipo;
	
	@Required
	@Size(min = 5, max = 50, message = "El proceso debe tener entre 5 y 50 caracteres")
	@Pattern(regexp = "[A-Za-z]+", message = "El proceso solo debe contener letras")
	private String proceso;
	
	@Required
	@Size(min = 5, max = 50, message = "La ubicación debe tener entre 5 y 50 caracteres")
	@Pattern(regexp = "[A-Za-z]+", message = "La ubicación solo debe contener letras")
	private String ubicacion;
	
	@Required
    @Enumerated(EnumType.ORDINAL)
    private Valor valorSeguridad;
    
    @Required
    @Enumerated(EnumType.ORDINAL)
    private Valor valorPrivacidad;
    
    @Required
    @Enumerated(EnumType.ORDINAL)
    private Valor valorReputacion;
    
    @Required
    @Enumerated(EnumType.ORDINAL)
    private Valor valorLegal;
    
    @Required
    @Enumerated(EnumType.ORDINAL)
    private Valor valorOperaciones;
    
    @Required
    @Enumerated(EnumType.ORDINAL)
    private Valor valorEconomico;
	
    @ReadOnly
	private String clasificacion;
	
	@Required
	@OneToOne(fetch = FetchType.LAZY)
	@DescriptionsList
	private Responsable responsable;
	
	@PrePersist @PreUpdate
    private void calculateClasificacion() {
        int sum = valorSeguridad.getValue() +
                  valorPrivacidad.getValue() +
                  valorReputacion.getValue() +
                  valorLegal.getValue() +
                  valorOperaciones.getValue() +
                  valorEconomico.getValue();
        int average = sum / 6;
        clasificacion = (average == 1) ? "No Crítico" : "Crítico";
    }
}
