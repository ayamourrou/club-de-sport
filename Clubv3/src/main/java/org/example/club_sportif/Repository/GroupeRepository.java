package org.example.club_sportif.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.club_sportif.Entities.Groupe;
import org.example.club_sportif.Entities.Membre;

import java.util.List;

public class GroupeRepository extends Repository<Groupe,Integer>{
    private Groupe groupe;
    private static EntityManagerFactory emf;
    private static EntityManager em;
    public int getId_group() {
        return groupe != null ? groupe.getId_group() : 0;
    }
    public GroupeRepository() {
        super(Groupe.class);
        if(em==null) {
            emf = Persistence.createEntityManagerFactory("bib");
            em = emf.createEntityManager();
        }
    }
    public List<Membre> findAllMembresByGroupe() {
        return em.createQuery("SELECT membre FROM Membre membre WHERE membre.groupe = :groupe", Membre.class)
                .setParameter("groupe", this)
                .getResultList();
    }
    public void addMembre(Membre membre){
        groupe = em.find(Groupe.class, this.getId_group());

        groupe.getListejoueur().add(membre);
        //fusionner les changements apportés à l'objet groupe
        em.merge(groupe);
    }

    public void deleteMembre(Membre membre) {
        groupe = em.find(Groupe.class, this.getId_group());
        if (groupe != null) {
            try {
                em.getTransaction().begin();
                groupe.getListejoueur().remove(membre);
                em.getTransaction().commit();
            } catch (Exception e) {
                em.getTransaction().rollback();
            }
        }
    }
}