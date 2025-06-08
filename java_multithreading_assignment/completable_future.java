import java.util.concurrent.CompletableFuture;

public class completable_future {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            return "Hello from CompletableFuture!";
        });

        future.thenAccept(result -> {
            System.out.println(result);
        });

        // Prevent main thread from exiting too early
        future.join();
    }
}
