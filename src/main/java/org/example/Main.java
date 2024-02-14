package org.example;

import org.example.Entity.Board;
import org.example.Entity.HumanPlayer;
import org.example.Entity.Player;
import org.example.Services.TicTacToeGame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Game Started");
        Board board = new Board(3);
        Scanner scanner = new Scanner(System.in);
        Player player1 = new HumanPlayer("X",scanner);
        Player player2 = new HumanPlayer("O",scanner);

        TicTacToeGame game = new TicTacToeGame(board,player1,player2);
        game.playGame();
    }
}