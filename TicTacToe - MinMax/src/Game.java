import javax.swing.*;

public class Game {

    int[] playfield;

    public Game(){
        playfield = new int[9];
    }

    public void place(int player, int position){
        if (playfield[position] == -1){
            playfield[position] = player;
        } else {
            JOptionPane.showConfirmDialog(null,"Tile is already taken");
        }
    }

    public boolean checkWin() {
        if (emptyTiles() < 5) {
            for (int i = 0; i < 3; i++) {
                if ((playfield[i] == playfield[i + 3]) && (playfield[i] == playfield[i + 6])) {
                    System.out.println("vertical");
                    return true;
                } else if ((playfield[i * 3] == playfield[i * 3 + 1]) && (playfield[i * 3] == playfield[i * 3 + 2])) {
                    System.out.println("horizontal");
                    return true;
                }
            }
            return (playfield[2] == playfield[4]) && (playfield[2] == playfield[6]) || (playfield[0] == playfield[4]) && (playfield[0] == playfield[8]);
        } else {
            return false;
        }
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

    public void setPlayfield(int position, int value) {
        playfield[position] = value;
    }

    public int[] getPlayfield() {
        return playfield;
    }
}
