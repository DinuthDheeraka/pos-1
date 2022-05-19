package bo.custom.impl;

import bo.custom.CustomerBO;
import dao.DAOFactory;
import dao.custom.CustomerDAO;
import entity.Customer;
import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {

    public CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    public ArrayList<Customer> getAllCustomers() throws SQLException, ClassNotFoundException {
        return customerDAO.getAll();
    }

    public void insertCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        customerDAO.insert(new Customer(customerDTO.getId(),customerDTO.getName(),
                customerDTO.getAddress()));
    }

    public void updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        customerDAO.update(new Customer(customerDTO.getId(), customerDTO.getName(),
                customerDTO.getAddress()));
    }

    public boolean isExistsCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.isExists(id);
    }

    public void deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        customerDAO.delete(id);
    }

    public String getCustomerLastId() throws SQLException, ClassNotFoundException {
        return customerDAO.getLastId();
    }
}
