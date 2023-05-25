package BaiThiJava;

public class BookDemo {
    public static void main(String[] args) {
        Author author = new Author("Russel", "Winder");
        Book book = new Book("Developing Java Software", author, 79.75);
        System.out.println(book.toString());
    }
}
