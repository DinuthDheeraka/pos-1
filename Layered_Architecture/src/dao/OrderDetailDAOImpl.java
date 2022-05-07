package dao;

import model.OrderDetailDTO;
import util.CrudUtil;

import java.math.BigDecimal;
import java.sql.SQLException;

public class OrderDetailDAOImpl implements OrderDetailDAOImplContract{
    public void insertOrderDetail(OrderDetailDTO dto){
        try {
            if(CrudUtil.execute("INSERT INTO orderdetail (orderId, itemCode, qty, unitPrice) VALUES (?,?,?,?)",
                    dto.getOrderId(),dto.getItemCode(),dto.getQty(),dto.getUnitPrice())){

            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
