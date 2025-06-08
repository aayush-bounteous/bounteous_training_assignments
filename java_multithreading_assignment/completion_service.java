import java.util.concurrent.*;

public class completion_service {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        CompletionService<String> completionService = new ExecutorCompletionService<>(executor);

        // Submit 5 tasks
        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            completionService.submit(() -> {
                Thread.sleep((long) (Math.random() * 3000));
                return "Task " + taskId + " completed!";
            });
        }

        // Retrieve and print results as they complete
        for (int i = 0; i < 5; i++) {
            Future<String> resultFuture = completionService.take(); // blocks until a result is ready
            System.out.println(resultFuture.get());
        }

        executor.shutdown();
    }
}
