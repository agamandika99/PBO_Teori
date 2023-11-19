package guipenjualan;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Penjualan extends JFrame{
    private JPanel Panel1;
    private JPanel Panel2;
    private JPanel Panel3;
    private JCheckBox steakCheckBox;
    private JCheckBox seblakCheckBox;
    private JCheckBox pizzaCheckBox;
    private JTextField textField4;
    private JButton TAMBAHButton;
    private JPanel Panel4;
    private JTextArea textArea1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JCheckBox jusCheckBox;
    private JLabel menuLabel;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;

    private int totalHarga = 0; // Variabel untuk menyimpan total harga

    private int hargaSteak = 10000;
    private int hargaSeblak = 8000;
    private int hargaPizza = 12000;
    private int hargaJus = 5000;


    public Penjualan() {
        setContentPane(Panel1);
        setTitle("Aplikasi Pemesanan Makanan");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        // Menambahkan listener untuk setiap checkbox
        steakCheckBox.addActionListener(new ItemChangeListener());
        seblakCheckBox.addActionListener(new ItemChangeListener());
        pizzaCheckBox.addActionListener(new ItemChangeListener());
        jusCheckBox.addActionListener(new ItemChangeListener());

        // Menambahkan listener untuk setiap textField item
        textField5.addActionListener(new ItemChangeListener());
        textField6.addActionListener(new ItemChangeListener());
        textField7.addActionListener(new ItemChangeListener());
        textField8.addActionListener(new ItemChangeListener());


        TAMBAHButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTotalHarga();
                tampilkanStrukPemesanan();
            }
        });
    }

    private class ItemChangeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            updateTotalHarga();
        }
    }


    private void updateTotalHarga() {
        totalHarga = 0;

        try {
            totalHarga += Integer.parseInt(textField5.getText()) * hargaSteak;
            totalHarga += Integer.parseInt(textField6.getText()) * hargaSeblak;
            totalHarga += Integer.parseInt(textField7.getText()) * hargaPizza;
            totalHarga += Integer.parseInt(textField8.getText()) * hargaJus;
        } catch (NumberFormatException e) {
            //
        }

        updateTotalTextField();
    }


    private void updateTotalTextField() {
        textField4.setText(String.valueOf(totalHarga));
    }

    private void tampilkanStrukPemesanan() {
        String nama = textField1.getText();
        String alamat = textField2.getText();
        String noHP = textField3.getText();
        String pesanan = generatePesananString();
        String totalBayar = String.valueOf(totalHarga);

        StringBuilder strukPemesanan = new StringBuilder();
        strukPemesanan.append("========================================\n");
        strukPemesanan.append("               Struk Pemesanan               \n");
        strukPemesanan.append("========================================\n");
        strukPemesanan.append("Nama: ").append(nama).append("\n");
        strukPemesanan.append("Alamat: ").append(alamat).append("\n");
        strukPemesanan.append("No Handphone: ").append(noHP).append("\n");
        strukPemesanan.append("----------------------------------------\n");
        strukPemesanan.append("Pesanan:\n").append(pesanan);
        strukPemesanan.append("----------------------------------------\n");
        strukPemesanan.append("Total Pembayaran: ").append(totalBayar).append("\n");
        strukPemesanan.append("========================================\n");

        textArea1.setText(strukPemesanan.toString());
    }

    private String generatePesananString() {
        StringBuilder pesananBuilder = new StringBuilder();
        int totalItem = 0;

        if (steakCheckBox.isSelected()) {
            int jumlahSteak = Integer.parseInt(textField5.getText());
            int hargaSteakTotal = jumlahSteak * hargaSteak;
            pesananBuilder.append("Steak - Harga: ").append(hargaSteak).append(", Item: ").append(jumlahSteak).append(", Subtotal: ").append(hargaSteakTotal).append("\n");
            totalItem += jumlahSteak;
        }
        if (seblakCheckBox.isSelected()) {
            int jumlahSeblak = Integer.parseInt(textField6.getText());
            int hargaSeblakTotal = jumlahSeblak * hargaSeblak;
            pesananBuilder.append("Seblak - Harga: ").append(hargaSeblak).append(", Item: ").append(jumlahSeblak).append(", Subtotal: ").append(hargaSeblakTotal).append("\n");
            totalItem += jumlahSeblak;
        }
        if (pizzaCheckBox.isSelected()) {
            int jumlahPizza = Integer.parseInt(textField7.getText());
            int hargaPizzaTotal = jumlahPizza * hargaPizza;
            pesananBuilder.append("Pizza - Harga: ").append(hargaPizza).append(", Item: ").append(jumlahPizza).append(", Subtotal: ").append(hargaPizzaTotal).append("\n");
            totalItem += jumlahPizza;
        }
        if (jusCheckBox.isSelected()) {
            int jumlahJus = Integer.parseInt(textField8.getText());
            int hargaJusTotal = jumlahJus * hargaJus;
            pesananBuilder.append("Jus - Harga: ").append(hargaJus).append(", Item: ").append(jumlahJus).append(", Subtotal: ").append(hargaJusTotal).append("\n");
            totalItem += jumlahJus;
        }

        pesananBuilder.append("----------------------------------------\n");
        pesananBuilder.append("Total Item: ").append(totalItem).append("\n");
        return pesananBuilder.toString();
    }


    public static void main(String[] args) {
        new Penjualan();
    }

}

