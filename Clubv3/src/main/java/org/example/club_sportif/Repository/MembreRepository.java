package org.example.club_sportif.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.club_sportif.Entities.Cotisation;
import org.example.club_sportif.Entities.Membre;

import java.util.Date;

public class MembreRepository extends Repository<Membre, Integer> {
    private static EntityManagerFactory emf;
    private static EntityManager em;

    public MembreRepository() {
        super(Membre.class);
    }

    public void payerCotisation(Integer idMembre, Date dateDebut, Date dateFin, double montant, String methodePaiement, String statutPaiement) {
        try {
            em.getTransaction().begin();

            Membre membre = em.find(Membre.class, idMembre);

            if (membre != null) {
                Cotisation cotisation = new Cotisation(dateDebut, dateFin, montant, methodePaiement, statutPaiement);

                membre.setCotisation(cotisation);

                em.persist(membre);

                em.getTransaction().commit();
            } else {
                em.getTransaction().rollback();
                System.out.println("Le membre avec l'ID " + idMembre + " n'existe pas.");
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Une erreur est survenue lors du paiement de la cotisation : " + e.getMessage());
        }
    }
}

