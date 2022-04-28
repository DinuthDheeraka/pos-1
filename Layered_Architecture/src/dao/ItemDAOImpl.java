package dao;

import javafx.scene.control.Alert;
import util.CrudUtil;
import view.tdm.ItemTM;

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
}
