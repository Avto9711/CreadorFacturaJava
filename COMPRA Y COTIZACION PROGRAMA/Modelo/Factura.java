package Modelo;

import javax.persistence.Entity; //Me dice que la clase que yo marque como entity sera una tabla en la bd
import javax.persistence.Table; // Me permite dar un nombre a la tabla(es decir a la clase que yo maque como entity )
import javax.persistence.Id;// Estableces la notacion identificador unico (ID)
import javax.persistence.GeneratedValue; //Establecer un valor generado mediante una estrategia
import javax.persistence.GenerationType; //Establecer estrategia para generar un valor, mas bien un tquienGuardoo de estrategia4
import javax.persistence.Column;//Me permite asignar un nombre a un atributo que hace referencia al campo en la BD
import java.io.Serializable;


@Entity
public class Factura implements Serializable{
	
	@Id
	private long numeroFactura;
	private String nombreCliente;
	private String RNC;
	private String ciudad;
	private String fechaCompra;
	private String metodoCompra;
	
	private double valorbruto;
	private int descuento;
	private int impuestos;
	private double valorneto;
	
	 
	 //Uno a muchos 
	 // @OneToMany(mappedBy = "factura")
	 // private List<Producto> productos;

	public Factura(long numeroFactura,String nombreCliente,String RNC, String ciudad,String fechaCompra, String metodoCompra,int descuento, double valorbruto, double valorneto, int impuestos){
		
		 this.numeroFactura = numeroFactura;
		 this.nombreCliente = nombreCliente;
		 this.RNC =           RNC;
		 this.ciudad =       ciudad;
		 this.fechaCompra =  fechaCompra;
		 this.metodoCompra = metodoCompra;
		 this.descuento =    descuento;
		 this.valorbruto  = valorbruto;
		 this.valorneto = valorneto;
		 this.impuestos = impuestos;
		
		
	}
	

	
	public Factura(long numeroFactura){
		this.numeroFactura = numeroFactura;
		
	}
	
	public Factura(){
		
	}
	
	public void setNumeroFactura(long numeroFactura){
		this.numeroFactura = numeroFactura;
	}
	
	public long getNumeroFactura(){
		return this.numeroFactura;
	}
	
	public void setNombreCliente(String nombreCliente){
		this.nombreCliente = nombreCliente;
	}
	
	public String getNombreCliente(){
		return this.nombreCliente;
	}
	
	
	public void setRnc(String RNC){
		this.RNC = RNC;
	}
	
	public String getRnc(){
		return this.RNC;
	}
	
	public void setCiudad(String ciudad){
		this.ciudad = ciudad;
	}
	
	public String getCiudad(){
		return this.ciudad;
	}
	
	public void setFechaCompra(String fechaCompra){
		this.fechaCompra  = fechaCompra;
		}
		
	public String getFechaCompra(){
			return this.fechaCompra;
		}

	public void setMetodoCompra(String metodoCompra){
		this.metodoCompra = metodoCompra;
	}
	
	public String getMetodoCompra(){
			return metodoCompra;
		}
		
	public void setValorBruto(double valorbruto){
		this.valorbruto = valorbruto;
	}
	
	public double getValorBruto(){
		return this.valorbruto;
	}
	
	public void setDescuento(int descuento){
		this.descuento = descuento;
	}
	
	public int getDescuento(){
		return this.descuento;
	}
	
	public void setImpuestos(int impuestos){
		this.impuestos = impuestos;
	}
	public int getImpuestos(){
		return this.impuestos;
	}
	
	public void setValorNeto(double valorneto){
		this.valorneto = valorneto;
	}
	
	public double getValorNeto(){
		return this.valorneto;
	}
	
	// public void setProducto( List<Producto> productos){
		// this.productos = productos;
	// }
	
	// public List<Producto> getProductos(){
		// return this.productos;
	// }
}