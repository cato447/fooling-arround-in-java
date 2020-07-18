import javax.swing.*;

public class Executor extends JFrame {

    public Executor(){
        initUI();
    }

    private void initUI(){
        Board board = new Board();
        add(board);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        Executor executor = new Executor();
        executor.setVisible(true);
    }
}
