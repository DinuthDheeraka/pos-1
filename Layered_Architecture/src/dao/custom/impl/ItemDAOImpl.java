package dao.custom.impl;

import dao.custom.ItemDAO;
import entity.Item;
import javafx.scene.control.Alert;
import model.ItemDTO;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public ArrayList<Item> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Item> arrayList = new ArrayList<>();
        try {
            ResultSet set = CrudUtil.execute("SELECT * FROM Item;");
            while (set.next()){
                arrayList.add(new Item(set.getString(1),set.getString(2),
                        set.getBigDecimal(3),set.getInt(4)));
            }
        } catch (SQLException|ClassNotFoundException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    @Override
    public void insert(Item tm) throws SQLException, ClassNotFoundException {
        if(CrudUtil.execute("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",
                tm.getCode(),tm.getDescription(),tm.getUnitPrice(),tm.getQoh())){
            new Alert(Alert.AlertType.CONFIRMATION,"Added Item Successfully").show();
        }else{
            new Alert(Alert.AlertType.ERROR,"Could't add Item!").show();
        }
    }

    @Override
    public void update(Item item) throws SQLException, ClassNotFoundException {
        try {
            if(CrudUtil.execute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",
                    item.getDescription(),item.getUnitPrice(),item.getQoh(),item.getCode())){

                new Alert(Alert.AlertType.CONFIRMATION,"Updated Item Successfully").show();
            }else{
                new Alert(Alert.AlertType.ERROR,"Couldn't Update Item").show();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String s) throws SQLException, ClassNotFoundException {
        try {
            if(CrudUtil.execute("DELETE FROM Item WHERE code=?",s)){
                new Alert(Alert.AlertType.CONFIRMATION,"Item Deleted Succsessfully").show();
            }else{
                new Alert(Alert.AlertType.ERROR,"Couldn't Delete Item").show();
            }
        } catch (SQLException |ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getLastId() throws SQLException, ClassNotFoundException {
        String lastCode = null;
        try {
            ResultSet resultSet = CrudUtil.execute("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
            if(resultSet.next()){
                lastCode = resultSet.getString(1);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return lastCode;
    }

    @Override
    public boolean isExists(String s) throws SQLException, ClassNotFoundException {
        boolean isExists = false;
        try {
            ResultSet resultSet = CrudUtil.execute("SELECT code FROM Item WHERE code=?",s);
            if(resultSet.next()){
                isExists = true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return isExists;
    }

    @Override
    public Item get(String s) {
        Item item = null;
        try {
            ResultSet rst = CrudUtil.execute("SELECT * FROM Item WHERE code=?",s);
            if(rst.next()){
                item = new Item(s, rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return item;
    }

    @Override
    public ArrayList<String> getAllIds() {
        ArrayList<String> arrayList = new ArrayList();
        try {
            ResultSet resultSet = CrudUtil.execute("SELECT code FROM Item");
            while (resultSet.next()){
                arrayList.add(resultSet.getString(1));
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return arrayList;
    }
}
