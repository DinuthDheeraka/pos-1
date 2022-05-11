package bo;

import dao.custom.ItemDAO;
import dao.custom.impl.ItemDAOImpl;
import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO{

    ItemDAO itemDAO = new ItemDAOImpl();

    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        return itemDAO.getAll();
    }

    public void deleteItem(String code) throws SQLException, ClassNotFoundException {
        itemDAO.delete(code);
    }

    public void insertItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        itemDAO.insert(itemDTO);
    }

    public void updatetItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        itemDAO.update(itemDTO);
    }

    public boolean isExistsItem(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.isExists(code);
    }

    public String getLastItemId() throws SQLException, ClassNotFoundException {
        return itemDAO.getLastId();
    }
}
