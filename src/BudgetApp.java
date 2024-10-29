import java.io.IOException;
import java.util.*;

public class BudgetApp{

    // log a new expense and save to csv file
    public static void logExpense(double amount, String category, String description){
        LocalDate today = LocalDate.now();
        Expense newExpense = new Expense(amount, category, today, description);
        ExpenseManager.saveExpense(newExpense);
    }

    // display budget summary (remaining budget, total expenses, daily spending limit)
    public static void displayBudget(double totalBudget) throws IOException{
        List<Expense> expenses = ExpenseManager.readExpense(); // read and load all expenses from csv file
        double totalExpenses = BudgetCalculator.totalExpenses(expenses);
        double remainingBudget = BudgetCalculator.remainingBudget(totalBudget, expenses);
        double dailyLimit = BudgetCalculator.dailyLimit(remainingBudget);

        //print all of the info
        System.out.println("Total expenses: $" + totalExpenses);
        System.out.println("Remaining expenses: $" + remainingBudget);
        System.out.println("Daily limit: $" + dailyLimit);
    }
}