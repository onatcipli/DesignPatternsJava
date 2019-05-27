package week_06_abstract_factory;

public class SE311_Week06AbstractFactory {

    public static void main(String[] args) {

        PhoneCreator appleCreator = new AppleCreator();
        PhoneCreator samsungCreator = new SamsungCreator();

        appleCreator.createPhone();

        samsungCreator.createPhone();
    }
}

/**
 * Abstract Factory
 */
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

class SamsungCreator extends PhoneCreator {

    @Override
    Screen createScreen() {
        return new SamsungScreen();
    }

    @Override
    Processor createProcessor() {
        return new SamsungProcessor();
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

class SamsungProcessor implements Processor {
    SamsungProcessor() {
        System.out.println("SamsungProcessor created!!");
    }
}

interface Screen {
}

class AppleScreen implements Screen {
    AppleScreen() {
        System.out.println("AppleScreen created!!");
    }
}

class SamsungScreen implements Screen {
    SamsungScreen() {
        System.out.println("SamsungScreen created!!");
    }
}
