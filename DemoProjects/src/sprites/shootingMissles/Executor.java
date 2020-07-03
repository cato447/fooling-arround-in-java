package sprites.shootingMissles;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Executor extends JFrame {

    public Executor() {

        initUI();
    }

    private void initUI() {

        add(new Board());

        setSize(400, 300);
        setResizable(false);

        setTitle("Shooting missiles");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            Executor ex = new Executor();
            ex.setVisible(true);
        });
    }
}