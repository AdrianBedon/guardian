package com.avilabedonliriaramos.guardian.guardian.model;

import javax.persistence.*;

import org.openxava.annotations.*;

import com.avilabedonliriaramos.guardian.guardian.enums.*;

import lombok.*;

@Entity
@Getter @Setter
public class RiesgoResidual {
	
	@Id
	@Hidden
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Vulnerabilidad vulnerabilidad;
	
	@OneToOne(fetch = FetchType.LAZY)
	@DescriptionsList
	private Responsable responsable;
	
	@Required
	@Enumerated(EnumType.STRING)
	private Tolerancia tolerancia;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Control nuevoControl;
	
	@ReadOnly
	private int riesgoResidual;
	
	@ReadOnly
	private String nuevoNivelRiesgo;
	
	@PrePersist @PreUpdate
	private void calculateResidualRisk() {
		if (vulnerabilidad != null) {
			int nivAmenaza = vulnerabilidad.getNivelAmenaza().getValue();
			int nivVul = vulnerabilidad.getNivelVulnerabilidad().getValue();
			int criticidad = vulnerabilidad.getActivo().getCriticidad();

			int riesgoCalculo = nivAmenaza * nivVul * criticidad;

			int tol;
			switch (tolerancia) {
				case MENOS_10:
					tol = 5;
					break;
				case MENOS_30:
					tol = 10;
					break;
				default:
					tol = 15;
					break;
			}

			int eficiencia = 0;
			if (nuevoControl != null) {
				eficiencia = nuevoControl.getEficiencia().getValue();
			}

			int riesgoRes = riesgoCalculo - tol - eficiencia;
			if (riesgoRes > 0) {
				this.riesgoResidual = riesgoRes;
			} else {
				this.riesgoResidual = 1;
				riesgoRes = 1;
			}

			if (riesgoRes >= 1 && riesgoRes < 4) {
				this.nuevoNivelRiesgo = "Bajo";
			} else if (riesgoRes >= 4 && riesgoRes < 9) {
				this.nuevoNivelRiesgo = "Medio";
			} else {
				this.nuevoNivelRiesgo = "Alto";
			}
		}
	}
}
