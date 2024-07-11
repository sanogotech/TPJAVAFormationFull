import java.util.Scanner;

/*
## java -Dfile.encoding=UTF-8 GuichetBancaire.java

*/

public class GuichetBancaire {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CompteBancaire compte = new CompteBancaire();

        System.out.println("Bienvenue au guichet bancaire");

        while (true) {
            afficherMenu();
            int choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    consulterSolde(compte);
                    break;
                case 2:
                    effectuerDepot(scanner, compte);
                    break;
                case 3:
                    effectuerRetrait(scanner, compte);
                    break;
                case 4:
                    System.out.println("Merci d'avoir utilisé notre service.");
                    return;
                default:
                    System.out.println("Choix invalide. Veuillez choisir une option valide.");
            }

            System.out.println(); // Ligne vide pour améliorer la lisibilité
        }
    }

    private static void afficherMenu() {
        System.out.println("Que souhaitez-vous faire ?");
        System.out.println("1. Consulter le solde");
        System.out.println("2. Effectuer un dépôt");
        System.out.println("3. Effectuer un retrait");
        System.out.println("4. Quitter");
    }

    private static void consulterSolde(CompteBancaire compte) {
        System.out.println("Votre solde actuel est : " + compte.getSolde() + " FCFA");
    }

    private static void effectuerDepot(Scanner scanner, CompteBancaire compte) {
        System.out.print("Entrez le montant à déposer : ");
        double montantDepot = scanner.nextDouble();
        compte.depot(montantDepot);
        System.out.println(montantDepot + " FCFA ont été déposés sur votre compte.");
    }

    private static void effectuerRetrait(Scanner scanner, CompteBancaire compte) {
        System.out.print("Entrez le montant à retirer : ");
        double montantRetrait = scanner.nextDouble();
        boolean retraitEffectue = compte.retrait(montantRetrait);
        if (retraitEffectue) {
            System.out.println(montantRetrait + " FCFA ont été retirés de votre compte.");
        } else {
            System.out.println("Fonds insuffisants pour effectuer le retrait.");
        }
    }
}

class CompteBancaire {
    private double solde;

    public CompteBancaire() {
        this.solde = 0.0;
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