package demo5;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Dũng", 20, "123456789", "Hà nam");
        Person person2 = new Person("Long", 25, "987654321", "Hà nội");
        Person person3 = new Person("Hiếu", 30, "111222333", "Hồ Chí Minh");

        Room room = new Room("T2210A Room", "4th floor");

        room.addPerson(person1);
        room.addPerson(person2);
        room.addPerson(person3);

        room.printRoomInfo();

        System.out.println("Removing " + person2.getName() + " from the room.");
        room.removePerson(person2);

        room.printRoomInfo();
    }
}