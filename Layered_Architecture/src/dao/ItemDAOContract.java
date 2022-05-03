package dao;

import view.tdm.ItemTM;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemDAOContract {
    ArrayList<ItemTM> getAllItems();
    void insertItem(ItemTM tm) throws SQLException, ClassNotFoundException;
    void updateItem(String desc, BigDecimal unitPrice, int qoh, String code);
    void deleteItem(String id);
    boolean isExistsItem(String code);
    String getLastItemCode();
}
