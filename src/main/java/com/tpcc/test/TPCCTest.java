package com.tpcc.test;

import com.tpcc.dao.AccidentalInsuranceDao;
import com.tpcc.dao.MedicalInsuranceDao;
import com.tpcc.entities.AccidentalInsurancePlan;
import com.tpcc.entities.InsurancePlan;
import com.tpcc.entities.MedicalInsurancePlan;
import com.tpcc.helper.EntityManagerFactoryRegistry;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityManager;

public class TPCCTest {
  public static void main(String[] args) {

    try {

      AccidentalInsuranceDao accidentalInsuranceDao = new AccidentalInsuranceDao();
      AccidentalInsurancePlan accidentalInsurancePlan = new AccidentalInsurancePlan();
      accidentalInsurancePlan.setPlanName("Jeevan Travel");
      accidentalInsurancePlan.setDescription("Accident Saver plan");
      accidentalInsurancePlan.setTaxSaver(false);
      accidentalInsurancePlan.setMinInsurredAmount(1000000);
      accidentalInsurancePlan.setCoverageType("international");
      accidentalInsurancePlan.setDisabilityCoveragePercentage(50);
      accidentalInsurancePlan.setMinInsurredAmount(100000);
      accidentalInsuranceDao.saveAccidentalInsurancePlan(accidentalInsurancePlan);


      MedicalInsuranceDao medicalInsuranceDao = new MedicalInsuranceDao();
      MedicalInsurancePlan medicalInsurancePlan = new MedicalInsurancePlan();
      medicalInsurancePlan.setPlanName("Jeevan Abhaya");
      medicalInsurancePlan.setDescription("Medical Saver plan");
      medicalInsurancePlan.setTaxSaver(false);
      medicalInsurancePlan.setMinInsurredAmount(4000000);
      medicalInsurancePlan.setNetworkType("in-network");
      medicalInsurancePlan.setCopay(10);

      medicalInsuranceDao.saveMedicalInsurancePlan(medicalInsurancePlan);
     // System.out.println(">>>>> persisted medicalInsurance plan");


/*      InsurancePlan ip = getRequiredEntity(1);
        System.out.println(">>>>> Retrieved entity: " + ip);*/
    } catch (Exception e) {
      System.out.println(">>>>>> Exception occured: " + e.getMessage());
      throw new RuntimeException(e);
    }
  }

  public static InsurancePlan getRequiredEntity(int id){
    EntityManagerFactory emf = EntityManagerFactoryRegistry.getEntityManagerFactory();
    EntityManager em = emf.createEntityManager();
    return em.find(InsurancePlan.class, id);
  }
}
