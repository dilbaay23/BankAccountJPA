package be.multimedi.bankapp.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmfSingleton {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
    public static EntityManager em = emf.createEntityManager();


    public static void close(){
        em.close();
        emf.close();
    }
}
