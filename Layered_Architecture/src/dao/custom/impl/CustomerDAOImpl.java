package dao.custom.impl;

import dao.custom.CustomerDAO;
import entity.Customer;
import javafx.scene.control.Alert;
import model.CustomerDTO;
import util.CrudUtil;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Customer> allCustomers = new ArrayList<>();
        ResultSet rst = CrudUtil.execute("SELECT * FROM Customer");
        while (rst.next()) {
            String id = rst.getString(1);
            String name = rst.getString(2);
            String address = rst.getString(3);
            allCustomers.add(new Customer(id, name, address));
        }
        return allCustomers;
    }

    @Override
    public void insert(Customer customer) throws SQLException, ClassNotFoundException {
        if(CrudUtil.execute("INSERT INTO Customer (id,name, address) VALUES (?,?,?)",customer.getId(),customer.getName(),customer.getAddress())){
            new Alert(Alert.AlertType.CONFIRMATION,"Customer Inserted Successfully").show();
        }else{
            new Alert(Alert.AlertType.CONFIRMATION,"Could't Insert Customer").show();
        }
    }

    public void update(Customer customer) throws SQLException, ClassNotFoundException {

        if(CrudUtil.execute("UPDATE Customer SET name=?, address=? WHERE id=?",customer.getName(),customer.getAddress(),
                customer.getId())){
            new Alert(Alert.AlertType.CONFIRMATION,"Updated Customer Successfully");
        }else{
            new Alert(Alert.AlertType.ERROR,"Couldn't Update Customer!");
        }
    }

    public void delete(String id) throws SQLException, ClassNotFoundException {
        if(CrudUtil.execute("DELETE FROM Customer WHERE id=?",id)){
            new Alert(Alert.AlertType.CONFIRMATION,"Deleted Customer Successfully");
        }else{
            new Alert(Alert.AlertType.ERROR,"Couldn't Delete Customer!");
        }
    }

    public String getLastId() throws SQLException, ClassNotFoundException {
        String lastId = null;
        ResultSet resultSet = CrudUtil.execute("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
        if(resultSet.next()){
            lastId = resultSet.getString(1);
        }
        return lastId;
    }

    public boolean isExists(String id) throws SQLException, ClassNotFoundException {
        boolean isExists = false;
        ResultSet resultSet = CrudUtil.execute("SELECT id FROM Customer WHERE id=?",id);
        if(resultSet.next()){
            isExists = true;
        }
        return isExists;
    }

    public Customer get(String id){
        Customer customer = null;
        try {
            ResultSet rst = CrudUtil.execute("SELECT * FROM Customer WHERE id=?",id);
            if(rst.next()){
                customer = new Customer(id, rst.getString("name"), rst.getString("address"));;
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }

    public ArrayList<String> getAllIds(){
        ArrayList<String> arrayList = new ArrayList();
        try {
            ResultSet resultSet = CrudUtil.execute("SELECT * FROM Customer");
            while(resultSet.next()){
                arrayList.add(resultSet.getString("id"));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return arrayList;
    }
}
