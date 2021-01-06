package com.company.jettCore.model;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerHelper {
	private static EntityManagerFactory entityManagerFactory;

    static
    {
        try {
            entityManagerFactory= Persistence.createEntityManagerFactory("pu");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}
