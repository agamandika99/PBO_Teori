import java.util.ArrayList;
import java.util.List;

class Buku {
    String judul;
    int idBuku;
    int jumlahHalaman;
    Perpustakaan perpustakaan; // Tambahkan referensi ke perpustakaan

    Buku(String judul, int idBuku, int jumlahHalaman, Perpustakaan perpustakaan) {
        this.judul = judul;
        this.idBuku = idBuku;
        this.jumlahHalaman = jumlahHalaman;
        this.perpustakaan = perpustakaan;
    }

    public String toString() {
        return "Judul: " + judul + ", ID Buku: " + idBuku + ", Jumlah Halaman: " + jumlahHalaman;
    }
}

class Mahasiswa {
    String nama;
    Perpustakaan perpustakaan; // Tambahkan referensi ke perpustakaan

    Mahasiswa(String nama, Perpustakaan perpustakaan) {
        this.nama = nama;
        this.perpustakaan = perpustakaan;
    }

    public String toString() {
        return "Nama Mahasiswa: " + nama + ", Perpustakaan yang Diakses: " + perpustakaan.nama;
    }
}

// Menambahkan relasi dependency antara Mahasiswa dan Perpustakaan
class Perpustakaan {
    String nama;
    private List<Buku> koleksiBuku;

    Perpustakaan(String nama) {
        this.nama = nama;
        this.koleksiBuku = new ArrayList<>();
    }

    public void tambahBuku(Buku buku) {
        koleksiBuku.add(buku);
    }

    static PerpusJurusan perpusPolban = new PerpusJurusan("Perpustakaan Polban");
    static PerpusJurusan perpusJurusan = new PerpusJurusan("Perpustakaan Jurusan");

    private final List<Mahasiswa> listPerpusPolban = new ArrayList<Mahasiswa>(); //ditambah, buat list mhs
    private final List<Mahasiswa> listPerpusJurusan = new ArrayList<Mahasiswa>(); //ditambah, buat list mhs


    public static void main(String[] args){
        Buku buku1 = new Buku("Harry Potter and the Sorcerer's Stone", 1001, 300, perpusPolban);
        Buku buku2 = new Buku("The Great Gatsby", 1002, 250, perpusPolban);
        Buku buku3 = new Buku("To Kill a Mockingbird", 1003, 320, perpusPolban);
        Buku buku4 = new Buku("1984", 1004, 280, perpusPolban);

        Buku buku5 = new Buku("The Catcher in the Rye", 2001, 220, perpusJurusan);
        Buku buku6 = new Buku("Pride and Prejudice", 2002, 350, perpusJurusan);
        Buku buku7 = new Buku("The Hobbit", 2003, 280, perpusJurusan);
        Buku buku8 = new Buku("Brave New World", 2004, 310, perpusJurusan);

        perpusPolban.tambahBuku(buku1);
        perpusPolban.tambahBuku(buku2);
        perpusPolban.tambahBuku(buku3);
        perpusPolban.tambahBuku(buku4);

        perpusJurusan.tambahBuku(buku5);
        perpusJurusan.tambahBuku(buku6);
        perpusJurusan.tambahBuku(buku7);
        perpusJurusan.tambahBuku(buku8);

        System.out.println(perpusPolban);
        System.out.println(perpusJurusan);

        perpusPolban.kunjungMhs();
    }

    //ditambah, buat kunjung mhs
    void kunjungMhs(){
        Mahasiswa mhs = new Mahasiswa("Julya",perpusPolban);
        Mahasiswa mhs1 = new Mahasiswa("Lutfi",perpusPolban);
        Mahasiswa mhs2 = new Mahasiswa("Aini",perpusJurusan);
        Mahasiswa mhs3 = new Mahasiswa("Kayna",perpusJurusan);

        listPerpusPolban.add(mhs);
        listPerpusPolban.add(mhs1);
        listPerpusJurusan.add(mhs2);
        listPerpusJurusan.add(mhs3);

        for (Mahasiswa b: listPerpusPolban){
            System.out.println(b);
        }

        for (Mahasiswa s: listPerpusJurusan){
            System.out.println(s);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nama Perpustakaan: ").append(nama).append("\n");
        sb.append("Koleksi Buku:\n");
        for (Buku buku : koleksiBuku) {
            sb.append("- ").append(buku).append("\n");
        }
        return sb.toString();
    }
}

class PerpusJurusan extends Perpustakaan {
    PerpusJurusan(String nama) {
        super(nama);
    }
}


