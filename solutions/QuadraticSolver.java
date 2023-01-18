import java.util.Scanner;

/** Solves a quadratic equation using known variables
 * and the quadratic formula.
 * @author Loud Cat
 */
public class QuadraticSolver {
    /** Solves the given quadratic equation
     * @param a first known number
     * @param b second known number
     * @param c third known number
     * @param positive "plus or minus" in the quadratic formula
     * @return the solution to the given equation, using "+" or "-" instead of "+-"
     */
    public static double solveQuad(double a, double b, double c, boolean positive) {
        int sign = positive ? 1 : -1;
        
        double top = -b + sign * Math.sqrt((b*b) - (4*a*c));
        return top / (2 * a);
    }
    
    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println("    Quadratic Equation Solver    ");
        
        System.out.println();
        System.out.println("Enter a quadratic equation:");
        System.out.println("ax² + bx + c = 0");
        
        double a = 0, b = 0, c = 0;
        
        if (args.length != 3) {
            // create a scanner to read input from the user
            Scanner input = new Scanner(System.in);
            
            System.out.print("Enter \"a\": ");
            a = input.nextDouble();
            input.nextLine();
            
            System.out.print("Enter \"b\": ");
            b = input.nextDouble();
            input.nextLine();
            
            System.out.print("Enter \"c\": ");
            c = input.nextDouble();
            input.nextLine();
            
            input.close();
        }
        else {
            System.out.println("Using data from command line...");
            
            a = Double.parseDouble(args[0]);
            b = Double.parseDouble(args[1]);
            c = Double.parseDouble(args[2]);
        }
        
        System.out.println();
        
        double plus = solveQuad(a, b, c, true);
        double minus = solveQuad(a, b, c, false);
        
        if (plus == minus)
            System.out.printf("Solution: %.3f" + "%n", plus);
        else
            System.out.printf("Solutions: %.3f and %.3f" + "%n", plus, minus);
        
        System.out.println("=================================");
    }
}
