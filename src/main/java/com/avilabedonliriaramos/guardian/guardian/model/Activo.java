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
	@Pattern(regexp = "[A-Za-zÁÉÍÓÚáéíóúñÑ ]+", message = "El nombre solo debe contener letras")
	private String nombre;
	
	@Required
	@Pattern(regexp = "[A-Z]{3}[0-9]{3}", message = "El código debe seguir el formato XXX123")
	@Size(min = 6, max = 6, message = "El código debe tener exactamente 6 caracteres")
	private String identificador;
	
	@Required
	@Size(min = 5, max = 50, message = "La descripción debe tener entre 5 y 50 caracteres")
	@Pattern(regexp = "[A-Za-zÁÉÍÓÚáéíóúñÑ ]+", message = "La descripción solo debe contener letras")
	private String descripcion;
		
	@Required
	@Enumerated(EnumType.STRING)
	private TipoActivo tipo;
	
	@Required
	@Size(min = 5, max = 50, message = "El proceso debe tener entre 5 y 50 caracteres")
	@Pattern(regexp = "[A-Za-zÁÉÍÓÚáéíóúñÑ ]+", message = "El proceso solo debe contener letras")
	private String proceso;
	
	@Required
	@Size(min = 5, max = 50, message = "La ubicación debe tener entre 5 y 50 caracteres")
	@Pattern(regexp = "[A-Za-zÁÉÍÓÚáéíóúñÑ0-9 ]+", message = "La ubicación solo debe contener letras, números y espacios")
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
        float criticidadCalculo = (float)(valorSeguridad.getValue() + valorPrivacidad.getValue() + 
                                          valorReputacion.getValue() + valorLegal.getValue() + 
                                          valorOperaciones.getValue() + valorEconomico.getValue()) / 6.0f;
        int criticidad;
        if (criticidadCalculo >= 1 && criticidadCalculo < 1.5) {
            criticidad = 1;
        } else if (criticidadCalculo >= 1.5 && criticidadCalculo < 2.5) {
            criticidad = 2;
        } else {
            criticidad = 3;
        }

        this.clasificacion = (criticidad == 1) ? "No crítico" : "Crítico";
    }

    public int getCriticidad() {
        float criticidadCalculo = (float)(valorSeguridad.getValue() + valorPrivacidad.getValue() + 
                                          valorReputacion.getValue() + valorLegal.getValue() + 
                                          valorOperaciones.getValue() + valorEconomico.getValue()) / 6.0f;
        if (criticidadCalculo >= 1 && criticidadCalculo < 1.5) {
            return 1;
        } else if (criticidadCalculo >= 1.5 && criticidadCalculo < 2.5) {
            return 2;
        } else {
            return 3;
        }
    }
}
