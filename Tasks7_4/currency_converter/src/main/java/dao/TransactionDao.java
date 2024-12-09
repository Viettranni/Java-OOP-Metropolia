package dao;

import jakarta.persistence.*;
import entity.Transaction;

public class TransactionDao {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");

    public void storeTransaction(Transaction transaction) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(transaction);
            em.getTransaction().commit(); 
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();  
        } finally {
            em.close();
        }
    }
}
