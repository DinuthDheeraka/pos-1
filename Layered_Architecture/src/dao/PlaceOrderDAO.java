package dao;

public interface PlaceOrderDAO {
    String getLastOrderId();
    boolean isExistsOrder(String id);
    void insertOrder(String orderId,String date,String customerId);
}
