package phonebook.model;

public class Person {

    private static long lastId; // 1 2
    private long id; // id = 1 , id = 2
    private String name;
    private String surName;
    private String phoneNumber;

    public Person(String name, String surName, String phoneNumber) {
        this.name = name;
        this.surName = surName;
        this.phoneNumber = phoneNumber;
        id = ++lastId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public Person() {
       id = ++lastId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length()>20){
            this.name = name.substring(0,20);
        }else {
            this.name = name;
        }
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPhoneNumber() {

        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(!phoneNumber.startsWith("(+994)")){
            this.phoneNumber = "(+994)"+phoneNumber;
        }else {
            this.phoneNumber = phoneNumber;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
