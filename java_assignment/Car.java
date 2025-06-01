
import java.util.*;

public class Car {

    
    static Scanner sc = new Scanner(System.in);
    public static String selectmanufacturer() {
        // Scanner sc = new Scanner(System.in);
        int input;
        while (true) {
            System.out.println("Select Car Manufacturer");
            System.out.println("Choose the number for selecting car manufacturer \n1.Mahindra \n2.Tata \n3.Maruti \n4.exit");
            input = sc.nextInt();
            switch (input) {
                case 1: return "Mahindra";
                case 2: return "Tata";
                case 3: return "Maruti";
                case 4: System.exit(0);
                default: System.out.println("Invalid input. Please try again.");
            }
        }
    }

    
    public static String selectmodel() {
        // Scanner sc = new Scanner(System.in);
        int input;
        while (true) {
            System.out.println("Select the model by number");
            System.out.println("1.Scorpio \n2.Thar \n3.Scorpio N \n4.XUV 700 \n5.exit");
            input = sc.nextInt();
            switch (input) {
                case 1: return "Scorpio";
                case 2: return "Thar";
                case 3: return "Scorpio N";
                case 4: return "XUV 700";
                case 5: System.exit(0);
                default: System.out.println("Invalid input. Please try again.");
            }
        }
    }

    

     public static String selecttransmission() {
        //  Scanner sc = new Scanner(System.in);
        int input;
        while (true) {
            System.out.println("Select Transmission Variant");
            System.out.println("1. Manual\n2. Automatic \n3.exit");
            input = sc.nextInt();
            switch (input) {
                case 1: return "Manual";
                case 2: return "Automatic";
                 case 3: System.exit(0);
                default: System.out.println("Invalid input. Please try again.");
            }
        }
    }


    public static String selectfueltype() {
        // Scanner sc = new Scanner(System.in);
        int input;
        while (true) {
            System.out.println("Select Fuel Type");
            System.out.println("1. Diesel\n2. Petrol\n3. CNG \n4.exit");
            input = sc.nextInt();
            switch (input) {
                case 1: return "Diesel";
                case 2: return "Petrol";
                case 3: return "CNG";
                 case 4: System.exit(0);
                default: System.out.println("Invalid input. Please try again.");
            }
        }
    }

     public static String selectaccessoriescolor() {
        // Scanner sc = new Scanner(System.in);
        int input;
        while (true) {
            System.out.println("Select Accessories Color");
            System.out.println("1. Silver\n2. Blue\n3. Yellow \n4.exit");
            input = sc.nextInt();
            switch (input) {
                case 1: return "Silver";
                case 2: return "Blue";
                case 3: return "Yellow";
                 case 4: System.exit(0);
                default: System.out.println("Invalid input. Please try again.");
            }
        }
    }
    public static String selectlocation() {
        //  Scanner sc = new Scanner(System.in);
        int input;
        while (true) {
            System.out.println("Select Location");
            System.out.println("1. Delhi\n2. Bangalore\n3. Hyderabad\n4. Chennai \n5.exit");
            input = sc.nextInt();
            switch (input) {
                case 1: return "Delhi";
                case 2: return "Bangalore";
                case 3: return "Hyderabad";
                case 4: return "Chennai";
                 case 5: System.exit(0);
                default: System.out.println("Invalid input. Please try again.");
            }
        }
    }
    public static void main(String[] args) {

       String car_manf = selectmanufacturer();
        String model = selectmodel();
        String transmission_vault = selecttransmission();
        String fuel_type = selectfueltype();
        String accessories_color = selectaccessoriescolor();
        String location = selectlocation();

        System.out.println("\nSelected Car Configuration : ");
        System.out.println("Car Manufacturer : " + car_manf);
        System.out.println("Car Model : " + model);
        System.out.println("Transmission : " + transmission_vault);
        System.out.println("Fuel Type : " + fuel_type);
        System.out.println("Accessories Color: " + accessories_color);
        System.out.println("Location : " + location);
    }
}
