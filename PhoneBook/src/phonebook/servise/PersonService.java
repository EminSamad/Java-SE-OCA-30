package phonebook.servise;

import phonebook.controller.PersonController;
import phonebook.model.Person;
import phonebook.ui.Util;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonService {

    private PersonController personController;

    public PersonService(PersonController personController) {
        this.personController = personController;
    }


    public void initializeProses() {
        Scanner scanner = new Scanner(System.in);
        while (personController.isContinue()) {
            Util.showChoise();
            String choise = scanner.nextLine();
            switch (choise) {
                case "1":
                    addNumber(scanner);
                    break;
                case "2":
                    if(!personController.getArrayList().isEmpty()) {
                        personController.printList();
                    }else{
                        System.out.println("Kontakta heç bir ad əlavə olunmayıb.");
                    }
                    break;
                case "3":
                    if(!personController.getArrayList().isEmpty()) {
                        personController.updateRecord(scanner);
                    }else{
                        System.out.println("Kontakta heç bir ad əlavə olunmayıb.");
                    }
                    break;
                case "4":
                    personController.removeRecord(scanner);
                    break;
                case "5":
                    personController.setContinue(false);
                    break;
                default:
                    System.out.println("Yanliş Giriş :( ");
                    break;
            }
        }
        scanner.close();
    }

    public void addNumber(Scanner scanner) {
        getInputs(scanner);
        System.out.println("Nömrə uğurla əlavə olundu");
    }

    private void getInputs(Scanner scanner) {
        System.out.print("Adı daxil edin:");
        String name = scanner.nextLine();
        System.out.print("Soyadı daxil edin:");
        String surname = scanner.nextLine();
        System.out.print("Nömrəni daxil edin:");
        String phoneNumber = scanner.nextLine();
        Person person = buildPerson(name, surname, phoneNumber);
        addList(person);
    }

    private Person buildPerson(String name, String surname, String phoneNumber) {
        Person person = new Person();
        person.setName(name);
        person.setSurName(surname);
        person.setPhoneNumber(phoneNumber);
        return person;
    }

    private void addList(Person person) {
        ArrayList<Person> personList = personController.getArrayList();
        personList.add(person);
    }



}
