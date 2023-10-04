package ma.fstt.model;

import ma.fstt.dao.ConnectionJDBC;

import java.sql.*;
import java.util.List;

public abstract class BaseDao<T> {

    protected Connection mycnx ;
    protected Statement statement ;
    protected PreparedStatement preparedStatement ;
    protected ResultSet resultset ;


    BaseDao() throws SQLException, ClassNotFoundException {

        this.mycnx = ConnectionJDBC.getInstance();
    }


    public abstract void save(T object) throws SQLException;

    public abstract void update(T object) throws SQLException;


    public abstract void delete(T object) throws SQLException;


    public abstract T getOne(Long id ) throws SQLException;

    public abstract List<T> getAll() throws SQLException;


}

