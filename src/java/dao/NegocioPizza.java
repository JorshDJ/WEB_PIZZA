
package dao;

import Interfaces.tiendaPizza;
import beans.Administradores;
import beans.Articulos;
import beans.Clientes;
import beans.Compra;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.MySQLConexion;


public class NegocioPizza implements tiendaPizza{
    

    @Override
    public List<Articulos> lisArt() {
        List<Articulos> lis = new ArrayList<>();
        Connection conn = null;
   try {
            conn = MySQLConexion.getConexion();
            String sql = "select idArticulo,Descripcion,PrecioUnidad ,Stock from articulos";
            PreparedStatement st = conn.prepareStatement(sql);
            //st.setString(1, cad);
            ResultSet rs = st.executeQuery();
            //llenar el arraylist con la clase entidad
            while (rs.next()) {
                Articulos a = new Articulos();
                a.setIdArtic(rs.getString(1));
                a.setDescripArtic(rs.getString(2));
                a.setPrecioUnitArtic(rs.getDouble(3));
                a.setStockArtic(rs.getInt(4));
                
	        lis.add(a);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }
        return lis;                           
    }
    

    @Override
    public Articulos busArt(String id) {
        Articulos a = null;
        Connection conn = null;
   try {
            conn = MySQLConexion.getConexion();
            String sql = "select idArticulo,descripcion,PrecioUnidad,stock from "
                    + " articulos where idArticulo=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            //llenar el arraylist con la clase entidad
           if (rs.next()) {
                 a = new Articulos();
                 
                a.setIdArtic(rs.getString(1));
                a.setDescripArtic(rs.getString(2));
                a.setPrecioUnitArtic(rs.getDouble(3));
                a.setStockArtic(rs.getInt(4));
                
	      
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }
      /*Retornar la entidad*/
        return a;
        
    }

    @Override
    public Clientes busCli(String id) {
        Clientes a = null;
        Connection conn = null;
   try {
            conn = MySQLConexion.getConexion();
            String sql = "select tarjeta,nombre,credito, PassWord, correo from "
                    + " clientes where tarjeta=?";
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            //llenar el arraylist con la clase entidad
           if (rs.next()) {
                 a = new Clientes();
                 
                a.setTarjetaCli(rs.getString(1));
                a.setNombreCli(rs.getString(2));
                a.setCredtitoCli(rs.getDouble(3));
                a.setClaveClie(rs.getString(4));
                a.setCorreoCli(rs.getString(5));                
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }

        return a;
        
    }

    @Override
    public String grabaFac(String codc, List<Compra> lista) {
        
        String fac="";
        //para el total
     double sm=0;
     for(Compra x:lista) sm=sm+x.total();
        Connection conn = null;
   try {
            conn = MySQLConexion.getConexion();
            String sql = "{call spfactura(?,?)}";
           CallableStatement st = conn.prepareCall(sql);
            st.setString(1, codc);//codigo de cliente
            st.setDouble(2, sm);
            ResultSet rs = st.executeQuery();
            //llenar el arraylist con la clase entidad
            rs.next();//leer el valor devuelto
            fac=rs.getString(1);//obtenemos la factura
            //grabar el detalle
            String sql2="{call spdetalle(?,?,?)}";
            CallableStatement st2=conn.prepareCall(sql2);
            for(Compra x:lista){//recorrer la lista de compra
                st2.setString(1, fac);
                st2.setString(2, x.getIdArtic());
               // st2.setDouble(3, x.getPrecioUnitArtic());
                st2.setInt(3, x.getCantidad());
                st2.executeUpdate();
            }     
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }

    
     
     return fac;
        
    }
    
    
    @Override
        public List<Articulos> lisGenArt() {
        List<Articulos> lis = new ArrayList<>();
        Connection conn = null;
   try {
            conn = MySQLConexion.getConexion();
            String sql = "select idArticulo,Descripcion,PrecioUnidad ,Stock from articulos";
            PreparedStatement st = conn.prepareStatement(sql);
            //st.setString(1, cad);
            ResultSet rs = st.executeQuery();
            //llenar el arraylist con la clase entidad
            while (rs.next()) {
                Articulos a = new Articulos();
                a.setIdArtic(rs.getString(1));
                a.setDescripArtic(rs.getString(2));
                a.setPrecioUnitArtic(rs.getDouble(3));
                a.setStockArtic(rs.getInt(4));
                
	        lis.add(a);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }
        return lis;                           
    }

    @Override
    public Administradores busAdm(String id) {
        
        Administradores a = null;
        Connection conn = null;
   try {
            conn = MySQLConexion.getConexion();
            String sql = "select codigo,nombre,pass, correo from "
                    + " administradores where codigo=?";
            
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            //llenar el arraylist con la clase entidad
           if (rs.next()) {
                 a = new Administradores();
                 
                a.setCodigo(rs.getString(1));
                a.setNombre(rs.getString(2));
                a.setPass(rs.getString(3));
                a.setCorreo(rs.getString(4));
                                      
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }

        return a;
    }

    @Override
    public List<Clientes> lisClientes() {
        
        List<Clientes> lis = new ArrayList<>();
        Connection conn = null;
   try {
            conn = MySQLConexion.getConexion();
            String sql = "select tarjeta, nombre,credito, PassWord, correo from clientes";
            PreparedStatement st = conn.prepareStatement(sql);
            
            ResultSet rs = st.executeQuery();
            //llenar el arraylist con la clase entidad
            while (rs.next()) {
                Clientes a = new Clientes();
                
                a.setTarjetaCli(rs.getString(1));
                a.setNombreCli(rs.getString(2));
                a.setCredtitoCli(rs.getDouble(3));
                a.setClaveClie(rs.getString(4));
                a.setCorreoCli(rs.getString(5));
                
                
                
	        lis.add(a);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }
        return lis;
    }
    
    
    public void actualizaArticulo(Articulos art) {
        String sql = "update articulos set Descripcion=?, PrecioUnidad=?, Stock=? where IdArticulo=?";
        Connection conn = null;
        try {
            conn = MySQLConexion.getConexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            //ps.setString(1, art.getIdArtic());
            ps.setString(1, art.getDescripArtic());
            ps.setDouble(2, art.getPrecioUnitArtic());
            ps.setInt(3, art.getStockArtic());
            ps.setString(4, art.getIdArtic());
            ps.executeUpdate();
        } catch (Exception e) {
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
            }
        }
    }
    
    public void nuevoArticulo(Articulos art) {
        String sql = "insert into articulos(IdArticulo, Descripcion, PrecioUnidad, stock) values( '" + art.getIdArtic() + "','" + art.getDescripArtic() + "','" + art.getPrecioUnitArtic() + "' ,'" + art.getStockArtic() + "')";
        Connection conn = null;
        try {
            conn = MySQLConexion.getConexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e2) {
            }
        }
        
        
    }
    
    public void borrarArticulo(String idArt) {
        String sql = "delete from articulos where IdArticulo=?";
        Connection conn = null;
        try {
            conn = MySQLConexion.getConexion();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idArt);
            ps.executeUpdate();
        } catch (Exception e) {
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e2) {
            }
        }
     
    }
}

