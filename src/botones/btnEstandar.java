package botones;

import javax.swing.ImageIcon;
import javax.swing.JButton;

// BOTONES DE ABM
// BOTON DE SALIDA
// BOTON DE IMPRIMIR


public class btnEstandar {
	
	public static JButton btnSalir;
	private String imIcono="C:\\Users\\gcardillo.FUMACA\\Apps-Fumaca\\TFONLINE\\contenido\\exit_1.png";
	
	public btnEstandar() {
	
		btnSalir=new JButton("SALIR");
		
		imIcono="C:\\Users\\gcardillo.FUMACA\\Apps-Fumaca\\TFONLINE\\contenido\\exit_1.png";
		ImageIcon icono=new ImageIcon(imIcono);
		btnSalir.setIcon(icono);
		btnSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		btnSalir.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
		btnSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		btnSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
	}
}	
