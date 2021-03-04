package impoSole;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//C:\Program Files (x86)\Microsoft Office\Office14\excelcnv.exe

/**
 * 
 * @author gcardillo
 *				Para tener en cuenta:
 *					Carpeta donde se descargan los excel
 *					Carpeta donde se guardan los archivos analizados
 *					Verificar que el archivo se pueda abrir para lectura
 *					Verificar la versión del archivo, sino es xlsx convertir
 *					Verificar si es articulo, cliente o .....
 *					
 */

public class BuscarEnDescargas {
	// Se comparan 100 Caracteres del encabezado para verificar si es el mismo.
	private final String ENCABEZADO_ARTICULO="codmatmonedalista1lista2lista3cod_rubrocod_marcacod_subrudepo1depo2depo3depo4depo5depo6cod_origcantp"; 
	private final String ENCABEZADO_CLIENTE= "codigonombredireclocalitelefonocuitzonalocali_alprovirubro_emptam_empsit_empprovinciapaistranspdesc_";
	
	private String encabezadoX100="";
 	private String strArchivo;
	private final String CARPETA_DESCARGA="Descargas\\";
	private final String CARPETA_SUBIDOS="Subidos\\";
	Extension extension=new Extension();
	
	public BuscarEnDescargas(){ //Cosntructor si NO recive nada
			File[] archivos;
			File carpeta = new File(CARPETA_DESCARGA);
			
            archivos = carpeta.listFiles();
            
            if(archivos.length>0) {
            	for(int i=0; i<archivos.length; i++) {
                  
            		if(extension.devuelveExtension(archivos[i].getName()).equals("xlsx")) {
            		    XSSFWorkbook libro = null;
            			
            			try {
            				/// VERIFICAR SI EL LIBRO ESTA ABIERTO  
							libro = new XSSFWorkbook(new FileInputStream("Descargas\\"+archivos[i].getName()));
							
							
						} catch (IOException e) {
							System.out.println("No se puede acceder al archivo en: "+"Descargas\\"+archivos[i].getName());
							System.out.println("El archivo puede estar en uso por otra aplicación");
							System.exit(0);
								//e.printStackTrace();
						}
            			
            	        XSSFSheet hoja = libro.getSheetAt(0);

            	        XSSFRow fila = hoja.getRow(0);
            	        
            	        // EXTRAE 100 CARACTERES DEL ENCABEZADO DEL LIBRO EXCEL PARA COMPARAR
            	       for(int cdc=0;cdc<fila.getLastCellNum();cdc++) {
            	    	   encabezadoX100=encabezadoX100+fila.getCell(cdc).getStringCellValue();
            	       }
            	       
            	       
            	       switch (encabezadoX100.substring(0, 100)) {
            	       	
            	       		case ENCABEZADO_ARTICULO: {
            	       					
            	       			new impoArticulo(hoja);
            	       			break;
        	       		
            	       	}
            	       	case ENCABEZADO_CLIENTE: {
            	       		System.out.println("ES CLIENTE");
            	       		break;
            	       	}
            	       	default:
            	       		System.out.println("El archivo : "+"Descargas\\"+archivos[i].getName()+" No es de ningún tipo conocido");
            	       }
         			
                  }/*else if(extension.devuelveExtension(archivos[i].getName()).equals("xls")){
                	  /// Programar si la extensión no es correcta
                	  System.out.println(archivos[i].getName());
                	  extension.verificaExtension(archivos[i].getName());
                	  
                  }*/
        			
            	}
            	
            }else {
            	System.out.println("CARPETA VACIA");
            }

	}//FIN //Cosntructor si NO recive nada
	
	public BuscarEnDescargas(String nombreFila){ //Cosntructor si recive el nombre del archivo
		
		this.strArchivo=CARPETA_DESCARGA+nombreFila;

		File nombreArchivo=new File(strArchivo);
		
		if(!nombreArchivo.canRead()) {
			System.out.println("ERROR - El archivo "+nombreArchivo+" no existe o no se puede abrir");
		}else {
			extension.verificaExtension(strArchivo);
		}
		
	}//FIN Cosntructor si recive el nombre del archivo
	
}/// FIN CLASE LeerExcel
 
class Extension {
	 
	public String devuelveExtension(String archivo) { //Extrae la extensión de un archivo
		String extension = "";

		int i = archivo.lastIndexOf('.');
		int p = Math.max(archivo.lastIndexOf('/'), archivo.lastIndexOf('\\'));

		if (i > p) {
		    extension = archivo.substring(i+1);
		}
		
		return extension;
		
	}
	
	public String verificaExtension(String nombre) {
		String nombreXLSX;

			// Convertimos el archivo xls a xlsx
			nombreXLSX=nombre.replace("xls", "xlsx");
			String cmd="excelcnv -nme -oice C:\\Users\\gcardillo.FUMACA\\Apps-Fumaca\\Elementos\\Descargas\\"+nombre+" C:\\Users\\gcardillo.FUMACA\\Apps-Fumaca\\Elementos\\Descargas\\"+nombreXLSX+"";
		
			try {
		
				Runtime.getRuntime().exec(cmd);
				File aBorrar=new File(nombre);
				aBorrar.delete();
				//	readExcel(fila);
			
			} catch (Exception e) {
			
				System.out.println("ERROR NO SE PUEDE ABRIR NI CONVERTIR EL ARCHIVO A XLSX");
				//e.printStackTrace();
		
	}
			return nombreXLSX;

	}
}