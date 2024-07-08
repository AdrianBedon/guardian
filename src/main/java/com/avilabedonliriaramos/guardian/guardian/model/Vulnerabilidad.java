package com.avilabedonliriaramos.guardian.guardian.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.avilabedonliriaramos.guardian.guardian.enums.*;

import lombok.*;

@Entity
@Getter @Setter
public class Vulnerabilidad {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Hidden
	private Long id;
	
	@ReadOnly
	private String riesgoInherente;
	
	@ReadOnly
	private int valorRiesgo;
	
	@Required
	@ManyToOne(fetch = FetchType.LAZY)
	private Amenaza amenaza;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Control controlAplicado;
	
	@Required
	@ManyToOne(fetch = FetchType.LAZY)
	private Activo activo;
	
	@Required
    @Enumerated(EnumType.ORDINAL)
	private Valor nivelVulnerabilidad;
	
	@Required
    @Enumerated(EnumType.ORDINAL)
	private Valor nivelAmenaza;
	
	@PrePersist @PreUpdate
	private void calculateRisk() {
		if (activo != null && nivelVulnerabilidad != null && nivelAmenaza != null) {
			int criticidad = activo.getCriticidad();
			valorRiesgo = nivelVulnerabilidad.getValue() * nivelAmenaza.getValue() * criticidad;

			if (valorRiesgo >= 1 && valorRiesgo < 4) {
				riesgoInherente = "Bajo";
			} else if (valorRiesgo >= 4 && valorRiesgo < 9) {
				riesgoInherente = "Medio";
			} else {
				riesgoInherente = "Alto";
			}
		}
	}
}
