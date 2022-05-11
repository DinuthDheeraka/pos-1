package dao;

import model.OrderDetailDTO;

import java.math.BigDecimal;

public interface OrderDetailDAO {
    void insertOrderDetail(OrderDetailDTO dto);
}
