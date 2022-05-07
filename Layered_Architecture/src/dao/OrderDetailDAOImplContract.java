package dao;

import model.OrderDetailDTO;

import java.math.BigDecimal;

public interface OrderDetailDAOImplContract {
    void insertOrderDetail(OrderDetailDTO dto);
}
