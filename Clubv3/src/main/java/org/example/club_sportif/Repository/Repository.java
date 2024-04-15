package org.example.club_sportif.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class Repository<T, U> {
    private Class<T> entityClass;
    private static EntityManagerFactory emf;
    private static EntityManager em;

    public Repository(Class<T> entityClass) {
        this.entityClass = entityClass;
        if(em==null) {
            emf = Persistence.createEntityManagerFactory("bib");
            em = emf.createEntityManager();
        }

    }

    public void save(T t) {
        try {
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            em.getTransaction().rollback();
        }
    }

    public T findById(U id) {
        return em.find(entityClass, id);
    }

    public List<T> findAll(){
        return em.createQuery("From "+entityClass.getSimpleName()).getResultList();
    }

    public void deleteById(U id) {
        T t = em.find(entityClass, id);
        if(t != null) {
            try {
                em.getTransaction().begin();
                em.remove(t);
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            }
        }
    }
    public void update(T updatedEntity) {
        try {
            em.getTransaction().begin();
            em.merge(updatedEntity);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            em.getTransaction().rollback();
        }
    }
}
