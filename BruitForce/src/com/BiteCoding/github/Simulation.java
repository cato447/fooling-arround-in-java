package com.BiteCoding.github;

import javax.swing.*;
import util.Timer;

public class Simulation {
    private Decoder decoder;
    private Timer timer;

    private String password;
    private boolean properPassword;

    public Simulation() {
        decoder = new Decoder();
        timer = new Timer();
        properPassword = false;
    }

    public void start(){
        String s = new String();
        while (!properPassword) {
            s = JOptionPane.showInputDialog("put in a password with 6 chars and only using" +
                    " the alphabet");
            if (s.length() == 6 && s.matches(".*[a-zA-Z]+.*")){
                properPassword = true;
            } else {
                JOptionPane.showMessageDialog(null, "not a valid entry");
            }
        }
        password = s.toLowerCase();
        timer.start();
        crackIt();
    }

    private void crackIt(){
        for (int i = 0; i < 26; i++) {
            String s1 = decoder.decode(i);

            for (int j = 0; j < 26; j++) {
                String s2 = decoder.decode(j);

                for (int k = 0; k < 26; k++) {
                    String s3 = decoder.decode(k);

                    for (int l = 0; l < 26; l++) {
                        String s4 = decoder.decode(l);

                        for (int m = 0; m < 26; m++) {
                            String s5 = decoder.decode(m);

                            for (int n = 0; n < 26; n++) {
                                String s6 = decoder.decode(n);
                                String possiblePassword = s1+s2+s3+s4+s5+s6;
                                if (possiblePassword.equals(password)){
                                    timer.end();
                                    JOptionPane.showMessageDialog(null, "Das Passwort war " + password);
                                    JOptionPane.showMessageDialog(null, timer.timeNeeded());
                                    System.exit(0);
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        simulation.start();
    }
}
