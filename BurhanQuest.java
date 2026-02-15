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
        System.setProperty("file.encoding", "UTF-8");
        // Tampilkan banner
        System.out.println(BANNER);
        System.out.println("Selamat datang di BurhanQuest!");
        System.out.println("Dibuat oleh: " + STUDENT_NAME + " - " + STUDENT_ID);
        System.out.println("Mari kita mulai dengan membuat sejumlah data quest dan pengembara.");

        // Seeding data quest dan pengembara
        int questCount = 0, travelerCount = 0;
        boolean invalidInput = true;

        // Input banyak quest dan pengembara
        while (invalidInput) {
            System.out.print("Silakan masukkan banyak quest yang ingin didaftarkan: "); 
            String questCountInput = input.nextLine();
            // Validasi input jumlah quest
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
        
        // Input jumlah pengembara
        invalidInput = true;
        while (invalidInput) {
            System.out.print("Silakan masukkan banyak pengembara yang ingin didaftarkan: ");
            String travelerCountInput = input.nextLine();
            // Validasi input jumlah pengembara
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
                    String statusQuest = "tersedia";
                    questData = questData + nama + ";" + deskripsi + ";" + reward + ";" + bonusExp + ";" + tingkatKesulitan + ";" + statusQuest + "\n";
                    ValidasiQuest = true;
                    System.out.println("Quest berhasil ditambahkan.");
                } else {
                    System.out.println("Input tidak valid. Harap masukkan data dengan benar.");
                }
                }
            }

        System.out.println();

        System.out.println("Mulai memasukkan data pengembara.");
        // Input data pengembara sebanyak pengembara yang diminta
        for (int i = 0; i < travelerCount; i++) {
            boolean ValidasiTraveler = false;
            while(!ValidasiTraveler){
                System.out.println("Pengembara " + (i + 1));
                System.out.print("Masukkan nama pengembara: ");
                String namaPengembara = input.nextLine().trim();
                System.out.print("Masukkan level pengembara berupa bilangan bulat [1-20]: ");
                String levelPengembara = input.nextLine().trim();
                 // Validasi Nama Pengembara
                boolean isPengembaraValid = namaPengembara.matches("^[a-zA-Z0-9 ]+$");
                // Validasi Level Pengembara
                boolean isLevelValid = levelPengembara.matches("^[0-9]+$");
                int levelInput = 0;
                if (isLevelValid) {
                    levelInput = Integer.parseInt(levelPengembara);
                    if (levelInput <1 || levelInput >20){
                        isLevelValid = false;
                    } 
                }
                if (isPengembaraValid && isLevelValid){
                    // Menghitung EXP
                    int expPengembara = 0;
                    if (levelInput == 1){
                        expPengembara = 0;
                    } else{
                        // exp = 5000 * 2 ^ (level-2)
                        expPengembara = (int) (5000 * Math.pow(2, levelInput - 2));
                    }
                    String statusTraveler = "kosong";
                    System.out.println("Pengembara berhasil ditambahkan.");
                    travelerData += namaPengembara + ";" + levelInput + ";" + expPengembara + ";" + statusTraveler + "\n";
                    ValidasiTraveler = true;
                } else{
                    System.out.println("Input tidak valid. Harap masukkan data dengan benar.");
                }
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

             // Atribut Tingkat Kesulitan
            String mudah = "\u2605";
            String menengah = "\u2605 \u2605";
            String sulit = "\u2605 \u2605 \u2605";

            // Atribut Status Quest
            String tersedia = "tersedia \ud83d\udfe2";
            String diambil = " \u231b";
            String selesai = "selesai \ud83c\udfc6";

            // Atribut Status Pengembara
            String kosong = "kosong \u2705";
            String dalamQuest = "dalam quest \u274c";
            switch (choice) {
               
                case "1":
                    // Tampilkan daftar quest
                    System.out.println("Quest yang terdaftar: ");
                    // Memisah data per baris
                    String[] lines = questData.split("\n");
                    int counterId = 1;
                    for (String line : lines){
                        if (line.trim().isEmpty()) continue;
                        // Mengambil data dari input pengguna
                        String[] data = line.split(";");

                        System.out.println("ID Quest: Q" + counterId);
                        System.out.println("Nama Quest: " + data[0]);
                        System.out.println("Deskripsi Quest: " + data[1]);
                        System.out.println("Reward Quest: " + data[2] + " koin");
                        System.out.println("Bonus Exp Quest: " + data[3] + " poin exp");
                        // Mencetak tingkat kesulitan dan status menggunakan unicode
                        System.out.print("Tingkat Kesulitan Quest: ");
                        if (data[4].equalsIgnoreCase("mudah")){
                            System.out.println(mudah);
                        } else if (data[4].equalsIgnoreCase("menengah")){
                            System.out.println(menengah);
                        } else if (data[4].equalsIgnoreCase("sulit")){
                            System.out.println((sulit));
                        }
                        System.out.print("Status Quest: ");
                        if (data[5].equalsIgnoreCase("tersedia")){
                            System.out.println(tersedia);
                        } else if (data[5].startsWith("diambil")){
                            System.out.println(data[5] + " " + diambil);
                        } else if (data[5].equalsIgnoreCase("selesai")){
                            System.out.println(selesai);
                        } 
                        System.out.println();
                        counterId++;
                    }
                    break;
                case "2":
                    // Tampilkan daftar pengembara
                    System.out.println("Pengembara yang terdaftar: ");
                    String[] travelerLines = travelerData.split("\n");
                    int travelerCounter = 1;

                    for (String line : travelerLines){
                        if (line.trim().isEmpty()) continue;

                        String[] data = line.split(";");
                        System.out.println("ID Pengembara: P" + travelerCounter);
                        System.out.println("Nama Pengembara: " + data[0]);
                        System.out.println("Level Pengembara: " + data[1]);
                        System.out.println("Exp Pengembara: " + data[2] + " poin exp");
                        System.out.print("Status Pengembara: ");
                        if (data[3].equalsIgnoreCase("kosong")){
                            System.out.println(kosong);
                        } else if (data[3].equalsIgnoreCase("dalam quest")){
                            System.out.println(dalamQuest);
                        }
                        System.out.println();
                        travelerCounter++;
                    }
                    
                    break;
                case "3":
                    // TODO: Tambah quest
                    String[] linesCount = questData.split("\n");
                    int nomorAddQuest;
                    if (questData.isEmpty()){
                        nomorAddQuest = 1; 
                    } else{
                        nomorAddQuest = linesCount.length + 1;
                    }
                    boolean Menu3 = true;
                    while (Menu3){
                        System.out.println("Quest " + nomorAddQuest);
                        System.out.print("Masukkan nama quest (masukkan 'x' atau 'X' untuk kembali): ");
                        String questNew = input.nextLine().trim();
                        if (questNew.equalsIgnoreCase("x")){
                            Menu3 = false;
                            continue;
                        }
                        System.out.print("Masukkan deskripsi quest (masukkan 'x' atau 'X' untuk kembali): ");
                        String deskripsiNew = input.nextLine().trim();
                        if (deskripsiNew.equalsIgnoreCase("x")){
                            Menu3 = false;
                            continue;
                        }
                        System.out.print("Masukkan reward quest berupa bilangan bulat (masukkan 'x' atau 'X' untuk kembali): ");
                        String rewardNew = input.nextLine().trim();
                        if (rewardNew.equalsIgnoreCase("x")){
                            Menu3 = false;
                            continue;
                        }
                        System.out.print("Masukkan bonus exp quest berupa bilangan bulat (masukkan 'x' atau 'X' untuk kembali): ");
                        String bonusNew = input.nextLine().trim();
                        if (bonusNew.equalsIgnoreCase("x")){
                            Menu3 = false;
                            continue;
                        }
                        System.out.print("Masukkan tingkat kesulitan quest (opsi: mudah, menengah, sulit) (masukkan 'x' atau 'X' untuk kembali): ");
                        String tingkatNew = input.nextLine().trim();
                        if (tingkatNew.equalsIgnoreCase("x")){
                            Menu3 = false;
                            continue;
                        }

                        boolean questNewValid = questNew.matches("^[a-zA-Z0-9 ]+$");
                        boolean deskripsiNewValid = deskripsiNew.matches("^[a-zA-Z0-9 ]+$");
                        boolean rewardNewValid = rewardNew.matches("^[0-9]+$");
                        boolean bonusNewValid = bonusNew.matches("^[0-9]+$");
                        boolean tingkatNewValid = tingkatNew.equalsIgnoreCase("mudah") ||
                                        tingkatNew.equalsIgnoreCase("menengah") ||
                                        tingkatNew.equalsIgnoreCase("sulit");
                
                        if (questNewValid && deskripsiNewValid && rewardNewValid && bonusNewValid && tingkatNewValid) {
                            String statusQuest = "tersedia";
                            questData += questNew + ";" + deskripsiNew + ";" + rewardNew + ";" + bonusNew + ";" + tingkatNew + ";" + statusQuest + "\n";
                            Menu3 = false;
                            System.out.println("Quest berhasil ditambahkan.");
                        } else {
                            System.out.println("Input tidak valid. Harap masukkan data dengan benar.");
                        }

                        }

                    System.out.println();
                    break;

                case "4":
                    // TODO: Tambah pengembara
                    String[] barisCount = travelerData.split("\n");
                    int travelerAdd;
                    if (travelerData.isEmpty()){
                        travelerAdd = 1; 
                    } else{
                        travelerAdd = barisCount.length + 1;
                    }
                    boolean Menu4 = true;
                    while (Menu4){
                        System.out.println("Pengembara " + travelerAdd);
                        System.out.print("Masukkan nama pengembara (masukkan 'x' atau 'X' untuk kembali): ");
                        String namaBaru = input.nextLine().trim();
                        if (namaBaru.equalsIgnoreCase("x")){
                            Menu4 = false;
                            continue;
                        }
                        System.out.print("Masukkan level pengembara berupa bilangan bulat [1-20] (masukkan 'x' atau 'X' untuk kembali): ");
                        String levelNew = input.nextLine().trim();
                        if (levelNew.equalsIgnoreCase("x")){
                            Menu4 = false;
                            continue;
                        }

                        boolean namaBaruValid = namaBaru.matches("^[a-zA-Z0-9 ]+$");
                        boolean levelNewValid = levelNew.matches("^[a-zA-Z0-9 ]+$");
                        int levelBaru = 0;
                        if (levelNewValid) {
                        levelBaru = Integer.parseInt(levelNew);
                        if (levelBaru <1 || levelBaru >20){
                        levelNewValid = false;
                            } 
                        }
                        if (namaBaruValid && levelNewValid){
                        // Menghitung EXP
                        int expNew = 0;
                        if (levelBaru == 1){
                            expNew = 0;
                        } else{
                            // exp = 5000 * 2 ^ (level-2)
                            expNew = (int) (5000 * Math.pow(2, levelBaru - 2));
                        }
                        String statusBaru = "kosong";
                        System.out.println("Pengembara berhasil ditambahkan.");
                        travelerData += namaBaru + ";" + levelBaru + ";" + expNew + ";" + statusBaru + "\n";
                        Menu4 = false;
                    } else{
                        System.out.println("Input tidak valid. Harap masukkan data dengan benar.");
                        }
                    }
                    System.out.println();
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
        System.out.println("Terima kasih telah menggunakan BurhanQuest!");
        System.out.println("Dibuat oleh: " + STUDENT_NAME + " - " + STUDENT_ID + " <3");
        System.out.println(BANNER);
    }
}
