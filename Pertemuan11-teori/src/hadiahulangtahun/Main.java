package hadiahulangtahun;

public class Main {
    public static void main(String[] args) {
        Family family = new Family();

        family.addUncle("Bill");
        family.addUncle("Albert");
        family.addUncle("Charlie");
        family.addUncle("David");

        family.addNiece("Beatrice", 15, 12);
        family.addNiece("Amy", 10, 11);
        family.addNiece("Claire", 20, 12);
        family.addNiece("Little Emily", 19, 12);

        // Sorting
        family.sortUncles();
        family.sortNieces();

        System.out.println("List of Uncles:");
        family.listIndexedUncles();

        System.out.println("\nList of Nieces:");
        family.listIndexedNieces();

        // Example: Albert gives a present to Amy
        Uncle albert = family.findUncle("Albert");
        Niece amy = family.findNiece("Amy");
        Uncle bill = family.findUncle("Bill");

        Uncle charlie = family.findUncle("Charlie");
        Niece beatrice = family.findNiece("Beatrice");
        Niece claire = family.findNiece("Claire");

        if (albert != null && amy != null && bill != null && charlie != null && beatrice != null && claire != null) {
            family.addPresent(albert, amy, "The Wonder of Computers", "Happy Birthday, dear Amy!");
            family.addPresent(bill, amy, "The Wonder of Computers", "Long live Amy!");
            family.addPresent(charlie, beatrice, "Flower", "Good luck! I hope you continue to be happy!");
            family.addPresent(charlie, claire, "Flower", "Happy birthday Claire!");
        }

        family.clearExpiredPresents();

        // List niece tanpa mendapatkan hadiah
        System.out.println("\nNieces without presents:");
        family.listNiecesWithoutPresents();

        // List uncle tanpa memberikan hadiah
        System.out.println("\nUncles without gifts:");
        family.listUnclesWithoutGifts();

    }
}
