import java.util.ArrayList;

abstract class Employee{
   private String name;
    private int id;

    public Employee(String name, int id){
        this.name=name;
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }

    public  abstract double calculateSalary();

    public String toString(){
        return "Employee [name= "+name+", id="+id+", salary="+calculateSalary()+"]";
    }
}

class FullTimeEmployee extends Employee{

    private double monthlySalary;

    public FullTimeEmployee(String name, int id ,double monthlySalary){
        super(name, id);
        this.monthlySalary=monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name,int id , int hoursWorked,double hourlyRate){
        super(name, id);
        this.hoursWorked=hoursWorked;
        this.hourlyRate=hourlyRate;
    }
    @Override
    public double calculateSalary(){
        return hoursWorked*hourlyRate;
    }
}

class PayrollSyatem{
    private ArrayList<Employee> employeeList;

    public PayrollSyatem(){
        employeeList =new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public void removeEmployee(int id){
        Employee employeeToRemove = null;
        for (Employee employee:employeeList){
            if (employee.getId()==id){
                employeeToRemove=employee;
                break;
            }
        }
        if (employeeToRemove !=null){
            employeeList.remove(employeeToRemove);
        }

    }

    public void displayEmployee(){
        for (Employee employee:employeeList){
            System.out.println(employee);
        }
    }
}

public class Main {
    public static void main(String[] args) {

       PayrollSyatem payrollSyatem = new PayrollSyatem();
       FullTimeEmployee emp1 = new FullTimeEmployee("vikas",1,45000);
       PartTimeEmployee emp2 = new PartTimeEmployee("Alex",2,5,500);

       payrollSyatem.addEmployee(emp1);
       payrollSyatem.addEmployee(emp2);
        System.out.println("initial employees details ");
        payrollSyatem.displayEmployee();
        System.out.println("remove employees Details");
        payrollSyatem.removeEmployee(2);
        System.out.println("Remaing employees details ");
        payrollSyatem.displayEmployee();


    }
}