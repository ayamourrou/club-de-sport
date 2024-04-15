package org.example.club_sportif.Entities;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="cotisation")
public class Cotisation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_Cotisation;

    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @Temporal(TemporalType.DATE)
    private Date dateFin;

    private double montant;

    private String methodePaiement;

    private String statutPaiement;

    public Cotisation() {
        super();
    }

    public Cotisation(Date dateDebut, Date dateFin, double montant, String methodePaiement, String statutPaiement) {
        super();
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.montant = montant;
        this.methodePaiement = methodePaiement;
        this.statutPaiement = statutPaiement;
    }

    public Integer getId_Cotisation() {
        return id_Cotisation;
    }

    public void setId_Cotisation(Integer id_Cotisation) {
        this.id_Cotisation = id_Cotisation;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getMethodePaiement() {
        return methodePaiement;
    }

    public void setMethodePaiement(String methodePaiement) {
        this.methodePaiement = methodePaiement;
    }

    public String getStatutPaiement() {
        return statutPaiement;
    }

    public void setStatutPaiement(String statutPaiement) {
        this.statutPaiement = statutPaiement;
    }

    @Override
    public String toString() {
        return "Cotisation{" +
                "id_Cotisation=" + id_Cotisation +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", montant=" + montant +
                ", methodePaiement='" + methodePaiement + '\'' +
                ", statutPaiement='" + statutPaiement + '\'' +
                '}';
    }
}
