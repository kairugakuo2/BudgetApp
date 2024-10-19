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