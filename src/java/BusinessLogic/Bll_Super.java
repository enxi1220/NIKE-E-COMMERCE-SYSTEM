package BusinessLogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lim En Xi
 */
public abstract class Bll_Super<T> {

    private Connection _conn;
    private final String _host = "jdbc:derby://localhost:1527/NIKE";
    private final String _user = "nbuser";
    private final String _password = "nbuser";

    protected ArrayList<T> run(T domain) throws SQLException, Exception {
        ArrayList<T> data = null;
        openConnection();
        System.out.println("open connection");
        try {
            beginTransaction();
            System.out.println("beginTransaction");
            data = execute(_conn, domain);
            System.out.println("dal executed");
            commit();
            System.out.println("commit");
        } catch (SQLException ex) {
            rollback();
            System.out.println("rollback!");
            throw new SQLException(ex);
        }catch (Exception ex) {
            rollback();
            System.out.println("rollback!");
            throw new Exception(ex);
        } finally {
            closeConnection();
            System.out.println("closeConnection");
        }
        return data;
    }

    public abstract ArrayList<T> businessLogic(T domain) throws Exception;

    protected abstract ArrayList<T> execute(Connection conn, T domain) throws SQLException;

    private void commit() throws SQLException {
        _conn.commit();//save Ctrl+s
    }

    private void rollback() throws SQLException {
        _conn.rollback();//undo
    }

    private void beginTransaction() throws SQLException {
        _conn.setAutoCommit(false);//unable autosave
    }

    private void closeConnection() throws SQLException {
        _conn.close();
    }

    private void openConnection() throws SQLException {
        _conn = DriverManager.getConnection(_host, _user, _password);
        System.out.println("------------------- "+ Helper.CurrentDate.getDate() +" Connection -------------------");
    }
}
