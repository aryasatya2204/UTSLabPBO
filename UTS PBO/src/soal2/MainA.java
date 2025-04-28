package soal2;

import java.util.ArrayList;
import java.util.Scanner;

public class MainA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<ClassA> daftarKendaraan = new ArrayList<>();
        int pilihan;

        do {
            System.out.println("\n=== Sistem Parkir ParkirChan ===");
            System.out.println("1. Tambah Kendaraan");
            System.out.println("2. Selesai dan Tampilkan Ringkasan Akhir");
            System.out.print("Pilihan Anda: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            if (pilihan == 1) {
                System.out.print("Masukkan jenis kendaraan (Motor/Mobil/Truk): ");
                String jenis = scanner.nextLine().toLowerCase();

                if (!jenis.equals("motor") && !jenis.equals("mobil") && !jenis.equals("truk")) {
                    System.out.println("Jenis kendaraan tidak valid!");
                    continue;
                }

                ClassA kendaraan = new ClassA(jenis);

                System.out.println("Pilih cara input durasi parkir:");
                System.out.println("1. Input langsung jumlah jam");
                System.out.println("2. Input jam masuk dan jam keluar");
                System.out.print("Pilihan: ");
                int caraInput = scanner.nextInt();

                if (caraInput == 1) {
                    System.out.print("Masukkan lama parkir (jam): ");
                    int lamaParkir = scanner.nextInt();
                    if (lamaParkir <= 0) {
                        System.out.println("Lama parkir harus lebih dari 0!");
                        continue;
                    }
                    kendaraan.hitungBiaya(lamaParkir);
                } else if (caraInput == 2) {
                    System.out.print("Masukkan jam masuk (0-23): ");
                    int jamMasuk = scanner.nextInt();
                    System.out.print("Masukkan jam keluar (0-23): ");
                    int jamKeluar = scanner.nextInt();
                    if (jamMasuk < 0 || jamMasuk > 23 || jamKeluar < 0 || jamKeluar > 23) {
                        System.out.println("Jam tidak valid!");
                        continue;
                    }
                    kendaraan.hitungBiaya(jamMasuk, jamKeluar);
                } else {
                    System.out.println("Pilihan tidak valid!");
                    continue;
                }

                daftarKendaraan.add(kendaraan);
                System.out.println("\nRingkasan Parkir:");
                kendaraan.tampilkanRingkasan();
            } else if (pilihan == 2) {
                tampilkanRingkasanAkhir(daftarKendaraan);
                break;
            } else {
                System.out.println("Pilihan tidak valid!");
            }
        } while (true);

        scanner.close();
    }

    private static void tampilkanRingkasanAkhir(ArrayList<ClassA> daftarKendaraan) {
        System.out.println("\n=== Ringkasan Akhir ===");
        if (daftarKendaraan.isEmpty()) {
            System.out.println("Belum ada kendaraan yang diparkir.");
            return;
        }

        int totalKendaraan = daftarKendaraan.size();
        double totalSemuaBiaya = 0;

        for (ClassA kendaraan : daftarKendaraan) {
            totalSemuaBiaya += kendaraan.getTotalBiaya();
        }

        System.out.println("Jumlah Total Kendaraan: " + totalKendaraan);
        System.out.printf("Total Semua Biaya Parkir: Rp %.0f%n", totalSemuaBiaya);
    }
}