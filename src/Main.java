import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int option = 0;
        int employeesArraySize = 0;
        double[] salaryList;
        int secondOption = 0;
        double invoiceValue = 0;
        double vat = 0;
        double balance = 1000000.0;
        int invoicesArraySize = 0;
        double[] invoiceAmountList;


        while (option != 4) {
            System.out.println("Please choose an option:\n1. Pay salaries \n2. Generate a new invoice \n3. Pay one or more invoices\n4. Quit\n");

            if (scanner.hasNextInt()) {
                option = scanner.nextInt();

                if (option == 1) {
                    System.out.println("Please enter the number of employees: ");
                    if (scanner.hasNext()) {
                        employeesArraySize = scanner.nextInt();
                        salaryList = new double[employeesArraySize];
                        int i;
                        for (i = 0; i < employeesArraySize; i++) {
                            System.out.println("How much would you like to pay for employee number " + (i + 1) + "?");
                            salaryList[i] = scanner.nextInt();
                            salaryList[i] *= 0.7;
                        }
                        System.out.println("Here comes the list of salaries after tax reduction. (The tax rate is 30 %) ");
                        for (i = 0; i < employeesArraySize; i++) {
                            System.out.println(salaryList[i]);
                        }
                        System.exit(0);
                    }
                }
                if (option == 2) {
                    System.out.println("Please enter the total amount of the new invoice? ");
                    if (scanner.hasNext()) {
                        invoiceValue = scanner.nextInt();
                        vat = invoiceValue * 0.25;
                        double nettoValue = invoiceValue - vat;
                        System.out.println("The total amount: " + invoiceValue);
                        System.out.println("The amount for VAT: " + vat);
                        System.out.println("The amount excluding VAT: " + nettoValue);
                        balance += nettoValue;;
                    } System.exit(0);

                }
                if (option == 3) {
                    System.out.println("Please enter the total number of invoices to be paid? ");
                    if (scanner.hasNext()) {
                        invoicesArraySize = scanner.nextInt();
                        invoiceAmountList = new double[invoicesArraySize];
                        int i;
                    for (i = 0; i < invoicesArraySize; i++) {
                        System.out.println("Please introduce the value of invoice nr " + (i + 1) + ":");
                        invoiceAmountList[i] = scanner.nextInt();
                        int x;
                        for (x = 0; x < employeesArraySize; x++);
                        balance -= invoiceAmountList[x] * 0.75;
                        System.out.println("The account balance is " + balance + ".");
                        }
                        System.exit(0);
                    }
                }
            }
        }
    }
}








    /*while (option != 4) {
            System.out.println("1. Pay salaries \n2. Generate a new invoice \n3. Pay one or more invoices ");
            option = validateInput();




        public static int validateInput() {
            Scanner scanner = new Scanner(System.in);
            int userInput;
            if(scanner.hasNext()) {
                try {
                    userInput = scanner.nextInt();
                    if(userInput < 1 || userInput > 4)
                        return 0;
                } catch (InputMismatchException error) {
                    System.out.println("Option must be a number from 1 to 4");
                    return 0;
                }*/
