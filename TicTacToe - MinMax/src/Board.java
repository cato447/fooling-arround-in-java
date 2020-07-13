import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class Board extends JPanel implements ActionListener {

    private final int B_WIDTH = 900;
    private final int B_HEIGHT = 900;
    private final int TILE_X = 300;
    private final int TILE_Y = 300;
    private final int DELAY = 50;

    private boolean gameWon = false;
    private boolean initialized = false;

    int[] oldPlayfield;

    private Timer timer;
    private Game game;
    private Painter painter;

    public Board(){
        initBoard();
    }

    private void initBoard(){
        painter = new Painter(B_WIDTH,B_HEIGHT);

        addMouseListener(new MAdapter());
        setBackground(Color.BLACK);
        setFocusable(true);
        setPreferredSize(new Dimension(B_WIDTH,B_HEIGHT));

        initGame();
    }

    private void initGame(){
        game = new Game();
        oldPlayfield = game.getPlayfield().clone();
        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        painter.paintGrid(g);
        updateBoard(g);
    }

    private void updateBoard(Graphics g){
        int actions = 0;
        for (int column = 0; column < 3; column++) {
            for (int row = 0; row < 3; row++) {
                if (game.getPlayfield()[actions] == 1) {
                    painter.drawX(g, column, row);
                } else if (game.getPlayfield()[actions] == -1) {
                    painter.drawO(g, column, row);
                }
                actions++;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!game.checkWin() && isChanged(oldPlayfield)){
            repaint();
            oldPlayfield = game.getPlayfield().clone();
            System.out.println(2);
        } else if (game.checkWin()){
            repaint();
        }
    }

    private boolean isChanged(int[] playfield){
        return !Arrays.equals(game.getPlayfield(), playfield);
    }

    private class MAdapter extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            int column = e.getX()/TILE_X;
            int row = e.getY()/TILE_Y;
            game.setPlayfield(column * 3 + row, 1);
        }
    }
}
