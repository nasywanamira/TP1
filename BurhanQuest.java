import java.util.Scanner;

public class BurhanQuest {
    // Banner pembuka, silakan manfaatkan variabel ini untuk menampilkan banner di awal dan di akhir program
    private static final String BANNER = "                                                                       \r\n" + //
                "                                                                       \r\n" + //
                "█████▄ ▄▄ ▄▄ ▄▄▄▄  ▄▄ ▄▄  ▄▄▄  ▄▄  ▄▄ ▄█████▄ ▄▄ ▄▄ ▄▄▄▄▄  ▄▄▄▄ ▄▄▄▄▄▄ \r\n" + //
                "██▄▄██ ██ ██ ██▄█▄ ██▄██ ██▀██ ███▄██ ██ ▄ ██ ██ ██ ██▄▄  ███▄▄   ██   \r\n" + //
                "██▄▄█▀ ▀███▀ ██ ██ ██ ██ ██▀██ ██ ▀██ ▀█████▀ ▀███▀ ██▄▄▄ ▄▄██▀   ██   \r\n" + //
                "                                           ▀▀                          ";
    private static final String STUDENT_NAME = "Nasywa Namira Suhendro";
    private static final String STUDENT_ID = "2506532196";


    // Penanda atribut, silakan manfaatkan variabel ini untuk menandai atribut di dalam data
    // Atribut yang sama
    private static final char NAME_IDENTIFIER = '!';
    private static final char STATUS_IDENTIFIER = '@';
    private static final char EXP_IDENTIFIER = '#';

    // Atribut khusus quest
    private static int questId = 1;
    private static final char REWARD_IDENTIFIER = '$';
    private static final char DESC_IDENTIFIER = '%';
    private static final char DIFFICULTY_IDENTIFIER = '^';

    // Atribut khusus pengembara
    private static int travelerId = 1;
    private static final char LEVEL_IDENTIFIER = '$';

    private static final int MAX_EXP = 1_310_720_000;

    // Scanner untuk input, silakan manfaatkan variabel ini untuk mengambil input dari user
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        // TODO: Tampilkan banner
        System.out.println(BANNER);
        System.out.println("Selamat datang di BurhanQuest!");
        System.out.println("Dibuat oleh: " + STUDENT_NAME + " - " + STUDENT_ID);
        System.out.println("Mari kita mulai dengan membuat sejumlah data quest dan pengembara.");

        // TODO: Seeding data quest dan pengembara
        int questCount = 0, travelerCount = 0;
        boolean invalidInput = true;

        // TODO: Input banyak quest dan pengembara
        while (invalidInput) {
            System.out.print("Silakan masukkan banyak quest yang ingin didaftarkan: "); 
            String questCountInput = input.nextLine();
            // TODO: Validasi input jumlah quest
            try {
                int quest = Integer.parseInt(questCountInput); // mengubah string ke integer
                
                if (quest >= 0) {
                        questCount = quest;
                        invalidInput = false;
                    }
                else {
                    System.out.println("Input tidak valid. Harap masukkan bilangan bulat nonnegatif.");
                    }
            }
            catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Harap masukkan bilangan bulat nonnegatif.");
            }
        }
        
        // TODO: Input jumlah pengembara
        invalidInput = true;
        while (invalidInput) {
            System.out.print("Silakan masukkan banyak pengembara yang ingin didaftarkan: ");
            String travelerCountInput = input.nextLine();
            // TODO: Validasi input jumlah pengembara
            try {
                int traveler = Integer.parseInt(travelerCountInput);

                if (traveler >= 0) {
                    travelerCount = traveler;
                    invalidInput = false;
                    }
                else {
                    System.out.println("Input tidak valid. Harap masukkan bilangan bulat nonnegatif.");
                    }
            }
            catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Harap masukkan bilangan bulat nonnegatif.");
            }
        }
        System.out.println();

        String questData = "";
        String travelerData = "";
        System.out.println("Mulai memasukkan data quest.");
        // TODO: Input data quest sebanyak quest yang diminta
        for (int i = 0; i < questCount; i++) {
            boolean ValidasiQuest = false;
            while (!ValidasiQuest) {
                System.out.println("Quest " + (i + 1));
                System.out.print("Masukkan nama quest: ");
                String nama = input.nextLine().trim();
                System.out.print("Masukkan deskripsi quest: ");
                String deskripsi = input.nextLine().trim();
                System.out.print("Masukkan reward quest berupa bilangan bulat nonnegatif: ");
                String reward = input.nextLine().trim();
                System.out.print("Masukkan bonus exp quest berupa bilangan bulat nonnegatif: ");
                String bonusExp = input.nextLine().trim();
                System.out.print("Masukkan tingkat kesulitan quest (opsi: mudah, menengah, sulit): ");
                String tingkatKesulitan = input.nextLine().trim();

                boolean isNamaValid = nama.matches("^[a-zA-Z0-9 ]+$");
                boolean isDeskripsiValid = deskripsi.matches("^[a-zA-Z0-9 ]+$");
                boolean isRewardValid = reward.matches("^[0-9]+$");
                boolean isExpValid = bonusExp.matches("^[0-9]+$");
                boolean isTingkatValid = tingkatKesulitan.equalsIgnoreCase("mudah") ||
                                        tingkatKesulitan.equalsIgnoreCase("menengah") ||
                                        tingkatKesulitan.equalsIgnoreCase("sulit");
                
                if (isNamaValid && isDeskripsiValid && isRewardValid && isExpValid && isTingkatValid) {
                    questData += // nanti dilanjut
                    ValidasiQuest = true;
                    System.out.println("Quest berhasil ditambahkan.");
                } else {
                    System.out.println("Input tidak valid. Harap masukkan data dengan benar.");
                }
                }
            }

        System.out.println();

        System.out.println("Mulai memasukkan data pengembara.");
        // TODO: Input data pengembara sebanyak pengembara yang diminta
        for (int i = 0; i < travelerCount; i++) {
            boolean ValidasiTraveler = false;
            while(!ValidasiTraveler){
                System.out.print("Pengembara " + (i + 1));
                System.out.print("Masukkan nama pengembara: ");
                String pengembara = input.nextLine().trim();
                System.out.print("Masukkan level pengembara berupa bilangan bulat: ");
                String level = input.nextLine().trim();

                boolean isPengembaraValid = pengembara.matches("^[a-zA-Z0-9 ]+$");
                // boolean isLevelValid = dilanjut sampai sini
            }
            
        }
        System.out.println("Data berhasil dimasukkan.");
        System.out.println();

        boolean running = true;
        // TODO: Loop menu utama
        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Lihat daftar quest");
            System.out.println("2. Lihat daftar pengembara");
            System.out.println("3. Tambah quest");
            System.out.println("4. Tambah pengembara");
            System.out.println("5. Menjalankan quest");
            System.out.println("6. Menyelesaikan quest");
            System.out.println("7. Filter daftar quest");
            System.out.println("8. Filter daftar pengembara");
            System.out.println("9.Tampilkan daftar quest terurut");
            System.out.println("10.Tampilkan daftar pengembara terurut");
            System.out.println("11. Keluar");
            System.out.print("Masukkan pilihan: ");
            String choice = input.nextLine().trim();

            switch (choice) {
                case "1":
                    // TODO: Tampilkan daftar quest
                    System.out.println("Belum diimplementasikan");
                    break;
                case "2":
                    // TODO: Tampilkan daftar pengembara
                    System.out.println("Belum diimplementasikan");
                    break;
                case "3":
                    // TODO: Tambah quest
                    System.out.println("Belum diimplementasikan");
                    break;
                case "4":
                    // TODO: Tambah pengembara
                    System.out.println("Belum diimplementasikan");
                    break;
                case "5":
                    // TODO: Menjalankan quest
                    System.out.println("Belum diimplementasikan");
                    break;
                case "6":
                    // TODO: Menyelesaikan quest
                    System.out.println("Belum diimplementasikan");
                    break;
                case "7":
                    // TODO: Filter daftar quest
                    System.out.println("Belum diimplementasikan");
                    break;
                case "8":
                    // TODO: Filter daftar pengembara
                    System.out.println("Belum diimplementasikan");
                    break;
                case "9":
                    // TODO: Tampilkan daftar quest terurut
                    System.out.println("Belum diimplementasikan");
                    break;
                case "10":
                    // TODO: Tampilkan daftar pengembara terurut
                    System.out.println("Belum diimplementasikan");
                    break;
                case "11":
                    // TODO: Keluar
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        }
        // Menampilkan banner penutup
        System.out.println(BANNER);
        System.out.println("Terima kasih telah menggunakan BurhanQuest!");
        System.out.println("Dibuat oleh: " + STUDENT_NAME + " - " + STUDENT_ID + "<3");
    }
}
