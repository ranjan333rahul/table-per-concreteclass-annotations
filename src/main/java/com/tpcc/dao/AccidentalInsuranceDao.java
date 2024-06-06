package com.tpcc.dao;

import com.tpcc.entities.*;
import com.tpcc.helper.EntityManagerFactoryRegistry;

import jakarta.persistence.*;

public class AccidentalInsuranceDao {
  public void saveAccidentalInsurancePlan(AccidentalInsurancePlan accidentalInsurancePlan) {
    EntityTransaction entityTransaction = null;
    EntityManagerFactory emFactory = null;
    EntityManager entityManager = null;
    boolean flag = false;
    try {
      emFactory = EntityManagerFactoryRegistry.getEntityManagerFactory();
      entityManager = emFactory.createEntityManager();
      entityTransaction = entityManager.getTransaction();
      entityTransaction.begin();

      entityManager.persist(accidentalInsurancePlan);

      flag = true;
    } finally {
      if (entityTransaction != null) {
        if (flag) {
          entityTransaction.commit();
        } else {
          entityTransaction.rollback();
        }
      }
      if (entityManager != null) {
        entityManager.close();
      }
    }
  }
}
