package dao;

public interface PlaceOrderDAOContract {
    String getLastOrderId();
    boolean isExistsOrder(String id);
    void insertOrder(String orderId,String date,String customerId);
}
