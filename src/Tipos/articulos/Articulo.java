package Tipos.articulos;

import marcas.Marca;
import rubros.Rubro;

import java.util.Date;

import varios.Unidades;

/**
 * @author gcardillo
 * @version 1.0
 * @created 18-nov.-2020 09:10:19
 * SE ENTIENDE POR ARTICULO AL PRODUCTO FINAL LISTO PARA LA VENTA
 */

/// *** LISTAS DE PRECIOS. SE CREA UNA TABLA CON 

public class Articulo  {
	
	private Boolean activo;
	private String idArticulo;
	private String descripcion;
	private String codBarra;
	private Double peso;
	private String ubicacion;
	private Unidades unidad;
	private int stockAct;
	private int stockMin;
	private Date fechUltRemito;
	private Date fechUltFactura;
	private Date fechModiFicha;
	private int multVenta;
	private int multCompra;
	private Rubro rubro;
	private Marca marca;
	private Double tasaIVA;
	/** LAS COMISIONES SON PROPORCIONALES A LAS QUE TENGA EL VENDEDOR. 
	 * SI EL VENDEDOR TIENE 5% Y ACÁ DICE 0,5. ENTONCES SERÁ 2,5%
	 */
	private Double comiVentaAbs; 
	private Double comiCobraAbs; 
	private Double comiVentaRel; 
	private Double comiCobraRel;
	private String usModiFicha;
	
	
	public Articulo(){

	}


	public Boolean getActivo() {
		return activo;
	}


	public String getIdArticulo() {
		return idArticulo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public String getCodBarra() {
		return codBarra;
	}


	public Double getPeso() {
		return peso;
	}


	public String getUbicacion() {
		return ubicacion;
	}


	public Unidades getUnidad() {
		return unidad;
	}


	public int getStockAct() {
		return stockAct;
	}


	public int getStockMin() {
		return stockMin;
	}


	public Date getFechUltRemito() {
		return fechUltRemito;
	}


	public Date getFechUltFactura() {
		return fechUltFactura;
	}


	public Date getFechModiFicha() {
		return fechModiFicha;
	}


	public int getMultVenta() {
		return multVenta;
	}


	public int getMultCompra() {
		return multCompra;
	}


	public Rubro getRubro() {
		return rubro;
	}


	public Marca getMarca() {
		return marca;
	}


	public Double getTasaIVA() {
		return tasaIVA;
	}


	public Double getComiVentaAbs() {
		return comiVentaAbs;
	}


	public Double getComiCobraAbs() {
		return comiCobraAbs;
	}


	public Double getComiVentaRel() {
		return comiVentaRel;
	}


	public Double getComiCobraRel() {
		return comiCobraRel;
	}


	public String getUsModiFicha() {
		return usModiFicha;
	}


	public void setActivo(Boolean activo) {
		this.activo = activo;
	}


	public void setIdArticulo(String idArticulo) {
		this.idArticulo = idArticulo;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public void setCodBarra(String codBarra) {
		this.codBarra = codBarra;
	}


	public void setPeso(Double peso) {
		this.peso = peso;
	}


	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}


	public void setUnidad(Unidades unidad) {
		this.unidad = unidad;
	}


	public void setStockAct(int stockAct) {
		this.stockAct = stockAct;
	}


	public void setStockMin(int stockMin) {
		this.stockMin = stockMin;
	}


	public void setFechUltRemito(Date fechUltRemito) {
		this.fechUltRemito = fechUltRemito;
	}


	public void setFechUltFactura(Date fechUltFactura) {
		this.fechUltFactura = fechUltFactura;
	}


	public void setFechModiFicha(Date fechModiFicha) {
		this.fechModiFicha = fechModiFicha;
	}


	public void setMultVenta(int multVenta) {
		this.multVenta = multVenta;
	}


	public void setMultCompra(int multCompra) {
		this.multCompra = multCompra;
	}


	public void setRubro(Rubro rubro) {
		this.rubro = rubro;
	}


	public void setMarca(Marca marca) {
		this.marca = marca;
	}


	public void setTasaIVA(Double tasaIVA) {
		this.tasaIVA = tasaIVA;
	}


	public void setComiVentaAbs(Double comiVentaAbs) {
		this.comiVentaAbs = comiVentaAbs;
	}


	public void setComiCobraAbs(Double comiCobraAbs) {
		this.comiCobraAbs = comiCobraAbs;
	}


	public void setComiVentaRel(Double comiVentaRel) {
		this.comiVentaRel = comiVentaRel;
	}


	public void setComiCobraRel(Double comiCobraRel) {
		this.comiCobraRel = comiCobraRel;
	}


	public void setUsModiFicha(String usModiFicha) {
		this.usModiFicha = usModiFicha;
	}



	
}//end Articulo