package com.tpcc.entities;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
public abstract class InsurancePlan implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "insurance_plan_no")
	int insurancePlanNo;

	@Column(name = "plan_name")
	String planName;

	String description;

	protected boolean taxSaver;

	protected float minInsurredAmount;
}