import javax.swing.*;

public class Game {

    public void place(int player, int position, int[] playfield){
        if (playfield[position] == -1){
            playfield[position] = player;
        } else {
            JOptionPane.showConfirmDialog(null,"Tile is already taken");
        }
    }

    private boolean checkWin(int[] playfield){
        for (int i = 0; i < 3; i++){
            if ((playfield[i] == playfield[i+3]) && (playfield[i] == playfield[i+6])){
                System.out.println("vertical");
                return true;
            } else if ((playfield[i*3] == playfield[i*3+1]) && (playfield[i*3] == playfield[i*3+2])){
                System.out.println("horizontal");
                return true;
            }
        }
        return (playfield[2] == playfield[4]) && (playfield[2] == playfield[6]) || (playfield[0] == playfield[4]) && (playfield[0] == playfield[8]);
    }


    public static void main(String[] args) {
        Game game = new Game();
        Render render = new Render();

        int[] playfield = {1,0,-1,1,1,0,-1,0,1};

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                render.createUI(playfield);
            }
        });

        System.out.println(game.checkWin(playfield));
    }
}
