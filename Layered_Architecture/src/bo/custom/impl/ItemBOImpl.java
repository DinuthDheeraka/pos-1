package bo.custom.impl;

import bo.custom.ItemBO;
import dao.DAOFactory;
import dao.custom.ItemDAO;
import entity.Item;
import model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {

    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        ArrayList<Item> items = itemDAO.getAll();
        ArrayList<ItemDTO> dtos = new ArrayList<>();
        for(Item item : items){
            dtos.add(new ItemDTO(
                    item.getCode(),item.getDescription(),
                    item.getUnitPrice(),item.getQoh()
            ));
        }
        return dtos;
    }

    public void deleteItem(String code) throws SQLException, ClassNotFoundException {
        itemDAO.delete(code);
    }

    public void insertItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        itemDAO.insert(new Item(itemDTO.getCode(),itemDTO.getDescription(),
                itemDTO.getUnitPrice(),itemDTO.getQtyOnHand()));
    }

    public void updatetItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {
        itemDAO.update(new Item(itemDTO.getCode(), itemDTO.getDescription(),
                itemDTO.getUnitPrice(), itemDTO.getQtyOnHand()));
    }

    public boolean isExistsItem(String code) throws SQLException, ClassNotFoundException {
        return itemDAO.isExists(code);
    }

    public String getLastItemId() throws SQLException, ClassNotFoundException {
        return itemDAO.getLastId();
    }
}
