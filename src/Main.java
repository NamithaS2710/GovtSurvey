import java.util.Scanner;
class Person {
    private String name;
    private int age;
    private double salary;

    public Person(String name, int age, double salary) throws NegativeInputException {
        if (age < 0 || salary < 0) {
            throw new NegativeInputException("Age and salary cannot be negative");
        }
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of people: ");
        int numPeople = scanner.nextInt();
        scanner.nextLine();

        int totalAge = 0;
        double totalSalary = 0;

        for (int i = 0; i < numPeople; i++) {
            System.out.println("Enter details for person " + (i + 1));
            System.out.print("Name: ");
            String name = scanner.nextLine();

            int age;
            while (true) {
                try {
                    System.out.print("Age: ");
                    age = scanner.nextInt();
                    if (age >= 0) {
                        break;
                    } else {
                        throw new NegativeInputException("Age cannot be negative. Please try again.");
                    }
                } catch (NegativeInputException e) {
                    System.out.println("Error: " + e);
                }
            }

            double salary;
            while (true) {
                try {
                    System.out.print("Salary: ");
                    salary = scanner.nextDouble();
                    if (salary >= 0) {
                        break;
                    } else {
                        throw new NegativeInputException("Salary cannot be negative. Please try again.");
                    }
                } catch (NegativeInputException e) {
                    System.out.println("Error: " + e);
                }
            }

            try {
                new Person(name, age, salary);
                totalAge += age;
                totalSalary += salary;
            } catch (NegativeInputException e) {
                System.out.println("Error: " + e);
                i--;
            }

            scanner.nextLine();
        }

        double averageSalary = totalSalary / numPeople;
        double averageAge = (double) totalAge / numPeople;

        System.out.println("\nSurvey Result");
        System.out.println("Average Salary: " + averageSalary);
        System.out.println("Average Age: " + averageAge);
    }
}

class NegativeInputException extends Exception {
    public NegativeInputException(String message) {
        super(message);
    }
}