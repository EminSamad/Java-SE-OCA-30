package phonebook.controller;

import phonebook.model.Person;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonController {

    private boolean isContinue = true;
    private ArrayList<Person> arrayList = new ArrayList<>();

    public boolean isContinue() {
        return isContinue;
    }

    public void setContinue(boolean aContinue) {
        isContinue = aContinue;
    }

    public PersonController() {
    }

    public ArrayList<Person> getArrayList() {
        return arrayList;
    }

    public void printList() {
        for (Person person : arrayList) {
            System.out.println(person);
        }
    }
    public void updateRecord(Scanner scanner) {
        System.out.print("Dəyişmək istədiyiniz adı daxil edin :");
        String name = scanner.nextLine();
        System.out.print("ID'sini daxil edin :");
        long id = Long.parseLong(scanner.nextLine());
        boolean check = false;

        for (Person person : arrayList) {
            if (person.getName().equals(name) && person.getId() == id) {
                check = true;
                System.out.print("Yeni nömrəni daxil edin:");
                String newPhoneNumber = scanner.nextLine();
                person.setPhoneNumber(newPhoneNumber);
                System.out.println("Nömrə uğurla yeniləndi.");
                break;
            }
        }
        if (!check) {
            System.out.println("Kontaktda belə biri yoxdur.");
        }
    }
    public void removeRecord(Scanner scanner) {
        System.out.print("Silmək istədiyiniz adı daxil edin :");
        String name = scanner.nextLine();
        boolean check = false;
        System.out.print("ID'sini daxil edin :");
        long id = Long.parseLong(scanner.nextLine());

        for (int i = 0; i < arrayList.size(); i++) {
            Person person = arrayList.get(i);
            if (person.getName().equals(name) && person.getId() == id) {
                arrayList.remove(i);
                check = true;
                System.out.println("Nömrə uğurla silindi.");
                break;
            }
        }
        if (!check) {
            System.out.println("Kontaktda belə biri yoxdur.");
        }
    }






}
