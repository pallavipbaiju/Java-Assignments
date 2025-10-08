//Calculator Application using Method Overloading

import java.util.Scanner;

class Calculator{
    // No specific attributes required.

    // Methods:-

    public int add( int a , int b){
        return (a+b);
    }

    public double add(double a , double b){
        return (a+b);
    }

    public int add(int a , int b, int c){
        return (a+b+c);
    }

    public int subtract(int a, int b){
        return (a-b);
    }

    public double multiply(double a, double b){
        return (a*b);
    }

    public int division (int a, int b){
        if (b==0){ // Handling division-by-zero exception.
            throw new ArithmeticException("Divide-by-zero exception!");
        }
        else{
            return a/b;
        }
    }
}

//User Interface Class

class UsersInterface {

    //Attributes:-
    Scanner sc = new Scanner(System.in);
    Calculator calc = new Calculator();

    //Methods:-
    public void performAddition() {
        System.out.println("Choose Addition type:");
        System.out.println("1. Add two integers.");
        System.out.println("2. Add two doubles");
        System.out.println("3. Add three integers");
        System.out.println("Enter your choice:");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Enter first integer:");
                int a1 = sc.nextInt();
                System.out.println("Enter second integer:");
                int b1 = sc.nextInt();
                System.out.println("Result : " + calc.add(a1, b1));
                break;

            case 2:
                System.out.println("Enter first double:");
                double a2 = sc.nextDouble();
                System.out.println("Enter second double:");
                double b2 = sc.nextDouble();
                System.out.println("Result : " + calc.add(a2, b2));
                break;

            case 3:
                System.out.println("Enter first integer: ");
                int a3 = sc.nextInt();
                System.out.println("Enter second integer: ");
                int b3 = sc.nextInt();
                System.out.println("Enter third integer: ");
                int c3 = sc.nextInt();
                System.out.println("Result : " + calc.add(a3, b3, c3));
                break;

            default:
                System.out.println("Invalid choice!!");
        }
    }

    public void performSubtraction() {
        System.out.println("Enter first integer:");
        int a = sc.nextInt();
        System.out.println("Enter second integer: ");
        int b = sc.nextInt();
        System.out.println("Result : " + calc.subtract(a, b));
    }

    public void performMultiplication() {
        System.out.println("Enter first integer:");
        int a = sc.nextInt();
        System.out.println("Enter second integer: ");
        int b = sc.nextInt();
        System.out.println("Result : " + calc.multiply(a, b));
    }

    public void performDivision() {
        System.out.println("Enter Numerator:");
        int a = sc.nextInt();
        System.out.println("Enter Denominator:");
        int b = sc.nextInt();

        try {
            System.out.println("Result : " + calc.division(a, b));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    //MAIN MENU
    public void mainMenu() {
        while (true) {
            System.out.println("\n----------WELCOME TO THE CALCULATOR APPLICATION !!----------\n");
            System.out.println(" 1. Addition");
            System.out.println(" 2. Subtraction ");
            System.out.println(" 3. Multiplication ");
            System.out.println(" 4. Division ");
            System.out.println(" 5. EXIT \n\n ");

            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    performAddition();
                    break;
                case 2:
                    performSubtraction();
                    break;
                case 3:
                    performMultiplication();
                    break;
                case 4:
                    performDivision();
                    break;
                case 5:
                    System.out.println(" Thank You for using our Calculator Application.");
                    return;
                default:
                    System.out.println("INVALID CHOICE!\n PLEASE TRY AGAIN!!");
            }

        }
    }
}

//Main Method
public  class CalculatorApp {
    public static void main(String[] args) {
        UsersInterface UI = new UsersInterface();
        UI.mainMenu();
    }
}
