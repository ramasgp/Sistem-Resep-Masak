import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class coba {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "user123";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan username: ");
        String usernameInput = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String passwordInput = scanner.nextLine();

        if (!usernameInput.equals(USERNAME) || !passwordInput.equals(PASSWORD)) {
            System.out.println("Username atau password salah. Program berhenti.");
            return;
        }

        System.out.println("Login berhasil. Selamat datang!");
        Map<String, Map<String, Object>> resepMakanan = new HashMap<>();

        Map<String, Object> nasiGoreng = new HashMap<>();
        nasiGoreng.put("Bahan", new String[]{"nasi", "minyak", "bawang merah", "bawang putih", "telur", "kecap", "garam"});
        nasiGoreng.put("Langkah", new String[]{"Panaskan minyak", "Tumis bawang merah dan bawang putih", "Masukkan telur dan aduk", "Tambahkan nasi, kecap, dan garam", "Aduk rata dan sajikan"});
        nasiGoreng.put("Kandungan Gizi", new HashMap<String, Integer>() {{
            put("Kalori", 350);
            put("Karbohidrat", 45);
            put("Protein", 10);
            put("Lemak", 15);
        }});
        nasiGoreng.put("Estimasi Harga", 10000);

        Map<String, Object> capcay = new HashMap<>();
        capcay.put("Bahan", new String[]{"wortel", "kembang kol", "buncis", "sawi", "daun bawang", "sosis", "saus tiram"});
        capcay.put("Langkah", new String[]{"Potong semua bahan", "Panaskan minyak", "Tumis wortel, kembang kol, dan buncis", "Tambahkan sawi, daun bawang, dan sosis", "Tuangkan saus tiram", "Aduk rata dan sajikan"});
        capcay.put("Kandungan Gizi", new HashMap<String, Integer>() {{
            put("Kalori", 200);
            put("Karbohidrat", 30);
            put("Protein", 8);
            put("Lemak", 6);
        }});
        capcay.put("Estimasi Harga", 20000);

        resepMakanan.put("Nasi Goreng Udang", nasiGoreng);
        resepMakanan.put("Capcay", capcay);

        System.out.println("List Makanan:");
        int i = 1;
        for (String makanan : resepMakanan.keySet()) {
            System.out.println(i + ". " + makanan);
            i++;
        }

        System.out.print("Masukkan nomor makanan yang ingin dilihat resepnya: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); 
        if (pilihan > 0 && pilihan <= resepMakanan.size()) {
            String makanan = (String) resepMakanan.keySet().toArray()[pilihan - 1];
            System.out.println("\n");
            System.out.println("Resep " + makanan + ":");

            Map<String, Object> resep = resepMakanan.get(makanan);
            System.out.println("Bahan: " + String.join(", ", (String[]) resep.get("Bahan")));
            System.out.println("Langkah-langkah:");
            String[] langkah = (String[]) resep.get("Langkah");
            for (int j = 0; j < langkah.length; j++) {
                System.out.println((j + 1) + ". " + langkah[j]);
            }
            System.out.println("Kandungan Gizi: " + resep.get("Kandungan Gizi"));
            System.out.println("Estimasi Harga: " + resep.get("Estimasi Harga"));
        } else {
            System.out.println("Nomor makanan tidak valid");
        }
    }
}