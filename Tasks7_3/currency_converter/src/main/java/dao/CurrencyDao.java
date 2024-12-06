package dao;

import jakarta.persistence.*;
import java.util.List;

import entity.Currency;

public class CurrencyDao {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");

    public static List<String> loadCurrencyCodes() {
        EntityManager em = emf.createEntityManager();
        List<String> currencyCodes;

        try {
            String jpql = "SELECT c.currencyCode FROM Currency c";
            currencyCodes = em.createQuery(jpql, String.class).getResultList();
        } finally {
            em.close();
        }

        return currencyCodes;
    }

    public static double getRate(String currencyCode) {
        EntityManager em = emf.createEntityManager();
        double rate;

        try {
            String jpql = "SELECT c.exchangeRate FROM Currency c WHERE c.currencyCode = :currencyCode";
            rate = em.createQuery(jpql, Double.class)
                     .setParameter("currencyCode", currencyCode)
                     .getSingleResult();
        } catch (NoResultException e) {
            throw new IllegalArgumentException("No exchange rate found for currency code: " + currencyCode);
        } finally {
            em.close();
        }
        return rate;
    }

    public static boolean insertNewCurrency(String currencyCode, String currencyName, double currencyRate) {
        EntityManager em = emf.createEntityManager();

        // Start a transaction
        em.getTransaction().begin();

        try {
            Currency currency = new Currency();
            currency.setCurrencyCode(currencyCode);
            currency.setExchangeRate(currencyRate);
            currency.setCurrencyName(currencyName);

            // Persist the new Currency object
            em.persist(currency);

            // Commit the transaction to save the data
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            // If something goes wrong, roll back the transaction
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            // Close the EntityManager to release resources
            em.close();
        }

    }
}
