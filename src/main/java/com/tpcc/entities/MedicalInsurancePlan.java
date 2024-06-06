
package com.tpcc.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.*;

@Entity
@Table(name = "medical_insurance_plan")
@Getter
@Setter
@ToString
public class MedicalInsurancePlan extends InsurancePlan {
	String networkType;
	int copay;
}

