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
    private static int travelerId= 1;
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
            // Cek apakah input hanya berisi angka 0-9
            if (questCountInput.matches("[0-9]+")) {
                int quest = Integer.parseInt(questCountInput);
                // Validasi logika (harus >= 0), meskipun regex [0-9]+ sudah pasti positif
                // tapi jaga-jaga kalau user input angka sangat besar
                if (quest >= 0) {
                    questCount = quest;
                    invalidInput = false;
                } else {
                    System.out.println("Input tidak valid. Harap masukkan bilangan bulat nonnegatif.");
                }
            } else {
                // Jika input mengandung huruf atau simbol negatif
                System.out.println("Input tidak valid. Harap masukkan bilangan bulat nonnegatif.");
            }
        }
        
        // Input jumlah pengembara
        invalidInput = true;
        while (invalidInput) {
            System.out.print("Silakan masukkan banyak pengembara yang ingin didaftarkan: ");
            String travelerCountInput = input.nextLine();
            // Validasi input jumlah pengembara
           // Cek apakah input hanya berisi angka 0-9
            if (travelerCountInput.matches("[0-9]+")) {
                int traveler = Integer.parseInt(travelerCountInput);
                
                if (traveler >= 0) {
                    travelerCount = traveler;
                    invalidInput = false;
                } else {
                    System.out.println("Input tidak valid. Harap masukkan bilangan bulat nonnegatif.");
                }
            } else {
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
                    System.out.println();
                    System.out.println("----------------------------");
                    System.out.println("Quest yang terdaftar: ");
                    System.out.println("----------------------------");
                    // Memisah data per baris
                   Scanner questScanner = new Scanner(questData);
                    int counterId = 1;
                    
                    while (questScanner.hasNextLine()) {
                        String line = questScanner.nextLine();
                        if (line.trim().isEmpty()) continue;

                        int index_awal = 0;
                        int index_akhir = line.indexOf(';');
                        String nama = line.substring(index_awal, index_akhir); // Nama Quest

                        index_awal = index_akhir + 1; // geser ke setelah tanda pemisah ';' sebelumnya
                        index_akhir = line.indexOf(';', index_awal);
                        String deskripsi = line.substring(index_awal, index_akhir); // Deskripsi Quest

                        index_awal = index_akhir + 1;
                        index_akhir = line.indexOf(';', index_awal);
                        String reward = line.substring(index_awal, index_akhir); // Reward Quest

                        index_awal = index_akhir + 1;
                        index_akhir = line.indexOf(';', index_awal);
                        String bonus = line.substring(index_awal, index_akhir); // Bonus exp

                        index_awal = index_akhir + 1;
                        index_akhir = line.indexOf(';', index_awal);
                        String tingkat = line.substring(index_awal, index_akhir); // Tingkat kesulitan
                        // Untuk yang terakhir, mengambil dari index_awal sampai ujung baris
                        index_awal = index_akhir + 1;
                        String status = line.substring(index_awal); // Status Quest
                        
                        System.out.println("----------------------------");
                        System.out.println("ID Quest: Q" + counterId);
                        System.out.println("Nama Quest: " + nama);
                        System.out.println("Deskripsi Quest: " + deskripsi);
                        System.out.println("Reward Quest: " + reward + " koin");
                        System.out.println("Bonus Exp Quest: " + bonus + " poin exp");
                        // Mencetak tingkat kesulitan dan status menggunakan unicode
                        System.out.print("Tingkat Kesulitan Quest: ");
                        if (tingkat.equalsIgnoreCase("mudah")){
                            System.out.println(mudah);
                        } else if (tingkat.equalsIgnoreCase("menengah")){
                            System.out.println(menengah);
                        } else if (tingkat.equalsIgnoreCase("sulit")){
                            System.out.println((sulit));
                        }
                        System.out.print("Status Quest: ");
                        if (status.equalsIgnoreCase("tersedia")){
                            System.out.println(tersedia);
                        } else if (status.startsWith("diambil")){
                            System.out.println(status + " " + diambil);
                        } else if (status.equalsIgnoreCase("selesai")){
                            System.out.println(selesai);
                        } 
                        System.out.println("----------------------------");
                        System.out.println();
                        counterId++;
                    }
                    break;
                case "2":
                    // Tampilkan daftar pengembara
                    System.out.println();
                    System.out.println("----------------------------");
                    System.out.println("Pengembara yang terdaftar: ");
                    System.out.println("----------------------------");
                    Scanner travelerScanner = new Scanner(travelerData);
                    int travelerCounter = 1;
                    
                    while (travelerScanner.hasNextLine()){
                        String line = travelerScanner.nextLine();
                        if (line.trim().isEmpty()) continue;

                        int index_awal = 0;
                        int index_akhir = line.indexOf(';');
                        String nama = line.substring(index_awal, index_akhir); // Nama Pengembara

                        index_awal = index_akhir + 1;
                        index_akhir = line.indexOf(';', index_awal);
                        String level = line.substring(index_awal, index_akhir); // Level Pengembara

                        index_awal = index_akhir +  1;
                        index_akhir = line.indexOf(';', index_awal);
                        String exp = line.substring(index_awal, index_akhir); // Exp

                        index_awal = index_akhir + 1;
                        String status = line.substring(index_awal); // Status

                        System.out.println("----------------------------");
                        System.out.println("ID Pengembara: P" + travelerCounter);
                        System.out.println("Nama Pengembara: " + nama);
                        System.out.println("Level Pengembara: " + level);
                        System.out.println("Exp Pengembara: " + exp + " poin exp");
                        System.out.print("Status Pengembara: ");
                        if (status.equalsIgnoreCase("kosong")){
                            System.out.println(kosong);
                        } else if (status.equalsIgnoreCase("dalam quest")){
                            System.out.println(dalamQuest);
                        }
                        System.out.println("----------------------------");
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
                        boolean levelNewValid = levelNew.matches("^[0-9]+$");
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
                        System.out.print("Masukkan ID Quest yang ingin diambil (atau 'X'/'x' untuk kembali): ");
                        String idQuest = input.nextLine().trim();
                        if (idQuest.equalsIgnoreCase("x")){
                            Menu5 = false;
                            System.out.println();
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
                            System.out.println();
                        } else{
                            // Jika quest valid, minta ID pengembara
                            System.out.print("Masukkan ID Pengembara yang akan mengambil quest (atau 'X'/'x' untuk kembali): ");
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
                                                newQuestData += line.replace(";tersedia", ";diambil" + "-" + idPengembara.toUpperCase()) + "\n";
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
                                    System.out.println();
                                }
                            }
                        }

                    }
                    break;
                case "6":
                    // Menyelesaikan quest
                    boolean Menu6 = true;
                    while (Menu6){
                        System.out.print("Masukkan ID Quest yang ingin diselesaikan (atau 'X'/'x' untuk kembali): ");
                        String idQuest = input.nextLine().trim();

                        if (idQuest.equalsIgnoreCase("x")){
                            Menu6 = false;
                        } else{
                            // Mencari quest dan ambil data exp serta ID Pengembara yang sedang mengerjakan
                            boolean questFound = false;
                            int bonusExpDapat = 0;
                            String idPengembaraYbs = "";
                            String statusQuestOld = "";

                            Scanner qScanner = new Scanner(questData);
                            int qCounter = 1;
                            boolean MencariQuest = true;

                            while (qScanner.hasNextLine() && MencariQuest){
                                String line = qScanner.nextLine();

                                if (!line.trim().isEmpty()){
                                    String currentQId = "Q" + qCounter;
                                    if (currentQId.equalsIgnoreCase(idQuest)){
                                        int pos1 = line.indexOf(';');
                                        int pos2 = line.indexOf(';',pos1+1);
                                        int pos3 = line.indexOf(';', pos2+1);
                                        int pos4 = line.indexOf(';', pos3+1);
                                        int pos5 = line.indexOf(';', pos4+1);
                                        String expStr = line.substring(pos3+1, pos4);
                                        String statusQuest = line.substring(pos5+1);

                                        // Mengecek apakah statusnya diawali dengan 'diambil'
                                        if (statusQuest.startsWith("diambil")){
                                            questFound = true;
                                            bonusExpDapat = Integer.parseInt(expStr);
                                            statusQuestOld = statusQuest; // Menyimpan tulisan contoh: "diambil-P1"
                                            
                                            // Mengambil ID Pengembara dari buntut status (misal: "diambil-P!" ->"P1")
                                            int stripIndex = statusQuest.indexOf('-');
                                            if (stripIndex != -1){
                                                idPengembaraYbs = statusQuest.substring((stripIndex + 1));
                                            }
                                        }
                                        MencariQuest = false;
                                    }
                                    qCounter++;
                                }
                            }
                            if (!questFound || idPengembaraYbs.isEmpty()){
                                System.out.println("Quest tidak ditemukan atau belum diambil/selesai.");
                            } else{
                                // Proses mengupdate Pengembara (Tambah EXP 7 Level Up)
                                String newTravelerData = "";
                                Scanner tScanner = new Scanner(travelerData);
                                int tCounter = 1;

                                int totalExpBaru = 0;
                                int levelBaruPengembara = 0;
                                boolean isLevelUp = false;

                                while (tScanner.hasNextLine()){
                                    String line = tScanner.nextLine();
                                    if (!line.trim().isEmpty()){
                                        String currentPId = "P" + tCounter;

                                        // Kalo ini pengembara yang mengerjakan quest, kita ubah datanya
                                        if (currentPId.equalsIgnoreCase(idPengembaraYbs)){
                                            int pos1 = line.indexOf(';');
                                            int pos2 = line.indexOf(';', pos1+1);
                                            int pos3 = line.indexOf(';', pos2+1);

                                            String namaStr = line.substring(0, pos1);
                                            String levelStr = line.substring(pos1+1, pos2);
                                            String expStr = line.substring(pos2+1, pos3);

                                            levelBaruPengembara = Integer.parseInt(levelStr);
                                            totalExpBaru = Integer.parseInt(expStr) + bonusExpDapat;

                                            // Level up dijamin hanya naik 1 level real no root
                                            if (levelBaruPengembara < 20){
                                                int syaratExp = (int) (5000 * Math.pow(2, levelBaruPengembara-1)); // Syarat minimal Exp pengembara
                                                if (totalExpBaru >= syaratExp) {
                                                    levelBaruPengembara++;
                                                    isLevelUp = true;
                                                }
                                            }   
                                            // Handle Max EXP jikalau menyentuh level 20 atau exp kelebihan
                                            if (levelBaruPengembara == 20 || totalExpBaru > MAX_EXP){
                                                totalExpBaru = MAX_EXP; // otomatis exp nya menjadi maksimal exp
                                            }
                                            // Membuat ulang baris pengembara
                                            newTravelerData += namaStr + ";" + levelBaruPengembara + ";" + totalExpBaru + ";kosong\n";
                                        } else{
                                            newTravelerData += line + "\n";
                                        }
                                        tCounter++;
                                    }
                                }
                                travelerData = newTravelerData;

                                // Proses update Quest
                                String newQuestData = "";
                                Scanner qUpdateScanner = new Scanner(questData);
                                int qUpdateCounter = 1;

                                while (qUpdateScanner.hasNextLine()){
                                    String line = qUpdateScanner.nextLine();
                                    if (!line.trim().isEmpty()){
                                        String currentQId = "Q" + qUpdateCounter;
                                        if (currentQId.equalsIgnoreCase(idQuest)){
                                            newQuestData += line.replace(";" + statusQuestOld, ";selesai") + "\n";
                                        } else{
                                            newQuestData += line + "\n";
                                        }
                                        qUpdateCounter++;
                                    }
                                }
                                questData = newQuestData; // Update data quest dengan yang baru
                                
                                // Mencetak hasil akhir
                                System.out.println("Quest berhasil diselesaikan!");
                                System.out.println("Exp didapatkan: " + bonusExpDapat);
                                System.out.println("Total Exp: " + totalExpBaru);
                                if (isLevelUp){
                                     System.out.println("Level pengembara naik menjadi: " + levelBaruPengembara);
                                }
                                System.out.println();
                                Menu6 = false;
                            }
                        }
                    }
                    break;
                case "7":
                    // Filter daftar quest
                    boolean Menu7 = true;
                    while (Menu7){
                    System.out.println();
                    System.out.println("Filter daftar quest");
                    System.out.println("1. Filter berdasarkan status");
                    System.out.println("2. Filter berdasarkan tingkat kesulitan");
                    System.out.println("X. Kembali ke menu utama");
                    System.out.print("Masukkan tipe filter: ");
                    String tipeFilterQuest = input.nextLine().trim();

                    if (tipeFilterQuest.equalsIgnoreCase("x")){
                        Menu7 = false;
                    } else if (tipeFilterQuest.equals("1")){
                        System.out.print("Masukkan status quest yang ingin difilter (tersedia/diambil/selesai), masukan 'x' atau 'X' untuk kembali ke menu utama: ");
                        String statusFilter = input.nextLine().trim();
                        // Jika pengguna input X
                        if (statusFilter.equalsIgnoreCase("x")){
                            Menu7 = false;
                        } else if (statusFilter.equalsIgnoreCase("tersedia") || statusFilter.equalsIgnoreCase("diambil") || statusFilter.equalsIgnoreCase("selesai")){
                            Scanner fScannerStatus = new Scanner(questData);
                            counterId = 1; // digit ID quest
                            boolean adaData = false;

                            while (fScannerStatus.hasNextLine()){
                                String line = fScannerStatus.nextLine();
                                if (!line.trim().isEmpty()){
                                    int index_awal = 0;
                                    int index_akhir = line.indexOf(';');
                                    String nama = line.substring(index_awal, index_akhir); // nama quest

                                    index_awal = index_akhir + 1;
                                    index_akhir = line.indexOf(';', index_awal);
                                    String deskripsi = line.substring(index_awal, index_akhir); // deskripsi quest

                                    index_awal = index_akhir + 1;
                                    index_akhir = line.indexOf(';', index_awal);
                                    String reward = line.substring(index_awal, index_akhir); // reward quest

                                    index_awal = index_akhir + 1;
                                    index_akhir = line.indexOf(';', index_awal);
                                    String bonus = line.substring(index_awal, index_akhir); // bonus exp quest

                                    index_awal = index_akhir + 1;
                                    index_akhir = line.indexOf(';', index_awal);
                                    String tingkat = line.substring(index_awal, index_akhir); // tingkat kesulitan quest

                                    index_awal = index_akhir + 1;
                                    String status = line.substring(index_awal); // status quest

                                    boolean match = false;
                                    // pake startsWith untuk mendeteksi "diambil-P1"
                                    if (statusFilter.equalsIgnoreCase("diambil") && status.toLowerCase().startsWith("diambil")){
                                        match = true;
                                    } else if (status.equalsIgnoreCase(statusFilter)){
                                        match = true;
                                    }
                                    if (match){
                                        if (!adaData){
                                            System.out.println();
                                            System.out.println("----------------------------");
                                            System.out.println("\nDaftar quest terfilter:");
                                            adaData = true; // supaya judulnya hanya di-print sekali
                                        }
                                        System.out.println("----------------------------");
                                        System.out.println("ID Quest: Q" + counterId);
                                        System.out.println("Nama Quest: " + nama);
                                        System.out.println("Deskripsi Quest: " + deskripsi);
                                        System.out.println("Reward Quest: " + reward + " koin");
                                        System.out.println("Bonus Exp Quest: " + bonus + " poin exp");

                                        System.out.print("Tingkat Kesulitan Quest: ");
                                        if (tingkat.equalsIgnoreCase("mudah")){
                                            System.out.println(mudah);
                                        } else if (tingkat.equalsIgnoreCase("menengah")){
                                            System.out.println(menengah);
                                        } else if (tingkat.equalsIgnoreCase("sulit")){
                                        System.out.println(sulit);
                                        }
                                    
                                        System.out.print("Status Quest: ");
                                        if (status.equalsIgnoreCase("tersedia")){
                                            System.out.println(tersedia);
                                        } else if (status.toLowerCase().startsWith("diambil")){
                                            System.out.println(status + "-" + diambil);
                                        } else if (status.equalsIgnoreCase("selesai")){
                                         System.out.println(selesai);
                                        }
                                        System.out.println("----------------------------");
                                        System.out.println();
                                    }
                                    counterId++; 
                                }
                            }
                            if (!adaData){ // Jika tidak ada quest dengan status yang difilter user
                                System.out.println("Tidak ada quest dengan status tersebut.");
                                System.out.println();
                            }
                            Menu7 = false;
                           
                        } else{
                        System.out.println("Pilihan tidak valid. Harap masukkan pilihan dengan benar.");
                    }

                    }  else if(tipeFilterQuest.equals("2")){
                        System.out.print("Masukkan tingkat kesulitan quest yang ingin difilter (mudah/menengah/sulit), masukan 'x' atau 'X' untuk kembali ke menu utama: ");
                        String tingkatFilter = input.nextLine().trim();

                        if (tingkatFilter.equalsIgnoreCase("x")){
                            Menu7 = false;
                        } else if (tingkatFilter.equalsIgnoreCase("mudah") || tingkatFilter.equalsIgnoreCase("menengah") || tingkatFilter.equalsIgnoreCase("sulit")){
                            Scanner fScannerTingkat = new Scanner(questData);
                            counterId = 1; // ini nantinya akan menjadi digit ID Quest
                            boolean adaData = false;

                            while (fScannerTingkat.hasNextLine()){
                                String line = fScannerTingkat.nextLine();
                                if (!line.trim().isEmpty()){
                                    int index_awal = 0;
                                    int index_akhir = line.indexOf(';');
                                    String nama = line.substring(index_awal, index_akhir); // Nama Quest

                                    index_awal = index_akhir + 1;
                                    index_akhir = line.indexOf(';', index_awal);
                                    String desk = line.substring(index_awal, index_akhir); // Deskripsi Quest

                                    index_awal = index_akhir + 1;
                                    index_akhir = line.indexOf(';', index_awal);
                                    String reward = line.substring(index_awal, index_akhir); // Reward Quest
                                    
                                    index_awal = index_akhir + 1;
                                    index_akhir = line.indexOf(';', index_awal);
                                    String bonus = line.substring(index_awal, index_akhir); // Bonus Exp Quest
                                    
                                    index_awal = index_akhir + 1;
                                    index_akhir = line.indexOf(';', index_awal);
                                    String tingkat = line.substring(index_awal, index_akhir); // Tingkat kesulitan quest

                                    index_awal = index_akhir + 1;
                                    String status = line.substring(index_awal); // Status Quest

                                    if (tingkat.equalsIgnoreCase(tingkatFilter)){
                                        if (!adaData){
                                            System.out.println();
                                            System.out.println("----------------------------");
                                            System.out.println("\nDaftar quest terfilter:");
                                            System.out.println("----------------------------");
                                            adaData = true;
                                        }
                                        System.out.println("----------------------------");
                                        System.out.println("ID Quest: Q" + counterId);
                                        System.out.println("Nama Quest: " + nama);
                                        System.out.println("Deskripsi Quest: " + desk);
                                        System.out.println("Reward Quest: " + reward + " koin");
                                        System.out.println("Bonus Exp Quest: " + bonus + " poin exp");

                                        System.out.print("Tingkat Kesulitan Quest: ");
                                        if (tingkat.equalsIgnoreCase("mudah")){
                                            System.out.println(mudah);
                                        } else if (tingkat.equalsIgnoreCase("menengah")){
                                            System.out.println(menengah);
                                        } else if (tingkat.equalsIgnoreCase("sulit")){
                                            System.out.println(sulit);
                                        }
                                        System.out.print("Status Quest: ");
                                        if (status.equalsIgnoreCase("tersedia")){
                                            System.out.println(tersedia);
                                        } else if(status.toLowerCase().startsWith("diambil")){
                                            System.out.println(status + "-" + diambil);
                                        } else if (status.equalsIgnoreCase("selesai")){
                                            System.out.println(selesai);
                                        }
                                        System.out.println("----------------------------");
                                        System.out.println();
                                    }
                                    counterId++;
                                }
                            }
                            if (!adaData){ // jika tidak ada quest dengan tingkat kesulitan yang diinput user
                                System.out.println("Tidak ada quest dengan tingkat kesulitan tersebut.");
                                System.out.println();
                            }
                            Menu7 = false;
                        } else {
                            System.out.println("Pilihan tidak valid. Harap masukkan pilihan dengan benar.");
                        }
                    } else {
                        System.out.println("Pilihan tidak valid. Harap masukkan pilihan dengan benar.");
                    }

                    }
                    break;
                case "8":
                    // Filter daftar pengembara
                    boolean Menu8 = true;
                    while (Menu8){
                        System.out.println();
                        System.out.println("Filter daftar pengembara");
                        System.out.println("1. Filter berdasarkan status");
                        System.out.println("2. Filter berdasarkan rentang level");
                        System.out.println("X. kembali ke menu utama");

                        System.out.print("Masukkan tipe filter: ");
                        String tipeFilterTraveler = input.nextLine().trim();

                        if (tipeFilterTraveler.equalsIgnoreCase("x")){
                            Menu8 = false;
                        } if (tipeFilterTraveler.equals("1")){
                            System.out.print("Masukkan status pengembara yang ingin difilter (kosong/dalam quest), masukan 'x' atau 'X' untuk kembali ke menu utama: ");
                            String statusFilter = input.nextLine().trim();

                            if (statusFilter.equalsIgnoreCase("x")){
                                Menu8 = false;
                            } else if (statusFilter.equalsIgnoreCase("kosong") || statusFilter.equalsIgnoreCase("dalam quest")){
                                Scanner fScannerStatus = new Scanner(travelerData);
                                counterId = 1; // digit ID pengembara
                                boolean adaData = false;

                                while (fScannerStatus.hasNextLine()){
                                    String line = fScannerStatus.nextLine();
                                    if (!line.trim().isEmpty()){
                                        int index_awal = 0;
                                        int index_akhir = line.indexOf(';');
                                        String nama = line.substring(index_awal, index_akhir); // nama pengembara

                                        index_awal = index_akhir + 1;
                                        index_akhir = line.indexOf(';', index_awal);
                                        String level = line.substring(index_awal, index_akhir); // level pengembara

                                        index_awal = index_akhir + 1;
                                        index_akhir = line.indexOf(';', index_awal);
                                        String exp = line.substring(index_awal, index_akhir); // Exp pengembara

                                        index_awal = index_akhir + 1;
                                        String status = line.substring(index_awal); // status pengembara

                                        if (status.equalsIgnoreCase(statusFilter)){
                                            if (!adaData){
                                                System.out.println();
                                                System.out.println("----------------------------");
                                                System.out.println("Daftar pengembara terfilter:");
                                                System.out.println("----------------------------");
                                                adaData = true;
                                            }
                                            System.out.println("----------------------------");
                                            System.out.println("ID Pengembara: P" + counterId);
                                            System.out.println("Nama Pengembara: " + nama);
                                            System.out.println("Level Pengembara: " + level);
                                            System.out.println("Exp Pengembara: " + exp + " poin exp");
                                            System.out.println("Status Pengembara: ");
                                            if (status.equalsIgnoreCase("kosong")){
                                                System.out.println(kosong);
                                            } else if (status.equalsIgnoreCase("dalam quest")){
                                                System.out.println(dalamQuest);
                                            }
                                            System.out.println("----------------------------");
                                            System.out.println();
                                        }
                                        counterId++;

                                    }
                                }
                                if (!adaData){ // Jika tidak ada pengembara dengan status yang difilter
                                    System.out.println("Tidak ada pengembara dengan status tersebut.");
                                    System.out.println();
                                }
                                Menu8 = false;
                            } else{
                            System.out.println("Pilihan tidak valid. Harap masukkan pilihan dengan benar.");
                            }
                        } else if (tipeFilterTraveler.equals("2")){
                            System.out.println("Masukkan rentang level (inklusif) yang ingin difilter, masukan 'x' atau 'X' untuk kembali ke menu utama:");
                            System.out.print("Masukkan batas bawah: ");
                            String batasBawahStr = input.nextLine().trim();

                            if (batasBawahStr.equalsIgnoreCase("x")){
                                Menu8 = false;
                            } else if (!batasBawahStr.matches("^[0-9]+$")){
                                System.out.println("Pilihan tidak valid. Harap masukkan pilihan dengan benar.");
                            } else {
                                int batasBawah = Integer.parseInt(batasBawahStr);
                                // Validasi rentang batas bawah
                                if (batasBawah < 1 || batasBawah > 20){
                                    System.out.println("Pilihan tidak valid. Harap masukkan pilihan dengan benar.");
                                } else{
                                    System.out.print("Masukkan batas atas: ");
                                    String batasAtasStr = input.nextLine().trim();

                                    if (batasAtasStr.equalsIgnoreCase("x")){
                                        Menu8 = false;
                                    } else if (!batasAtasStr.matches("^[0-9]+$")){
                                        System.out.println("Pilihan tidak valid. Harap masukkan pilihan dengan benar.");
                                    } else{
                                        int batasAtas = Integer.parseInt(batasAtasStr);
                                        // validasi rentang batas atas (tdk boleh kurang dari batas bawah)
                                        if (batasAtas < batasBawah || batasAtas > 20){
                                            System.out.println("Rentang level tidak valid. Batas bawah harus lebih kecil atau sama dengan batas atas.");
                                        } else{
                                            // Jika semua validasi lolos, baru jalankan scan data
                                            Scanner fScannerLevel = new Scanner(travelerData);
                                            counterId = 1; // untuk digit ID pengembara
                                            boolean adaData = false;

                                            while (fScannerLevel.hasNextLine()){
                                                String line = fScannerLevel.nextLine();
                                                if (!line.trim().isEmpty()){
                                                    int index_awal = 0;
                                                    int index_akhir = line.indexOf(';');
                                                    String nama = line.substring(index_awal, index_akhir); // Nama pengembara

                                                    index_awal = index_akhir + 1;
                                                    index_akhir = line.indexOf(';', index_awal);
                                                    String level = line.substring(index_awal, index_akhir); // Level pengembara

                                                    index_awal = index_akhir + 1;
                                                    index_akhir = line.indexOf(';', index_awal);
                                                    String exp = line.substring(index_awal, index_akhir); // Exp Pengembara

                                                    index_awal = index_akhir + 1;
                                                    String status = line.substring(index_awal); // Status Pengembara

                                                    int levelInt = Integer.parseInt(level); // Mengubah tipe data string level menjadi integer agar bisa menggunakan operasi ><

                                                    if (levelInt >= batasBawah && levelInt <= batasAtas){
                                                        if (!adaData){
                                                            System.out.println();
                                                            System.out.println("-----------------------------");
                                                            System.out.println("Daftar pengembara terfilter: ");
                                                            System.out.println("----------------------------");
                                                            adaData = true;
                                                        }
                                                        System.out.println();
                                                        System.out.println("ID Pengembara: P" + counterId);
                                                        System.out.println("Nama Pengembara: " + nama);
                                                        System.out.println("Level Pengembara: " + level);
                                                        System.out.println("Exp Pengembara: " + exp + " poin exp");
                                                        System.out.print("Status Pengembara: ");
                                                        if (status.equalsIgnoreCase("kosong")){
                                                            System.out.println(kosong);
                                                        } else if (status.equalsIgnoreCase("dalam quest")){
                                                            System.out.println(dalamQuest);
                                                        }
                                                        System.out.println("----------------------------");
                                                        System.out.println();
                                                    // LANJUT SAMPE SINI. ADMIN MENYERAH
                                                    } counterId++;
                                                }
                                            }
                                            if (!adaData){ // Kalo input rentang level pengembara tapi gak ada pengembara yang memenuhi rentang tersebut
                                                System.out.println("Tidak ada pengembara dalam rentang level tersebut.");
                                                System.out.println();
                                            }
                                            Menu8 = false;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case "9":
                    // Tampilkan daftar quest terurut
                    boolean Menu9 = true;
                    while (Menu9){

                    }
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
