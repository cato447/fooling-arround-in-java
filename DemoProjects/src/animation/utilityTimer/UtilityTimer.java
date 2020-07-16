package animation.utilityTimer;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class UtilityTimer extends JFrame {

    public UtilityTimer() {

        initUI();
    }

    private void initUI() {

        add(new Board());

        setResizable(false);
        pack();

        setTitle("Star");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            JFrame ex = new UtilityTimer();
            ex.setVisible(true);
        });
    }
}