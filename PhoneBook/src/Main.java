import phonebook.controller.PersonController;
import phonebook.servise.PersonService;
import phonebook.ui.Util;

public class Main {

    static {
        Util.startProgram();
    }

    public static void main(String[] args) {
        PersonController controller = new PersonController();
        PersonService personService = new PersonService(controller);
        personService.initializeProses();

    }
}
