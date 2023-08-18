package DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lim En Xi
 */
public abstract class Dal_Super<T> { 

    private Connection _conn;
    private PreparedStatement _stmt;

    public Dal_Super(Connection conn) {
        _conn = conn;
    }

    protected abstract String sqlStatement();

    protected abstract ExecutionTypeEnum executionType();

    protected abstract void prepareParameters(PreparedStatement stmt, T domain) throws SQLException;

//    null by default, override if you want, executionType = Query need mapping
    protected T domainMapping(ResultSet rs) throws SQLException {
        return null;
    }

    public ArrayList<T> run(T domain) throws SQLException {
        ArrayList<T> data = null;
        System.out.println("executing dal........");
        String sql = sqlStatement();
        System.out.println("query get");
        _stmt = _conn.prepareStatement(sql);
        System.out.println("preparedStatement get");
        prepareParameters(_stmt, domain);
        System.out.println("query done");
        ExecutionTypeEnum executionType = executionType();
        System.out.println("Enum type get");
        
        if (executionType == ExecutionTypeEnum.Query) {
            data = executeQuery();
            System.out.println("select statement executed");
        } else {
            executeUpdate();
            System.out.println("CUD statement executed");
        }
        _stmt.close();
        
        return data;

    }

    private ArrayList<T> executeQuery() throws SQLException {
        ResultSet rs = _stmt.executeQuery();
        System.out.println("result set returned");
        ArrayList<T> data = new ArrayList<>();
        while (rs.next()) {
            T datum = domainMapping(rs);
            data.add(datum);
            System.out.println("domain mapping...");
        }
        rs.close();
        System.out.println("map done");
        return data;
    }

//    use this int return primary key
    private int executeUpdate() throws SQLException {
        return _stmt.executeUpdate();
//        return pk query
    }

    public enum ExecutionTypeEnum {
        Query,
        Update
    }
}
