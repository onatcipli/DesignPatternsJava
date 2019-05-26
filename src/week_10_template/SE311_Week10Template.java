package week_10_template;

public class SE311_Week10Template {

    public static void main(String[] args) {
        GameEngine unity = new Unity();
        GameEngine unreal = new UnrealEngine();


        unity.createNewGame("the-ozon");


        unreal.createNewGame("FindIt");
    }
}

abstract class GameEngine {


    /**
     * this is the template method
     * it has some steps which is can differ according to gameEngines
     * but the steps is generally is same.
     * <p>
     * We use this method from the base class
     *
     * @param gameName
     */
    public void createNewGame(String gameName) {
        startGameEngine();
        performCreateGame();
        typeGameProjectName(gameName);
        completeProcess();
        System.out.println("---------------------------------");
    }

    protected abstract void performCreateGame();

    protected abstract void typeGameProjectName(String gameName);

    protected abstract void completeProcess();

    protected abstract void startGameEngine();
}

class Unity extends GameEngine {

    @Override
    protected void performCreateGame() {
        System.out.println("Unity perform create game operation.!");
    }

    @Override
    protected void typeGameProjectName(String gameName) {
        System.out.println("Unity perform type name operation.! the name is : " + gameName);
    }

    @Override
    protected void completeProcess() {
        System.out.println("Unity perform complete process operation.!");
        System.out.println("Game Created!!!");
    }

    @Override
    protected void startGameEngine() {
        System.out.println("Unity start game engine operation.!");
    }
}

class UnrealEngine extends GameEngine {

    @Override
    protected void performCreateGame() {
        System.out.println("Unreal perform create game operation.!");
    }

    @Override
    protected void typeGameProjectName(String gameName) {
        System.out.println("Unreal perform type name operation.! the name is : " + gameName);
    }

    @Override
    protected void completeProcess() {
        System.out.println("Unreal perform complete process operation.!");
        System.out.println("Game Created!!!");
    }

    @Override
    protected void startGameEngine() {
        System.out.println("Unreal start game engine operation.!");
    }
}