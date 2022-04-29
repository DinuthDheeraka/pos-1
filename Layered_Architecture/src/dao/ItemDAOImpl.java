package dao;

import javafx.scene.control.Alert;
import util.CrudUtil;
import view.tdm.ItemTM;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDAOImpl {
    public ArrayList<ItemTM> getAllItems(){
        ArrayList<ItemTM> arrayList = new ArrayList<>();
        try {
            ResultSet set = CrudUtil.execute("SELECT * FROM Item;");
            while (set.next()){
                arrayList.add(new ItemTM(set.getString(1),set.getString(2),
                        set.getBigDecimal(3),set.getInt(4)));
            }
        } catch (SQLException|ClassNotFoundException e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public void insertItem(ItemTM tm) throws SQLException, ClassNotFoundException {
        if(CrudUtil.execute("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",
                tm.getCode(),tm.getDescription(),tm.getUnitPrice(),tm.getQtyOnHand())){
            new Alert(Alert.AlertType.CONFIRMATION,"Added Item Successfully").show();
        }else{
            new Alert(Alert.AlertType.ERROR,"Could't add Item!").show();
        }
    }

    public void updateItem(String desc, BigDecimal unitPrice, int qoh, String code){
        try {
            if(CrudUtil.execute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",
                    desc,unitPrice,qoh,code)){

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

    public void deleteItem(String id){
        try {
            if(CrudUtil.execute("DELETE FROM Item WHERE code=?",id)){
               new Alert(Alert.AlertType.CONFIRMATION,"Item Deleted Succsessfully").show();
            }else{
                new Alert(Alert.AlertType.ERROR,"Couldn't Delete Item").show();
            }
        } catch (SQLException |ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean isExistsItem(String code){
        boolean isExists = false;
        try {
            ResultSet resultSet = CrudUtil.execute("SELECT code FROM Item WHERE code=?",code);
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

    public String getLastItemCode(){
        String lastCode = null;
        try {
            ResultSet resultSet = CrudUtil.execute("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
            if(resultSet.next()){
                lastCode = resultSet.getString(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return lastCode;
    }
}
