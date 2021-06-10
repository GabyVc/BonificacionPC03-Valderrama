package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidad.Cliente;
import entidad.TipoCliente;
import util.MySqlDBConexion;
  
public class ClienteModel {
	
	public List<Cliente> consultaCliente(String nombres){
		ArrayList<Cliente> data = new ArrayList<Cliente>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null; 
		try {
			con = MySqlDBConexion.getConexion();
			
			String sql = "select * from cliente c inner join tipo_cliente tc on "
					    + "c.idTipoCliente = tc.idTpoCliente where c.nombres = ?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1,nombres);
			rs = pstm.executeQuery();
	
			Cliente objClt = null;
			TipoCliente objTclt = null;
			while(rs.next()){
				objClt = new Cliente();
				objClt.setIdCliente(rs.getInt("idCliente"));
				objClt.setNombres(rs.getString("nombres"));
				objClt.setApellidos(rs.getString("apellidos"));
				objClt.setDNI(rs.getString("dni"));
				objClt.setFechNac(rs.getDate("fechaNacimiento"));
				objTclt = new TipoCliente();
				objTclt.setIdTipoCliente(rs.getInt("idTipoCliente"));
				objTclt.setNombres(rs.getString("nombre"));
				objClt.setTipoCliente(objTclt);
				data.add(objClt);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null)pstm.close();
				if (con != null)con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
}
