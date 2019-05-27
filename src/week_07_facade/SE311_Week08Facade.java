package week_07_facade;

public class SE311_Week08Facade {

    public static void main(String[] args) {

        Service service = new Service();
        Contacts contacts = new Contacts();
        Call call = new Call();


        Siri siri = new Siri(service, contacts, call);

        siri.heySiriCallPersonNamed("Onat");
    }
}

/**
 * This is our facade pattern
 */
class Siri {
    public Siri(Service service, Contacts contacts, Call call) {
        this.service = service;
        this.contacts = contacts;
        this.call = call;
    }

    Service service;
    Contacts contacts;
    Call call;


    void heySiriCallPersonNamed(String personName) {
        System.out.println("Hey patron,");
        if (service.isServiceAvailable()) {
            call.callPerson(contacts.getContact(personName));
        }
    }
}

class Service {

    boolean isServiceAvailable() {
        return true;
    }
}

class Contacts {
    String getContact(String person) {
        return person;
    }
}

class Call {
    void callPerson(String person) {
        System.out.println("Calling.... " + person);
    }
}

