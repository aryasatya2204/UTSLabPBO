package soal3;

import java.util.Random;

public class ClassA {
    private char[][] board;
    private boolean[][] revealed;
    private int[][] data;
    private int safeCellsOpened;
    private boolean gameOver;
    private static final int ROWS = 4;
    private static final int COLS = 5;
    private static final int BOMB_COUNT = 2;

    public ClassA() {
        board = new char[ROWS][COLS];
        revealed = new boolean[ROWS][COLS];
        data = new int[ROWS][COLS];
        safeCellsOpened = 0;
        gameOver = false;
        initializeBoard();
        generateBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = '*';
                revealed[i][j] = false;
                data[i][j] = 0;
            }
        }
    }

    public void generateBoard() {
        Random random = new Random();
        int bombsPlaced = 0;

        // Tempatkan 2 bom secara acak
        while (bombsPlaced < BOMB_COUNT) {
            int row = random.nextInt(ROWS);
            int col = random.nextInt(COLS);
            if (data[row][col] == 0) {
                data[row][col] = 1;
                bombsPlaced++;
            }
        }
    }

    public void displayBoard() {
        System.out.println("\n   0 1 2 3 4");
        System.out.println("  ---------");
        for (int i = 0; i < ROWS; i++) {
            System.out.print(i + " |");
            for (int j = 0; j < COLS; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("  ---------");
    }

    public boolean guess(int row, int col) {
        if (row < 0 || row >= ROWS || col < 0 || col >= COLS) {
            System.out.println("Posisi tidak valid!");
            return true;
        }

        if (revealed[row][col]) {
            System.out.println("Kotak ini sudah dibuka!");
            return true;
        }

        revealed[row][col] = true;

        if (data[row][col] == 1) {
            board[row][col] = 'X';
            gameOver = true;
            return false;
        } else {
            board[row][col] = 'O';
            safeCellsOpened++;
            return true;
        }
    }

    public boolean isGameOver() {
        if (gameOver) {
            return true;
        }
        if (safeCellsOpened == (ROWS * COLS - BOMB_COUNT)) {
            gameOver = true;
            return true;
        }
        return false;
    }

    public boolean getGameOver() {
        return gameOver;
    }
}