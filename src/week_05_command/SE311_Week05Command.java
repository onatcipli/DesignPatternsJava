package week_05_command;

import java.util.ArrayList;
import java.util.List;

public class SE311_Week05Command {

    public static void main(String[] args) {
        // this is our Receiver
        Calculator calculator = new Calculator();

        // this is our invoker who compute's the commands
        // User does not know about calculator which is Receiver in our case.
        Invoker currentUser = new User();

        // this is our concreteCommand for adding 2 numbers
        Command addFiveToTen = new AddCommand(5, 10, calculator);
        Command addTenToTen = new AddCommand(10, 10, calculator);

        currentUser.compute(addFiveToTen);

        currentUser.compute(addTenToTen);

        currentUser.unCompute(addFiveToTen);

    }

}

interface Invoker {
    void compute(Command command);

    void unCompute(Command command);
}

class User implements Invoker {
    List commands = new ArrayList();

    @Override
    public void compute(Command command) {
        command.execute();
        commands.add(command);
    }

    @Override
    public void unCompute(Command command) {
        command.unExecute();
        commands.remove(command);
    }
}

/**
 * Generic Interface for Commands
 */
interface Command {
    public void execute();

    public void unExecute();
}

class AddCommand implements Command {
    private int numb1;
    private int numb2;
    private Calculator calculator;

    AddCommand(int numb1, int numb2, Calculator calculator) {
        this.numb1 = numb1;
        this.numb2 = numb2;
        this.calculator = calculator;
    }

    @Override
    public void execute() {
        calculator.collect(numb1, numb2);
    }

    @Override
    public void unExecute() {
        calculator.subtraction(numb1, numb2);
    }
}

/**
 * This is our Receiver who does the job.
 */
class Calculator {
    int sum;

    Calculator() {
        sum = 0;
    }

    int collect(int numb1, int numb2) {
        int currentCalculate = numb1 + numb2;
        System.out.println("Current Calculate is : " + currentCalculate);
        sum += currentCalculate;
        System.out.println("Sum is : " + sum);
        return currentCalculate;
    }

    int subtraction(int numb1, int numb2) {
        int currentCalculate = Math.abs(numb1 - numb2);
        System.out.println("Current Calculate is : " + currentCalculate);
        sum -= currentCalculate;
        System.out.println("Sum is : " + sum);
        return currentCalculate;
    }

    int multiply(int numb1, int numb2) {
        int currentCalculate = numb1 * numb2;
        System.out.println("Current Calculate is : " + currentCalculate);
        sum += currentCalculate;
        System.out.println("Sum is : " + sum);
        return currentCalculate;
    }

    float divide(int numb1, int numb2) {
        int currentCalculate = numb1 / numb2;
        System.out.println("Current Calculate is : " + currentCalculate);
        sum += currentCalculate;
        System.out.println("Sum is : " + sum);
        return currentCalculate;
    }
}

