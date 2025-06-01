import java.util.Scanner;

public class Tax{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your annual salary: ");
        double salary = sc.nextDouble();

        System.out.print("Enter your age in years : ");
        int age = sc.nextInt();

        System.out.print("Enter investment in tax-saving instruments : ");
        double investment = sc.nextDouble();

        System.out.print("Enter health insurance premium : ");
        double healthinsurance = sc.nextDouble();

        System.out.print("Enter home loan interest paid annually : ");
        double homeloaninterest = sc.nextDouble();

        sc.close();

   
        double deduction80c = Math.min(investment, 150000);
        double deduction80d;
        if (age >= 60) {
            deduction80d = Math.min(healthinsurance, 50000);
        } else {
            deduction80d = Math.min(healthinsurance, 25000);
        }
        double deduction24 = Math.min(homeloaninterest, 200000);

        double totaldeductions = deduction80c + deduction80d + deduction24;
        double taxableincome = salary - totaldeductions;
        taxableincome = Math.max(taxableincome, 0); 

     
        double tax = 0;
        if (age < 60) {
            tax = calculatetax(taxableincome, 250000);
        } else if (age >= 60 && age <= 80) {
            tax = calculatetax(taxableincome, 300000);
        } else {
            tax = calculatetax(taxableincome, 500000);
        }

        
        System.out.printf("Total tax owed: %.2f\n", tax);
    }

    public static double calculatetax(double income, double exemptionlimit) {
        double tax = 0;

        if (income <= exemptionlimit) {
            return 0;
        } else if (income <= 500000) {
            tax = (income - exemptionlimit) * 0.05;
        } else if (income <= 1000000) {
            tax = (500000 - exemptionlimit) * 0.05;
            tax += (income - 500000) * 0.20;
        } else {
            tax = (500000 - exemptionlimit) * 0.05;
            tax += 500000 * 0.20;
            tax += (income - 1000000) * 0.30;
        }

        return tax;
    }
}
