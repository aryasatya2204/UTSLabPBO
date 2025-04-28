package soal1;

import java.util.ArrayList;
import java.util.Scanner;

public class mainA {
    private ArrayList<ClassA> daftarKaryawan;

    public mainA() {
        daftarKaryawan = new ArrayList<>();
    }

    public void tambahKaryawan(ClassA karyawan) {
        if (cariKaryawanById(karyawan.getId()) != null) {
            System.out.println("ID karyawan sudah ada. Tidak dapat menambahkan.");
        } else {
            daftarKaryawan.add(karyawan);
            System.out.println("Karyawan berhasil ditambahkan.");
        }
    }

    public void hapusKaryawan(String id) {
        ClassA karyawan = cariKaryawanById(id);
        if (karyawan != null) {
            daftarKaryawan.remove(karyawan);
            System.out.println("Karyawan dengan ID " + id + " berhasil dihapus.");
        } else {
            System.out.println("Karyawan dengan ID " + id + " tidak ditemukan.");
        }
    }

    public void ubahPosisiKaryawan(String id, String posisiBaru) {
        ClassA karyawan = cariKaryawanById(id);
        if (karyawan != null) {
            karyawan.setPosisi(posisiBaru);
            System.out.println("Posisi karyawan berhasil diubah.");
        } else {
            System.out.println("Karyawan dengan ID " + id + " tidak ditemukan.");
        }
    }

    public void ubahGajiKaryawan(String id, double gajiBaru) {
        ClassA karyawan = cariKaryawanById(id);
        if (karyawan != null) {
            karyawan.setGaji(gajiBaru);
            System.out.println("Gaji karyawan berhasil diubah.");
        } else {
            System.out.println("Karyawan dengan ID " + id + " tidak ditemukan.");
        }
    }

    public void tampilkanSemuaKaryawan() {
        if (daftarKaryawan.isEmpty()) {
            System.out.println("Belum ada karyawan dalam perusahaan.");
        } else {
            System.out.println("Daftar Karyawan:");
            for (ClassA k : daftarKaryawan) {
                k.tampilkanInfo();
            }
        }
    }

    private ClassA cariKaryawanById(String id) {
        for (ClassA karyawan : daftarKaryawan) {
            if (karyawan.getId().equalsIgnoreCase(id)) {
                return karyawan;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        mainA perusahaan = new mainA();
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n=== Sistem Manajemen Karyawan ===");
            System.out.println("1. Tambah Karyawan");
            System.out.println("2. Hapus Karyawan");
            System.out.println("3. Ubah Posisi Karyawan");
            System.out.println("4. Ubah Gaji Karyawan");
            System.out.println("5. Tampilkan Semua Karyawan");
            System.out.println("0. Keluar");
            System.out.print("Pilihan Anda: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Masukkan Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Posisi: ");
                    String posisi = scanner.nextLine();
                    System.out.print("Masukkan Gaji: ");
                    double gaji = scanner.nextDouble();
                    perusahaan.tambahKaryawan(new ClassA(id, nama, posisi, gaji));
                    break;
                case 2:
                    System.out.print("Masukkan ID karyawan yang akan dihapus: ");
                    String idHapus = scanner.nextLine();
                    perusahaan.hapusKaryawan(idHapus);
                    break;
                case 3:
                    System.out.print("Masukkan ID karyawan yang akan diubah posisinya: ");
                    String idPosisi = scanner.nextLine();
                    System.out.print("Masukkan posisi baru: ");
                    String posisiBaru = scanner.nextLine();
                    perusahaan.ubahPosisiKaryawan(idPosisi, posisiBaru);
                    break;
                case 4:
                    System.out.print("Masukkan ID karyawan yang akan diubah gajinya: ");
                    String idGaji = scanner.nextLine();
                    System.out.print("Masukkan gaji baru: ");
                    double gajiBaru = scanner.nextDouble();
                    perusahaan.ubahGajiKaryawan(idGaji, gajiBaru);
                    break;
                case 5:
                    perusahaan.tampilkanSemuaKaryawan();
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan sistem ini.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 0);

        scanner.close();
    }
}