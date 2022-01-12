package dao;

import application.City;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class DAO<T> {
    protected static final String SELECT_ALL = "SELECT * FROM ";

    public abstract List<T> getAll();
}
