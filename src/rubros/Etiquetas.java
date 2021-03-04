package rubros;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class Etiquetas {
	public JLabel lblTitulo,lblTituloRubro,lblTituloSubRubro;
	
	public Etiquetas() {
		
		lblTitulo=new JLabel("Rubros y Subrubros");
		lblTitulo.setBounds(10, 15, 300, 40);
		lblTitulo.setForeground(new Color(137,212,236));
		lblTitulo.setFont(new Font("Adobe Hebrew", Font.BOLD , 25));
		
		lblTituloRubro=new JLabel("Rubros");
		lblTituloRubro.setBounds(30, 80, 300, 40);
		lblTituloRubro.setForeground(new Color(153,158,159));
		lblTituloRubro.setFont(new Font("Adobe Hebrew", Font.PLAIN , 20));
		
		lblTituloSubRubro=new JLabel("Subrubros");
		lblTituloSubRubro.setBounds(300, 80, 300, 40);
		lblTituloSubRubro.setForeground(new Color(153,158,159));
		lblTituloSubRubro.setFont(new Font("Adobe Hebrew", Font.PLAIN , 20));
		
		
		
		
	}
	
}
