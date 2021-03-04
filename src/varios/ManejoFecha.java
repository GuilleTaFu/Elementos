package varios;


/**
 *Equivalencias de otras unidades de tiempo en milisegundos
	Un centisegundo equivale a 10 milisegundos
	Un decisegundo equivale a 100 milisegundos
	Un segundo equivale a 1000 milisegundos
	Un minuto equivale a 60 000 milisegundos
	Una hora equivale a 3 600 000 milisegundos
	Un día equivale a 86 400 000 milisegundos  ******
	Una semana equivale a 604 800 000 milisegundos
	Un mes equivale a 2 628 000 000 milisegundos
	Un año equivale a 31 536 000 000 milisegundos
	Un lustro equivale a 157 680 000 000 milisegundos
	Una década equivale a 315 360 000 000 milisegundos
	Un siglo equivale a 3 153 600 000 000 milisegundos
	Un milenio equivale a 31 536 000 000 000 milisegundos
 * 
 * */
 

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class ManejoFecha {
	private String fecha;
	private Calendar fechaHoy;
	private int diaHoy;
	private int mesNumeroHoy;
	private int mesHoy;
	private int anioHoy;

	private int dia;
	private int mesNumero;
	private int mes;
	private int anio;

	public ManejoFecha() {  // Recibe formaro AAAA/MM/DD
		if(fecha==null) {
			fechaHoy();
			setAnio(getAnioHoy());
			setMes(getMesHoy());
			setDia(getDiaHoy());
		}else {
			try {
				
				setAnio(Integer.parseInt(fecha.substring(0, 4)));
				setMes(Integer.parseInt(fecha.substring(5, 7)));
				setDia(Integer.parseInt(fecha.substring(8, 10)));
				fechaHoy();
			}catch(Exception e) {
				System.out.println("El formato de la fecha debe ser YYYY/MM/DD Ejemplo: 1810/05/25");
			}
		}
	}
	
	public int difEnDias(String Fecha1,String Fecha2) { //Formato del String AAAA/MM/DD
	java.util.Date dinicio = null;
    java.util.Date dfinal = null;

    long milis1, milis2, diff;

    SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");

    try {
            dinicio = sdf.parse(Fecha1);
            dfinal = sdf.parse(Fecha2);                    
           
    } catch (ParseException e) {

            System.out.println("Se ha producido un error en el parseo");
    }
    
    Calendar cinicio = Calendar.getInstance();
    Calendar cfinal = Calendar.getInstance();
    
    cinicio.setTime(dinicio);
    cfinal.setTime(dfinal);
    
    milis1 = cinicio.getTimeInMillis();
    
    milis2 = cfinal.getTimeInMillis();

    diff = milis2-milis1;
    long diffdias = Math.abs ( diff / (24 * 60 * 60 * 1000) );

    return (int)diffdias;
		
	}
	
	public int difEnDiasDesdeHoy(String Fecha1){
		
		java.util.Date dinicio = null;
	    java.util.Date dfinal = null;

	    
	    long milis1, milis2, diff;

	    SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");

	    try {
	            dinicio = sdf.parse(Fecha1);
	            dfinal = sdf.parse(getAnioHoy()+"-"+getMesHoy()+"-"+getDiaHoy());   

	           
	    } catch (ParseException e) {

	            System.out.println("Se ha producido un error en el parseo");
	    }
	    
	    Calendar cinicio = Calendar.getInstance();
	    Calendar cfinal = Calendar.getInstance();
	    
	    cinicio.setTime(dinicio);
	    cfinal.setTime(dfinal);
	    
	    milis1 = cinicio.getTimeInMillis();
	    
	    milis2 = cfinal.getTimeInMillis();

	    diff = milis2-milis1;
	    long diffdias = Math.abs ( diff / (24 * 60 * 60 * 1000) );

		
		
		  return (int)diffdias;
	}
	public static String convertirAlReves(String fecha) { // Recibe fecha DD/MM/AAAA y devuelve AAAA/MM/DD
		String convertido=fecha.substring(6, 10).concat("-").concat(fecha.substring(3, 5).concat("-").concat(fecha.substring(0,2)));
		
		return convertido;
	}
	
	private void fechaHoy() {
	 
		fechaHoy=Calendar.getInstance();
		
		setAnioHoy(fechaHoy.get(Calendar.YEAR));
		setMesHoy(fechaHoy.get(Calendar.MONTH));
		setDiaHoy(fechaHoy.get(Calendar.DAY_OF_MONTH));
		
	}
	
	public int getDia() {
		return dia;
	}

	public int getMesNumero() {
		return mesNumero;
	}

	public int getMes() {
		return mes;
	}

	public int getAnio() {
		return anio;
	}
	private void setFechaHoy(Calendar fechaHoy) {
		this.fechaHoy = fechaHoy;
	}

	private void setDiaHoy(int diaHoy) {
		this.diaHoy = diaHoy;
	}

	private void setMesHoy(int mesHoy) {
		this.mesHoy = mesHoy+1;
	}

	private void setAnioHoy(int anioHoy) {
		this.anioHoy = anioHoy;
	}

	private void setDia(int dia) {
		this.dia = dia;
	}

	private void setMesNumero(int mesNumero) {
		this.mesNumero = mesNumero;
	}

	private void setMes(int mes) {
		this.mes = mes;
	}

	private void setAnio(int anio) {
		this.anio = anio;
	}

	public Calendar getFechaHoy() {
		return fechaHoy;
	}

	public int getDiaHoy() {
		return diaHoy;
	}

	public int getMesHoy() {
		return mesHoy;
	}

	public int getAnioHoy() {
		return anioHoy;
	}


}
