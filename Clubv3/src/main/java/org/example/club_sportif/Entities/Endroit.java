package org.example.club_sportif.Entities;
import jakarta.persistence.*;
@Entity
@Table(name="endroit")
public class Endroit {
    @Id
    @GeneratedValue
    long idEndroit;
    @OneToOne
    Sport sport;
    String nomEndroit;
    Boolean disponibilite;
    String adresse;


    public Endroit( String nomEndroit, Boolean disponibilite, String adresse) {
        this.nomEndroit = nomEndroit;
        this.disponibilite = disponibilite;
        this.adresse = adresse;
    }
    public void editEndroit(Boolean disponibilite){

        if(disponibilite.equals(true)){
            this.setDisponibilite(false);
        }else{
            this.setDisponibilite(true);
        }
    }
    public Endroit() {
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public long getIdEndroit() {
        return idEndroit;
    }

    public void setIdEndroit(long id_terrain) {
        this.idEndroit = id_terrain;
    }

    public String getNomEndroit() {
        return nomEndroit;
    }

    public void setNomEndroit(String nom_terrain) {
        this.nomEndroit = nom_terrain;
    }

    public Boolean getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(Boolean disponibilite) {
        this.disponibilite = disponibilite;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Endroit{" +
                "id_terrain=" + idEndroit +
                ", nom_terrain='" + nomEndroit + '\'' +
                ", disponibilité='" + disponibilite + '\'' +
                ", adresse='" + adresse + '\'' +
                '}';
    }


    public void afficher_disponibilite(){
        //System.out.println("Le terrain " + nom_terrain + " est disponible : " + disponibilite);
    }
    public void annuler_reservation(String disponibilite){
/*
        if ("Réservé".equals(disponibilite)) {
            disponibilite = "Disponible";
            System.out.println("Réservation annulée pour le terrain " + nom_terrain);
        } else {
            System.out.println("Aucune réservation à annuler pour le terrain " + nom_terrain);
        }*/
    }
    public void reserver_terrain(int id_terrain){
       /* ("Disponible".equals(disponibilite)) {
            disponibilite = "Réservé";
            System.out.println("Terrain " + nom_terrain + " réservé avec succès.");
        } else {
            System.out.println("Le terrain " + nom_terrain + " n'est pas disponible pour la réservation.");
        }*/
    }
}
