package org.example.Entity;

import java.util.Scanner;

public class HumanPlayer implements Player{
    private final String symbol;
    private final Scanner scanner;

    public HumanPlayer(String symbol, Scanner scanner) {
        this.symbol = symbol;
        this.scanner = scanner;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public int[] makeMove(Board board) {
        System.out.println("enter row and column numbers");
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        return new int[]{row,col};
    }
}
