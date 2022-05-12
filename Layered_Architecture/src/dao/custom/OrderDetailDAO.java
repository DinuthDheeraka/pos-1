package dao.custom;

import dao.SuperDAO;
import model.OrderDetailDTO;

import java.math.BigDecimal;

public interface OrderDetailDAO extends SuperDAO {
    void insertOrderDetail(OrderDetailDTO dto);
}
