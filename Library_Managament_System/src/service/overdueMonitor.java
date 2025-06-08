package service;

import model.LendingRecord;

import java.time.LocalDate;
import java.util.List;

public class overdueMonitor extends Thread {
    private List<LendingRecord> records;

    public overdueMonitor(List<LendingRecord> records) {
        this.records = records;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Overdue Books Check");
            for (LendingRecord record : records) {
                if (record.getReturnDate() == null && record.getDueDate().isBefore(LocalDate.now())) {
                    System.out.println("Overdue: " + record.getBook().getTitle() + " | Member: " + record.getMember().getName());
                }
            }
            try {
                Thread.sleep(60000); // it will check after every 1 minute and return the resutlt
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
//Not implementd this : Optionally, sends notifications or flags members with overdue books.




