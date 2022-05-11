package dao.custom.impl;

import dao.custom.OrderDetailDAO;
import model.OrderDetailDTO;
import util.CrudUtil;

import java.sql.SQLException;

public class OrderDetailDAOImpl implements OrderDetailDAO {
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
