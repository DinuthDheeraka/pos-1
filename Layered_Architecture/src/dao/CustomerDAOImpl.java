package dao;

import db.DBConnection;
import javafx.scene.control.Alert;
import model.CustomerDTO;
import util.CrudUtil;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/

public class CustomerDAOImpl implements CustomerDAOContract{

    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException {
        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();
        ResultSet rst = CrudUtil.execute("SELECT * FROM Customer");
        while (rst.next()) {
            String id = rst.getString(1);
            String name = rst.getString(2);
            String address = rst.getString(3);
            allCustomers.add(new CustomerDTO(id, name, address));
        }
        return allCustomers;
    }

    public void insertCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        if(CrudUtil.execute("INSERT INTO Customer (id,name, address) VALUES (?,?,?)",customerDTO.getId(),customerDTO.getName(),customerDTO.getAddress())){
            new Alert(Alert.AlertType.CONFIRMATION,"Customer Inserted Successfully").show();
        }else{
            new Alert(Alert.AlertType.CONFIRMATION,"Could't Insert Customer").show();
        }

    }

    public void updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {

        if(CrudUtil.execute("UPDATE Customer SET name=?, address=? WHERE id=?",customerDTO.getName(),customerDTO.getAddress(),
                customerDTO.getId())){
            new Alert(Alert.AlertType.CONFIRMATION,"Updated Customer Successfully");
        }else{
            new Alert(Alert.AlertType.ERROR,"Couldn't Update Customer!");
        }
    }

    public void deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        if(CrudUtil.execute("DELETE FROM Customer WHERE id=?",id)){
            new Alert(Alert.AlertType.CONFIRMATION,"Deleted Customer Successfully");
        }else{
            new Alert(Alert.AlertType.ERROR,"Couldn't Delete Customer!");
        }
    }

    public String getCustomerLastId() throws SQLException, ClassNotFoundException {
        String lastId = null;
        ResultSet resultSet = CrudUtil.execute("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
        if(resultSet.next()){
            lastId = resultSet.getString(1);
        }
        return lastId;
    }

    public boolean isExistsCustomer(String id) throws SQLException, ClassNotFoundException {
        boolean isExists = false;
        ResultSet resultSet = CrudUtil.execute("SELECT id FROM Customer WHERE id=?",id);
        if(resultSet.next()){
            isExists = true;
        }
        return isExists;
    }

    public CustomerDTO getCustomer(String id){
        CustomerDTO customerDTO = null;
        try {
            ResultSet rst = CrudUtil.execute("SELECT * FROM Customer WHERE id=?",id);
            if(rst.next()){
                customerDTO = new CustomerDTO(id, rst.getString("name"), rst.getString("address"));;
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return customerDTO;
    }
}
