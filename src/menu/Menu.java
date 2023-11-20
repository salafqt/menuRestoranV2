package menu;

import java.io.*;
import java.util.ArrayList;

public class Menu {
    private ArrayList<MenuItem> daftarMenu;

    public Menu() {
        daftarMenu = new ArrayList<>();
        inisialisasiMenu();
    }

    private void inisialisasiMenu() {
        // Tambahkan menu makanan
        daftarMenu.add(new Makanan("Sop Ayam", 20000, "Makanan"));
        daftarMenu.add(new Makanan("Sate Ayam", 15000, "Makanan"));
        daftarMenu.add(new Makanan("Nasi Padang", 25000, "Makanan"));
        daftarMenu.add(new Makanan("Ayam Goreng", 15000, "Makanan"));


        // Tambahkan menu minuman
        daftarMenu.add(new Minuman("Jus Jeruk", 10000, "Minuman"));
        daftarMenu.add(new Minuman("Kopi Susu", 5000, "Minuman"));
        daftarMenu.add(new Minuman("Es Teh Tawar", 4000, "Minuman"));
        daftarMenu.add(new Minuman("Es Teh Manis", 6000, "Minuman"));

        // tambahkan menu diskon
        daftarMenu.add(new Diskon("Nasi Bakar", 250000, "Makanan"));


    }

    public void tampilMenu() {
        tampilkanSemuaMenu();
    }

    public void tampilkanSemuaMenu() {
        System.out.println("===== Makanan =====");
        for (MenuItem item : daftarMenu) {
            if (item instanceof Makanan) {
                System.out.println(item.getNama() + " \tRp. " + item.getHarga());
            }
        }

        System.out.println();
        System.out.println("===== Minuman ===== ");
        for (MenuItem item : daftarMenu) {
            if (item instanceof Minuman) {
                System.out.println(item.getNama() + " \tRp. " + item.getHarga());
            }
        }
    }

    public void tampilkanMenuMinuman() {
        System.out.println(" ===== Minuman ===== ");
        for (MenuItem item : daftarMenu) {
            if (item instanceof Minuman) {
                System.out.println(item.getNama() + " \tRp. " + item.getHarga());
            }
        }
    }

    public void tampilDaftarMenu() {
        System.out.println("Daftar Menu:");

        for (int i = 0; i < daftarMenu.size(); i++) {
            MenuItem menuItem = daftarMenu.get(i);
            System.out.println((i + 1) + ". " + menuItem.getNama() + "Rp. " + menuItem.getHarga());
        }
    }


    public MenuItem cariMenu(String namaMenu) {
        for (MenuItem menuItem : daftarMenu) {
            if (menuItem.getNama().equalsIgnoreCase(namaMenu)) {
                return menuItem;
            }
        }

        return null;
    }

    public void ubahHarga(int nomorMenu, int hargaMenu) {
        daftarMenu.get(nomorMenu-1).setHarga(hargaMenu);
    }

    public MenuItem getMenuByIndex(int index) {
        return daftarMenu.get(index-1);
    }

    public void hapusMenu(int nomorMenu) {
        daftarMenu.remove(nomorMenu-1);
    }

    public void tambahMenu(String namaMenu, int hargaMenu, String kategoriMenu) {
        if (kategoriMenu.equalsIgnoreCase("Makanan")) {
            daftarMenu.add(new Makanan(namaMenu, hargaMenu, kategoriMenu));
        } else if (kategoriMenu.equalsIgnoreCase("Minuman")) {
            daftarMenu.add(new Minuman(namaMenu, hargaMenu, kategoriMenu));
        }
    }

    public void exportMenuToTxt(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Daftar Menu:\n");

            for (MenuItem menuItem : daftarMenu) {
                writer.write(menuItem.getNama() + " (" + menuItem.getHarga() + ")\n");
            }

            System.out.println("Menu berhasil diekspor ke " + fileName);
        } catch (IOException e) {
            System.out.println("Gagal mengekspor menu ke file " + fileName);
            e.printStackTrace();
        }
    }

    public void importMenuFromTxt(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("Isi file " + fileName + ":");

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca file " + fileName);
            e.printStackTrace();
        }
    }

    public int getSize() {
        return daftarMenu.size();
    }

}