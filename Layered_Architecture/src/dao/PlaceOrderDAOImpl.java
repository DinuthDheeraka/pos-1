package dao;

import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaceOrderDAOImpl implements PlaceOrderDAOContract{
    public String getLastOrderId(){
        String lastId = null;
        try {
            ResultSet resultSet = CrudUtil.execute("SELECT id FROM `Orders` ORDER BY id DESC LIMIT 1;");
            if(resultSet.next()){
                lastId = resultSet.getString(1);
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return lastId;
    }
}
