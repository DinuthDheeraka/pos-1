package dao;

import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDAOContract {
    ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException;
    void insertCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;
    void updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;
    void deleteCustomer(String id) throws SQLException, ClassNotFoundException;
    String getCustomerLastId() throws SQLException, ClassNotFoundException;
    boolean isExistsCustomer(String id) throws SQLException, ClassNotFoundException;
    CustomerDTO getCustomer(String id);
}
