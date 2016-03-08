package Modelo;

import javax.persistence.Entity; //Me dice que la clase que yo marque como entity sera una tabla en la bd
import javax.persistence.Table; // Me permite dar un nombre a la tabla(es decir a la clase que yo maque como entity )
import javax.persistence.Id;// Estableces la notacion identificador unico (ID)
import javax.persistence.GeneratedValue; //Establecer un valor generado mediante una estrategia
import javax.persistence.GenerationType; //Establecer estrategia para generar un valor, mas bien un tquienGuardoo de estrategia4
import javax.persistence.Column;//Me permite asignar un nombre a un atributo que hace referencia al campo en la BD
import java.io.Serializable;


@Entity
public class ProductoCotizacion implements Serializable{
	
	private String nombreProducto;
	@Id
	private int  codigoProducto;
	private int precioProducto;
	private int cantidadProducto;
	private long numeroCotizacion;
	
	//aplicacion aplicacion muchos a uno
	// @ManyToOne
	// private Factura factura;	
	
	// @ManyToOne
	// private Factura numeroFactura;

	
	public ProductoCotizacion(String nombreProducto,int codigoProducto,int precioProducto, int cantidadProducto,long numeroCotizacion){
		
		 this.codigoProducto =    codigoProducto;
		 this.nombreProducto = 	  nombreProducto;
		 this.precioProducto =    precioProducto;
		 this.cantidadProducto =  cantidadProducto;
		 this.numeroCotizacion = numeroCotizacion;

		
	}
	
	
	public ProductoCotizacion(int codigoProducto){
		
		this.codigoProducto = codigoProducto;
		
	}
	
	public ProductoCotizacion(){
		
	}
	
	
	public void setCodigoProducto(int codigoProducto){
		this.codigoProducto = codigoProducto;
	}
	
	public int getCodigoProducto(){
		return this.codigoProducto;
	}
	
	public void setNombreProducto(int precioProducto){
		
		this.precioProducto = precioProducto;
	}
	
	public String getNombreProducto(){	
		return this.nombreProducto;
	}
	
	public void setPrecioProducto(int precioProducto){
		this.precioProducto = precioProducto;
	}
	
	public int getPrecioProducto(){
		return this.precioProducto;
	}
	
	public void setCantidadProducto(int cantidadProducto){
		this.cantidadProducto = cantidadProducto;
	}
	
	public int getCantidadProducto(){
		return this.cantidadProducto;
	}
	
	public void setNumeroCotizacion(long numeroCotizacion){
		this.numeroCotizacion = numeroCotizacion;
	}
	
	public long getNumeroCotizacion(){
		return this.numeroCotizacion;
	}
	
	// public setFactura(Factura factura){
		// this.factura = factura;
	// }
	
	// public Factura getFactura(){
		// return this.factura;
	// }
	
	// public void setNumeroFactura(Factura numeroFactura){
			// this.numeroFactura = numeroFactura;
	// }
	
	// public Factura getNumeroFactura(){
		// return this.numeroFactura;
	// }
	
}	