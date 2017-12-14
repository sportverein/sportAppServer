package server;

import java.sql.*;
import java.util.ArrayList;

// autor: mm-geh

public class SimpleQuery {


    public static void main(String[] args) {

       //SimpleQuery.signoff("10.10.10.10", 2);
       //SimpleQuery.signon("10.10.10.10", 2);
        //SimpleQuery.delivery("7a",2,3);
       //SimpleQuery.grouplist(2);
    }

        // Verbindungs-daten
    final static String hostname = "kmint.de";
    final static String port = "3306";
    final static String dbname = "d028be11";
    final static String user = "d028be11";
    final static String password = "alp-dillingen17";


    static Connection conn = null;
    static int i  = 3;

        public static void connect()
        {

                try {
                    Class.forName("org.gjt.mm.mysql.Driver").newInstance(); //Treiber laden
                }
                catch (Exception e) {
                    System.err.println("Unable to load driver.");
                    e.printStackTrace();
                }


        }

public static boolean signon (String ip, int Station)

        {
            connect();

         try {                      //Verbindung aufbauen

        String url = "jdbc:mysql://"+hostname+":"+port+"/"+dbname;
        conn = DriverManager.getConnection(url, user, password);
        //Datenübermittlung
        Statement stmt = conn.createStatement(); //Statement beginnt
        //Abfrage beginnen


             String sqlCommand = "SELECT IP FROM station WHERE Nr = "+ Station+ ";";
             ResultSet rs =  stmt.executeQuery(sqlCommand);

             String Check = "";
             while (rs.next()) {
                  Check = rs.getString(1);
             }


              if (!Check.equals(ip)&& !Check.equals(""))
             {
                 stmt.close(); //Statement beenden
                 conn.close(); // Datenbank-Verbindung beenden
                 System.out.println(" Kein Login!");
                 return false;
             }

        sqlCommand = "UPDATE station SET IP =  '"+ ip + "' WHERE Nr = " +Station+";";
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

    public  static boolean delivery (String Klasse, int Station, int Punkte)

    {
        connect();
        i++;
        try {                      //Verbindung aufbauen

            String url = "jdbc:mysql://"+hostname+":"+port+"/"+dbname;
            conn = DriverManager.getConnection(url, user, password);
            //Datenübermittlung
            Statement stmt = conn.createStatement(); //Statement beginnt
            //Abfrage beginnen
            String sqlCommand = "INSERT INTO klasse_zu_station (Klasse,Station,Punkte,ID) VALUES ('"+ Klasse +"',"+Station+","+ Punkte +","+ i +");";
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


    public static ArrayList grouplist (int Station)

    {
     ArrayList<String> Dropdown = new ArrayList<>();

         connect();

        String output ="";
        try {
            //Verbindung aufbauen
            String url = "jdbc:mysql://"+hostname+":"+port+"/"+dbname;
            conn = DriverManager.getConnection(url, user, password);
            //Datenübermittlung
            Statement stmt = conn.createStatement(); //Statement beginnt
            //Abfrage beginnen

            String sqlCommand = "SELECT Name FROM klassen WHERE Name NOT IN (SELECT Klasse FROM klasse_zu_station WHERE Station = "+ Station + " AND Punkte >= 0);";

            ResultSet rs =  stmt.executeQuery(sqlCommand);


            while (rs.next())
            {
                Dropdown.add(rs.getString(1));

            }


            for (int i = 0;i<Dropdown.size();i++)
            {
                output = output +(Dropdown.get(i)+",");
            }


            stmt.close(); //Statement beenden
            conn.close(); // Datenbank-Verbindung beenden
        }
        catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            System.out.println("SQLState: " + sqle.getSQLState());
            System.out.println("VendorError: " + sqle.getErrorCode());
            sqle.printStackTrace();

            return null;
        }


        return Dropdown;

    }




} //Ende Klasse
