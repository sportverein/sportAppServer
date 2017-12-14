package server;

import java.sql.*;

// autor: mm-geh

public class SimpleQuery {

    // Verbindungs-daten
    final static String hostname = "kmint.de";
    final static String port = "3306";
    final static String dbname = "d028be11";
    final static String user = "d028be11";
    final static String password = "alp-dillingen17";

    static Connection conn = null;
    int i = 0;

    public static void connect() {
        try {
            Class.forName("org.gjt.mm.mysql.Driver").newInstance(); //Treiber laden
        }
        catch (Exception e) {
            System.err.println("Unable to load driver.");
            e.printStackTrace();
        }


    }

    public static boolean signon (String ip, int Station) {
        connect();

        try {                      //Verbindung aufbauen

            String url = "jdbc:mysql://"+hostname+":"+port+"/"+dbname;
            conn = DriverManager.getConnection(url, user, password);
            //Datenübermittlung
            Statement stmt = conn.createStatement(); //Statement beginnt
            //Abfrage beginnen
            String sqlCommand = "UPDATE station SET IP =  '"+ ip + "' WHERE Nr = " +Station+";";
            stmt.executeUpdate(sqlCommand);

            stmt.close(); //Statement beenden
            conn.close(); // Datenbank-Verbindung beenden
        }
        catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            System.out.println("SQLState: " + sqle.getSQLState());
            System.out.println("VendorError: " + sqle.getErrorCode());
            sqle.printStackTrace();

            return false;
        }

        return true;
    }



    public  static boolean signoff (String ip, int Station)

    {
        connect();

        try {                      //Verbindung aufbauen

            String url = "jdbc:mysql://"+hostname+":"+port+"/"+dbname;
            conn = DriverManager.getConnection(url, user, password);
            //Datenübermittlung
            Statement stmt = conn.createStatement(); //Statement beginnt
            //Abfrage beginnen
            String sqlCommand = "UPDATE station SET IP = '' " + " WHERE Nr = " +Station+ " AND IP = '"+ ip + "';";
            stmt.executeUpdate(sqlCommand);

            stmt.close(); //Statement beenden
            conn.close(); // Datenbank-Verbindung beenden
        }
        catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            System.out.println("SQLState: " + sqle.getSQLState());
            System.out.println("VendorError: " + sqle.getErrorCode());
            sqle.printStackTrace();

            return false;
        }

        return true;
    } //Ende Signoff

    public  static boolean Delivery (String ip, int Station)

    {
        connect();

        try {                      //Verbindung aufbauen

            String url = "jdbc:mysql://"+hostname+":"+port+"/"+dbname;
            conn = DriverManager.getConnection(url, user, password);
            //Datenübermittlung
            Statement stmt = conn.createStatement(); //Statement beginnt
            //Abfrage beginnen
            String sqlCommand = "UPDATE station SET IP = '' " + " WHERE Nr = " +Station+ " AND IP = '"+ ip + "';";
            stmt.executeUpdate(sqlCommand);

            stmt.close(); //Statement beenden
            conn.close(); // Datenbank-Verbindung beenden
        }
        catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            System.out.println("SQLState: " + sqle.getSQLState());
            System.out.println("VendorError: " + sqle.getErrorCode());
            sqle.printStackTrace();

            return false;
        }

        return true;
    } //Ende Signoff

} //Ende Klasse
