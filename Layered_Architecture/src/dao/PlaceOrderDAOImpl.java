package dao;

import model.OrderDTO;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PlaceOrderDAOImpl implements PlaceOrderDAO {

    @Override
    public ArrayList<OrderDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public void insert(OrderDTO orderDTO) throws SQLException, ClassNotFoundException {
        try {
            if(CrudUtil.execute("INSERT INTO `Orders` (id, date, customerId) VALUES (?,?,?)",
                    orderDTO.getOrderId(),orderDTO.getOrderDate(),orderDTO.getCustomerId())){
            }else{
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void update(OrderDTO orderDTO) throws SQLException, ClassNotFoundException {

    }

    @Override
    public void delete(String s) throws SQLException, ClassNotFoundException {

    }

    @Override
    public String getLastId() throws SQLException, ClassNotFoundException {
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

    @Override
    public boolean isExists(String s) throws SQLException, ClassNotFoundException {
        boolean isExists = false;
        try {
            ResultSet resultSet = CrudUtil.execute("SELECT id FROM `Orders` WHERE id=?",s);
            if(resultSet.next()){
                isExists = true;
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return isExists;
    }

    @Override
    public OrderDTO get(String s) {
        return null;
    }

    @Override
    public ArrayList<String> getAllIds() {
        return null;
    }
}
