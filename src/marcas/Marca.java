package marcas;
/**
 * @author gcardillo
 * @version 1.0
 * @created 21-dic.-2020 09:10:22
 * 
 * DEBE PODER CARGAR UNA MARCA NUEVA
 * LA CLASE MANEJA LOS ID, NO SON PUBLICOS.
 * SE PUEDE MODIFICAR LA DESCRIPCION
 * SE PUEDE ELIMINAR UNA MARCA, LOS ARTICULOS QUE ESTABAN VINCULADOS QUEDAN CON EL 0 "SIN MARCA"
 * ----- NO SE PUEDE MODIFICAR UN RUBRO SI TIENE ALGÚN ARTCICULO VINCULADO ------
 */

public class Marca {
	private int idMarca;
	private String Marca;
	private String idSoleMarca;

	
	public Marca() {
		
	}
	public Marca(int id,String marca,String idsole ) {
		this.idMarca=id;
		this.Marca=marca;
		this.idSoleMarca=idsole;
	}

	public int getIdMarca() {
		return idMarca;
	}

	public String getMarca() {
		return Marca;
	}

	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}

	public void setMarca(String marca) {
		Marca = marca;
	}

	public String getIdSoleMarca() {
		return idSoleMarca;
	}

	public void setIdSoleMarca(String idSoleMarca) {
		this.idSoleMarca = idSoleMarca;
	}




}
