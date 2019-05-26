package week_12_visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Visitor
 */
interface Visitor {
    public void Visit(Clerk element);

    public void Visit(Director element);

    public void Visit(President element);
}

/**
 * This is ConcreteVisitor
 */
class IncomeVisitor implements Visitor {
    @Override
    public void Visit(Clerk element) {
        element.setIncome(element.getIncome() * 1.10);
    }

    @Override
    public void Visit(Director element) {
        element.setIncome(element.getIncome() * 1.50);
    }

    @Override
    public void Visit(President element) {
        element.setIncome(element.getIncome() * 2.0);
    }
}

class VacationVisitor implements Visitor {

    @Override
    public void Visit(Clerk element) {
        element.setVacationDays(element.getVacationDays() + 3);
    }

    @Override
    public void Visit(Director element) {
        element.setVacationDays(element.getVacationDays() + 5);

    }

    @Override
    public void Visit(President element) {
        element.setVacationDays(element.getVacationDays() + 7);

    }
}

/**
 * To be able to perform new operations with Visitor,
 * Element has a method Accept and it takes Visitor as an argument(parameter)
 */
interface Element {
    public void Accept(Visitor Visitor);
}

abstract class Employee implements Element {
    private String name;
    private double income;

    private int vacationDays;

    public Employee(String name, double income, int vacationDays) {
        this.name = name;
        this.income = income;
        this.vacationDays = vacationDays;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public int getVacationDays() {
        return vacationDays;
    }

    public void setVacationDays(int vacationDays) {
        this.vacationDays = vacationDays;
    }

}

/**
 * Concrete Element
 */
class Clerk extends Employee {
    public Clerk(String name, double income, int vacationDays) {
        super(name, income, vacationDays);
    }

    @Override
    public void Accept(Visitor Visitor) {
        Visitor.Visit(this);
    }
}

/**
 * Concrete Element
 */
class Director extends Employee {

    public Director(String name, double income, int vacationDays) {
        super(name, income, vacationDays);
    }

    @Override
    public void Accept(Visitor Visitor) {
        Visitor.Visit(this);
    }
}

/**
 * Concrete Element
 */
class President extends Employee {

    public President(String name, double income, int vacationDays) {
        super(name, income, vacationDays);
    }

    @Override
    public void Accept(Visitor Visitor) {
        Visitor.Visit(this);
    }
}

class Employees {
    private ArrayList<Employee> employees;

    Employees() {
        employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        employees.add(employee);
    }

    public void remove(Employee employee) {
        employees.remove(employee);
    }

    public void AcceptVisitors(Visitor visitor) {
        for (Employee employee : employees) {
            employee.Accept(visitor);
        }
    }

    public void displayInfos() {
        for (Employee employee : employees) {
            System.out.println("Employee name         : " + employee.getName());
            System.out.println("Employee income       : " + employee.getIncome());
            System.out.println("Employee VacationDays : " + employee.getVacationDays());
            System.out.println("-----------------------");
        }
        System.out.println("************************************************************");
    }
}

public class SE311_Week12Visitor {

    public static void main(String[] args) {
        // write your code here
        System.out.println("SE311_Week12Visitor !!");

        Employees employees = new Employees();

        employees.add(new Clerk("Senol Güneş", 20000, 10));
        employees.add(new Clerk("Umut Güner", 30000, 20));
        employees.add(new Clerk("Fikret Orman", 40000, 30));

        employees.displayInfos();
        employees.AcceptVisitors(new IncomeVisitor());
        employees.displayInfos();
        employees.AcceptVisitors(new VacationVisitor());
        employees.displayInfos();


    }
}

