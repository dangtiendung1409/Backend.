package demo10;

import javafx.scene.control.TextInputDialog;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.Optional;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;

public class HomeController1 {
    @FXML
    public TextField txtName;
    @FXML
    public TextField txtPrice;
    @FXML
    public TextField txtQuantity;
    @FXML
    public TextArea txtComment;

    @FXML
    public ListView<String> myListView;
    public ArrayList<String> nameList = new ArrayList<>();
    public ArrayList<String> priceList = new ArrayList<>();
    public ArrayList<String> quantityList = new ArrayList<>();
    public ArrayList<String> commentList = new ArrayList<>();
    public ComboBox<String> combobox;
    public TextField txtSearch;
    private ObservableList<String> categoryList = FXCollections.observableArrayList("Áo sơ mi", "Quần short", "Váy dài", "Váy ngắn", "Quần dài", "Áo đồng phục", "Áo phông");
    private ObservableList<String> originalItems;


    public void initialize() {
        originalItems = FXCollections.observableArrayList();
        myListView.setItems(originalItems);
        combobox.setItems(categoryList);
        combobox.setOnAction(event -> {
            String selectedCategory = combobox.getSelectionModel().getSelectedItem();
            System.out.println("Danh mục đã chọn: " + selectedCategory);
        });
    }

    public void Submit(ActionEvent actionEvent) {
        try {
            String name = txtName.getText();
            String price = txtPrice.getText();
            String quantity = txtQuantity.getText();
            String comment = txtComment.getText();
            String selectedCategory = combobox.getSelectionModel().getSelectedItem();

            if (nameList.contains(name))
                throw new Exception("Name đã tồn tại");
            nameList.add(name);
            priceList.add(price);
            quantityList.add(quantity);
            commentList.add(comment);

            String sv = "Chủ đề: " + selectedCategory + "\n" + name + "\n" + price + "\n" + quantity + "\n" + comment;
            originalItems.add(sv);

            // Sắp xếp lại danh sách originalItems theo tên sản phẩm
            originalItems.sort((s1, s2) -> {
                String[] parts1 = s1.split("\n");
                String[] parts2 = s2.split("\n");
                return parts1[1].compareToIgnoreCase(parts2[1]);
            });

            txtName.clear();
            txtPrice.clear();
            txtQuantity.clear();
            txtComment.clear();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }


    public void handleDelete(ActionEvent actionEvent) {
        String selectedValue = myListView.getSelectionModel().getSelectedItem();
        if (selectedValue != null) {
            int selectedIndex = myListView.getSelectionModel().getSelectedIndex();

            // Xoá thông tin khỏi ListView và các danh sách
            originalItems.remove(selectedIndex);
            nameList.remove(selectedIndex);  // Cập nhật danh sách nameList
            priceList.remove(selectedIndex);  // Cập nhật danh sách priceList
            quantityList.remove(selectedIndex);  // Cập nhật danh sách quantityList
            commentList.remove(selectedIndex);  // Cập nhật danh sách commentList
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Vui lòng chọn một mục để xoá.");
            alert.show();
        }
    }


    public void handleEdit(ActionEvent actionEvent) {
        String selectedValue = myListView.getSelectionModel().getSelectedItem();
        if (selectedValue != null) {
            int selectedIndex = myListView.getSelectionModel().getSelectedIndex();

            try {
                // Lấy thông tin đã chọn từ ListView
                String selectedItem = myListView.getSelectionModel().getSelectedItem();
                String[] parts = selectedItem.split("\n");
                String category = parts[0];
                String originalName = parts[1];
                String price = parts[2];
                String quantity = parts[3];
                String comment = parts[4];

                // Sửa chủ đề
                ChoiceDialog<String> categoryDialog = new ChoiceDialog<>(category, categoryList);
                categoryDialog.setTitle("Sửa chủ đề");
                categoryDialog.setHeaderText(null);
                categoryDialog.setContentText("Chọn chủ đề đã chỉnh sửa:");
                Optional<String> categoryResult = categoryDialog.showAndWait();
                if (categoryResult.isPresent()) {
                    category = categoryResult.get();
                }

                // Sửa tên
                TextInputDialog nameDialog = new TextInputDialog(originalName);
                nameDialog.setTitle("Sửa tên");
                nameDialog.setHeaderText(null);
                nameDialog.setContentText("Nhập tên đã chỉnh sửa:");
                Optional<String> nameResult = nameDialog.showAndWait();
                if (nameResult.isPresent()) {
                    String newName = nameResult.get();

                    // Kiểm tra trùng tên với các mục khác trong nameList
                    if (nameList.contains(newName) && !newName.equals(originalName)) {
                        throw new Exception("Tên đã tồn tại");
                    }

                    // Cập nhật tên mới vào nameList
                    nameList.set(selectedIndex, newName);
                    originalName = newName;
                }

                // Sửa giá
                TextInputDialog priceDialog = new TextInputDialog(price);
                priceDialog.setTitle("Sửa giá");
                priceDialog.setHeaderText(null);
                priceDialog.setContentText("Nhập giá đã chỉnh sửa:");
                Optional<String> priceResult = priceDialog.showAndWait();
                if (priceResult.isPresent()) {
                    price = priceResult.get();
                }

                // Sửa số lượng
                TextInputDialog quantityDialog = new TextInputDialog(quantity);
                quantityDialog.setTitle("Sửa số lượng");
                quantityDialog.setHeaderText(null);
                quantityDialog.setContentText("Nhập số lượng:");
                Optional<String> quantityResult = quantityDialog.showAndWait();
                if (quantityResult.isPresent()) {
                    quantity = quantityResult.get();
                }

                // Sửa comment
                TextInputDialog commentDialog = new TextInputDialog(comment);
                commentDialog.setTitle("Sửa comment");
                commentDialog.setHeaderText(null);
                commentDialog.setContentText("Nhập comment đã chỉnh sửa:");
                Optional<String> commentResult = commentDialog.showAndWait();
                if (commentResult.isPresent()) {
                    comment = commentResult.get();
                }

                // Tạo thông tin đã chỉnh sửa
                String editedItem = category + "\n" + originalName + "\n" + price + "\n" + quantity + "\n" + comment;

                // Cập nhật thông tin đã chỉnh sửa trong ListView
                originalItems.set(selectedIndex, editedItem);

                // Sắp xếp lại danh sách originalItems dựa trên danh sách nameList

                originalItems.sort((s1, s2) -> {
                    String[] parts1 = s1.split("\n");
                    String[] parts2 = s2.split("\n");
                    String name1 = parts1[1];
                    String name2 = parts2[1];
                    return name1.compareToIgnoreCase(name2);
                });



            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText(e.getMessage());
                alert.show();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Vui lòng chọn một mục để sửa.");
            alert.show();
        }
    }



    public void returnToList(ActionEvent actionEvent) {
        // Quay về list view

        myListView.setItems(originalItems);
        txtSearch.clear();
    }


    // Tìm kiếm thông tin
    public void search(ActionEvent actionEvent) {

        String searchTerm = txtSearch.getText();
        ObservableList<String> searchResults = FXCollections.observableArrayList();

        for (String item : originalItems) {
            if (item.toLowerCase().contains(searchTerm.toLowerCase())) {
                searchResults.add(item);
            }
        }

        myListView.setItems(searchResults);
    }
}


