package transaction;

import menu.MenuItem;

import java.util.ArrayList;

public class Pesanan {
    private String namaPelanggan;
    private ArrayList<ItemPesanan> daftarItemPesanan;
    private ArrayList<MenuItem> daftarPesanan;

    public Pesanan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
        this.daftarItemPesanan = new ArrayList<>();
        daftarPesanan = new ArrayList<>();
    }

    public void tambahItemPesanan(String namaItem, int jumlah, double hargaSatuan) {
        ItemPesanan itemPesanan = new ItemPesanan(namaItem, jumlah, hargaSatuan);
        daftarItemPesanan.add(itemPesanan);
    }


    public double hitungTotalHargaPesanan() {
        double totalHargaPesanan = 0;
        for (ItemPesanan itemPesanan : daftarItemPesanan) {
            totalHargaPesanan += itemPesanan.getHargaTotal();
        }
        return totalHargaPesanan;
    }

    public void tampilkanStruk() {
        System.out.println("\nStruk Pesanan:");
        System.out.println("-----------------------------------------");
        System.out.println("Item\t\tJumlah\tHarga\tTotal");
        for (ItemPesanan itemPesanan : daftarItemPesanan) {
            System.out.println(itemPesanan.getNamaItem() + "\t" + itemPesanan.getJumlah() + "\t" + itemPesanan.getHargaSatuan() + "\t" + itemPesanan.getHargaTotal());
        }
        System.out.println("-----------------------------------------");
        System.out.println("Total Harga Pesanan: " + hitungTotalHargaPesanan());
        double diskon = 0;
        if (hitungTotalHargaPesanan() >= 100000) {
            System.out.println("Selamat! Anda mendapatkan diskon 10%!");
            diskon = 0.1;
        }
        System.out.println("-----------------------------------------");
        double totalPembayaran = hitungTotalHargaPesanan() - (hitungTotalHargaPesanan() * diskon);
        System.out.println("Diskon: " + hitungTotalHargaPesanan() * diskon);
        System.out.println("Pajak 10%: " + (totalPembayaran * 0.1));
        System.out.println("Biaya Pelayanan: 20000");
        System.out.println("-----------------------------------------");
        System.out.println("Total Harus Dibayarkan: " + (totalPembayaran + (totalPembayaran * 0.1) + 20000));
        System.out.println("-----------------------------------------");

        System.out.println("Terima kasih telah berkungjung di restoran kami!");

    }

    public boolean isEmpty() {
        return daftarItemPesanan.isEmpty();
    }

    private class ItemPesanan {
        private String namaItem;
        private int jumlah;
        private double hargaSatuan;

        public ItemPesanan(String namaItem, int jumlah, double hargaSatuan) {
            this.namaItem = namaItem;
            this.jumlah = jumlah;
            this.hargaSatuan = hargaSatuan;
        }

        public String getNamaItem() {
            return namaItem;
        }

        public int getJumlah() {
            return jumlah;
        }

        public double getHargaSatuan() {
            return hargaSatuan;
        }

        public double getHargaTotal() {
            return jumlah * hargaSatuan;
        }
    }
}