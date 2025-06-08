import model.Employee;
import model.Priority;
import model.Task;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Employee emp1 = new Employee(1, "Alice", "IT");
        Employee emp2 = new Employee(2, "Bob", "HR");

        Task t1 = new Task(101, "Complete report", "Pending", LocalDate.now().plusDays(1), Priority.HIGH);
        Task t2 = new Task(102, "System update", "Pending", LocalDate.now().minusDays(1), Priority.MEDIUM);

    }
}