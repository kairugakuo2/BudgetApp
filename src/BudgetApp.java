import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class BudgetApp{
    private static final Scanner input = new Scanner(System.in);

    public static void promptAndLogBudget(Scanner input){
        try {
            System.out.println();
            System.out.println("Enter budget amount: ");
            String budgetInput = input.nextLine();
            double amount = Double.parseDouble(budgetInput);
            displayBudget(amount);
        } catch (Exception e) {
            System.out.println("Error: Invalid input, only numbers are allowed.");
            e.printStackTrace();
            input.nextLine(); //clear the invalid input
        }
    }


    // display budget summary (remaining budget, total expenses, daily spending limit)
    public static void displayBudget(double totalBudget) throws IOException{
        List<Expense> expenses = ExpenseManager.readExpense(); // read and load all expenses from csv file
        double totalExpenses = BudgetCalculator.totalExpenses(expenses);
        double remainingBudget = BudgetCalculator.remainingBudget(totalBudget, expenses);
        double dailyLimit = BudgetCalculator.dailyLimit(remainingBudget);

        //print all the info
        System.out.println();
        System.out.println("Total expenses: $" + totalExpenses);
        System.out.println("Remaining expenses: $" + remainingBudget);
        System.out.println("Daily limit: $" + dailyLimit);
    }
    public static void promptAndLogExpense(Scanner input){
        try {
            System.out.println();
            System.out.print("Enter expense amount: ");
            double amount = input.nextDouble();
            input.nextLine(); // remove the newline left by nextDouble

            System.out.print("Enter the category (ex: Groceries, Transportation): ");
            String category = input.nextLine();

            System.out.print("Enter a description: ");
            String description = input.nextLine();

            logExpense(amount, category, description);

        } catch (Exception e) {
            System.out.println("Error: Invalid input, please try again.");
            e.printStackTrace();
            input.nextLine(); //clear invalid input
        }
    }
    // log a new expense and save to csv file
    public static void logExpense(double amount, String category, String description) throws IOException {
        LocalDate today = LocalDate.now();
        Expense newExpense = new Expense(amount, category, today, description);
        ExpenseManager.saveExpense(newExpense);
        System.out.println("Expense saved successfully.");
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Budget App!");

        promptAndLogExpense(input);
        promptAndLogBudget(input);

        input.close();
    }
}
//