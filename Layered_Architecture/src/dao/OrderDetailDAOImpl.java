package dao;

import util.CrudUtil;

import java.math.BigDecimal;
import java.sql.SQLException;

public class OrderDetailDAOImpl implements OrderDetailDAOImplContract{
    public void insertOrderDetail(String orderId, String itemCode, int qty, BigDecimal uPrice){
        try {
            if(CrudUtil.execute("INSERT INTO orderdetail (orderId, itemCode, qty, unitPrice) VALUES (?,?,?,?)",
                    orderId,itemCode,qty,uPrice)){

            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
