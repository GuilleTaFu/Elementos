package marcas.igu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import marcas.Marca;
import marcas.bdd.ExceipcionDeMarca;
import marcas.bdd.ImpleMarcasDAO;

public class MarcasIGU extends JFrame{
	
	private static final long serialVersionUID = 8215459426302282971L;
	JFrame ventana;

	JList<String> lstMarcas;
	JTable tblArticulos;
	JButton btnAgregar,btnModificar,btnEliminar,btnSalir,btnAceptar,btnCancelar;
	JLabel lblTitulo,lblDelPanelSecundario;
	JTextField txtMarca;
	DefaultListModel<String> modelo; 
	ImpleMarcasDAO impleMarcaDAO;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	JPanel panIngresa,panModifica;
	Marca marca;

	/// SE FIJA AL 70% DEL TAMAÑO DE LA PANTALLA
	final int ANCHO_CUADRO= (int) ( screenSize.width*.3);
	final int ALTO_CUADRO=(int) ( screenSize.height*.7);
	final int X_INICIAL=(int) (screenSize.width/2-ANCHO_CUADRO/2);
	final int Y_INICIAL=(int) (screenSize.height/2-ALTO_CUADRO/2);
	final String UBICACION="C:\\Users\\gcardillo.FUMACA\\Apps-Fumaca\\Elementos\\src";
	
    public MarcasIGU(Marca marca) {
    	
    	this.marca=marca;
    	impleMarcaDAO=new ImpleMarcasDAO();
    	
        initComponents();
        initLista();       
     
    }

	private void initLista() {
    	
    	modelo= new DefaultListModel<String>();
    	lstMarcas = new JList<String>(modelo);
    	
    	JScrollPane scroll = new JScrollPane(lstMarcas);
    	scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    	scroll.setBounds(35, 70, 200, 210);
    	lstMarcas.setBackground(new Color(203,243,254));
    	lstMarcas.setBorder(new BevelBorder(BevelBorder.LOWERED));
    	
    	lstMarcas.addKeyListener(new KeyAdapter(){
    		public void keyReleased(KeyEvent e){
    		    if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_UP){
    		    	
    		    	clickLista(lstMarcas.getSelectedValue());  
    		    	
    		    }
    		}
    	});
    	
    	lstMarcas.addMouseListener(new MouseAdapter() {
    		 public void mouseClicked(MouseEvent e) {
    			 clickLista(lstMarcas.getSelectedValue());   

    		 }
    	});
    	
    	try {
    		
    	for (int i = 0; i < impleMarcaDAO.obtenerTodasLasMarcas().length; i++)
    		{
    		
    	    	modelo.addElement(impleMarcaDAO.obtenerTodasLasMarcas()[i].getMarca());
    		}
    		impleMarcaDAO.obtenerTodasLasMarcas();
    	}catch (Exception e) {
    		
    	}
   	
   	ventana.add(scroll);

		
	}

	private void initComponents() {
    	
    	lblTitulo = new javax.swing.JLabel();
		lblTitulo=new JLabel("Marcas");
		lblTitulo.setBounds(10, 15, 300, 40);
		lblTitulo.setForeground(new Color(137,212,236));
		lblTitulo.setFont(new Font("Adobe Hebrew", Font.BOLD , 25));
		    	
    	btnSalir= new javax.swing.JButton();
    	Image iconoSalir = new ImageIcon(UBICACION+"\\Imagenes\\exit_1.png").getImage();
		btnSalir.setBounds(460, 600, 90,90);	
		btnSalir.setHorizontalTextPosition( SwingConstants.CENTER );
		btnSalir.setVerticalTextPosition( SwingConstants.BOTTOM );
    	btnSalir.setText("Salir");
    	btnSalir.setToolTipText("Se cierra "+lblTitulo.getText());
    	btnSalir.setIcon(new ImageIcon(iconoSalir));
    	
    	btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.exit(0);
            }
        });

    	btnAgregar = new javax.swing.JButton();
       	Image iconoAgregar = new ImageIcon(UBICACION+"\\Imagenes\\add.png").getImage();
       	btnAgregar.setBounds(40, 300, 35,35);	
       	btnAgregar.setHorizontalTextPosition( SwingConstants.CENTER );
       	btnAgregar.setVerticalTextPosition( SwingConstants.BOTTOM );
       	btnAgregar.setIcon(new ImageIcon(iconoAgregar));
       	btnAgregar.setToolTipText("Ingresa un nuevo item");
    	
    	btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarActionPerformed(evt);
            }

        });
    	
    	btnModificar = new javax.swing.JButton();
      	Image iconoModificar = new ImageIcon(UBICACION+"\\Imagenes\\edit_page.png").getImage();
      	btnModificar.setBounds(100, 300, 35,35);	
      	btnModificar.setHorizontalTextPosition( SwingConstants.CENTER );
      	btnModificar.setVerticalTextPosition( SwingConstants.BOTTOM );
      	btnModificar.setIcon(new ImageIcon(iconoModificar));
       	btnModificar.setToolTipText("Modificar los datos del item seleccionado");
    	btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                btActualizarActionPerformed(evt);

            }

        });
    	
    	btnEliminar = new javax.swing.JButton();
     	Image iconoEliminar = new ImageIcon(UBICACION+"\\Imagenes\\trash_can.png").getImage();
     	btnEliminar.setBounds(160, 300, 35,35);	
     	btnEliminar.setHorizontalTextPosition( SwingConstants.CENTER );
     	btnEliminar.setVerticalTextPosition( SwingConstants.BOTTOM );
     	btnEliminar.setIcon(new ImageIcon(iconoEliminar));
     	btnEliminar.setToolTipText("Elimina esta marca y todos los articulos que la contienen se modifican a SIN MARCA");
    	btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBorrarActionPerformed(evt);
            }
        });
    	
		ventana=new JFrame();
		ventana.setLayout(null);
		ventana.setBounds(X_INICIAL,Y_INICIAL,ANCHO_CUADRO,ALTO_CUADRO );	
		ventana.setResizable(false);
		ventana.setDefaultCloseOperation(0);
		ventana.setTitle("Marcas");
		ventana.getContentPane().setBackground(new Color(240,246,246));
		ventana.add(lblTitulo);
		ventana.add(btnAgregar);
		ventana.add(btnModificar);
		ventana.add(btnEliminar);
		ventana.add(btnSalir);
		ventana.setVisible(true);

    }
	
    private void initPaneIngresa() {
    	desactivar();
    	panIngresa=new JPanel();
    	panIngresa.setLayout(null);
    	panIngresa.setBackground(Color.white);
    	panIngresa.setBounds(250, 70, 290, 210);
    	panIngresa.setBackground(new Color(203,243,254));
    	panIngresa.setBorder(new BevelBorder(BevelBorder.LOWERED));
    	panIngresa.setVisible(false);	
    	
    	lblDelPanelSecundario=new javax.swing.JLabel();
    	lblDelPanelSecundario.setBounds(10, 30, 60,35);
    	lblDelPanelSecundario.setFont(new Font("Adobe Hebrew", Font.BOLD , 15));
    	lblDelPanelSecundario.setText("Marca: ");
    	
    	txtMarca=new javax.swing.JTextField();
    	txtMarca.setBounds(80, 30, 120,35);
    	txtMarca.setFont(new Font("Adobe Hebrew", Font.BOLD , 15));
    	
    	
    	btnAceptar= new javax.swing.JButton();
     	Image iconoAceptar = new ImageIcon(UBICACION+"\\Imagenes\\accept.png").getImage();
     	btnAceptar.setBounds(50, 160, 60,35);	
     	btnAceptar.setHorizontalTextPosition( SwingConstants.CENTER );
     	btnAceptar.setVerticalTextPosition( SwingConstants.BOTTOM );
     	btnAceptar.setIcon(new ImageIcon(iconoAceptar));
     	btnAceptar.setToolTipText("Se guardará el item nuevo");
     	btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBorrarActionPerformed(evt);
            }
        });
     	
     	btnCancelar= new javax.swing.JButton();
     	Image iconoCancelar = new ImageIcon(UBICACION+"\\Imagenes\\delete.png").getImage();
     	btnCancelar.setBounds(160, 160, 60,35);	
     	btnCancelar.setHorizontalTextPosition( SwingConstants.CENTER );
     	btnCancelar.setVerticalTextPosition( SwingConstants.BOTTOM );
     	btnCancelar.setIcon(new ImageIcon(iconoCancelar));
     	btnCancelar.setToolTipText("Se guardará el item nuevo");
     	btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
        		panIngresa.setVisible(false);
                activar();
            }
        });
     	   	
     	panIngresa.add(lblDelPanelSecundario);
     	panIngresa.add(txtMarca);
     	panIngresa.add(btnCancelar);
     	panIngresa.add(btnAceptar);
    	ventana.add(panIngresa);
	}
    private void initPaneModifica(String marca) {
    	desactivar();
    	panModifica=new JPanel();
    	panModifica.setLayout(null);
    	panModifica.setBackground(Color.white);
    	panModifica.setBounds(250, 70, 290, 210);
    	panModifica.setBackground(new Color(203,243,254));
    	panModifica.setBorder(new BevelBorder(BevelBorder.LOWERED));
    	panModifica.setVisible(false);	
    	
    	lblDelPanelSecundario=new javax.swing.JLabel();
    	lblDelPanelSecundario.setBounds(10, 30, 60,35);
    	lblDelPanelSecundario.setFont(new Font("Adobe Hebrew", Font.BOLD , 15));
    	lblDelPanelSecundario.setText("Marca: ");
    	
    	txtMarca=new javax.swing.JTextField();
    	txtMarca.setText(marca);
    	txtMarca.setBounds(80, 30, 120,35);
    	txtMarca.setFont(new Font("Adobe Hebrew", Font.BOLD , 15));
    	
    	
    	btnAceptar= new javax.swing.JButton();
     	Image iconoAceptar = new ImageIcon(UBICACION+"\\Imagenes\\accept.png").getImage();
     	btnAceptar.setBounds(50, 160, 60,35);	
     	btnAceptar.setHorizontalTextPosition( SwingConstants.CENTER );
     	btnAceptar.setVerticalTextPosition( SwingConstants.BOTTOM );
     	btnAceptar.setIcon(new ImageIcon(iconoAceptar));
     	btnAceptar.setToolTipText("Se guardará el item nuevo");
     	btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAceptaModificar(evt);
            }
        });
     	
     	btnCancelar= new javax.swing.JButton();
     	Image iconoCancelar = new ImageIcon(UBICACION+"\\Imagenes\\delete.png").getImage();
     	btnCancelar.setBounds(160, 160, 60,35);	
     	btnCancelar.setHorizontalTextPosition( SwingConstants.CENTER );
     	btnCancelar.setVerticalTextPosition( SwingConstants.BOTTOM );
     	btnCancelar.setIcon(new ImageIcon(iconoCancelar));
     	btnCancelar.setToolTipText("Se guardará el item nuevo");
     	btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
        		panModifica.setVisible(false);
                activar();
            }
        });
     	   	
     	panModifica.add(lblDelPanelSecundario);
     	panModifica.add(txtMarca);
     	panModifica.add(btnCancelar);
     	panModifica.add(btnAceptar);
    	ventana.add(panModifica);
	}
    
	protected void btAceptaModificar(ActionEvent evt) {
		marca.setMarca(txtMarca.getText());
		try {
			impleMarcaDAO.cambiarDatosDeMarca(marca);
		} catch (ExceipcionDeMarca e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private void desactivar() {
		btnAgregar.setEnabled(false);
		btnModificar.setEnabled(false);
		btnEliminar.setEnabled(false);
		btnSalir.setEnabled(false);
		lstMarcas.setEnabled(false);
		
	}

	private void activar() {
		btnAgregar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnEliminar.setEnabled(true);
		btnSalir.setEnabled(true);
		lstMarcas.setEnabled(true);
		
	}
	
	private void clickLista(String elemento) {
		marca.setMarca(elemento);
		
	}
	private void btActualizarActionPerformed(ActionEvent evt) {
        initPaneModifica(lstMarcas.getSelectedValue());
        panModifica.setVisible(true);
		
	}
	
	private void btAgregarActionPerformed(ActionEvent evt) {
        initPaneIngresa();
		panIngresa.setVisible(true);		
	}
	private void btBorrarActionPerformed(ActionEvent evt) {
		
	}
}
