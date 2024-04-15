package org.example.club_sportif.Entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Admin {
    @Id
    @GeneratedValue
    private int id_admin;
    private String nom;
    private String prenom;
    private String username;
    private String password;
    private String adresse;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private String numeroTelephone;

    @OneToMany(mappedBy = "admin",cascade = CascadeType.ALL,orphanRemoval = true)
    List<Sport> sports;

    public Admin(String nom, String prenom, String username, String password, String adresse, Date dateNaissance, String numeroTelephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
        this.password = password;
        this.adresse = adresse;
        this.dateNaissance = dateNaissance;
        this.numeroTelephone = numeroTelephone;
    }

    public Admin() {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", adresse='" + adresse + '\'' +
                ", dateNaissance=" + dateNaissance +
                ", numeroTelephone='" + numeroTelephone + '\'' +
                '}';
    }

    public void affecterEntraineur(Groupe groupe,Entraineur entraineur){
        groupe.setEntraineur(entraineur);
    }

    public boolean authentifier(String username,String password) throws Exception {
        if (username.equalsIgnoreCase(this.username) && (this.password.equalsIgnoreCase(password))){
            return true;
        }
        else throw new Exception("The admin credentials are not correct");
    }


}
