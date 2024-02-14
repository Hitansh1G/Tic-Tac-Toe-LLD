package org.example.Services;

import org.example.Entity.Board;
import org.example.Entity.Player;

public class TicTacToeGame {
    private final Board board;
    private final Player player1;
    private final Player player2;

    public TicTacToeGame(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void playGame(){
        boolean gameOver=false;
        Player currentPlayer = player1;

        while(!gameOver){
            board.display();

            int[]move = currentPlayer.makeMove(board);

            int row = move[0];
            int col = move[1];

            if(board.isCellEmpty(row,col)){
                board.setCell(row,col, currentPlayer.getSymbol());

                if(isWinner(row,col,currentPlayer.getSymbol())){
                    System.out.println(currentPlayer.getSymbol()+" winns");
                    board.display();
                    gameOver = true;
                }else if(isFull()){
                    //if board is full;
                    System.out.println("match draw");
                    gameOver = true;
                    
                }else{
                    if(currentPlayer==player1)currentPlayer=player2;
                    else currentPlayer= player1;
                }

            }else{
                System.out.println("cell is already occupoed .");
            }
        }
    }

    private boolean isFull() {
        String[][] grid = board.getGrid();
        for(int i=0;i< grid.length;i++){
            for(int j=0;j< grid.length;j++){
                if(grid[i][j].equals("-"))return false;
            }
        }
        return true;
    }

    private boolean isWinner(int row, int col, String symbol) {
        //check row
        boolean win =true;
        String[][] grid = board.getGrid();
        for(int i=0;i<grid.length;i++){
            if(!grid[row][i].equals(symbol)){
                win=false;
                break;
            }
        }
        if(win==true)return true;


        //check column

        win = true;

        for(int i=0;i<grid.length;i++){
            if(!grid[i][col].equals(symbol)){
                win=false;
                break;
            }
        }
        if(win)return true;


        //check diagonal

        if(row == col){
            win = true;
            for(int i=0;i<grid.length;i++){
                if(!grid[i][i].equals(symbol)){
                    win=false;
                    break;
                }
            }
            if(win)return true;
        }
        if(row+col == grid.length-1){
            win = true;
            for(int i=0;i<grid.length;i++){
                if(!grid[i][grid.length-1-i].equals(symbol)){
                    win = false;
                    break;
                }
            }
            if(win)return true;
        }
        return false;
    }
}
