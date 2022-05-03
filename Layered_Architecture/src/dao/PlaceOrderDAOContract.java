package dao;

public interface PlaceOrderDAOContract {
    String getLastOrderId();
    boolean isExistsOrder(String id);
}
