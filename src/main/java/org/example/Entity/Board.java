package org.example.Entity;

public class Board {
    private final int size;
    private final String[][] grid;

    public Board(int size) {
        this.size = size;
        grid = new String[size][size];
        initializeGrid();
    }

    public void initializeGrid() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = "-";
            }
        }
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isCellEmpty(int row, int col) {
        return grid[row][col].equals("-");
    }

    public void setCell(int x, int y, String symbol) {
        grid[x][y] = symbol;
    }

    public int getSize() {
        return size;
    }

    public String[][] getGrid() {
        return grid;
    }
}
