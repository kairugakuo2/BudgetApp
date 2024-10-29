import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

public class BudgetCalculator {

    // sum up all of the expenses
    public static double totalExpenses(List<Expense> expenses){
        double total = 0.0;
        for(int i = 0; i < expenses.size(); i++){
            Expense expense = expenses.get(i);
            totalExpenses += expense.getAmount();
        }
        return total;
    }

    // calculate remaining budget ( total budget - expenses)
    public static double remainingBudget(double totalBudget, List<Expense> expenses){
        double totalExpenses = totalExpenses(expenses);
        double remainingBudget = totalBudget - totalExpenses;
        return remainingBudget;
    }

    // calculate days left in month
    public static int daysLeft(){
        LocalDate today = LocalDate.now();
        YearMonth yearMonth = YearMonth.of(today.getYear(), today.getMonth());
        int lastDay = yearMonth.lengthOfMonth();
        int daysLeft = lastDay - today.getDayOfMonth();
        return daysLeft;
    }

    //calculate daily spending limit (remaining budget / days left in month)
    public static double dailyLimit(double remainingbudget){
        int daysLeft = daysLeft();
        double dailyLimit = remainingbudget / daysLeft;
        return dailyLimit;
    }
}