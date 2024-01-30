import java.util.Scanner;

public class Worker {
    Scanner input=new Scanner(System.in);
    private final static int FEMALETAXRATE=30;
    private static final int MALETAXREATE=50;
    int id;
    String name;
    String gender;
    String position;
    float hours;
    float rate;

Worker(){}

Worker(int id, String name, String gender , String position, float rate, float hours){
    this.id=id;
    this.name=name;
    this.position=position;
    this.rate= rate;
    this.hours=hours;
}
private float findSalary(){
    return rate * hours;
}

private float findTaxDeduction() {
        float rate=0;
        if(gender.equalsIgnoreCase("Female")){
            rate = FEMALETAXRATE;
        }else{
            rate = MALETAXREATE;
        }
        float deduction = findSalary() * (rate / 100);
        System.out.println("Tax:" +rate+"%");
        System.out.println("Tax Salary Deduction:"+ deduction+"$");
        return deduction;
    }

public void workerInput(){
    System.out.println("Enter Worker ID:");
    id= input.nextInt();
    System.out.println("Enter Worker Name:");
    input.nextLine();//for cleaning the buffer
    name= input.nextLine();
    System.out.println("Enter Worker Gender:");
    gender= input.nextLine();
    System.out.println("Enter Worker Position:");
    position= input.nextLine();
    System.out.println("Enter Worker Hours:");
    hours= input.nextFloat();
    System.out.println("Enter Worker Rate:");
    rate= input.nextFloat();
}

public void workerInfo(){
    System.out.println("Worker ID:"+id);
    System.out.println("Worker Name:"+name);
    System.out.println("Worker Position:"+position);
    System.out.println("Tax :"+FEMALETAXRATE+"%");
    System.out.println("Tax Salary Deduction:");
    System.out.println("Final Salary:"+findSalary());
}
}

