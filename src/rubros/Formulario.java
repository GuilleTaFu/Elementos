package rubros;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import botones.*;

public class Formulario extends JFrame{
	private JFrame ventana;
	private Connection conn;
	
	Etiquetas eti;
	CajaDeTexto txt;
	btnEstandar btnSTD;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	/// SE FIJA AL 70% DEL TAMAÑO DE LA PANTALLA
	final int ANCHO_CUADRO= (int) ( screenSize.width*.3);
	final int ALTO_CUADRO=(int) ( screenSize.height*.7);
	final int X_INICIAL=(int) (screenSize.width/2-ANCHO_CUADRO/2);
	final int Y_INICIAL=(int) (screenSize.height/2-ALTO_CUADRO/2);
	
	public Formulario(String [] arrRubro) {

		eti=new Etiquetas();
		txt=new CajaDeTexto();
		btnSTD=new btnEstandar();
		
		ventana=new JFrame();
		ventana.setLayout(null);

		ventana.getContentPane();
		Image icono = new ImageIcon("src\\Imagenes\\ejecutivo_1_16x16.png").getImage();
		
		ventana.setIconImage(icono);
		ventana.setBounds(X_INICIAL,Y_INICIAL,ANCHO_CUADRO,ALTO_CUADRO );	
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setTitle("Rubro y Subrubro");
		ventana.getContentPane().setBackground(new Color(240,246,246));
			
		ventana.add(eti.lblTitulo);
		ventana.add(eti.lblTituloRubro);
		ventana.add(eti.lblTituloSubRubro);
		ventana.add(txt.lstRubro);
		ventana.add(txt.lstSubRubro);
		//ventana.add(txt.txtRubro);
		
		btnSTD.btnSalir.setBounds(420, 600, 100, 90);
		ventana.add(btnSTD.btnSalir);
		
		ventana.setVisible(true);

		for(int a=0;a<arrRubro.length;a++) {
			txt.modelRubro.addElement(arrRubro[a]);
			
		}
	}
	




}
