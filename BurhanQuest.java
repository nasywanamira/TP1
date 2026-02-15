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
        // Input data quest sebanyak quest yang diminta
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
        // Loop menu utama
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
                   Scanner questScanner = new Scanner(questData);
                    int counterId = 1;
                    
                    while (questScanner.hasNextLine()) {
                        String line = questScanner.nextLine();
                        if (line.trim().isEmpty()) continue;

                        int index_awal = 0;
                        int index_akhir = line.indexOf(';');
                        String data0 = line.substring(index_awal, index_akhir); // Nama Quest

                        index_awal = index_akhir + 1; // geser ke setelah tanda pemisah ';' sebelumnya
                        index_akhir = line.indexOf(';', index_awal);
                        String data1 = line.substring(index_awal, index_akhir); // Deskripsi Quest

                        index_awal = index_akhir + 1;
                        index_akhir = line.indexOf(';', index_awal);
                        String data2 = line.substring(index_awal, index_akhir); // Reward

                        index_awal = index_akhir + 1;
                        index_akhir = line.indexOf(';', index_awal);
                        String data3 = line.substring(index_awal, index_akhir); // Bonus exp

                        index_awal = index_akhir + 1;
                        index_akhir = line.indexOf(';', index_awal);
                        String data4 = line.substring(index_awal, index_akhir); // Tingkat kesulitan
                        // Untuk yang terakhir, mengambil dari index_awal sampai ujung baris
                        index_awal = index_akhir + 1;
                        String data5 = line.substring(index_awal); // Status Quest
                        

                        System.out.println("ID Quest: Q" + counterId);
                        System.out.println("Nama Quest: " + data0);
                        System.out.println("Deskripsi Quest: " + data1);
                        System.out.println("Reward Quest: " + data2 + " koin");
                        System.out.println("Bonus Exp Quest: " + data3 + " poin exp");
                        // Mencetak tingkat kesulitan dan status menggunakan unicode
                        System.out.print("Tingkat Kesulitan Quest: ");
                        if (data4.equalsIgnoreCase("mudah")){
                            System.out.println(mudah);
                        } else if (data4.equalsIgnoreCase("menengah")){
                            System.out.println(menengah);
                        } else if (data4.equalsIgnoreCase("sulit")){
                            System.out.println((sulit));
                        }
                        System.out.print("Status Quest: ");
                        if (data5.equalsIgnoreCase("tersedia")){
                            System.out.println(tersedia);
                        } else if (data5.startsWith("diambil")){
                            System.out.println(data5 + " " + diambil);
                        } else if (data5.equalsIgnoreCase("selesai")){
                            System.out.println(selesai);
                        } 
                        System.out.println();
                        counterId++;
                    }
                    break;
                case "2":
                    // Tampilkan daftar pengembara
                    System.out.println("Pengembara yang terdaftar: ");
                    Scanner travelerScanner = new Scanner(travelerData);
                    int travelerCounter = 1;
                    
                    while (travelerScanner.hasNextLine()){
                        String line = travelerScanner.nextLine();
                        if (line.trim().isEmpty()) continue;

                        int index_awal = 0;
                        int index_akhir = line.indexOf(';');
                        String data0 = line.substring(index_awal, index_akhir); // Nama Pengembara

                        index_awal = index_akhir + 1;
                        index_akhir = line.indexOf(';', index_awal);
                        String data1 = line.substring(index_awal, index_akhir); // Level Pengembara

                        index_awal = index_akhir +  1;
                        index_akhir = line.indexOf(';', index_awal);
                        String data2 = line.substring(index_awal, index_akhir); // Exp

                        index_awal = index_akhir + 1;
                        String data3 = line.substring(index_awal); // Status

                    
                        System.out.println("ID Pengembara: P" + travelerCounter);
                        System.out.println("Nama Pengembara: " + data0);
                        System.out.println("Level Pengembara: " + data1);
                        System.out.println("Exp Pengembara: " + data2 + " poin exp");
                        System.out.print("Status Pengembara: ");
                        if (data3.equalsIgnoreCase("kosong")){
                            System.out.println(kosong);
                        } else if (data3.equalsIgnoreCase("dalam quest")){
                            System.out.println(dalamQuest);
                        }
                        System.out.println();
                        travelerCounter++;
                    }
                    
                    break;
                case "3":
                    // Tambah quest
                    int nomorAddQuest = 1;
                    if (!questData.isEmpty()){
                        Scanner countQuest = new Scanner(questData);
                        int lineCount = 0;
                        while (countQuest.hasNextLine()) {
                            countQuest.nextLine();
                            lineCount++;
                        }
                        nomorAddQuest = lineCount + 1;
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
                    // Tambah pengembara
                    int travelerAdd = 1;
                    if (!travelerData.isEmpty()){
                        Scanner countTraveler = new Scanner(travelerData);
                        int lineCount = 0;
                        while (countTraveler.hasNextLine()){
                            countTraveler.nextLine();
                            lineCount++;
                        }
                        travelerAdd = lineCount + 1;
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
                    // Menjalankan quest
                    boolean Menu5 = true;
                    while(Menu5){
                        System.out.println("Masukkan ID Quest yang ingin diambil (atau 'X'/'x' untuk kembali): ");
                        String idQuest = input.nextLine().trim();
                        if (idQuest.equalsIgnoreCase("x")){
                            Menu5 = false;
                            continue;
                        } 
                        // Mencari dan Memvalidasi Quest
                        boolean questFound = false;
                        String tingkatKesulitanQuest = "";

                        Scanner qScanner = new Scanner(questData); // Quest Scanner
                        int qCounter = 1;
                        boolean MencariQuest = true;
                        while (qScanner.hasNextLine() && MencariQuest){
                            String line = qScanner.nextLine();
                            if (!line.trim().isEmpty()){

                            String currentQId = "Q" + qCounter;
                            // jika ID cocok (case insensitive)
                            if (currentQId.equalsIgnoreCase(idQuest)){
                                int pos1 = line.indexOf(';');
                                int pos2 = line.indexOf(';', pos1+1);
                                int pos3 = line.indexOf(';', pos2+1);
                                int pos4 = line.indexOf(';', pos3+1);
                                int pos5 = line.indexOf(';', pos4+1);

                                tingkatKesulitanQuest = line.substring(pos4+1, pos5);
                                String statusQuest = line.substring(pos5+1);

                                // Syarat quest: harus "tersedia"
                                if (statusQuest.equalsIgnoreCase("tersedia")){
                                    questFound = true;
                                }
                                MencariQuest = false;
                            } 
                            qCounter++;
                            }
                        }
                        if (!questFound) {
                            System.out.println("Quest tidak ditemukan atau sudah diambil/selesai.");
                        } else{
                            // Jika quest valid, minta ID pengembara
                            System.out.println("Masukkan ID Pengembara yang akan mengambil quest (atau 'X'/'x' untuk kembali): ");
                            String idPengembara = input.nextLine().trim();

                            if (idPengembara.equalsIgnoreCase("x")){
                                Menu5 =  false;
                            } else{
                                // Mencari dan Memvalidasi Pengembara
                                boolean travelerFound = false;
                                Scanner tScanner = new Scanner(travelerData); // traveler scanner
                                int tCounter = 1;
                                boolean MencariPengembara = true;

                                while (tScanner.hasNextLine() && MencariPengembara){
                                    String line = tScanner.nextLine();

                                    if (!line.trim().isEmpty()){
                                        String currentPId = "P" + tCounter;
                                        if (currentPId.equalsIgnoreCase(idPengembara)){
                                            int pos1 = line.indexOf(';');
                                            int pos2 = line.indexOf(';', pos1+1);
                                            int pos3 = line.indexOf(';', pos2+1);

                                            String levelStr = line.substring(pos1+1, pos2);
                                            String statusTraveler = line.substring(pos3+1);

                                            int level = Integer.parseInt(levelStr);
                                            boolean levelCukup = false;

                                            if (tingkatKesulitanQuest.equalsIgnoreCase("sulit")){
                                                if (level >= 16){ 
                                                    levelCukup = true;
                                                }
                                            } else if (tingkatKesulitanQuest.equalsIgnoreCase("menengah")){
                                                if (level >= 6){
                                                    levelCukup = true;
                                                }
                                            } else if (tingkatKesulitanQuest.equalsIgnoreCase("mudah")){
                                                levelCukup = true;
                                            }
                                            if (statusTraveler.equalsIgnoreCase("kosong") && levelCukup){
                                                travelerFound = true;
                                            }
                                            MencariPengembara = false; // Berhenti mencari data pengembara
                                        }
                                        tCounter++;
                                    }
                                }
                                if (!travelerFound){
                                    System.out.println("Pengembara tidak ditemukan atau tidak memenuhi persyaratan untuk mengambil quest.");
                                } else{
                                    // Mengupdate data
                                    String newQuestData = "";
                                    Scanner qUpdateScanner = new Scanner(questData);
                                    int qUpdateCounter = 1;
                                    while (qUpdateScanner.hasNextLine()){
                                        String line = qUpdateScanner.nextLine();
                                        if (!line.trim().isEmpty()){
                                            String currentQid = "Q" + qUpdateCounter;
                                            if (currentQid.equalsIgnoreCase(idQuest)){
                                                newQuestData += line.replace(";tersedia", ";diambil") + "\n";
                                            } else{
                                                newQuestData += line + "\n";
                                            }
                                            qUpdateCounter++;
                                        }
                                    }
                                    questData = newQuestData;

                                    String newTravelerData = "";
                                    Scanner tUpdateScanner = new Scanner(travelerData);
                                    int tUpdateCounter = 1;
                                    while (tUpdateScanner.hasNextLine()){
                                        String line = tUpdateScanner.nextLine();
                                        if (!line.trim().isEmpty()){
                                            String currentPId = "P" + tUpdateCounter;
                                            if (currentPId.equalsIgnoreCase(idPengembara)){
                                                newTravelerData += line.replace(";kosong", ";dalam quest") + "\n";
                                            } else{
                                                newTravelerData += line + "\n";
                                            }
                                            tUpdateCounter++;
                                        }
                                    }
                                    travelerData = newTravelerData;

                                    System.out.println("Quest berhasil diambil!");
                                    Menu5 = false; 
                                }
                            }
                        }

                    }


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
