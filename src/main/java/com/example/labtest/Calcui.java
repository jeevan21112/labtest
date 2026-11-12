
package com.example.labtest;

import java.util.Scanner;

public class Calcui {

    // Salary percentages
    private static final double HRA_RATE = 20;
    private static final double DA_RATE = 10;
    private static final double PF_RATE = 12;

    // Validate basic salary
    private void validateSalary(double basicSalary) {
        if (!Double.isFinite(basicSalary) || basicSalary < 0) {
            throw new IllegalArgumentException(
                "Salary must be a valid non-negative number");
        }
    }

    // Calculate HRA
    public double calculateHRA(double basicSalary) {
        validateSalary(basicSalary);
        return round(basicSalary * HRA_RATE / 100);
    }

    // Calculate DA
    public double calculateDA(double basicSalary) {
        validateSalary(basicSalary);
        return round(basicSalary * DA_RATE / 100);
    }

    // Calculate gross salary
    public double calculateGrossSalary(double basicSalary) {
        validateSalary(basicSalary);
        return round(basicSalary
                + calculateHRA(basicSalary)
                + calculateDA(basicSalary));
    }

    // Calculate deductions (PF)
    public double calculateDeductions(double basicSalary) {
        validateSalary(basicSalary);
        return round(basicSalary * PF_RATE / 100);
    }

    // Calculate net salary
    public double calculateNetSalary(double basicSalary) {
        validateSalary(basicSalary);
        return round(calculateGrossSalary(basicSalary)
                - calculateDeductions(basicSalary));
    }

    // Round to two decimal places
    private double round(double amount) {
        return Math.round(amount * 100.0) / 100.0;
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Calcui salary = new Calcui();

        try {
            System.out.print("Enter Basic Salary: ");
            double basicSalary = sc.nextDouble();

            double hra = salary.calculateHRA(basicSalary);
            double da = salary.calculateDA(basicSalary);
            double gross = salary.calculateGrossSalary(basicSalary);
            double deductions = salary.calculateDeductions(basicSalary);
            double net = salary.calculateNetSalary(basicSalary);

            System.out.println("\n----- EMPLOYEE SALARY DETAILS -----");
            System.out.printf("Basic Salary     : Rs. %.2f%n", basicSalary);
            System.out.printf("HRA              : Rs. %.2f%n", hra);
            System.out.printf("DA               : Rs. %.2f%n", da);
            System.out.printf("Gross Salary     : Rs. %.2f%n", gross);
            System.out.printf("Deductions (PF)  : Rs. %.2f%n", deductions);
            System.out.printf("Net Salary       : Rs. %.2f%n", net);

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid salary: " + e.getMessage());
        } catch (java.util.InputMismatchException e) {
            System.out.println("Please enter a valid numeric salary.");
        } finally {
            sc.close();
        }
    }
}
