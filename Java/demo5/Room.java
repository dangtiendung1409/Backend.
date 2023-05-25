package demo5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.lang.Override;

public class Room {
    private String name;
    private String position;
    private ArrayList<Person> personList;

    public Room(String name, String position) {
        this.name = name;
        this.position = position;
        this.personList = new ArrayList<Person>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(ArrayList<Person> personList) {
        this.personList = personList;
    }
    // Thêm thành viên
    public void addPerson(Person person) {
        this.personList.add(person);
    }
    //Xoá thành viên
    public void removePerson(Person person) {
        this.personList.remove(person);
    }
    // In thông tin phòng
    public void printRoomInfo() {
        System.out.println("Room name: " + this.name);
        System.out.println("Room position: " + this.position);
        System.out.println("Person list:");

        // Sắp xếp theo tên trước
        Collections.sort(this.personList, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getName().compareTo(p2.getName());
            }
        });

        for (Person person : this.personList) {
            System.out.println(person.getName() + ", " + person.getAge() + ", " + person.getTelephone() + ", " + person.getAddress());
        }
    }
}