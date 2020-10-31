package ConexionBD;

import java.sql.*;

public class SQLConexion {

    public static Connection getConexion() {
        Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // verifica el driver
            String url = "jdbc:sqlserver://localhost;database=pastelerianectar"; // verifica la base de datos
            String usr = "sa";
            String psw = "alumno";
            con = DriverManager.getConnection(url, usr, psw);
            System.out.println("conexion sql server ok");
        } catch (ClassNotFoundException ex) {
            System.out.println("No hay Driver!!");
        } catch (SQLException ex) {
            System.out.println("Error con la BD");
        }
        return con;
    }
}
