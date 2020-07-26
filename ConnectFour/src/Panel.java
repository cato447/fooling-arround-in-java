import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Panel extends JPanel implements ActionListener {

    private final int DELAY = 50;
    private final int BOARD_W = 700;
    private final int BOARD_H = 600;
    private Chip[][] board = new Chip[7][6];
    private boolean isInitialized = false;
    private boolean right,left,space;

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
        //timer.start();
    }



    @Override
    public void actionPerformed(ActionEvent e) {
       repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        painter.paintBoard(g);
        if (!isInitialized) {
            fillBoard(g);
            isInitialized = true;
        }
    }

    private void fillBoard(Graphics g) {
        class MyExecutor extends SwingWorker<Void, SwingWorkerValues>{
            Graphics g;
            public MyExecutor(Graphics g){
                this.g = g;
            }
            @Override
            protected Void doInBackground() throws Exception {
                for (int column = 5; column >= 0; column--){
                    for (int row = 0; row < 7; row++) {
                        Thread.sleep(100);
                        publish(new SwingWorkerValues(row, column));
                    }
                }
                return null;
            }

            @Override
            protected void process(java.util.List<SwingWorkerValues> chunks) {
                super.process(chunks);
                SwingWorkerValues values = chunks.get(chunks.size()-1);
                System.out.println(values.row + " " + values.column);
                painter.paintRedChip(g, values.row, values.column);
                repaint();
            }

            @Override
            protected void done() {
                super.done();
                painter.paintYellowChip(g, 2,2);

            }
        }
        MyExecutor executor = new MyExecutor(g);
        executor.execute();
    }

    public void addToBoard (Chip chip, int x, int y){
        board[x][y] = chip;
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
