package varios;

public class Unidades {
	private String idUnidad;
	private String Unidad;
	
	public Unidades(String idUnidad) {

		setIdUnidad("ID") ;
		setUnidad("UNIDAD");
	}
	public String getIdUnidad() {
		return idUnidad;
	}
	public String getUnidad() {
		return Unidad;
	}
	public void setIdUnidad(String idUnidad) {
		this.idUnidad = idUnidad;
	}
	public void setUnidad(String unidad) {
		Unidad = unidad;
	}
	
}
