package dao;

import model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO <DTO,ID>{
    ArrayList<DTO> getAll() throws SQLException, ClassNotFoundException;
    void insert(DTO dto) throws SQLException, ClassNotFoundException;
    void update(DTO dto) throws SQLException, ClassNotFoundException;
    void delete(ID id) throws SQLException, ClassNotFoundException;
    ID getLastId() throws SQLException, ClassNotFoundException;
    boolean isExists(ID id) throws SQLException, ClassNotFoundException;
    CustomerDTO get(ID id);
    ArrayList<ID> getAllIds();
}
