package demo9;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.Collections;
import java.util.Optional;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


public class HomeController {
    @FXML
    public TextField txtName;
    public TextField txtEmail;
    public TextField txtTelephone;
    public Text txtOut;
    public ListView<String> myListView;
    public ArrayList<String> nameList = new ArrayList<>();
    public ArrayList<String> emailList = new ArrayList<>();
    public ArrayList<String> telephoneList = new ArrayList<>();
    public Button btnSearch;
    public TextField txtSearch;
    public DatePicker datePicker;

    private ObservableList<String> originalItems;

    public void initialize() {
        originalItems = FXCollections.observableArrayList();
        myListView.setItems(originalItems);
        datePicker.setValue(LocalDate.now());
    }
    // gửi thông tin
    public void submit(ActionEvent actionEvent) {
        try {
            String name = txtName.getText();
            String email = txtEmail.getText();
            String telephone = txtTelephone.getText();
            if (nameList.contains(name))
                throw new Exception("Name đã tồn tại");
            if (emailList.contains(email))
                throw new Exception("Email đã tồn tại.");
            if (telephoneList.contains(telephone))
                throw new Exception("Số điện thoại đã tồn tại.");
            nameList.add(name);
            emailList.add(email);
            telephoneList.add(telephone);

            String sv = name + "\n" + email + "\n" + telephone;
            originalItems.add(sv);
            //sắp xếp tên sau khi thêm thông tin mới theo bảng chữ cái ( không phân biệt in, hoa in thường )
            Collections.sort(originalItems, String.CASE_INSENSITIVE_ORDER);

            txtName.clear();
            txtEmail.clear();
            txtTelephone.clear();

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();

        }
    }
    // sửa thông tin
    public void editSelectedItem(ActionEvent actionEvent) {
        String selectedValue = myListView.getSelectionModel().getSelectedItem();
        if (selectedValue != null) {
            int selectedIndex = myListView.getSelectionModel().getSelectedIndex();

            try {
                // Lấy thông tin đã chọn từ ListView
                String selectedItem = myListView.getSelectionModel().getSelectedItem();
                String[] parts = selectedItem.split("\n");
                String name = parts[0];
                String email = parts[1];
                String telephone = parts[2];

                // Sửa tên
                TextInputDialog nameDialog = new TextInputDialog(name);
                nameDialog.setTitle("Sửa tên");
                nameDialog.setHeaderText(null);
                nameDialog.setContentText("Nhập tên đã chỉnh sửa:");
                Optional<String> nameResult = nameDialog.showAndWait();
                if (nameResult.isPresent()) {
                    name = nameResult.get();
                }

                // Sửa email
                TextInputDialog emailDialog = new TextInputDialog(email);
                emailDialog.setTitle("Sửa email");
                emailDialog.setHeaderText(null);
                emailDialog.setContentText("Nhập email đã chỉnh sửa:");
                Optional<String> emailResult = emailDialog.showAndWait();
                if (emailResult.isPresent()) {
                    email = emailResult.get();
                }

                // Sửa số điện thoại
                TextInputDialog telephoneDialog = new TextInputDialog(telephone);
                telephoneDialog.setTitle("Sửa số điện thoại");
                telephoneDialog.setHeaderText(null);
                telephoneDialog.setContentText("Nhập số điện thoại đã chỉnh sửa:");
                Optional<String> telephoneResult = telephoneDialog.showAndWait();
                if (telephoneResult.isPresent()) {
                    telephone = telephoneResult.get();
                }

                // Tạo thông tin đã chỉnh sửa
                String editedItem = name + "\n" + email + "\n" + telephone;

                // Cập nhật thông tin đã chỉnh sửa trong ListView
                originalItems.set(selectedIndex, editedItem);
                //sắp xếp tên sau khi thêm thông tin mới theo bảng chữ cái ( không phân biệt in, hoa in thường )
                Collections.sort(originalItems, String.CASE_INSENSITIVE_ORDER);


                // Cập nhật thông tin đã chỉnh sửa trong danh sách emailList và telephoneList
                emailList.set(selectedIndex, email);
                telephoneList.set(selectedIndex, telephone);
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Lỗi khi sửa thông tin.");
                alert.show();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Vui lòng chọn một mục để sửa.");
            alert.show();
        }
    }
    // Xoá thông tin nhập
    public void deleteSelectedItem(ActionEvent actionEvent) {
        String selectedValue = myListView.getSelectionModel().getSelectedItem();
        if (selectedValue != null) {
            int selectedIndex = myListView.getSelectionModel().getSelectedIndex();

            // Xoá thông tin khỏi ListView và các danh sách
            originalItems.remove(selectedIndex);
            emailList.remove(selectedIndex);
            telephoneList.remove(selectedIndex);
            Collections.sort(originalItems, String.CASE_INSENSITIVE_ORDER);

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Vui lòng chọn một mục để xoá.");
            alert.show();
        }
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
    // Quay về list view
    public void returnToList(ActionEvent actionEvent) {
        myListView.setItems(originalItems);
        txtSearch.clear();
    }
}


// cách 2 dùng if và lưu ý bỏ String ra ngoài chứ không bỏ trong try
// if(emailList.contains(email)){
//    Alert aleart = new Alert(Alert.AlertType.ERROR);
//     aleart.setContentText("Email này đã tồn tại.");
//     aleart.show();
//     return;
// }
//  emailList.add(email);
// String sv ="\n"+ name + "\n" + email + "\n" + telephone;
//  txtOut.setText(txtOut.getText() + sv);
//Telephone
// if(telephoneList.contains(telephone)){
//    Alert aleart = new Alert(Alert.AlertType.ERROR);
//    aleart.setContentText("telephone này đã tồn tại.");
//    aleart.show();
//    return;
//  }
//  telephoneList.add(telephone);
//  String sm ="\n"+ name + "\n" + email + "\n" + telephone;
//  txtOut.setText(txtOut.getText() + sm);





