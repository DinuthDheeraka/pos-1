package bo;

import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO {
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException;
    public void deleteItem(String code) throws SQLException, ClassNotFoundException;
    public void insertItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
    public void updatetItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException;
    public boolean isExistsItem(String code) throws SQLException, ClassNotFoundException;
    public String getLastItemId() throws SQLException, ClassNotFoundException;
}
