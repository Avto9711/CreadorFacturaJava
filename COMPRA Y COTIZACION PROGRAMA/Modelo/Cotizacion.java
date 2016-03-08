package Modelo;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Cotizacion implements Serializable{
	@Id
	private long numeroCotizacion;
	private String nombreClienteCotizacion;
	private String  rncCotizacion;
	private String ciudadCotizacion;
	private  String fechaCotizacion;
	
	private double valorbruto;
	private double descuento;
	private int impuestos;
	private double valorneto;
	
	public Cotizacion(String nombreClienteCotizacion, String rncCotizacion, String ciudadCotizacion, String fechaCotizacion,long numeroCotizacion, double valorbruto, double descuento, int impuestos, double valorneto){
		
		this.numeroCotizacion = numeroCotizacion;
		this.nombreClienteCotizacion = nombreClienteCotizacion;
		this.rncCotizacion = rncCotizacion;
		this.ciudadCotizacion = ciudadCotizacion;
		this.fechaCotizacion = fechaCotizacion;
		this.valorbruto = valorbruto;
		this.descuento = descuento;
		this.impuestos = impuestos;
		this.valorneto = valorneto;
		
	}
	
	public Cotizacion(long numeroCotizacion){
		this.numeroCotizacion = numeroCotizacion;
	}
	
	
	public Cotizacion(){
		
	}
	
	public void setNumeroCotizacion(long numeroCotizacion){
		this.numeroCotizacion =numeroCotizacion;
	}
	
	public long getNumeroCotizacion(){
		return this.numeroCotizacion;
	}
	
	public void setNombreClienteCotizacion(String nombreClienteCotizacion){
		this.nombreClienteCotizacion = nombreClienteCotizacion;
	}
	
	public String getNombreClienteCotizacion(){
		return this.nombreClienteCotizacion;
	}
	
	public void setRncCotizacion(String rncCotizacion){
		this.rncCotizacion = rncCotizacion;
	}
	
	public String getRncCotizacion(){
		return this.rncCotizacion;
	}
	
	public void setCiudadCotizacion(String ciudadCotizacion){
		this.ciudadCotizacion = ciudadCotizacion;
	}
	
	public String getCiudadCotizacion(){
		return this.ciudadCotizacion;
	}
	
	public void setFechaCotizacion(String fechaCotizacion){
		this.fechaCotizacion = fechaCotizacion;
	}
	
	public String getFechaCotizacion(){
		return this.fechaCotizacion;
	}
	
	public void setValorBruto(double valorbruto){
	this.valorbruto = valorbruto;
	}
	
	public double getValorBruto(){
		return this.valorbruto;
	}
	
	public void setDescuento(double descuento){
		this.descuento = descuento;
	}
	
	public double getDescuento(){
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
	
}