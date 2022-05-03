package dao;

import java.math.BigDecimal;

public interface OrderDetailDAOImplContract {
    void insertOrderDetail(String orderId, String itemCode, int qty, BigDecimal uPrice);
}
