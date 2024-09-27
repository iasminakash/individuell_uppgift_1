//Importerar scanner, för att kunna ta input och klass för felhantering
import java.util.InputMismatchException;
import java.util.Scanner;
//Deklarerar klassen Main
public class Main {

    /*Skaffar skanner för att kunna ta user input, beskriver den som statisk för att använda scanner i Main metoden som är statisk.
    //Om man initierar en variaber eller en metod utan beskrivningen static och sedan anroppar den i en static pe så ger det error.
    //Beskrivningen public och private i metoder och variabler spelar ej så stor roll, allt kunde gärna vara public, eller allt kunde
    vara private i den uppgiften, men man ska gärna sträva efter konfidentitet, dvs att mer data är skyddat för att användas i andra klasser, om inte det är nödvändigt?*/
    public static Scanner scanner = new Scanner(System.in);

    //Initierar variabeln balance av typen double, tilldellar värde 1000000.0, beskriver den som statisk för att anroppa variablen i en statiska metoden Main
    public static double balance = 1000000.0;


    //Metod för att betala ut löner (statisk pga att kommer att användas i Main)
    public static void paySalaries() {
        // hur många ska det betalas löner till (i programmet: stroleken på listan)
        int employeesArraySize;
        // array med löner
        double[] salaryList;
        //Frågar användaren om antal anstälda som ska få betalt
        System.out.println("Please enter the number of employees: ");
        //Kollar om användaren har svarat
        if (scanner.hasNext()) {
            try {
                //Läser in användarens svar och tilldelar värdet till variabeln som beskriver storleken på listan
                employeesArraySize = scanner.nextInt();
                //Om svaret är positivt, dvs att antal anstälda är större än noll
                if (employeesArraySize > 0) {

                    //Initierar en array av typen double för att lagra alla löner
                    salaryList = new double[employeesArraySize];
                    //Loopar genom alla elelement i arrayen
                    int i;
                    for (i = 0; i < employeesArraySize; i++) {
                        //Frågar användaren vilken summa ska betalas till varje anställd, läser in inputen och tilldelar värden till varje element i listan
                        System.out.println("How much would you like to pay for employee number " + (i + 1) + "?");
                        salaryList[i] = scanner.nextInt();
                        // Ser till all lönen som ska betalas är ett positivt tal och om det är positivt så ska det dras från balansen
                        // I annat fall ska en felmeddelande printas ut med info att det är fel värde
                        // Går ett steg tillbaka i loppen så användaren kan matta in igen
                        if (salaryList[i] > 0) {
                            //Kollar så att det finns att det finns tillräckligt med pengar på kontsaldo, annars skriver ut felmedelande till usern
                            if(balance >= (salaryList[i])) {
                                balance -= (salaryList[i]);
                            } else {
                                System.out.println("There is not enough funds on the balance. The transaction can not be completed.");
                            }
                        } else {
                            System.out.println("Invalid value.");
                            i--;
                        }
                    }
                    //Printar ut det aktuella kontosaldot samt lönelistan (exklusive skatteavdraget)
                    System.out.println("The balance now is " + balance);
                    System.out.println("Here comes the list of salaries after tax reduction. (The tax rate is 30 %) ");
                    for (i = 0; i < employeesArraySize; i++) {
                        System.out.println((i + 1) + ". " + (salaryList[i] * 0.7));
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

    //Metoden för att generera faktura, statisk för jag anroppar den inom Main klassen
    private static void generateInvoice() {
        //Initierar variabler av typen double, en för fakturans värde och en annan för momsvärde
        double invoiceValue;
        double vat;
        //Ber användaren att introducera värdet av fakturan
        System.out.println("Please enter the total amount of the new invoice? ");
        invoiceValue = scanner.nextInt();
        //Ser till att värdet är positivt, annars skrivet ut felmedelande
        if (invoiceValue >= 0) {
            try {
                //Räknar ut moms värdet och netto värdet och printar ut dem
                vat = invoiceValue * 0.25;
                double nettoValue = invoiceValue - vat;
                System.out.println("The total amount: " + invoiceValue);
                System.out.println("The amount for VAT: " + vat);
                System.out.println("The amount excluding VAT: " + nettoValue);
                //plusar värdet till kontosaldot, printar ut aktuell kontosaldo
                balance += nettoValue;
                System.out.println("The current balance now is " + balance);
            } catch (InputMismatchException e) {
                System.out.println("Invalid value.");
            }
        } else System.out.println("Invalid value");
    }

    //metoden för att betala fakturor, statisk för att beffiner sig inom Main metoden
    private static void payInvoices() {
        //hur många fakturor ska vara med i listan
        int invoicesArraySize;
        //listan med alla fakturor som ska betalas
        double[] invoiceAmountList;
        //Ber användaren att välja hur många fakturor ska betalas och det ska bli storleken på vår array
        System.out.println("Please enter the total number of invoices to be paid? ");
        invoicesArraySize = scanner.nextInt();
        //Ser till at det är ett positivt värde, annars skriver ut felmedelande
        if (invoicesArraySize > 0) {
            try {
                //Initierar en array med strolek som användaren har angett
                invoiceAmountList = new double[invoicesArraySize];
                //Lopar genom alla element i listan
                for (int i = 0; i < invoicesArraySize; i++) {
                    //Ber användaren att förra in summan av varje faktura
                    System.out.println("Please introduce the value of invoice nr " + (i + 1) + ":");
                    //Lagrar inputer till listan
                    invoiceAmountList[i] = scanner.nextInt();
                    //Ser till att värden på fakturor är positiva tal
                    // Annars skriver ut felmedelande till användaren, går ett steg tillbaka i listan och ger användaren en chans till att förra in rätt värde

                    if (invoiceAmountList[i] >= 0){
                        //Om värdet på "fakturan - moms" ej överstigger kontosaldot, så ska det dras från kondosaldot
                        //Annars ska felmedelande printas ut
                        //Skriver ut aktuella kontosaldor
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
    /* Initierar metoden Main, huvudmetoden, väljer att organisera alternativen i metoder med anledning att
    det hoppar in tillbaka i huvudmenyn efter att man har utfört en viss operation, inte avslutar programmet som det gjorde
    när jag körde med if-else. */

    public static void main(String[] args) {
        //Initierar variabeln option av typen integer
        int option;

        while (true) {
            //Skriver ut menyn
            System.out.println("============================");
            System.out.println("Please choose an option:\n1. Pay salaries \n2. Generate a new invoice \n3. Pay one or more invoices\n4. Quit");
            System.out.println("============================");
            try {
                //Läser in användarens val
                option = scanner.nextInt();
                //Anroppar olika metod beroende på användarens val
                if (option == 1) {
                    paySalaries();
                } else if (option == 2) {
                    generateInvoice();
                } else if (option == 3) {
                    payInvoices();
                //Avslutar ifall användaren har valt 4
                } else if (option == 4) {
                    System.exit(0);
                //Skriver ut felmedelande ifall usern skrev in något oväntat
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