package demo4;

public class Product {
    private int id;
    private String productName;
    private int qty;
    private double price;
    private double shippingFee;

    public Product(int id, String productName, int qty, double price) {
        this.id = id;
        this.productName = productName;
        this.qty = qty;
        this.price = price;
    }
    // kiểm tra hàng
    public void checkQty() {
        if (qty > 0) {
            System.out.println("Còn hàng");
        } else {
            System.out.println("Hết hàng");
        }
    }
    public int getQty() {
        return qty;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public double getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(double shippingFee) {
        this.shippingFee = shippingFee;
    }
}