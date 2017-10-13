package com.company;

public class Main
{

    public static void main(String[] args)
    {
        Calculator calc = new Calculator(); //eller 2 Udregningsobjekter i stedet for 1.
        Calculator calc2 = new Calculator();

        calc.calc();
        double x1 = calc.getX();
        double y1 = calc.getY();

        calc2.calc();
        double x2 = calc2.getX();
        double y2 = calc2.getY();

        System.out.println("Afstand mellem punkterne: " + calc.calcDist(x1, x2, y1, y2));
    }
}
