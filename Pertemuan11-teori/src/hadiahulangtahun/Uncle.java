package hadiahulangtahun;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Uncle implements Comparable<Uncle> {
    private final String name;
    private final List<String> givenPresents;

    Uncle(String name) {
        this.name = name;
        this.givenPresents = new ArrayList<>();
    }

    public boolean addPresent(Niece recipient, String description, String birthdayMessage) {
        String presentKey = recipient.getName() + ":" + description;

        if (givenPresents.contains(presentKey)) {
            System.out.println("Duplicate Gift! " + presentKey);
            return false;
        }

        Niece.Present newPresent = recipient.new Present(this, recipient, description);
        recipient.addPresent(newPresent);
        givenPresents.add(presentKey);

        System.out.println("\nUncle " + this.getName() + " says: " + birthdayMessage);

        return true;
    }

    public List<String> getGivenPresents() {
        return givenPresents;
    }

    public boolean hasGivenSameDescription(Niece recipient, String description) {
        return givenPresents.stream()
                .anyMatch(present -> present.startsWith(recipient.getName() + ":" + description));
    }

    public boolean hasGivenSameDescriptionToOtherNiece(Niece recipient, String description) {
        long count = givenPresents.stream()
                .filter(present -> present.endsWith(":" + description))
                .map(present -> present.split(":")[0])
                .filter(name -> !name.equals(recipient.getName()))
                .distinct()
                .count();

        return count > 0;
    }

    public List<String> getNiecesWithSameDescription(String description) {
        return givenPresents.stream()
                .filter(present -> present.endsWith(":" + description))
                .map(present -> present.split(":")[0])
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Uncle: " + name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Uncle otherUncle) {
        return this.getName().compareTo(otherUncle.getName());
    }
}
