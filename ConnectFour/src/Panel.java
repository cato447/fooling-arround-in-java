import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Panel extends JPanel implements ActionListener {

    private final int DELAY = 10;
    private final int BOARD_W = 700;
    private final int BOARD_H = 600;
    private Chip[][] board = new Chip[7][6];
    private boolean isFinished = true;
    private boolean right,left,space;
    private int times = 0;

    private Painter painter;
    private Timer timer;

    public Panel() {
        initBoard();
        initGame();
    }

    private void initBoard() {
        setPreferredSize(new Dimension(BOARD_W, BOARD_H));
        setBackground(Color.LIGHT_GRAY);
        addKeyListener(new MovingKeyListener());
    }

    private void initGame() {
        painter = new Painter(this, BOARD_W, BOARD_H);
        timer = new Timer(DELAY, this);
        timer.start();
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        painter.paintBoard(g);
        actualizeBoard(g);
        if (isFinished){
            fillBoard();
            isFinished = false;
        }
    }

    public void actualizeBoard(Graphics g){
        for (Chip[] chips : board) {
            for (Chip chip: chips) {
                if (chip != null){
                    painter.paintChip(g, chip.isRed(), chip.getPosition().x, chip.getPosition().y);
                }
            }
        }
    }

    public void fillBoard(){
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                for (int column = 0; column < 7; column++){
                    for (int row = 0; row < 7; row++){
                        Thread.sleep(10);
                        addToBoard(new Chip(times % 2 == 0, row, column));
                    }
                }
                return null;
            }

            @Override
            protected void done() {
                super.done();
                times++;
                isFinished = true;
                System.out.println(times);
            }
        };
        worker.execute();
    }

    public void addToBoard (Chip chip){
        board[chip.getPosition().x][chip.getPosition().y] = chip;
    }

    class MovingKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
            int keyPressed = e.getKeyCode();
            switch (keyPressed) {
                case KeyEvent.VK_RIGHT:
                    right = true;
                    break;
                case KeyEvent.VK_LEFT:
                    left = true;
                    break;
                case KeyEvent.VK_SPACE:
                    space = true;
                    break;
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    };
}
