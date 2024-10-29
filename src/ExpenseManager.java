import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

private static final String csvFile = "expenses.csv";
private static final DateTimeFormatter formatter =
        DateTimeFormatter.ofPattern("dd/MM/yyyy");

// use to save expense object to csv file
public static void saveExpense(Expense expense) throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
        String line = reader.readLine();
    }
}

// move expenses from csv file to list in program

public static List<Expense> readExpense() throws IOException{
    List<Expense> expenses = new ArrayList<>(); //list to store expense variables
    try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {

        String line = reader.readLine();
        while(line != null) {
            String[] parts = line.split(",");
            double amount = Double.parseDouble(parts[0]);
            String category = parts[1];
            LocalDate date = LocalDate.parse(parts[2], formatter);
            String description = parts[3];
            expenses.add(new Expense(amount, category, date, description));
        }
        return expenses;
    }
}
