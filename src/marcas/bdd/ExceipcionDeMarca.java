package marcas.bdd;

public class ExceipcionDeMarca extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8909146076004276299L;

	/**
     * Crea un nuevo objeto del tipo <code>ExcepcionVentasAClientes</code> con el mensaje de detalle de error.
     */
    public ExceipcionDeMarca() {
        this("ExceipcionDeMarca");
    }
    
    /**
     * Construye una <code>ExcepcionVentasAClientes</code> con el mensaje del detalle
     * especificado como parámetro
     * @param mensaje	Texto que detalla el error.
     */
    public ExceipcionDeMarca(String mensaje) {
        super(mensaje);
    }
}
