package impoSole;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFCell;

import Tipos.articulos.Articulo;
import marcas.Marca;
import marcas.bdd.ImpleMarcasDAO;
import rubros.Rubro;
import varios.ManejoFecha;
import varios.Unidades;


public class impoArticulo {
	Articulo articulo;
	ImpleMarcasDAO marcasDAO;
	Marca marca=new Marca();
	private XSSFSheet hojas;
	
	private String impoidArticulo;
	private String impoDescripcion;
	private int impoIDMarca;
	private String impoMarca;
	
	private String impoCodBarra;
	private Double impoPeso;
	private String impoUbicacion;
	//private Unidades impoUnidad;
	private int impoStockAct;
	private int impoStockMin;
	//private Date impoFechUltRemito;
	//private Date impoFechUltFactura;
	private String strFechaTemp;
	private Long longFechaTemp;
	private Date impoFechModiFicha;
	private int impoMultVenta;
	private int impoMultCompra;
	private String impoIdRubro;

	private Double impoTasaIVA;

	private Double impoComiVentaAbs; 
	private Double impoComiCobraAbs; 
	private Double impoComiVentaRel; 
	private Double impoComiCobraRel;
	private String impoUsModiFicha;
	
	public impoArticulo(XSSFSheet hoja) {
		this.hojas=hoja;
		try {
			leerHoja();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void leerHoja() throws Exception {
		
		articulo=new Articulo();
		marcasDAO=new ImpleMarcasDAO();
		Marca[] todas=marcasDAO.obtenerTodasLasMarcas();
	
        int rows = hojas.getLastRowNum();
        
        for (int i = 1; i < rows; ++i) {
           
        	XSSFRow row = hojas.getRow(i);

        	impoidArticulo=row.getCell(0).getStringCellValue();
        	impoDescripcion=row.getCell(1).getStringCellValue();
        	
            /// FALTA SUBIR EL PRECIO
        	
        	
            String idMarcaSole=row.getCell(7).getStringCellValue();
            for(int intMarca=0;intMarca<todas.length;intMarca++) {
            	
            	if(idMarcaSole.equals(todas[intMarca].getIdSoleMarca())) {
            		impoIDMarca=todas[intMarca].getIdMarca();
            		impoMarca=todas[intMarca].getMarca();
            		break;
            	}
            	
            }
            
            impoCodBarra=row.getCell(40).getStringCellValue();
        	impoPeso=row.getCell(41).getNumericCellValue();
        	impoUbicacion=row.getCell(57).getStringCellValue();
        	impoStockAct=(int) row.getCell(16).getNumericCellValue();
        	impoStockMin=(int) row.getCell(39).getNumericCellValue();
        	//System.out.println(row.getCell(55).getCellType().toString());
        	
        	
        		if(row.getCell(55).getCellType().toString().equals("NUMERIC")) {
        	        		
        	        		
        			LocalDateTime fecha=row.getCell(55).getLocalDateTimeCellValue();
        	        	     
        			
        			impoFechModiFicha=formFecha(fecha);
        			
        			System.out.println(impoFechModiFicha);
        	        	     

        	        	        	        		
        	        		//SimpleDateFormat formFecha=new SimpleDateFormat("dd/MM/yyyy");  
        	        		
        	        		
        	        		
        	        		//longFechaTemp=(long) row.getCell(55).getNumericCellValue();
        	        		
        	        		//impoFechModiFicha= new Date(longFechaTemp* 1_000L);
        	        	//	System.out.println(impoFechModiFicha);
        	        		//ManejoFecha.convertirAlReves(strFechaTemp);              	  	

                    	  	//impoFechModiFicha=formFecha.parse(impoFechModiFicha);
                    	  	
        	        
        	       // 	}else {
        	        //		impoFechModiFicha=null;
        	        	}
        	
    	
  
        	 
            //BigDecimal price = new BigDecimal(priceCell.getNumericCellValue()).setScale(2, BigDecimal.ROUND_HALF_DOWN);

            System.out.println(impoidArticulo+  " " + impoDescripcion + " "+ impoIDMarca+ " "+ impoMarca
            		+ " "+impoCodBarra + " "+impoPeso+ " "+impoUbicacion+ " "+impoStockAct+ " "+impoStockMin
            		+ " "+impoFechModiFicha);
        }
	}
}
