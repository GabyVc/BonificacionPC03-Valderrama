package componentes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;

import util.MySqlDBConexion;


/*
 * Esta clase permite crear un combo dinámico, es decir, 
 * con registros de la base de datos
 */

@SuppressWarnings({ "serial", "rawtypes" })
public class JComboBoxBD extends JComboBox {

	private String sql;
	
	@SuppressWarnings("unchecked")
	public JComboBoxBD(String sql) {

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			conn = MySqlDBConexion.getConexion();
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			addItem("[seleccione]");
			addItem("-1: Todos");
			while(rs.next()){
				addItem(rs.getString(1)+": "+ rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!= null)	rs.close();
				if(pstm!= null)	pstm.close();
				if(conn!= null)	conn.close();
			} catch (SQLException e) {
			}
		}
	}
	
	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}
}
