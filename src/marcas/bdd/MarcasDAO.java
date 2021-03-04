package marcas.bdd;

import marcas.Marca;

public interface MarcasDAO {
	
    void crearMarca(Marca marca) throws ExceipcionDeMarca;
    void borrarMarca(Marca marca) throws ExceipcionDeMarca;
    void cambiarDatosDeMarca(Marca marca) throws ExceipcionDeMarca;
    Marca getMarca(String dni) throws ExceipcionDeMarca;
    Marca[] obtenerTodasLasMarcas() throws ExceipcionDeMarca;
    public boolean existeDni(String dni);

}