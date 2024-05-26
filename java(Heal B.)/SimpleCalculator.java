import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Select operation:");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        System.out.println("5. Modulus");
        
        System.out.print("Enter choice (1/2/3/4/5): ");
        int choice = scanner.nextInt();
        
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();
        
        switch(choice) {
            case 1:
                System.out.println("Result: " + add(num1, num2));
                break;
            case 2:
                System.out.println("Result: " + subtract(num1, num2));
                break;
            case 3:
                System.out.println("Result: " + multiply(num1, num2));
                break;
            case 4:
                System.out.println("Result: " + divide(num1, num2));
                break;
            case 5:
                System.out.println("Result: " + Modulus(num1, num2));
                break;

            default:
                System.out.println("Invalid Input");
        }
        
        scanner.close();
    }
    
    public static double add(double x, double y) {
        return x + y;
    }
    
    public static double subtract(double x, double y) {
        return x - y;
    }
    
    public static double multiply(double x, double y) {
        return x * y;
    }
    
    public static double divide(double x, double y) {
        if (y == 0) {
            System.out.println("Error! Cannot divide by zero.");
            return Double.NaN;
        } else {
            return x / y;
        }
    }
        
    public static double Modulus(double x, double y) {
        return x % y;
    }
}