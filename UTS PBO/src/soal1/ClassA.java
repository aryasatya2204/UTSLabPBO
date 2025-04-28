package soal1;

public class ClassA {
    private String id;
    private String nama;
    private String posisi;
    private double gaji;

    public ClassA(String id, String nama, String posisi, double gaji) {
        this.id = id;
        this.nama = nama;
        this.posisi = posisi;
        setGaji(gaji);
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPosisi() {
        return posisi;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

    public double getGaji() {
        return gaji;
    }

    public void setGaji(double gaji) {
        if (gaji < 0) {
            System.out.println("Gaji tidak boleh negatif. Gaji diset ke 0.");
            this.gaji = 0;
        } else {
            this.gaji = gaji;
        }
    }
    public void tampilkanInfo() {
        System.out.println("ID: " + id + " | Nama: " + nama + " | Posisi: " + posisi + " | Gaji: " + String.format("%.0f", gaji));
    }
}