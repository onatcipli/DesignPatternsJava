package week_09_adapter;

import java.util.ArrayList;
import java.util.List;

/**
 * It's our Target that client uses,
 */
interface SimpleCalculator {
    int multiply(int number1, int number2);
}

/**
 * It's our Adaptee that will adapt to the Target interface
 */
class ExpertCalculator {
    double expertMultiply(List<Integer> numbers) {
        System.out.println("ExpertCalculator works");
        double total = 0;
        for (int i = 1; i < numbers.size(); i++) {
            total += numbers.get(i - 1) * numbers.get(i);
        }
        return total;
    }
}

/**
 * Its our Adapter, it works with object composition
 * Its adapting the (ExpertCalculator) Adaptee to our Target(SimpleCalculator) interface
 */
class Calculator implements SimpleCalculator {
    public Calculator(ExpertCalculator expertCalculator) {
        this.expertCalculator = expertCalculator;
    }

    ExpertCalculator expertCalculator;

    @Override
    public int multiply(int number1, int number2) {
        List numbers = new ArrayList();
        numbers.add(number1);
        numbers.add(number2);
        return (int) expertCalculator.expertMultiply(numbers);
    }
}

public class SE311_Week09Adapter {

    public static void main(String[] args) {
        ExpertCalculator expertCalculator = new ExpertCalculator();
        Calculator calculator = new Calculator(expertCalculator);


        System.out.println(calculator.multiply(5, 10));
    }
}
