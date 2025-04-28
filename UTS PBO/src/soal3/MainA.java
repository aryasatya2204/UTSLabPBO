package soal3;

import java.util.Scanner;

public class MainA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClassA lotre = new ClassA();

        System.out.println("=== Lotre Gosok Bang Pawwry ===");
        System.out.println("Papan berukuran 4x5, terdapat 2 bom.");
        System.out.println("Buka 18 kotak aman untuk menang, hindari bom!");
        System.out.println("Masukkan posisi (baris kolom), misal: 0 1");

        while (!lotre.isGameOver()) {
            lotre.displayBoard();
            System.out.print("Masukkan tebakan (baris kolom): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            boolean isSafe = lotre.guess(row, col);

            if (!isSafe) {
                lotre.displayBoard();
                System.out.println("BOOM! Kamu mengenai bom. Permainan selesai!");
                break;
            } else if (lotre.isGameOver()) {
                lotre.displayBoard();
                System.out.println("Selamat! Kamu berhasil membuka semua kotak aman!");
                break;
            }
        }

        scanner.close();
    }
}