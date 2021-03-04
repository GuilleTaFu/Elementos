package rubros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultListModel;

import conexiones.ConexionServFumaca;

/**
 * @author gcardillo
 * @version 1.0
 * @param <arrRubro>
 * @created 18-nov.-2020 09:10:22
 * SE CONSTRUYE AL RECIBIR EL ID COMPUESTO.
 * DEBE TENER DISPONIBLE LOS ID SEPARADOS Y LAS DESCRIPCIONES
 * DEBE PODER CARGAR UN RUBRO Y SUBRUBRO NUEVO
 * LA CLASE MANEJA LOS ID, NO SON PUBLICOS.
 * SE PUEDE MODIFICAR LA DESCRIPCION
 * AL CREAR UN RUBRO SE CREA EL SUBRUBRO 00 SIN CLASIFICAR POR DEFECTO.
 * SE PUEDE ELIMINAR UN SUBRUBRO EXCEPTO EL 00, AL ELIMINARSE, TODOS LOS ARTICULOS SE VINCULAN CON EL 00
 * ----- NO SE PUEDE MODIFICAR UN RUBRO SI TIENE ALGÚN ARTCICULO VINCULADO ------
 */

public class Rubro {

	// EL CODIGO COMPUESTO QUEDARÍA R01S01, R01S02...
	private String idRubro;  // R01, R02, R03...
	private String idSubRubro; //S01, S02, S03 ....
	private String rubro;
	private String subRubro;
	private String []  arrRubro;
	private Connection conn;


	public Rubro(String idRubroSubrubro){   // CONSTRUCTOR SI SE LLAMA PARA CONSULTA

		setExtraeCodigos(idRubroSubrubro);
		buscarDescripciones(idRubroSubrubro);

		System.out.println(getIdRubro());
		System.out.println(getIdSubRubro());
		System.out.println(getRubro());
		System.out.println(getSubRubro());
	}
	public Rubro() { // CONSTRUCTOR PARA ABM
		cargarRubro ();
		Formulario formu = new Formulario(arrRubro);

		
		
	}
	public void cargarRubro () {
		ConexionServFumaca SQL = new ConexionServFumaca();
		int a=0;
		conn = SQL.conectar();
		String sSQL =   "";
		
		try{	
	
			sSQL = "SELECT  distinct rubro FROM rubros ";

			PreparedStatement ps=conn.prepareStatement(sSQL);
			ResultSet rs=ps.executeQuery(); 
			
			rs.last();
			arrRubro=new String [rs.getRow()];
			rs.beforeFirst();
					
			while (rs.next()){
				arrRubro[a]=rs.getString("rubro");
				a++;
			}

			
			ConexionServFumaca.cerrar();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	private void buscarDescripciones(String idRubroSubrubro) {
		
		ConexionServFumaca SQL = new ConexionServFumaca();
		conn = SQL.conectar();
		String sSQL =   "";
		try{	
			sSQL = "SELECT * FROM rubros where idRubroSub= '"+idRubroSubrubro+"'";
			PreparedStatement ps=conn.prepareStatement(sSQL);
			ResultSet rs=ps.executeQuery(); 
	
				while (rs.next()){
					setRubro(rs.getNString("rubro"));
					setSubRubro(rs.getNString("subrubro"));
				}
				
			ConexionServFumaca.cerrar();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void setExtraeCodigos(String idRubroSubrubro) {
				setIdRubro(idRubroSubrubro.substring(0, 3));
				setIdSubRubro(idRubroSubrubro.substring(3, 6));
	}
	
	private void setIdRubro(String idRubro) {
		this.idRubro = idRubro;
	}

	private void setIdSubRubro(String idSubRubro) {
		this.idSubRubro = idSubRubro;
	}

	private void setRubro(String rubro) {
		this.rubro = rubro;
	}

	private void setSubRubro(String subRubro) {
		this.subRubro = subRubro;
	}
	public String getIdRubro() {
		return idRubro;
	}

	public String getIdSubRubro() {
		return idSubRubro;
	}

	public String getRubro() {
		return rubro;
	}

	public String getSubRubro() {
		return subRubro;
	}



}//end Rubro