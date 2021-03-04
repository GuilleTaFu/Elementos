package rubros;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;

import conexiones.ConexionServFumaca;

public class CajaDeTexto {

	public JList lstRubro,lstSubRubro;
	public JTextField txtRubro,txtSubRubro;
	public DefaultListModel modelRubro,modelSubrubro;
	private Connection conn;

	public CajaDeTexto() {
		
		modelRubro= new DefaultListModel();
		lstRubro=new JList(modelRubro) ;
		lstRubro.setBounds(30, 120, 200, 300);
		lstRubro.setForeground(new Color(107,109,109));
		lstRubro.setFont(new Font("Adobe Hebrew", Font.PLAIN , 15));
		lstRubro.addMouseListener(new MouseListener(){
			
			@Override
			public void mouseClicked(MouseEvent e) {
				buscaSub(lstRubro.getSelectedValue().toString());				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		lstRubro.addKeyListener(new KeyListener(){
            public void keyTyped(KeyEvent e){
                //Aqui no funcionara
            }
            public void keyPressed(KeyEvent e){
            		
   

            }
			@Override
			public void keyReleased(KeyEvent e) {
				buscaSub(lstRubro.getSelectedValue().toString());
				
			}
		});
	
		
		modelSubrubro=new DefaultListModel();
		lstSubRubro=new JList(modelSubrubro) ;
		lstSubRubro.setBounds(300, 120, 200, 300);
		lstSubRubro.setForeground(new Color(107,109,109));
		lstSubRubro.setFont(new Font("Adobe Hebrew", Font.PLAIN , 15));

		
		txtRubro=new JTextField();
		txtRubro.setBounds(30, 450, 200, 30);
		txtRubro.setForeground(new Color(107,109,109));
		txtRubro.setFont(new Font("Adobe Hebrew", Font.PLAIN , 15));
		txtRubro.setEnabled(false);
			
	}

	public  void buscaSub(String rubro) {
		String [] sub = null;
		modelSubrubro.clear();
		ConexionServFumaca SQL = new ConexionServFumaca();
		int a=0;
		conn = SQL.conectar();
		String sSQL =   "";
		
		try{	
	
			sSQL = "SELECT subrubro FROM rubros where rubro= '"+rubro+"'";

			PreparedStatement ps=conn.prepareStatement(sSQL);
			ResultSet rs=ps.executeQuery(); 
			
			rs.last();
			sub=new String [rs.getRow()];
			rs.beforeFirst();
					
			while (rs.next()){
				modelSubrubro.addElement(rs.getString("subrubro"));
				a++;
			}

			
			ConexionServFumaca.cerrar();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}


	

}
	

