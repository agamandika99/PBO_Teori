package hadiahulangtahun;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.time.LocalDate;

public class Family {
    private final List<Uncle> uncles;
    private final List<Niece> nieces;

    public Family() {
        this.uncles = new ArrayList<>();
        this.nieces = new ArrayList<>();
    }

    public boolean addNiece(String name, int day, int month) {
        Niece existingNiece = findNiece(name);
        if (existingNiece == null) {
            nieces.add(new Niece(name, day, month));
            return true;
        }
        return false;
    }

    public boolean addUncle(String name) {
        Uncle existingUncle = findUncle(name);
        if (existingUncle == null) {
            uncles.add(new Uncle(name));
            return true;
        }
        return false;
    }

    public Niece findNiece(String name) {
        for (Niece niece : nieces) {
            if (niece.getName().equals(name)) {
                return niece;
            }
        }
        return null;
    }

    public Uncle findUncle(String name) {
        for (Uncle uncle : uncles) {
            if (uncle.getName().equals(name)) {
                return uncle;
            }
        }
        return null;
    }

    public void listIndexedUncles() {
        for (int i = 0; i < uncles.size(); i++) {
            System.out.println((i + 1) + ". " + uncles.get(i));
        }
    }

    public void listIndexedNieces() {
        for (int i = 0; i < nieces.size(); i++) {
            System.out.println((i + 1) + ". " + nieces.get(i));
        }
    }

    public boolean addPresent(Uncle uncle, Niece recipient, String description, String birthdayMessage) {
        for (Uncle otherUncle : uncles) {
            if (otherUncle != uncle && otherUncle.hasGivenSameDescription(recipient, description)) {
                System.out.println("Duplicate Gift! Gift: " + description);
                System.out.println("Uncles involved: " + uncle.getName() + " and " + otherUncle.getName());

                // Print the nieces involved
                List<String> niecesWithSameDescription = otherUncle.getNiecesWithSameDescription(description);
                niecesWithSameDescription.remove(recipient.getName());
                System.out.println("Nieces: " + recipient.getName() + " and " + String.join(", ", niecesWithSameDescription));

                return false;
            }
        }

        if (uncle.hasGivenSameDescriptionToOtherNiece(recipient, description)) {
            System.out.println("Duplicate Gift! Gift: " + description);
            System.out.println("Uncle involved: " + uncle.getName());

            // Print the nieces involved
            List<String> niecesWithSameDescription = uncle.getNiecesWithSameDescription(description);
            niecesWithSameDescription.remove(recipient.getName());
            System.out.println("Nieces: " + recipient.getName() + " and " + String.join(", ", niecesWithSameDescription));

            return false;
        }

        boolean isAdded = uncle.addPresent(recipient, description, birthdayMessage);
        if (isAdded) {
            System.out.println("Present from " + uncle.getName() + " to " + recipient.getName() + ": " + description);
        } else {
            System.out.println("Duplicate Gift! Gift: " + description);
        }
        return isAdded;
    }

    public List<Uncle> getUncles() {
        return uncles;
    }

    public List<Niece> getNieces() {
        return nieces;
    }

    public void sortUncles() {
        Collections.sort(uncles);
    }

    public void sortNieces() {
        Collections.sort(nieces);
    }

    public void listNiecesWithoutPresents() {
        for (Niece niece : nieces) {
            if (niece.getPresents().isEmpty()) {
                System.out.println(niece.getName() + ": didn't get a prize");
            }
        }
    }

    public void listUnclesWithoutGifts() {
        for (Uncle uncle : uncles) {
            if (uncle.getGivenPresents().isEmpty()) {
                System.out.println(uncle.getName() + ": don't give gifts");
            }
        }
    }

    public void clearExpiredPresents() {
        LocalDate currentDate = LocalDate.now();

        for (Niece niece : nieces) {
            if (niece.getBirthdate().isBefore(currentDate)) {
                niece.clearPresents();
            }
        }
    }
}