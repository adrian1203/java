package lab8.pracownik;

import lab8.pracownik.Pracownik;
import lab8.bazadanych.ConnectException;

import java.sql.*;
import java.util.ArrayList;

public class DB {
    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private int  how_many_connect=0;
    public ArrayList<Pracownik> arrayList=new ArrayList<Pracownik>();

    public void connect() throws ConnectException{
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            /*conn =
                    DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/opiela1",
                            "opiela1", "QDrSmuGmYAky6NdC");*/
            conn =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/java",
                            "root", "");


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
            rs = stmt.executeQuery("SELECT * FROM pracownicy");
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

    public void addbook(Pracownik book) throws ConnectException {
        try {
            if (conn == null) {
                connect();
            }
            how_many_connect=0;
            stmt = conn.createStatement();
            String query="INSERT INTO  pracownicyy VALUES ('"+book.GetPesel()+"','"+book.GetName()+"','"+book.GetSurname()+"')";
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
            String query = "SELECT * FROM pracownicyy WHERE author LIKE '%" + author + "'";
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
            String query = "SELECT * FROM pracownicyy WHERE pesel='" + isbn + "'";
            rs = stmt.executeQuery(query);
            rsToArray(rs);
        } catch (SQLException ex) {

        }
    }
    public void rsToArray(ResultSet rs) throws SQLException {

        while (rs.next()) {
            String isbn = rs.getString(1);
            String title = rs.getString(2);
            String year = rs.getString(3);
            System.out.println(title);

            Pracownik book=new Pracownik(isbn, title,year);
            arrayList.add(book);


        }

    }
}
