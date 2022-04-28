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

public class CustomerDAOImpl {

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
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Customer (id,name, address) VALUES (?,?,?)");
//        pstm.setString(1,customerDTO.getId());
//        pstm.setString(2,customerDTO.getName());
//        pstm.setString(3,customerDTO.getAddress());
//        return pstm.executeUpdate()>0;
        if(CrudUtil.execute("INSERT INTO Customer (id,name, address) VALUES (?,?,?)",customerDTO.getId(),customerDTO.getName(),customerDTO.getAddress())){
            new Alert(Alert.AlertType.CONFIRMATION,"Customer Inserted Successfully").show();
        }else{
            new Alert(Alert.AlertType.CONFIRMATION,"Could't Insert Customer").show();
        }

    }

    public boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE Customer SET name=?, address=? WHERE id=?");
        pstm.setString(1, customerDTO.getName());
        pstm.setString(2, customerDTO.getAddress());
        pstm.setString(3, customerDTO.getId());
        return pstm.executeUpdate()>0;
    }

    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Customer WHERE id=?");
        pstm.setString(1, id);
        return pstm.executeUpdate()>0;
    }
}
