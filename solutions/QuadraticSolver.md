# Quadratic Equation Solver

This short Java program solves a quadratic equation using three known variables and the quadratic formula.

## Some examples of its use:
```text
C:\user\project-ideas>java QuadraticSolver
=================================
    Quadratic Equation Solver

Enter a quadratic equation:
ax² + bx + c = 0
Enter "a": 1
Enter "b": -2
Enter "c": -3

Solutions: 3.000 and -1.000
=================================
```

```text
C:\user\project-ideas>java QuadraticSolver 1 -18 81
=================================
    Quadratic Equation Solver

Enter a quadratic equation:
ax² + bx + c = 0
Using data from command line...

Solution: 9.000
=================================
```

```text
C:\user\project-ideas>java QuadraticSolver
=================================
    Quadratic Equation Solver

Enter a quadratic equation:
ax² + bx + c = 0
Enter "a": 6
Enter "b": 19
Enter "c": -7

Solutions: 0.333 and -3.500
=================================
```

## How I did it

Since we already know the formula and the known variables, it was pretty easy to substitute:
`x = (-b +- sqrt((b*b) + (4*a*c)) / (2 * a)`

The only thing I needed to implement was a way of getting the plus-or-minus sign into code.
I turned it all into a short parameterized method. The majority of it was documentation:
```java
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
```

This way, I could easily get both solutions to a given equation very easily:
```java
double plus = solveQuad(a, b, c, true);
double minus = solveQuad(a, b, c, false);
```
