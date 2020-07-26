import javax.swing.*;

public class Executor extends JFrame {

    public Executor(){
        initUI();
    }

    private void initUI(){
        Panel panel = new Panel();
        add(panel);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Executor executor = new Executor();
                executor.setVisible(true);
            }
        });
    }
}
