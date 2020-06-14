import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Keyboard {

    public static void main(String args[]) throws InterruptedException {
        KeyListener listener = new KeyListener() {

            @Override

            public void keyPressed(KeyEvent event) {
                System.out.println(event.getKeyChar());
            }

            @Override

            public void keyReleased(KeyEvent event) {
                System.out.println(event.getKeyChar());
            }

            @Override

            public void keyTyped(KeyEvent event) {
                System.out.println(event.getKeyChar());
            }

            private void printEventInfo(String str, KeyEvent e) {
                System.out.println(str);
                int code = e.getKeyCode();
                System.out.println("   Code: " + KeyEvent.getKeyText(code));
                System.out.println("   Char: " + e.getKeyChar());
                int mods = e.getModifiersEx();
                System.out.println("    Mods: "
                        + KeyEvent.getModifiersExText(mods));
                System.out.println("    Location: "
                        + keyboardLocation(e.getKeyLocation()));
                System.out.println("    Action? " + e.isActionKey());
            }

            private String keyboardLocation(int keybrd) {
                switch (keybrd) {
                    case KeyEvent.KEY_LOCATION_RIGHT:
                        return "Right";
                    case KeyEvent.KEY_LOCATION_LEFT:
                        return "Left";
                    case KeyEvent.KEY_LOCATION_NUMPAD:
                        return "NumPad";
                    case KeyEvent.KEY_LOCATION_STANDARD:
                        return "Standard";
                    case KeyEvent.KEY_LOCATION_UNKNOWN:
                    default:
                        return "Unknown";
                }
            }
        };

        JFrame jFrame = new JFrame();
        jFrame.setSize(1000,1000);
        jFrame.setVisible(true);

        jFrame.addKeyListener(listener);

        while(true){
            Thread.sleep(1);
        }
    }
}
