import java.util.Scanner;
import java.util.regex.Pattern;

public class Worker {
    Scanner input = new Scanner(System.in);
    private static final int FEMALETAXRATE = 30;
    private static final int MALETAXREATE = 50;
    int id;
    String name;
    String gender;
    String position;
    float hours;
    float rate;

    Worker() {}

    Worker(int id, String name, String gender, String position, float rate, float hours) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.rate = rate;
        this.hours = hours;
    }

    private float findSalary() {
        return rate * hours;
    }

    public String validate(String message,String regex) {
        while (true) {
            System.out.println(message);
            String userInput = input.nextLine().trim();
            Pattern pattern = Pattern.compile(regex);
            if (pattern.matcher(userInput).matches()) {
                return userInput;
            } else {
                System.out.println(" Error invalid !");
            }
        }
    }

        private float findTaxDeduction(){
            float rate = 0;
            if (gender.equalsIgnoreCase("Female")) {
                rate = FEMALETAXRATE;
            } else {
                rate = MALETAXREATE;
            }
            float deduction = findSalary() * (rate / 100);
            System.out.println("Tax:" + rate + "%");
            System.out.println("Tax Salary Deduction:" + deduction + "$");
            return deduction;
        }

        public void workerInput() {
            id = Integer.parseInt(validate("Enter worker ID: ","\\d+"));
            name = validate("Enter Worker Name:","[a-zA-Z0-9 ]+");
            gender = validate("Enter Worker Gender:","[a-zA-Z0-9 ]+");
            position = validate("Enter Worker Position:","[a-zA-Z0-9 ]+");
            hours =Float.parseFloat(validate("Enter Worker Hours","\\d+(\\.\\d+)?"));
            rate =Float.parseFloat(validate("Enter Worker Rate","\\d+(\\.\\d+)?"));
        }

        public void workerInfo () {
            System.out.println("Worker ID:" + id);
            System.out.println("Worker Name:" + name);
            System.out.println("Worker Position:" + position);
            System.out.println("Tax :" + FEMALETAXRATE + "%");
            System.out.println("Tax Salary Deduction:");
            System.out.println("Final Salary:" + findSalary());
        }

    public static void main(String[] args) {

        Worker obj = new Worker();
        obj.workerInput();obj.workerInfo();

    }
}


