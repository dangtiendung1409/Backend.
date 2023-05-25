package demo6;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.insertPhone("Đạt", "123456789");
        phoneBook.insertPhone("My", "987654321");
        phoneBook.insertPhone("Đạt", "111222333");
        phoneBook.insertPhone("Khải", "555444333");

        System.out.println("List of phone numbers in phone book:");
        phoneBook.sort();
        phoneBook.display();

        System.out.println("\nSearching for phone number of Đạt:");
        PhoneNumber Đạt = phoneBook.searchPhone("Đạt");
        if (Đạt != null) {
            System.out.println("Phone number of Đạt: " + Đạt.getPhone());
        } else {
            System.out.println("Đạt not found in phone book.");
        }

        System.out.println("\nRemoving  My from phone book:");
        phoneBook.removePhone("My");
        phoneBook.display();

        System.out.println("\nUpdating phone number of Đạt:");
        phoneBook.updatePhone("Đạt", "123456789", "999888777");
        phoneBook.display();
    }
}