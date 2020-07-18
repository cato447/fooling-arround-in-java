import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JPanel implements ActionListener {

    private final int DELAY = 15;
    private final int BOARD_W = 700;
    private final int BOARD_H = 600;
    private boolean isInitialized = false;

    private Painter painter;
    private Timer timer;

    public Board(){
        initBoard();
        initGame();
    }

    private void initBoard(){
        setPreferredSize(new Dimension(BOARD_W,BOARD_H));
        setBackground(Color.LIGHT_GRAY);
    }

    private void initGame(){
        painter = new Painter();
        timer = new Timer(15, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        painter.paintBoard(g, BOARD_W, BOARD_H);
    }
}
