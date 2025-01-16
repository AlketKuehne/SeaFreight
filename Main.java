import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("================ MAKE YOUR ORDER ================");
        
        String name = "";
        int weigh = 0;
        int length = 0;
        int width = 0;
        int height = 0;
        int vol = 0;
        String pol = "";
        String pod = "";
        
        try (Scanner scanner = new Scanner(System.in)) {
            boolean validInput = false;
            while (!validInput) {
                System.out.print("Please enter your name: ");
                name = scanner.nextLine();
                if (name.matches("[a-zA-Z ]+")) {
                    validInput = true;
                } else {
                    System.out.println("Error: Name must contain only letters.");
                }
            }
            validInput = false;

            while (!validInput) {
                System.out.print("Please enter point of loading: ");
                pol = scanner.nextLine();
                if (pol.matches("[a-zA-Z ]+")) {
                    validInput = true;
                } else {
                    System.out.println("Error: Invalid location.");
                }
            }
            validInput = false;
            
            while (!validInput) {
                System.out.print("Please enter point of discharge: ");
                pod = scanner.nextLine();
                if (pod.matches("[a-zA-Z ]+")) {
                    validInput = true;
                } else {
                    System.out.println("Error: Invalid location.");
                }
            }
            validInput = false;

            while (!validInput) {
                System.out.print("Please enter weigh (in kg): ");
                if (scanner.hasNextInt()) {
                    weigh = scanner.nextInt();
                    validInput = true;
                } else {
                    System.out.println("Error: Not a valid number.");
                    scanner.next();
                }
            }
            validInput = false;

            scanner.nextLine(); 

            while (!validInput) {
                System.out.print("Please enter dimensions (seperate values with: 'length x width x height' in cm): ");
                String dimensions = scanner.nextLine();
                String[] values = dimensions.split("x");
                if (values.length == 3 && isNumeric(values[0]) && isNumeric(values[1]) && isNumeric(values[2])) {
                    length = Integer.parseInt(values[0].trim());
                    width = Integer.parseInt(values[1].trim());
                    height = Integer.parseInt(values[2].trim());
                    vol = length * width * height;
                    validInput = true;
                } else {
                    System.out.println("Error: Invalid input.");
                }
            }
        }
        
        System.out.println("--------------Information--------------");
        System.out.println("Name:              " + name);
        System.out.println("From:              " + pol); 
        System.out.println("To:                " + pod); 
        System.out.println("Weigh:             " + weigh + " kg");
        System.out.println("Volume:            " + vol);
        System.out.println("Your order #21312 has been placed!");
    }
    
    private static boolean isNumeric(String str) {
        return str != null && str.matches("\\d+");
    }
}