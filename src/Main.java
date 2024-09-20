import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static double balance = 1000000.0;

    private static void paySalaries() {
        int employeesArraySize;
        double[] salaryList;
        System.out.println("Please enter the number of employees: ");
        if (scanner.hasNext()) {
            try {
                employeesArraySize = scanner.nextInt();
                if (employeesArraySize > 0) {

                    salaryList = new double[employeesArraySize];
                    int i;
                    for (i = 0; i < employeesArraySize; i++) {
                        System.out.println("How much would you like to pay for employee number " + (i + 1) + "?");
                        salaryList[i] = scanner.nextInt();
                        if (salaryList[i] > 0) {
                            if(balance >= (salaryList[i] )) {
                                balance -= (salaryList[i]);
                            } else {
                                System.out.println("There is not enough funds on the balance. The transaction can not be completed.");
                            }
                        } else {
                            System.out.println("Invalid value.");
                            i--;
                        }
                    }
                    System.out.println("Here comes the list of salaries after tax reduction. (The tax rate is 30 %) ");
                    System.out.println("The balance now is " + balance);
                    for (i = 0; i < employeesArraySize; i++) {
                        System.out.println((i + 1) + ". " + salaryList[i]);
                    }

                } else {
                    System.out.println("Invalid value.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid value.");
                scanner.next();
            }

        }

    }

    private static void generateInvoice() {
        double invoiceValue;
        double vat;
        System.out.println("Please enter the total amount of the new invoice? ");
        invoiceValue = scanner.nextInt();
        if (invoiceValue >= 0) {
            try {
                vat = invoiceValue * 0.25;
                double nettoValue = invoiceValue - vat;
                System.out.println("The total amount: " + invoiceValue);
                System.out.println("The amount for VAT: " + vat);
                System.out.println("The amount excluding VAT: " + nettoValue);
                balance += nettoValue;
                System.out.println("The current balance now is " + balance);
            } catch (InputMismatchException e) {
                System.out.println("Invalid value.");
            }
        } else System.out.println("Invalid value");
    }

    private static void payInvoices() {
        int invoicesArraySize;
        double[] invoiceAmountList;
        System.out.println("Please enter the total number of invoices to be paid? ");
        invoicesArraySize = scanner.nextInt();
        if (invoicesArraySize > 0) {
            try {
                invoiceAmountList = new double[invoicesArraySize];
                for (int i = 0; i < invoicesArraySize; i++) {
                    System.out.println("Please introduce the value of invoice nr " + (i + 1) + ":");
                    invoiceAmountList[i] = scanner.nextInt();
                    if (invoiceAmountList[i] >= 0){
                        if (balance >= (invoiceAmountList[i] * 0.75)) {
                        balance -= invoiceAmountList[i] * 0.75;
                        System.out.println("The account balance is " + balance + ".");}
                        else {
                            System.out.println("There is not enough funds on the balance. The transaction can not be completed.");
                        }
                    } else {
                        System.out.println("Invalid value.");
                        i--;
                    }

                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid value.");
            }
        }
        else {
            System.out.println("Invalid value");
        }
    }

    public static void main(String[] args) {
        int option;

        while (true) {
            System.out.println("============================");
            System.out.println("Please choose an option:\n1. Pay salaries \n2. Generate a new invoice \n3. Pay one or more invoices\n4. Quit");
            System.out.println("============================");
            try {
                option = scanner.nextInt();
                if (option == 1) {
                    paySalaries();
                } else if (option == 2) {
                    generateInvoice();
                } else if (option == 3) {
                    payInvoices();
                } else if (option == 4) {
                    System.exit(0);
                } else {
                    System.out.println("Invalid option. Please introduce a number from 1 to 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid option.");
                scanner.next();
            }

        }
    }
}