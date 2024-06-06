package com.tpcc.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.*;

@Entity
@Table(name = "accidental_insurance_plan")
@Getter
@Setter
@ToString
public class AccidentalInsurancePlan extends InsurancePlan {
	String coverageType;
	int disabilityCoveragePercentage;
}