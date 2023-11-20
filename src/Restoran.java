
import admin.Admin;
import menu.Menu;
import pelanggan.Pelanggan;

import java.util.Scanner;

public class Restoran {
    private Menu menu;
    private Pelanggan pelanggan;
    private Admin admin;

    public Restoran(Menu menuRestoran) {
        this.menu = menuRestoran;
        this.pelanggan = new Pelanggan(menuRestoran);
        this.admin = new Admin(menuRestoran);
    }

    public void startApp() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\033[H\033[2J");
        System.out.println("Silahkan pilih login sebagai:");
        System.out.println("1. Pelanggan");
        System.out.println("2. Admin");

        //handle if input string or other
        while (!scanner.hasNextInt()) {
            System.out.println("Pilihan salah");
            scanner.next();
        }

        int pilihanUser = scanner.nextInt();
        if (pilihanUser == 1) {
            System.out.println("Anda login sebagai Pelanggan");
//            menu.tampilkanSemuaMenu();
            menu.tampilMenu();
            pelanggan.terimaPesanan();
            pelanggan.tampilkanStruk();
        } else if (pilihanUser == 2) {
            System.out.println("Anda login sebagai Admin");
            admin.menuAdmin();
            startApp();
        }
        else {
            System.out.println("Pilihan salah");
            startApp();
        }

        scanner.close();
    }
}