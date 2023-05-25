package demo4;

import java.util.ArrayList;

public class Cart {
    private int id;
    private String customer;
    private double grandTotal;
    private ArrayList<Product> productList;
    private String city;
    // Constructor ko tham số, tạo ô nhớ cho mảng
    public Cart() {
        productList = new ArrayList<Product>();
        city = "";
    }

    public Cart(String city) {
        this.city = city;
        productList = new ArrayList<Product>();
    }

    // Thêm sản phẩm vào giỏ hàng
    public void addProduct(Product product) {
        productList.add(product);
        updateGrandTotal(product);
    }

    // Xoá sản phẩm khỏi giỏ hàng
    public void removeProduct(Product product) {
        productList.remove(product);
        updateGrandTotal(product);
    }

    // Cập nhật tổng tiền
    private void updateGrandTotal(Product product) {
        grandTotal = 0.0;
        for (Product p : productList) {
            grandTotal += (p.getPrice() * p.getQty());
            if (city.equals("Hanoi") || city.equals("Ho Chi Minh City")) {
                grandTotal += p.getShippingFee() * p.getQty() * 1.01;
            } else {
                grandTotal += p.getShippingFee() * p.getQty() * 1.02;
            }
        }
        if (city.equals("Hanoi") || city.equals("Ho Chi Minh City")) {
            grandTotal += product.getShippingFee() * product.getQty() * 1.01;
        } else {
            grandTotal += product.getShippingFee() * product.getQty() * 1.02;
        }
    }

    // Tính tổng tiền
    public void calculateTotal() {
        grandTotal = 0.0;
        for (Product product : productList) {
            grandTotal += product.getPrice() * product.getQty();
        }
        if (city.equals("Hanoi") || city.equals("Ho Chi Minh City")) {
            grandTotal *= 1.01;
        } else {
            grandTotal *= 1.02;
        }
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public String getCity() {
        return city;
    }
}