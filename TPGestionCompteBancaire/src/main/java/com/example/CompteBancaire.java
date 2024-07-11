package com.example;

public class CompteBancaire {
    private double solde;

    public CompteBancaire() {
        this.solde = 0.0; // Initialisation du solde à zéro au début
    }

    public double getSolde() {
        return solde;
    }

    public void depot(double montant) {
        if (montant > 0) {
            solde += montant;
        }
    }

    public boolean retrait(double montant) {
        if (montant > 0 && montant <= solde) {
            solde -= montant;
            return true;
        } else {
            return false;
        }
    }
}
