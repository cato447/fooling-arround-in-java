import javax.swing.*;
import java.util.Arrays;

public class Game {

    private int[] playfield;
    private int boardValue;
    private boolean turnTaken = false;
    private int winningX1,winningY1,winningX2,winningY2;

    public Game(){
        playfield = new int[9];
        boardValue = 0;
    }

    public void place(int position, int player){
        if (playfield[position] == 0){
            playfield[position] = player;
            if (player == 1) {
                turnTaken = true;
            }
        } else {
            JOptionPane.showInternalMessageDialog(null,"Tile is already taken");
        }
    }

    public void computersTurn(){

    }

    public boolean checkWin(int[] board) {
        //only check if winning is possible
        if (emptyTiles() < 5) {
            System.out.println(boardValue);
            for (int i = 0; i < 3; i++) {
                //horizontal
                if ((board[i] == board[i + 3] && board[i] != 0) && (board[i] == board[i + 6])) {
                    winningX1 = 75;
                    winningX2 = 825;
                    winningY1 = winningY2 = i * 300 + 150;
                    if (board[i] == 1){
                        boardValue = 10;
                    } else {
                        boardValue = -10;
                    }
                    return true;
                }
                //vertical
                else if ((board[i * 3] == board[i * 3 + 1] && board[i * 3] != 0) && (board[i * 3] == board[i * 3 + 2])) {
                    winningY1 = 75;
                    winningY2 = 825;
                    winningX1 = winningX2 = i * 300 + 150;
                    if (board[i * 3] == 1){
                        boardValue = 10;
                    } else {
                        boardValue = -10;
                    }
                    return true;
                }
            }
            //diagonal
            if ((board[2] == board[4] && board[2] != 0) && (board[2] == board[6])){
                winningX2 = winningY1 = 75;
                winningX1 = winningY2 = 825;
                if (board[2] == 1){
                    boardValue = 10;
                } else {
                    boardValue = -10;
                }
                return true;
            } else if ((board[0] == board[4] && board[0] != 0) && (board[0] == board[8])){
                winningX1 = winningY1 = 75;
                winningX2 = winningY2 = 825;
                if (board[0] == 1){
                    boardValue = 10;
                } else {
                    boardValue = -10;
                }
                return true;
            }
        }
        boardValue = 0;
        return false;
    }
    
    public int emptyTiles(){
        int n = 9;
        for (int i = 0; i < playfield.length; i++){
            if (playfield[i] != 0){
                n -= 1;
            }
        }
        return n;
    }

    public boolean isTurnTaken() {
        return turnTaken;
    }

    public void setTurnTaken(boolean turnTaken) {
        this.turnTaken = turnTaken;
    }

    public void setPlayfield(int position, int value) {
        playfield[position] = value;
    }

    public int[] getPlayfield() {
        return playfield;
    }

    public int getWinningX1() {
        return winningX1;
    }

    public int getWinningX2() {
        return winningX2;
    }

    public int getWinningY1() {
        return winningY1;
    }

    public int getWinningY2() {
        return winningY2;
    }

    public int getBoardValue(int[] board) {
        checkWin(board);
        return boardValue;
    }

    public void setBoardValue(int boardValue) {
        this.boardValue = boardValue;
    }
}
