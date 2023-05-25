package BaiThiJava;

public class BookDemo {
    public static void main(String[] args) {
        Author author = new Author("Tiến", "Dũng");
        Book book = new Book("Một thế giới mới", author, 77.77);
        System.out.println(book.toString());
    }
}
