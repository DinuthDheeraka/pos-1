package bo.custom;

import entity.Customer;
import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO extends SuperBO{

    public ArrayList<CustomerDTO> getAllCustomers() throws SQLException, ClassNotFoundException;
    public void insertCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;
    public void updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;
    public boolean isExistsCustomer(String id) throws SQLException, ClassNotFoundException;
    public void deleteCustomer(String id) throws SQLException, ClassNotFoundException;
    public String getCustomerLastId() throws SQLException, ClassNotFoundException;
}
