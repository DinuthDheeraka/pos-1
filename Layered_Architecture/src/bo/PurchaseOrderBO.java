package bo;

import model.CustomerDTO;
import model.ItemDTO;
import model.OrderDTO;
import model.OrderDetailDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface PurchaseOrderBO {
    public boolean purchaseOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException;
    public ItemDTO findItem(String itemCode);
    public CustomerDTO getCustomer(String id);
    public boolean isExistsItem(String itemCode) throws SQLException, ClassNotFoundException;
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException;
    public String getLastOrderId() throws SQLException, ClassNotFoundException;
    public ArrayList<String> getAllCustomerIds();
    public ArrayList<String> getAllItemsIds();
}
