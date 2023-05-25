package demo7;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        News news = new News();
        news.setTitle("Một ngày mới");
        news.setPublishDate("2023-05-11");
        news.setAuthor("Tiến Dũng");
        news.setContent("Đó là một ngày tuyệt vời");

        Scanner scanner = new Scanner(System.in);
        boolean continueRating = true;

        // Nhập lần đánh giá đầu tiên
        System.out.print("Enter the rating: ");
        float firstRating = scanner.nextFloat();
        news.AddRate(firstRating);
        scanner.nextLine();

        while (continueRating) {
            news.Display();

            System.out.print("Do you want to rate this news again? (Y/N): ");
            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase("Y")) {
                System.out.print("Enter the rating: ");
                float rating = scanner.nextFloat();
                news.AddRate(rating);
                scanner.nextLine();
            } else {
                continueRating = false;
            }
        }

        scanner.close();
    }
}






