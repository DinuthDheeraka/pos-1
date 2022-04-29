package util;

import db.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class IdsGenerator {

    public String generateId(String prefix, ArrayList<String> lastId){
        if(lastId.size()>0){
            int newCustomerId = Integer.parseInt(lastId.get(0).replace(prefix, "")) + 1;
            return String.format(prefix+"%03d", newCustomerId);
        }
        else {
            return prefix+000;
        }
    }
}
