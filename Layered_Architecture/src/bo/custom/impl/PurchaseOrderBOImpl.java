package bo.custom.impl;

import bo.custom.PurchaseOrderBO;
import dao.DAOFactory;
import dao.custom.CustomerDAO;
import dao.custom.ItemDAO;
import dao.custom.OrderDetailDAO;
import dao.custom.PlaceOrderDAO;
import entity.Customer;
import entity.Item;
import model.CustomerDTO;
import model.ItemDTO;
import model.OrderDTO;
import model.OrderDetailDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PurchaseOrderBOImpl implements PurchaseOrderBO {

    ItemDAO itemDAOContract = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    CustomerDAO customerDAOContract = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    PlaceOrderDAO placeOrderDAOContract = (PlaceOrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);
    OrderDetailDAO orderDetailDAOImplContract = (OrderDetailDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDERDETAILS);

    public boolean purchaseOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException {
        /*Transaction*/
        /*if order id already exist*/
        if (placeOrderDAOContract.isExists(orderId)) {
        }
        placeOrderDAOContract.insert(new OrderDTO(orderId,orderDate,customerId));

        for (OrderDetailDTO detail : orderDetails) {
            orderDetailDAOImplContract.insertOrderDetail(new OrderDetailDTO(orderId,detail.getItemCode(),detail.getQty(),
                    detail.getUnitPrice()));

            //Search & Update Item
            ItemDTO item = findItem(detail.getItemCode());
            item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());

            itemDAOContract.update(new Item(item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQtyOnHand()));
        }
        return true;
    }

    public ItemDTO findItem(String itemCode) {
        Item item = itemDAOContract.get(itemCode);
        return new ItemDTO(item.getCode(),item.getDescription(),
                item.getUnitPrice(),item.getQoh());
    }

    public CustomerDTO getCustomer(String id){
        Customer customer = customerDAOContract.get(id);
        return new CustomerDTO(customer.getId(),customer.getName(),customer.getAddress());
    }

    public boolean isExistsItem(String itemCode) throws SQLException, ClassNotFoundException {
        return itemDAOContract.isExists(itemCode);
    }

    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAOContract.isExists(id);
    }

    public String getLastOrderId() throws SQLException, ClassNotFoundException {
        return placeOrderDAOContract.getLastId();
    }

    public ArrayList<String> getAllCustomerIds(){
        return customerDAOContract.getAllIds();
    }

    public ArrayList<String> getAllItemsIds(){
        return itemDAOContract.getAllIds();
    }
}
