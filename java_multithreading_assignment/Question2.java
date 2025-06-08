// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.util.*;

// public class Question2 {
//     static class stock {
//         String stock_security;
//         double stock_price;

//         stock(String stock_security, double stock_price) {
//             this.stock_security = stock_security;
//             this.stock_price = stock_price;
//         }

//         String toCsvLine() {
//             return stock_security + "," + stock_price;
//         }
//     }
//     public static void main(String[] args) {
//           String filepath = "stocks.csv";  
//         List<data<String, Double>> rawData = new ArrayList<>();
//                 try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
//             String line;
//             boolean isFirstLine = true;
//             while ((line = br.readLine()) != null) {
//                 if (isFirstLine) { 
//                     isFirstLine = false;
//                     continue;
//                 }
                
//             }
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }
// }

// class data<S, P> {
//     S key;
//     P value;

//     data(S key, P value) {
//         this.key = key;
//         this.value = value;
//     }

//     public S getKey() {
//         return key;
//     }

//     public P getValue() {
//         return value;
//     }

//     @Override
//     public String toString() {
//         return "data{" + "key=" + key + ", value=" + value + '}';
//     }
// }

/*String[] parts = line.split(",");
                if (parts.length >= 2) {
                    String stockName = parts[0].trim();
                    try {
                        double price = Double.parseDouble(parts[1].trim());
                        rawData.add(new data<>(stockName, price));
                    } catch (NumberFormatException e) {
                        System.err.println("Skipping invalid price for: " + parts[0]);
                    }
                } */



// class data<S, P> {
//     S key;
//     P value;

//     data(S key, P value) {
//         this.key = key;
//         this.value = value;
//     }

//     public S getKey() {
//         return key;
//     }

//     public P getValue() {
//         return value;
//     }

//     @Override
//     public String toString() {
//         return "pair{" + "key=" + key + ", value=" + value + '}';
//     }
// }

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;

public class Question2 {
    static class stock {
        String stock_security;
        double stock_price;

        stock(String stock_security, double stock_price) {
            this.stock_security = stock_security;
            this.stock_price = stock_price;
        }

        String toCsvLine() {
            return stock_security + "," + stock_price;
        }
    }

    public static void main(String[] args) {
        String filepath = "stocks.csv";  
        List<data<String, Double>> rawData = new ArrayList<>();

        
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) { 
                    isFirstLine = false;
                    continue;
                }
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    String stockName = parts[0].trim();
                    try {
                        double price = Double.parseDouble(parts[1].trim());
                        rawData.add(new data<>(stockName, price));
                    } catch (NumberFormatException e) {
                        System.err.println("Skipping invalid price for: " + parts[0]);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        ExecutorService executor = Executors.newFixedThreadPool(4);
        CompletionService<data<String, Double>> completionService = new ExecutorCompletionService<>(executor);

       
        for (data<String, Double> entry : rawData) {
            completionService.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " processing: " + entry);
                
                return new data<>(entry.getKey(), entry.getValue());
            });
        }

        List<data<String, Double>> processedData = new ArrayList<>();
        for (int i = 0; i < rawData.size(); i++) {
            try {
                processedData.add(completionService.take().get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();

        System.out.println("\nProcessed stock data:");
        for (data<String, Double> d : processedData) {
            System.out.println(d);
        }
    }
}

class data<S, P> {
    S key;
    P value;

    data(S key, P value) {
        this.key = key;
        this.value = value;
    }

    public S getKey() {
        return key;
    }

    public P getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "data{" + "key=" + key + ", value=" + value + '}';
    }
}



// BufferedReader


