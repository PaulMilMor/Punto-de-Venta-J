/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto.de.venta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class Conexion {

    private String database = "bin8acqfuoisdxxg0vgs";
    private String host = "bin8acqfuoisdxxg0vgs-mysql.services.clever-cloud.com";
    private String port = "3306";
    private String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
    private String user = "utbd8vd2wnzjdyy1";
    private String password = "lyx8T96JZqwDz0AE5fU4";
    private Connection connection;

    public Conexion() {
        System.out.println("Connecting...");
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Database connected!");
            connection.close();

        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to database!", e);
        }
    }

    public List<Producto> getProductos() {
        String query = "SELECT * FROM producto";
        List<Producto> productos = new ArrayList<Producto>();

        try {
            connection = DriverManager.getConnection(url, user, password);
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Producto p = new Producto();
                p.setCodigo(rs.getInt("idproducto"));
                p.setNombre(rs.getString("Nombre"));
                p.setInventario(rs.getInt("inventario"));
                p.setPrecio(rs.getInt("unidad"));
                p.setDescuento(rs.getInt("descuento"));
                productos.add(p);
            }
            st.close();
            connection.close();
            return productos;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,  "" + e,"Error de conexión.", JOptionPane.WARNING_MESSAGE);
            return productos;
        }

    }

    public void Reduce(int code, int bought) {
        String query = "UPDATE producto SET inventario = ? WHERE idproducto = ?";
        try {
            connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, bought);
            preparedStmt.setInt(2, code);
            preparedStmt.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión.", "" + e, JOptionPane.WARNING_MESSAGE);

        }
    }

    public void Increment(int code, int invent) {
        String query = "UPDATE producto SET inventario = ? WHERE idproducto  = ?";
         try {
            connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1,invent);
            preparedStmt.setInt(2, code);
            preparedStmt.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión.", "" + e, JOptionPane.WARNING_MESSAGE);

        }
    }

}


