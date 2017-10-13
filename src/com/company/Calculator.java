package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Calculator
{
    private String s;
    private double x;
    private double y;
    private int counterX;
    private int counterY;
    private Queue<Integer> queueX;
    private Queue<Integer> queueY;

    public Calculator()
    {
        queueX = new LinkedList<>();
        queueY = new LinkedList<>();
    }

    public void calc()
    {
        counterX = 0;
        counterY = 0;
        System.out.println("Skriv punkt.");
        Scanner input = new Scanner(System.in);
        s = input.nextLine();
        s = s.replaceAll("[^1-9]","");

        for (int i = 0; i < s.length(); i++)
        {
            queueX.add(Integer.parseInt(String.valueOf(s.charAt(i))));
            queueY.add(Integer.parseInt(String.valueOf(s.charAt(i))));
        }
        System.out.println("Du har valgt: " + queueX);

        x = calcXPoint(queueX.poll());
        y = calcYPoint(queueY.poll());
        System.out.println("x: " + x + "\ny: " + y);
    }

    public double calcXPoint(int n)
    {
        if(queueX.isEmpty())
        {
            return Math.abs(((n-1)%3)/Math.pow(3, counterX))/3;
        }
        counterX++;
        return Math.abs(1*(((n-1)%3)/Math.pow(3, counterX))) + calcXPoint(queueX.poll());
    }

    public double calcYPoint(int n)
    {
        if(queueY.isEmpty())
        {
            return Math.abs(((n-1)/3)/Math.pow(3, counterY))/3;
        }
        counterY++;
        return Math.abs(1*(((n-1)/3)/Math.pow(3, counterY))) + calcYPoint(queueY.poll());
    }

    public double calcDist(double x1, double x2, double y1, double y2)
    {
        return Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }
}
