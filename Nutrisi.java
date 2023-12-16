import java.util.ArrayList;
import java.util.Scanner;

class ResepMasak {
    String namaMasakan;
    double harga;
    String kandunganNutrisi;

    public ResepMasak(String namaMasakan, double harga, String kandunganNutrisi) {
        this.namaMasakan = namaMasakan;
        this.harga = harga;
        this.kandunganNutrisi = kandunganNutrisi;
    }

    public String getNamaMasakan() {
        return namaMasakan;
    }

    public double getHarga() {
        return harga;
    }

    public String getKandunganNutrisi() {
        return kandunganNutrisi;
    }
}

class Nutrisiers {
    private ArrayList<ResepMasak> resepMasakList;

    public Nutrisiers() {
        resepMasakList = new ArrayList<>();
    }

    public void tambahResep(String namaMasakan, double harga, String kandunganNutrisi) {
        ResepMasak resep = new ResepMasak(namaMasakan, harga, kandunganNutrisi);
        resepMasakList.add(resep);
        System.out.println("Resep masakan berhasil ditambahkan!");
    }

    public void tampilkanResep() {
        if (resepMasakList.isEmpty()) {
            System.out.println("Belum ada resep masakan yang tersedia.");
        } else {
            System.out.println("Daftar Resep Masakan:");
            for (int i = 0; i < resepMasakList.size(); i++) {
                ResepMasak resep = resepMasakList.get(i);
                System.out.println("[" + (i + 1) + "]");
                System.out.println("Nama Masakan: " + resep.getNamaMasakan());
                System.out.println("Harga: " + resep.getHarga());
                System.out.println("Kandungan Nutrisi: " + resep.getKandunganNutrisi());
                System.out.println();
            }
        }
    }

    public void editResep(int index, String namaMasakan, double harga, String kandunganNutrisi) {
        if (index >= 0 && index < resepMasakList.size()) {
            ResepMasak resep = resepMasakList.get(index);
            resep.namaMasakan = namaMasakan;
            resep.harga = harga;
            resep.kandunganNutrisi = kandunganNutrisi;
            System.out.println("Resep masakan berhasil diubah!");
        } else {
            System.out.println("Indeks resep masakan tidak valid.");
        }
    }

    public void hapusResep(int index) {
        if (index >= 0 && index < resepMasakList.size()) {
            resepMasakList.remove(index);
            System.out.println("Resep masakan berhasil dihapus!");
        } else {
            System.out.println("Indeks resep masakan tidak valid.");
        }
    }
}

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean isValid(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}

public class Nutrisi {
    public static void main(String[] args) {
        Nutrisiers nutrisiers = new Nutrisiers();
        Scanner scanner = new Scanner(System.in);

        User user = new User("nutrisi", "nutrisi123"); 
        System.out.println("===== Login =====");
        System.out.print("Username: ");
        String usernameInput = scanner.nextLine();
        System.out.print("Password: ");
        String passwordInput = scanner.nextLine();

        if (user.isValid(usernameInput, passwordInput)) {
            System.out.println("Login berhasil!");
            while (true) {
                System.out.println("===== Aplikasi Resep Masak =====");
                System.out.println("1. Tampilkan Resep");
                System.out.println("2. Tambah Resep");
                System.out.println("3. Edit Resep");
                System.out.println("4. Hapus Resep");
                System.out.println("5. Keluar");
                System.out.print("Pilih menu: ");
                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:
                        nutrisiers.tampilkanResep();
                        break;
                    case 2:
                        System.out.print("Nama Masakan: ");
                        String namaMasakan = scanner.nextLine();
                        System.out.print("Harga: ");
                        double harga = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Kandungan Nutrisi: ");
                        String kandunganNutrisi = scanner.nextLine();
                        nutrisiers.tambahResep(namaMasakan, harga, kandunganNutrisi);
                        break;
                    case 3:
                        nutrisiers.tampilkanResep();
                        System.out.print("Pilih nomor resep yang akan diubah: ");
                        int indeksEdit = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nama Masakan: ");
                        namaMasakan = scanner.nextLine();
                        System.out.print("Harga: ");
                        harga = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Kandungan Nutrisi: ");
                        kandunganNutrisi = scanner.nextLine();
                        nutrisiers.editResep(indeksEdit - 1, namaMasakan, harga, kandunganNutrisi);
                        break;
                    case 4:
                        nutrisiers.tampilkanResep();
                        System.out.print("Pilih nomor resep yang akan dihapus: ");
                        int indeksHapus = scanner.nextInt();
                        nutrisiers.hapusResep(indeksHapus - 1);
                        break;
                    case 5:
                        System.out.println("Terima kasih telah menggunakan aplikasi Resep Masak!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                        break;
                }
                System.out.println();
            }
        } else {
            System.out.println("Login gagal. Username atau password salah.");
        }
    }
}
