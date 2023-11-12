package hadiahulangtahun;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Niece implements Comparable<Niece> {
    private final String name;
    private final int day;
    private final int month;
    private final List<Present> presents;

    Niece(String name, int day, int month) {
        this.name = name;
        this.day = day;
        this.month = month;
        this.presents = new ArrayList<>();
    }

    public void addPresent(Present present) {
        presents.add(present);
    }

    @Override
    public String toString() {
        return "Niece: " + name + ", Birthday: " + day + "/" + month;
    }

    public String getName() {
        return name;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public List<Present> getPresents() {
        return presents;
    }

    public void clearPresents() {
        presents.clear();
    }

    public LocalDate getBirthdate() {
        return LocalDate.of(LocalDate.now().getYear(), month, day);
    }

    @Override
    public int compareTo(Niece otherNiece) {
        return Integer.compare(this.getDay() + this.getMonth() * 100, otherNiece.getDay() + otherNiece.getMonth() * 100);
    }

    public class Present {
        private final Uncle uncle;
        private final Niece recipient;
        private final String description;

        Present(Uncle uncle, Niece recipient, String description) {
            this.uncle = uncle;
            this.recipient = recipient;
            this.description = description;
        }
    }
}
