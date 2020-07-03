package src;

import java.util.Scanner;

public class Operator {

    private int balance;
    private int options;
    private int pin;
    private boolean isActive;

    public Operator() {
        balance = 100;
        options = -1;
        pin = 1234;
        isActive = true;
    }

    private void printMenu() {
        System.out.println("Which action do you want to take?");
        System.out.println("    1. Check balance");
        System.out.println("    2. Add money to account");
        System.out.println("    3. Withdraw money from account");
        System.out.println("    4. Change Pin");
        System.out.println("    5. Cancel action");
    }

    public void manage() {
        System.out.println("Welcome to the ATM");
        while (isActive) {
            printMenu();
            Scanner numScanner = new Scanner(System.in);
            int option = numScanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println();
                    System.out.printf("Your account balance is %d€\n", balance);
                    System.out.println();
                    break;

                case 2:
                    System.out.println();
                    System.out.println("How much money do you want to add to your account?");
                    Scanner addScanner = new Scanner(System.in);
                    int amountAdded = addScanner.nextInt();
                    balance += amountAdded;
                    System.out.println();
                    System.out.printf("%d€ added to your account\n", amountAdded);
                    System.out.printf("New balance: %d€\n", balance);
                    System.out.println();
                    break;

                case 3:
                    System.out.println();
                    int tries = 3;
                    while (tries > 0) {
                        System.out.println("Please enter your pin");
                        Scanner pinScanner = new Scanner(System.in);
                        if (pinScanner.nextInt() == pin) {
                            while (true) {
                                System.out.println("Which amount do you want to withdraw from your account?");
                                Scanner amountScanner = new Scanner(System.in);
                                int amount = amountScanner.nextInt();
                                if (amount < balance) {
                                    System.out.printf("%d€ got withdrawn from your Account\n", amount);
                                    balance -= amount;
                                    System.out.printf("New balance: %d", balance);
                                    System.out.println();
                                    break;
                                } else {
                                    System.out.printf("You can only withdraw %d€\n", balance);
                                    System.out.println();
                                }
                            }
                            break;
                        } else {
                            tries -= 1;
                            System.err.println("The entered pin is incorrect");
                            System.out.printf("%d tries left\n", tries);
                        }
                    }
                    if (tries <= 0) {
                        System.err.println("Action canceled");
                        isActive = false;
                    }
                    break;

                case 4:
                    System.out.println();
                    System.out.println("Enter your pin");
                    Scanner pinScanner = new Scanner(System.in);
                    int oldPin = pinScanner.nextInt();
                    boolean pinNotValid = true;
                    while (pinNotValid) {
                        if (oldPin == pin) {
                            System.out.println("Enter a new 4-digit pin");
                            int newPin = pinScanner.nextInt();
                            if ((newPin + "").length() == 4) {
                                pin = newPin;
                                pinNotValid = false;
                            } else {
                                System.out.println("You have to enter a 4-digit pin");
                            }
                        } else {
                            System.err.println("Wrong pin entered");
                        }
                    }
                    System.out.println();
                    break;

                case 5:
                    System.out.println();
                    System.err.println("Action canceled");
                    isActive = false;
            }
        }
    }

    public static void main(String[] args) {
        Operator operator = new Operator();
        operator.manage();
    }

}
