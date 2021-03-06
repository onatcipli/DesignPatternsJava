package week_06_factory;

public class SE311_Week06Factory {

    public static void main(String[] args) {

        PhoneCreator appleCreator = new AppleCreator();

        appleCreator.createPhone();

    }
}

abstract class PhoneCreator {
    /**
     * Factory Method, let subclasses decide which class to instantiate
     *
     * @return
     */
    abstract Screen createScreen();

    /**
     * Factory Method, let subclasses decide which class to instantiate
     *
     * @return
     */
    abstract Processor createProcessor();

    /**
     * This is an Template Method,
     * We implement it, base class and we are overriding the steps which are Factory methods in sub-classes.
     */
    void createPhone() {
        createScreen();
        createProcessor();
    }
}

class AppleCreator extends PhoneCreator {

    @Override
    Screen createScreen() {
        return new AppleScreen();
    }

    @Override
    Processor createProcessor() {
        return new AppleProcessor();
    }
}

/**
 * Product one
 */
interface Processor {
}

class AppleProcessor implements Processor {
    AppleProcessor() {
        System.out.println("AppleProcessor created!!");
    }
}

interface Screen {
}

class AppleScreen implements Screen {
    AppleScreen() {
        System.out.println("AppleScreen created!!");
    }
}

