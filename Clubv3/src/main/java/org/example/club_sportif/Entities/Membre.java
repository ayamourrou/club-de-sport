package org.example.club_sportif.Entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Membre {
    @Id
    @GeneratedValue
    private int id_membre;
    private String adresse;
    private String nom;
    private String prenom;
    private String numerotelephone;
    private Date dateNaissance;
    @ManyToOne
    private Groupe groupe;
    @OneToOne
    @JoinColumn(name = "id_Cotisation")
    Cotisation cotisation;

    @ManyToOne
    private Sport sports;

    public Sport getSports() {
        return sports;
    }

    public void setSports(Sport sports) {
        this.sports = sports;
    }

    public Membre(String adresse, String nom, String prenom, String numerotelephone, Date dateNaissance, Groupe groupe, Cotisation cotisation, Sport sports) {
        this.adresse = adresse;
        this.nom = nom;
        this.prenom = prenom;
        this.numerotelephone = numerotelephone;
        this.dateNaissance = dateNaissance;
        this.groupe = groupe;
        this.cotisation = cotisation;
        this.sports = sports;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public Membre() {
    }
    public void inscrireGroupe(int groupeId){
        Groupe groupe = new Groupe();
        groupe.setId_group(groupeId);
        Membre membre = new Membre(this.adresse,this.nom,this.prenom,this.numerotelephone,this.dateNaissance,this.groupe,this.cotisation,this.sports);
        this.setGroupe(groupe);
        groupe.getListejoueur().add(membre);
    }
    public void quitterGroupe(int groupeId){
        Groupe groupe = new Groupe();
        groupe.setId_group(groupeId);
        Membre membre = new Membre(this.adresse,this.nom,this.prenom,this.numerotelephone,this.dateNaissance,this.groupe,this.cotisation,this.sports);
        groupe.getListejoueur().remove(membre);
        this.setGroupe(null);
    }
    public int getId_membre() {
        return id_membre;
    }

    public void setId_membre(int id_membre) {
        this.id_membre = id_membre;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumerotelephone() {
        return numerotelephone;
    }

    public void setNumerotelephone(String numerotelephone) {
        this.numerotelephone = numerotelephone;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Cotisation getCotisation() {
        return cotisation;
    }

    public void setCotisation(Cotisation cotisation) {
        this.cotisation = cotisation;
    }
    public boolean authentifier(String username,String password) throws Exception {
        if (username.equalsIgnoreCase(this.nom) && (password.equalsIgnoreCase(String.valueOf(this.id_membre)))){
            return true;
        }
        else throw new Exception("The admin credentials are not correct");
    }
}
