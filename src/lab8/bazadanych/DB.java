package lab8.bazadanych;

import java.sql.*;
import java.util.ArrayList;

public class DB {
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private int  how_many_connect=0;
    public ArrayList<Book> arrayList=new ArrayList<Book>();

    public void connect() throws ConnectException{
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn =
                    DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/opiela1",
                            "opiela1a", "QDrSmuGmYAky6NdC");
          /*  conn =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/java",
                            "root", "");*/


        } catch (SQLException ex) {
            how_many_connect+=1;
            System.out.println(how_many_connect);
            if(how_many_connect<=3){
                connect();
            }
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            throw new ConnectException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listname() throws ConnectException{
        try {
            if (conn == null) {
                connect();
            }
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM books");
            rsToArray(rs);
        } catch (SQLException ex) {

        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    rs = null;
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    stmt = null;
                }
            }

        }
    }

    public void addbook(Book book) throws ConnectException {
        try {
            if (conn == null) {
                connect();
            }
            how_many_connect=0;
            stmt = conn.createStatement();
            String query="INSERT INTO  books VALUES ('"+book.getIsbn()+"','"+book.getTitle()+"','"+book.getAuthor()+"','"+book.getYear()+"')";
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Błąd przy dodawaniu ksiązki");
        }
    }

    public void searchauthor(String author) throws ConnectException{
        try {
            if (conn == null) {
                connect();
            }
            how_many_connect=0;
            stmt = conn.createStatement();
            String query = "SELECT * FROM books WHERE author LIKE '%" + author + "'";
            rs = stmt.executeQuery(query);
            rsToArray(rs);
        } catch (SQLException ex) {

        }
    }
    public void searchIsbn(String isbn) throws ConnectException{
        try {
            if (conn == null) {
                connect();
            }
            stmt = conn.createStatement();
            String query = "SELECT * FROM books WHERE isbn='" + isbn + "'";
            rs = stmt.executeQuery(query);
            rsToArray(rs);
        } catch (SQLException ex) {

        }
    }
    public void rsToArray(ResultSet rs) throws SQLException {

        while (rs.next()) {
            String isbn = rs.getString(1);
            String title = rs.getString(2);
            String year = rs.getString(4);
            String author=rs.getString(3);
            Book book=new Book(isbn, title,year,author);
            arrayList.add(book);


        }

    }
}
