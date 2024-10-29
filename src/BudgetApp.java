import java.io.IOException;
import java.util.*;

public class BudgetApp{

    public static void logExpense(double amount, String category, String description){
        LocalDate today = LocalDate.now();
        Expense newExpense = new Expense(amount, category, today, description);
        ExpenseManager.saveExpense(newExpense);
    }
}