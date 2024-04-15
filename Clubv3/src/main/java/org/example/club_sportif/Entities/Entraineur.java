package org.example.club_sportif.Entities;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Entraineur {
    @Id
    @GeneratedValue
    private int id_entraineur;
    private String adresse, nom, prenom, Numerotelephone;
    private Date dateNaissance;

    @OneToMany(mappedBy = "entraineur")
    private List<Groupe> groupes;

    public Entraineur(String adresse, String nom, String prenom, String numerotelephone, Date dateNaissance) {
        this.adresse = adresse;
        this.nom = nom;
        this.prenom = prenom;
        this.Numerotelephone = numerotelephone;
        this.dateNaissance = dateNaissance;
    }

    public Entraineur() {
    }

    public int getId_entraineur() {
        return id_entraineur;
    }

    public void setId_entraineur(int id_entraineur) {
        this.id_entraineur = id_entraineur;
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
        return Numerotelephone;
    }

    public void setNumerotelephone(String numerotelephone) {
        Numerotelephone = numerotelephone;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public List<Groupe> getGroupes() {
        return groupes;
    }

    public void setGroupes(List<Groupe> groupes) {
        this.groupes = groupes;
    }
    public void EditEntraineur(Entraineur entraineur){
        this.adresse = entraineur.adresse;
        this.nom = entraineur.nom;
        this.prenom = entraineur.prenom;
        this.Numerotelephone = entraineur.Numerotelephone;
        this.dateNaissance = entraineur.dateNaissance;
    }
    public void deleteEntraineur(){
        for (Groupe groupe : groupes) {
            groupe.setEntraineur(null);
        }
        groupes.clear();
        this.adresse = null;
        this.nom = null;
        this.prenom = null;
        this.Numerotelephone = null;
        this.dateNaissance = null;
    }

}
