package Midterm;

import java.util.Scanner;

public class ATM_Machine_copy {
    private static void printMainMenu(){
        System.out.println("Main menu\n1: check balance\n2: withdraw\n3: deposit\n4: exit ");
    }
    public static void main(String[] args) throws Exception {
        Account[] accounts = new Account[10];
        for(int i = 0; i < 10; i++){
            accounts[i] = new Account(i,100);
        }
        //ask for ID
        while(true) {
            Scanner keyboard = new Scanner(System.in);
            boolean doneID = false;
            int inputID = -1;

            //make sure the ID entered are limited to 0-9
            while (!doneID) {
                try {
                    System.out.print("Enter an id (0-9): ");
                    inputID = keyboard.nextInt();
                    if (inputID < 0 || inputID > 9) {
                        throw new Exception("Error: You entered an invalid id.");
                    } else doneID = true;
                } catch (Exception e) {
                    String message = e.getMessage();
                    System.out.println(message);
                }
            }

            Account curAccount = accounts[inputID];
            int inputChoice = 0;

            //ask for choices
            while (true) {
                if(inputChoice == 4) break;
                printMainMenu();
                boolean doneChoice = false;

                //make sure the choice entered are limited to 1,2,3,4
                while (!doneChoice) {
                    try {
                        System.out.print("Enter a choice(1-4): ");
                        inputChoice = keyboard.nextInt();
                        if (inputChoice < 1 || inputChoice > 4) {
                            throw new Exception("Error: You entered an invalid choice.");
                        } else doneChoice = true;
                    } catch (Exception e) {
                        String message = e.getMessage();
                        System.out.println(message);
                    }
                }

                switch (inputChoice) {
                    case 1:
                        System.out.printf("Account id: %d. Your current balance is: $%.2f\n", curAccount.getId(), curAccount.getBalance());
                        break;
                    case 2:
                        boolean doneWithdraw = false;
                        while (!doneWithdraw) {
                            System.out.print("Enter the withdraw amount: ");
                            double inputWithdrawAmount = keyboard.nextDouble();
                            try {
                                curAccount.withdraw(inputWithdrawAmount);
                                doneWithdraw = true;
                            } catch (Exception e) {
                                String message = e.getMessage();
                                System.out.println(message);
                            }
                        }
                        break;
                    case 3:
                        boolean doneDeposit = false;
                        while (!doneDeposit) {
                            System.out.print("Enter the deposit amount: ");
                            double inputDepositAmount = keyboard.nextDouble();
                            try {
                                curAccount.deposit(inputDepositAmount);
                                doneDeposit = true;
                            } catch (Exception e) {
                                String message = e.getMessage();
                                System.out.println(message);
                            }
                        }
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        break;
                }
            }
        }
    }
}
