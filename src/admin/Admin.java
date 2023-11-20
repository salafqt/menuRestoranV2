package admin;

import menu.Menu;

import java.util.Scanner;

public class Admin {
    private static Menu menu;
    static Scanner scanner = new Scanner(System.in);

    public Admin(menu.Menu menu) {
        this.menu = menu;
    }

    public void menuAdmin() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Apakah anda ingin mengubah harga / menambah menu?:");
        System.out.println("1. Tambah menu");
        System.out.println("2. Ubah harga");
        System.out.println("3. Hapus menu");
        System.out.println("4. Export Menu");
        System.out.println("5. Read Menu");
        System.out.println("6. Selesai");

        int pilihanUser = scanner.nextInt();

        switch (pilihanUser) {
            case 1:
                tambahMenu();
                break;
            case 2:
                ubahHarga();
                break;
            case 3:
                hapusMenu();
                break;
            case 4:
                menu.exportMenuToTxt("Daftar Menu");
                menuAdmin();
                break;
            case 5:
                menu.importMenuFromTxt("Daftar Menu");
                menuAdmin();
                break;
            case 6:
                System.out.println("Selesai");
                return;
            default:
                System.out.println("Pilihan salah");
                menuAdmin();
                break;
        }
    }

    private void tambahMenu() {

        menu.tampilkanSemuaMenu();

        while (true) {
            System.out.println("Masukkan nama menu:");
            String namaMenu = masukkanNamaMenu();
            System.out.println("Masukkan harga menu:");
            int hargaMenu = masukkanHargaMenu();
            scanner.nextLine(); // Consuming the newline character

            System.out.println("Masukkan kategori menu (Makanan/Minuman):");
            String kategoriMenu = masukkanKategoriMenu();

            System.out.println("Apakah anda yakin? (yes/no)");
            boolean selesaiUbah = masukkanKonfirmasi();

            if (selesaiUbah){
                menu.tambahMenu(namaMenu, hargaMenu, kategoriMenu);
                System.out.println("Menu berhasil ditambahkan: " + namaMenu);
                menu.tampilkanSemuaMenu();
                break;
            }else{
                System.out.println("Menu tidak ditambahkan");
                menu.tampilkanSemuaMenu();
                break;
            }
        }

        menuAdmin();
    }

    private void ubahHarga() {

        menu.tampilDaftarMenu();

        while (true) {
            System.out.print("Masukkan nomor menu yang ingin diubah harganya:");
            int nomorMenu = masukkanNomorMenu();

            scanner.nextLine(); // Consuming the newline character

            System.out.print("Masukkan harga menu yang ingin diubah:");
            int hargaMenu = scanner.nextInt();
            scanner.nextLine(); // Consuming the newline character

            System.out.println("Apakah anda yakin?");
            boolean selesaiUbah = masukkanKonfirmasi();

            if (selesaiUbah){
                menu.ubahHarga(nomorMenu, hargaMenu);
                System.out.println("Menu berhasil diubah: " + menu.getMenuByIndex(nomorMenu).getNama() + " = " + menu.getMenuByIndex(nomorMenu).getHarga());
                menu.tampilDaftarMenu();
                break;
            }else{
                System.out.println("Menu tidak diubah");
                menu.tampilkanSemuaMenu();
                break;
            }
        }
        menuAdmin();
    }

    private void hapusMenu() {
        Scanner scanner = new Scanner(System.in);

        menu.tampilDaftarMenu();

        while (true) {
            System.out.print("Masukkan nomor menu yang ingin dihapus:");
            int nomorMenu = masukkanNomorMenu();
            scanner.nextLine(); // Consuming the newline character

            System.out.println("Menu berhasil dihapus.");
            menu.tampilDaftarMenu();

            System.out.println("Apakah anda yakin?)");
            boolean selesaiUbah = masukkanKonfirmasi();

            if (selesaiUbah){
                menu.hapusMenu(nomorMenu);
                System.out.println("Menu berhasil dihapus.");
                menu.tampilDaftarMenu();
                break;
            }else{
                System.out.println("Menu tidak dihapus");
                menu.tampilkanSemuaMenu();
                break;
            }
        }
        menuAdmin();
    }



    public static String masukkanNamaMenu() {
        String namaMenu = scanner.nextLine();

        if (namaMenu.isEmpty()) {
            System.out.println("Nama menu tidak boleh kosong.");
            return masukkanNamaMenu();
        } else {
            return namaMenu;
        }
    }

    public static String masukkanKategoriMenu() {

        System.out.println("1. Makanan");
        System.out.println("2. Minuman");

        int kategoriMenu = scanner.nextInt();
        if (kategoriMenu == 1) {
            return "Makanan";
        } else if (kategoriMenu == 2) {
            return "Minuman";
        } else {
            System.out.println("Kategori menu salah.");
            return masukkanKategoriMenu();
        }
    }

    public static int masukkanHargaMenu() {
        int hargaMenu = 0;
        try {
            hargaMenu = scanner.nextInt();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Input harga salah.");
            return masukkanHargaMenu();
        }
        return hargaMenu;
    }

    public static int masukkanNomorMenu() {
        int nomorMenu = 0;
        try {
            nomorMenu = scanner.nextInt();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Input nomor menu salah.");
            return masukkanNomorMenu();
        }

        if (nomorMenu < 1 || nomorMenu > menu.getSize()) {
            System.out.println("Nomor menu salah, masukkan nomor menu : ");
            return masukkanNomorMenu();
        } else {
            return nomorMenu;
        }
    }

    private static boolean masukkanKonfirmasi() {
        System.out.println("1. Ya");
        System.out.println("0. Tidak");

        int userInput = scanner.nextInt();

        boolean result;

        if (userInput == 1) {
            result = true;
        } else if (userInput == 0) {
            result = false;
        } else {
            System.out.println("Input salah. Harap masukkan 0 atau 1.");
            return masukkanKonfirmasi();
        }

        return result;
    }
}
