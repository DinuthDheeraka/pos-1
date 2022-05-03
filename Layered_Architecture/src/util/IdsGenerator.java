package util;

import db.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class IdsGenerator {

    public static String generateId(String prefix,String lastId){
        if(lastId!=null){
            int newCustomerId = Integer.parseInt(lastId.replace(prefix, "")) + 1;
            return String.format(prefix+"%03d", newCustomerId);
        }
        else {
            return prefix+000;
        }
    }
}
