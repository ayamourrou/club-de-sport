package org.example.club_sportif.Entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Groupe {
    @Id
    @GeneratedValue
    private int id_group;
    private String categorie, nomequipe;

    @ManyToOne
    @JoinColumn(name = "id_entraineur")
    private Entraineur entraineur;

    @OneToMany(mappedBy = "groupe")
    private List<Membre> listejoueur;

    public Groupe(String categorie, String nomequipe, List<Membre> listejoueur, Entraineur entraineur) {
        this.categorie = categorie;
        this.nomequipe = nomequipe;
        this.listejoueur = listejoueur;
        this.entraineur = entraineur;
    }

    public Groupe() {
    }

    public int getId_group() {
        return id_group;
    }

    public void setId_group(int id_group) {
        this.id_group = id_group;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getNomequipe() {
        return nomequipe;
    }

    public void setNomequipe(String nomequipe) {
        this.nomequipe = nomequipe;
    }

    public List<Membre> getListejoueur() {
        return listejoueur;
    }

    public void setListejoueur(List<Membre> listejoueur) {
        this.listejoueur = listejoueur;
    }

    public Entraineur getEntraineur() {
        return entraineur;
    }

    public void setEntraineur(Entraineur entraineur) {
        this.entraineur = entraineur;
    }

    public void addEntraineur(Entraineur entraineur) {
        this.entraineur = entraineur;
    }
}
