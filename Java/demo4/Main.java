package demo4;

public class Main {

    public static void main(String[] args) {
        Product product1 = new Product(1, "Product 1", 5, 1000);
        Product product2 = new Product(2, "Product 2", 5, 2000);
        product1.checkQty();
        product2.checkQty();
        Cart cart = new Cart("Hanoi"); // tạo đối tượng Cart với địa chỉ thành phố là "Hanoi"
        cart.addProduct(product1);
        cart.addProduct(product2);

        cart.calculateTotal();
        System.out.println("Grand total before adding new product: " + cart.getGrandTotal());
        // thêm sản phẩm
        Product product3 = new Product(3, "Product 3", 1, 1000);
        cart.addProduct(product3);
        cart.calculateTotal();
        System.out.println("Grand total after adding new product: " + cart.getGrandTotal());
    }
}