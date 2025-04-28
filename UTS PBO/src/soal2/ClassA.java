package soal2;

public class ClassA {
    private String jenisKendaraan;
    private int lamaParkir;
    private double totalBiaya;

    public ClassA(String jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan.toLowerCase();
        this.lamaParkir = 0;
        this.totalBiaya = 0;
    }

    public void hitungBiaya(int lamaParkir) {
        this.lamaParkir = lamaParkir;
        double biayaPerJam = getBiayaPerJam();
        this.totalBiaya = lamaParkir * biayaPerJam;
        terapkanDiskon();
    }

    public void hitungBiaya(int jamMasuk, int jamKeluar) {
        if (jamKeluar < jamMasuk) {
            jamKeluar += 24;
        }
        this.lamaParkir = jamKeluar - jamMasuk;
        double biayaPerJam = getBiayaPerJam();
        this.totalBiaya = lamaParkir * biayaPerJam;
        terapkanDiskon();
    }

    private double getBiayaPerJam() {
        switch (jenisKendaraan) {
            case "motor":
                return 2000;
            case "mobil":
                return 5000;
            case "truk":
                return 10000;
            default:
                return 0;
        }
    }

    private void terapkanDiskon() {
        if (lamaParkir > 5) {
            this.totalBiaya *= 0.9;
        }
    }

    public void tampilkanRingkasan() {
        System.out.println("Jenis Kendaraan: " + jenisKendaraan);
        System.out.println("Lama Parkir: " + lamaParkir + " jam");
        System.out.printf("Total Biaya: Rp %.0f%n", totalBiaya);
    }

    public double getTotalBiaya() {
        return totalBiaya;
    }

    public String getJenisKendaraan() {
        return jenisKendaraan;
    }
}