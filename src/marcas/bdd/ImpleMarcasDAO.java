package marcas.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import conexiones.ConexionServFumaca;
import marcas.Marca;

public class ImpleMarcasDAO implements MarcasDAO{
	ConexionServFumaca conexion=new ConexionServFumaca();
	int idMarca;
	String Marca;
	String idSole;
	
	public ImpleMarcasDAO() {
		conexion.conectar();
	}

	@Override
	public void crearMarca(Marca marca) throws ExceipcionDeMarca {
		
		
	}

	@Override
	public void borrarMarca(Marca marca) throws ExceipcionDeMarca {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cambiarDatosDeMarca(Marca marca) throws ExceipcionDeMarca {
	       try {
	            
	            Connection con;
	            Statement sentencia;
	            String requerimiento;

	            con = ConexionServFumaca.getConexion();            
	            sentencia = con.createStatement();
	            
	            System.out.println(marca.getMarca());
	            System.out.println(marca.getIdMarca());
	            
	            requerimiento = "UPDATE Marcas SET marca = '" + marca.getMarca() + "'  WHERE idmarca='" + marca.getIdMarca() + "'";
	            
	           int conta= sentencia.executeUpdate(requerimiento);
	           
	           System.out.println(conta);
	          
	       } catch (Exception e) {
	            e.toString();
	            throw new ExceipcionDeMarca("ImplementacionClientesDAO.cambiarDatosDelCliente\n" + e);
	        }
	}

	@Override
	public Marca getMarca(String dni) throws ExceipcionDeMarca {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Marca[] obtenerTodasLasMarcas() throws ExceipcionDeMarca {
		
		Connection con;
		String sSQL;
     	Statement sentencia;
     	ResultSet resultado = null;
		
     	Marca marca = null;
     	Marca[] todos;
     	ArrayList<Marca> listaMarcas = new ArrayList<Marca>(1);
        
     	try {

     		con = ConexionServFumaca.getConexion();
     		sentencia = con.createStatement();
     		sSQL = "SELECT * FROM Marcas";
     		resultado = sentencia.executeQuery(sSQL);
            
     		while (resultado.next()) {
            	
     			idMarca=Integer.parseInt(resultado.getString("idmarca"));
     			Marca=resultado.getString("marca");
     			idSole=resultado.getString("idmarcasole");
            	
            	marca=new Marca(idMarca,Marca,idSole);

            	listaMarcas.add(marca);
     
            }
            
            if (listaMarcas.size() > 0) {
            	
            	todos=new Marca[listaMarcas.size()];
                todos =  listaMarcas.toArray(todos);
                
            } else {
                todos = null;
            }
               /*for(int a=0;a<todos.length;a++) {
            	   System.out.println(todos[a].getIdMarca()+" "+todos[a].getMarca()+" "+todos[a].getIdSoleMarca());
               }*/
            return todos;
            
        } catch (SQLException e) {
            todos = null;
            e.toString();
            throw new ExceipcionDeMarca("ImpleMarcaDAO.obtenerTodasLasMarcas\n" + e);
        }
	}

	private void marca(int idMarca, String marca, String idSole) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean existeDni(String dni) {
		// TODO Auto-generated method stub
		return false;
	}

}
