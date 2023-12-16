import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Resep {
    private String nama;
    private List<String> bahan;
    private List<String> instruksi;

    public Resep(String nama, List<String> bahan, List<String> instruksi) {
        this.nama = nama;
        this.bahan = bahan;
        this.instruksi = instruksi;
    }

    public String getNama() {
        return nama;
    }

    public List<String> getBahan() {
        return bahan;
    }

    public List<String> getInstruksi() {
        return instruksi;
    }
}

class AplikasiResep {
    private List<Resep> resepList;

    public AplikasiResep() {
        resepList = new ArrayList<>();
    }

    public void tambahResep(Resep resep) {
        resepList.add(resep);
        System.out.println("Resep '" + resep.getNama() + "' berhasil ditambahkan.");
    }

    public void lihatResep() {
        if (resepList.isEmpty()) {
            System.out.println("Belum ada resep yang tersedia.");
        } else {
            for (Resep resep : resepList) {
                System.out.println("Nama Resep: " + resep.getNama());
                System.out.println("Bahan-bahan:");
                for (String bahan : resep.getBahan()) {
                    System.out.println("- " + bahan);
                }
                System.out.println("Instruksi:");
                for (String instruksi : resep.getInstruksi()) {
                    System.out.println("- " + instruksi);
                }
                System.out.println();
            }
        }
    }

    public void hapusResep(String namaResep) {
        boolean found = false;
        for (Resep resep : resepList) {
            if (resep.getNama().equalsIgnoreCase(namaResep)) {
                resepList.remove(resep);
                found = true;
                System.out.println("Resep '" + namaResep + "' berhasil dihapus.");
                break;
            }
        }
        if (!found) {
            System.out.println("Resep '" + namaResep + "' tidak ditemukan.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        AplikasiResep aplikasiResep = new AplikasiResep();
        Scanner scanner = new Scanner(System.in);

        String username = "koki";
        String password = "koki123";

        System.out.print("Username: ");
        String inputUsername = scanner.nextLine();

        System.out.print("Password: ");
        String inputPassword = scanner.nextLine();

        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            while (true) {
                System.out.println("===== Aplikasi Resep Masak =====");
                System.out.println("1. Tambah Resep");
                System.out.println("2. Lihat Resep");
                System.out.println("3. Hapus Resep");
                System.out.println("0. Keluar");
                System.out.print("Pilihan: ");
                int pilihan = scanner.nextInt();
                scanner.nextLine(); // Mengonsumsi karakter newline

                if (pilihan == 1) {
                    System.out.print("Masukkan Nama Resep: ");
                    String namaResep = scanner.nextLine();

                    List<String> bahan = new ArrayList<>();
                    System.out.println("Masukkan Bahan-bahan (selesai dengan 'selesai'):");
                    while (true) {
                        String bahanInput = scanner.nextLine();
                        if (bahanInput.equalsIgnoreCase("selesai")) {
                            break;
                        }
                        bahan.add(bahanInput);
                    }

                    List<String> instruksi = new ArrayList<>();
                    System.out.println("Masukkan Instruksi (selesai dengan 'selesai'):");
                    while (true) {
                        String instruksiInput = scanner.nextLine();
                        if (instruksiInput.equalsIgnoreCase("selesai")) {
                            break;
                        }
                        instruksi.add(instruksiInput);
                    }

                    Resep resep = new Resep(namaResep, bahan, instruksi);
                    aplikasiResep.tambahResep(resep);
                } else if (pilihan == 2) {
                    aplikasiResep.lihatResep();
                } else if (pilihan == 3) {
                    System.out.print("Masukkan Nama Resep yang akan dihapus: ");
                    String namaResep = scanner.nextLine();
                    aplikasiResep.hapusResep(namaResep);
                } else if (pilihan == 0) {
                    System.out.println("Terima kasih telah menggunakan Aplikasi Resep Masak!");
                    break;
                } else {
                    System.out.println("Pilihan tidak valid.");
                }

                System.out.println();
            }
        } else {
            System.out.println("Login gagal. Username atau password salah.");
        }

        scanner.close();
    }
}
