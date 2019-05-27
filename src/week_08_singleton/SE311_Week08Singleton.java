package week_08_singleton;

import sun.misc.Lock;

public class SE311_Week08Singleton {

    public static void main(String[] args) {


        // The address is same, its the unique instance
        TaskManager windowsTaskManager = TaskManager.createInstance();
        System.out.println(windowsTaskManager);

        // The address is same, its the unique instance
        TaskManager windowsSecondTaskManager = TaskManager.createInstance();
        System.out.println(windowsSecondTaskManager);
    }
}

/**
 * The os should only have one task manager
 */
class TaskManager {
    /**
     * We make private instance, this will be our unique instance
     */
    private static TaskManager instance = null;

    /**
     * We need to make the constructor private to deny access out side of the class
     */
    private TaskManager() {
    }

    /**
     * This is public static method we will create and provide the unique instance with this method
     * Not multi-Thread safe
     *
     * @return
     */
    public static TaskManager createInstance() {
        if (instance == null) {
            instance = new TaskManager();
        }
        return instance;
    }

    /**
     * This is public static method we will create and provide the unique instance with this method,
     * multi Thread safe
     *
     * @return
     * @throws InterruptedException
     */
    public static TaskManager createInstanceThreadSafe() throws InterruptedException {
        if (instance == null) {
            Lock lock = new Lock();
            lock.lock();
            try {
                if (instance == null) {
                    instance = new TaskManager();
                }
            } finally {
                lock.lock();
                System.out.println("Released lock");
            }
        }
        return instance;
    }

}
