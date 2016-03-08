import org.hibernate.SessionFactory;//interfaz esta clase me permite crear la factoria de sesiones
import org.hibernate.Session;//interfaz me permite abrir una de las sesiones que me creo la factoria
import org.hibernate.Transaction;//interfaz me permite utilizar las propiedades de las transacciones 
import org.hibernate.cfg.Configuration; //Clase que me permite configurar mi archivo xml
import org.hibernate.*;
import javax.swing.*;
import java.util.List;
import javax.swing.table.*;

import java.lang.Double;

import java.util.Iterator;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Modelo.Factura;
import Modelo.Producto;
import Modelo.Cotizacion;
import Modelo.ProductoCotizacion;

public class BaseDatos{
	
	public Session sesion;
	public Transaction transaccion;
	
	private JTable tblProducto;
	private DefaultTableModel tablaModel;
	
	public BaseDatos(){
		
		
	}
	
	public void iniciarsesion(){
		
		try{
		sesion = HibernateUtil.getSessionFactory().openSession();
		
		transaccion = sesion.beginTransaction();
		
		}catch(HibernateException ex){
			ex.printStackTrace();
			
		}
		
	}
	
	public void manejarExcepcion(HibernateException ex) throws HibernateException {
		transaccion.rollback();
		
		throw new HibernateException("Ocurrio un error accediendo a la sesion", ex);
	}
																							
	public void guardarFactura(long numeroFactura,String nombreCliente,String rnc, String ciudad,String fechaCompra, String metodoCompra, int descuento,double valorbruto, double valorneto, int impuestos){
		try{
		iniciarsesion();
		
		Query sentencia = sesion.createQuery("select count(numeroFactura) from  Factura  where numeroFactura  ="+ numeroFactura);
		
		Iterator it = sentencia.iterate();
		int numero = Integer.valueOf(it.next().toString());
		
		
		if(numero == 0){
			
			Factura reg1 = new Factura(numeroFactura,nombreCliente, rnc,ciudad, fechaCompra, metodoCompra,descuento, valorbruto, valorneto, impuestos);
			sesion.save(reg1);
			transaccion.commit();
			JOptionPane.showMessageDialog(null, "Datos guardados correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);


		}else{
			JOptionPane.showMessageDialog(null, "Lo sentimos Existe una factura igual en la base de datos.", "Aviso", JOptionPane.WARNING_MESSAGE);
			transaccion.rollback();
			
		}

		}catch(HibernateException ex){
			manejarExcepcion(ex);
			System.out.println("Error en metodo guardar factura base de datos");
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error en metodo guardar factura base de datos");
			
		}finally{
			sesion.disconnect();
			
		}
		
	}
	
	public void guardarProducto(String nombreProducto,int codigoProducto,int precioProducto, int cantidadProducto,long numeroFactura ){
		try{
		iniciarsesion();
		
		int codigomini = codigoProducto;
		Query sentencia = sesion.createQuery("select count(codigoProducto) from  Producto  where codigoProducto  ="+ codigomini);
		
		Iterator it = sentencia.iterate();
		int numero = Integer.valueOf(it.next().toString());
		
		if (numero == 0 ){
			//select count(numeroSactura) from factura where numeroFactura = numeroFactura
		
		Producto producto = new Producto (nombreProducto,codigoProducto,precioProducto, cantidadProducto, numeroFactura);
		sesion.save(producto);
		transaccion.commit();
		}else if(numero >0 ){
			JOptionPane.showMessageDialog(null, "Lo sentimos Existe una producto con el mismo numero en la base de datos. Si desea agregar mas productos cree una nueva factura", "Aviso", JOptionPane.WARNING_MESSAGE);
			transaccion.rollback();

		}
		
		
		
		}catch(HibernateException ex){
			manejarExcepcion(ex);
			System.out.println("Error en metodo guardar producto base de datos");
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error en metodo guardar producto base de datos");
		} finally{
			sesion.disconnect();
		}
	}
	
	public void guardarProductoCotizacion(String nombreProducto,int codigoProducto,int precioProducto, int cantidadProducto,long numeroFactura){
			try{
		iniciarsesion();
		
		int codigomini = codigoProducto;
		Query sentencia = sesion.createQuery("select count(codigoProducto) from  ProductoCotizacion  where codigoProducto  ="+ codigomini);
		
		Iterator it = sentencia.iterate();
		int numero = Integer.valueOf(it.next().toString());
		
		if (numero == 0 ){
			//select count(numeroSactura) from factura where numeroFactura = numeroFactura
		
		ProductoCotizacion pc = new ProductoCotizacion (nombreProducto,codigoProducto,precioProducto, cantidadProducto, numeroFactura);
		sesion.save(pc);
		transaccion.commit();
		}else if(numero >0 ){
			JOptionPane.showMessageDialog(null, "Lo sentimos Existe una producto con el mismo numero en la base de datos. Si desea agregar mas productos cree una nueva factura", "Aviso", JOptionPane.WARNING_MESSAGE);
			transaccion.rollback();

		}
		
		
		
		}catch(HibernateException ex){
			manejarExcepcion(ex);
			System.out.println("Error en metodo guardar producto base de datos");
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error en metodo guardar producto base de datos");
		} finally{
			sesion.disconnect();
		}
		
	}
	
	public void guardarCotizacion(String nombreClienteCotizacion, String rncCotizacion,  String ciudadCotizacion ,String fechaCotizacion, long numeroCotizacion, double valorbruto, double descuento, int impuestos, double valorneto){
		try{
		iniciarsesion();
		
		Query sentencia = sesion.createQuery("select count(numeroCotizacion) from  Cotizacion  where numeroCotizacion  ="+ numeroCotizacion);
		
		Iterator it = sentencia.iterate();
		int numero = Integer.valueOf(it.next().toString());

			if(numero == 0){
		Cotizacion cotizacion = new Cotizacion (nombreClienteCotizacion, rncCotizacion, ciudadCotizacion,fechaCotizacion, numeroCotizacion, valorbruto, descuento, impuestos, valorneto);
		JOptionPane.showMessageDialog(null, "Cotizaci\u00f3n guardada correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);

		sesion.save(cotizacion);
		transaccion.commit();
			}else{
			JOptionPane.showMessageDialog(null, "Lo sentimos Existe una Cotizaci\u00f3n igual en la base de datos.", "Aviso", JOptionPane.WARNING_MESSAGE);
			transaccion.rollback();
			}
			
		}catch(HibernateException ex){
			manejarExcepcion(ex);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void buscar(String tipoNumero,String numero,JList list, DefaultListModel listmodel){
		try{
		iniciarsesion();
		if(numero.equals("")){
		Query sentencia = sesion.createQuery("SELECT numero" +tipoNumero+ " from "+ tipoNumero+ " where numero"+tipoNumero+" LIKE '%"+ numero + "%'");
		List <String> listaBuscar = sentencia.list();
		
		// for(Long dc: listaBuscar){
			// System.out.println(dc);
		// }
		
		listmodel = new DefaultListModel<String>();
		Iterator it = listaBuscar.iterator();
		while(it.hasNext()){
			listmodel.addElement(String.valueOf(it.next().toString()));
		}
		list.setModel(listmodel);
		transaccion.commit();
		}else{
			
			Query sentencia = sesion.createQuery("SELECT numero" +tipoNumero+ " from "+ tipoNumero+ " where numero"+tipoNumero+" LIKE '%"+ numero + "%'");
		List <String> listaBuscar = sentencia.list();
		
		// for(Long dc: listaBuscar){
			// System.out.println(dc);
		// }
		
		listmodel = new DefaultListModel<String>();
		Iterator it = listaBuscar.iterator();
		while(it.hasNext()){
			listmodel.addElement(String.valueOf(it.next().toString()));
		}
		list.setModel(listmodel);
			transaccion.commit();
		}
		//list.setModel(listmodel);
		//transaccion.commit();
		
		}catch (HibernateException ex){
				manejarExcepcion(ex);
				System.out.println("Error en buscar");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error en buscar");
			}finally{
				sesion.disconnect();
			}
		
	}
	
	public void eliminar(String tipoNumero, long numero){
		try{
		iniciarsesion();
		Query sentencia = sesion.createQuery("SELECT numero" +tipoNumero+ " from "+ tipoNumero+ " where numero"+tipoNumero+" = '"+ numero + "'");
		List<Long> listaEliminar = sentencia.list();
		
		for(long dc : listaEliminar){
			Factura eliminarRegistro  = new Factura(dc);
			sesion.delete(eliminarRegistro);
		}
		transaccion.commit();
		}catch(HibernateException ex){
			manejarExcepcion(ex);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			sesion.disconnect();
		}
		
	}
		
	public void eliminarCotizacion(String tipoNumero, long numero){
		try{
		iniciarsesion();
		Query sentencia = sesion.createQuery("SELECT numero" +tipoNumero+ " from "+ tipoNumero+ " where numero"+tipoNumero+" = '"+ numero + "'");
		List<Long> listaEliminar = sentencia.list();
		
		
		for(long dc : listaEliminar){
			Cotizacion eliminarRegistro  = new Cotizacion(dc);
			sesion.delete(eliminarRegistro);
		}
		transaccion.commit();
		}catch(HibernateException ex){
			manejarExcepcion(ex);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			sesion.disconnect();
		}
		
	}
	
	public void recargarTabla(String idfacturaclick ,JTable tblProducto, DefaultTableModel tablaModel,TableColumnModel columnModel){
		try{ 	 

		iniciarsesion();
		Query sentencia = sesion.createQuery("from Producto where numeroFactura = '"+ idfacturaclick+"'");
		List<Producto> listaFactura = sentencia.list();
		
		String [] fila  = new String [4];
		// String tbltitulo [] = {"Nombre del producto","C\u00f3digo de Producto ","Precio de (los) producto(s)","Cantidad de productos"};
		// tablaModel = new DefaultTableModel(null, tbltitulo);
		
		// columnModel = tblProducto.getColumnModel();
		// columnModel.getColumn(0).setPreferredWidth(230);
		// columnModel.getColumn(1).setPreferredWidth(200);
		// columnModel.getColumn(2).setPreferredWidth(240);
		// columnModel.getColumn(3).setPreferredWidth(190);
		// tblProducto.setRowHeight(20);
		// tblProducto.setAutoResizeMode(tblProducto.AUTO_RESIZE_OFF);
		
		for(Producto p: listaFactura){
			
			fila[0] = p.getNombreProducto();
			fila[1] = String.valueOf(p.getCodigoProducto());
			fila[2] = String.valueOf(p.getPrecioProducto());
			fila[3] = String.valueOf(p.getCantidadProducto());
			tablaModel.addRow(fila);
			
		}
		
		
		
		
		tblProducto.setModel(tablaModel);
		transaccion.commit();
		
		}catch(HibernateException ex){
			manejarExcepcion(ex);
			System.out.println("Error en recargar tabla");
		}
	}
			
	public void recargarTablaCotizacion(String idfacturaclick ,JTable tbcotizacion, DefaultTableModel tablamodel_cotizacion,TableColumnModel columnModel_Cotizacion){
		try{ 	 

		iniciarsesion();
		Query sentencia = sesion.createQuery("from ProductoCotizacion where numeroCotizacion= '"+ idfacturaclick+"'");
		List<ProductoCotizacion> listaFactura = sentencia.list();
		
		String [] fila  = new String [4];
		// String tbltitulo [] = {"Nombre del producto","C\u00f3digo de Producto ","Precio de (los) producto(s)","Cantidad de productos"};
		// tablaModel = new DefaultTableModel(null, tbltitulo);
		
		// columnModel = tblProducto.getColumnModel();
		// columnModel.getColumn(0).setPreferredWidth(230);
		// columnModel.getColumn(1).setPreferredWidth(200);
		// columnModel.getColumn(2).setPreferredWidth(240);
		// columnModel.getColumn(3).setPreferredWidth(190);
		// tblProducto.setRowHeight(20);
		// tblProducto.setAutoResizeMode(tblProducto.AUTO_RESIZE_OFF);
		
		for(ProductoCotizacion pc: listaFactura){
			
			fila[0] = pc.getNombreProducto();
			fila[1] = String.valueOf(pc.getCodigoProducto());
			fila[2] = String.valueOf(pc.getPrecioProducto());
			fila[3] = String.valueOf(pc.getCantidadProducto());
			tablamodel_cotizacion.addRow(fila);
			
		}
		
		
		
		
		tbcotizacion.setModel(tablamodel_cotizacion);
		transaccion.commit();
		
		}catch(HibernateException ex){
			manejarExcepcion(ex);
			System.out.println("Error en recargar tabla");
		}
	}
	
	public void llenarLista(String tipoNumero ,JList list, DefaultListModel listmodel){
		try{
		iniciarsesion();
		Query sentencia = sesion.createQuery("select numero"+tipoNumero +" from " + tipoNumero);
		List<Long> listaNumeroFactura = sentencia.list();
		
		Iterator it = listaNumeroFactura.iterator();
		//list.setModel(listmodel);
		
		listmodel = new DefaultListModel <String>();
		
		while(it.hasNext()){
			listmodel.addElement(it.next());
		}
		
		list.setModel(listmodel);
		
		}catch(HibernateException ex){
			manejarExcepcion(ex);
		}catch(Exception e){
			e.printStackTrace();
		} finally{
			sesion.disconnect();
		}
	}
	
	public void cargarFactura(String idfacturaclick, JTextField txtnombre_cliente,JTextField txtrnc, JTextField txtciudad, JTextField txtfechacompra, JTextField txtno_factura,JComboBox cbmetodo_compra, JTextField txttotal_bruto, JTextField txtdescuento, JTextField txtimpuesto, JTextField txtvalor_neto){
		//
		
		iniciarsesion();
		try{
			Query sentencia1 = sesion.createQuery("Select metodoCompra from Factura where numeroFactura = '" + idfacturaclick+ "'");
			Iterator it = sentencia1.iterate();
			String metodo = it.next().toString();
			
			if(metodo.equals("Cr\u00e9dito")){
				cbmetodo_compra.setSelectedIndex(1);
			}else if(metodo.equals("Contado")){
			cbmetodo_compra.setSelectedIndex(2);	
			}
			
			System.out.println(metodo);
			
			Query sentencia = sesion.createQuery("from Factura WHERE numeroFactura = '"+ idfacturaclick+"'");
			List<Factura> listaFactura = sentencia.list();
			
			
			for(Factura e: listaFactura){
				
				txtnombre_cliente.setText((e.getNombreCliente()));
				txtrnc.setText((e.getRnc()));
				txtciudad.setText((e.getCiudad()));
				txtfechacompra.setText((e.getFechaCompra()));
				txtno_factura.setText((String.valueOf((e.getNumeroFactura()))));
				txttotal_bruto.setText((String.valueOf((e.getValorBruto()))));
				txtdescuento.setText((String.valueOf((e.getDescuento()))));
				txtimpuesto.setText((String.valueOf((e.getImpuestos()))));
				txtvalor_neto.setText((String.valueOf((e.getValorNeto()))));
				
			}
			
			
			
			transaccion.commit();
			
		}catch(HibernateException ex){
			
			manejarExcepcion(ex);
			
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				sesion.disconnect();
			}
	}

	public void cargarCotizacion(String idfacturaclick, JTextField txtnombre_cliente_cotizacion,JTextField txtrnc_cotizacion, JTextField txtciudad_cotizacion, JTextField txtfechacotizacion, JTextField txtno_cotizacion, JTextField txttotal_bruto_cotizacion, JTextField txtdescuento_cotizacion, JTextField txtimpuesto_cotizacion, JTextField txtvalor_neto_cotizacion){
		iniciarsesion();
		try{
			
			Query sentencia = sesion.createQuery(" from Cotizacion WHERE numeroCotizacion = '"+ idfacturaclick+"'");
			List<Cotizacion> listaCotizacion = sentencia.list();
			
			
			for(Cotizacion e: listaCotizacion){
				
				txtnombre_cliente_cotizacion.setText((e.getNombreClienteCotizacion()));
				txtrnc_cotizacion.setText((e.getRncCotizacion()));
				txtciudad_cotizacion.setText((e.getCiudadCotizacion()));
				txtfechacotizacion.setText((e.getFechaCotizacion()));
				txtno_cotizacion.setText((String.valueOf((e.getNumeroCotizacion()))));
				txttotal_bruto_cotizacion.setText((String.valueOf((e.getValorBruto()))));
				txtdescuento_cotizacion.setText((String.valueOf((e.getDescuento()))));
				txtimpuesto_cotizacion.setText((String.valueOf((e.getImpuestos()))));
				txtvalor_neto_cotizacion.setText((String.valueOf((e.getValorNeto()))));
				
			}
			
			
			
			transaccion.commit();
			
		}catch(HibernateException ex){
			
			manejarExcepcion(ex);
			
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				sesion.disconnect();
			}
	}
	
	public void calculoPrecio(JTextField txtprecio_producto, JTextField txtdescuento, JTextField txtimpuesto, JTextField txtvalor_neto){
		if (txtdescuento.getText().equals("")){
	    
		}else{
			
			double precioProductoparacalcular = Double.valueOf(txtprecio_producto.getText());
				double descuentoProducto = Double.valueOf(txtdescuento.getText());
					//double impuestoProducto = Double.valueOf(txtimpuesto.getText());
					
					double valorDescuento  = ((precioProductoparacalcular * descuentoProducto) /100);
					
					double aplicarDescuento = (precioProductoparacalcular - valorDescuento);
				
						txtvalor_neto.setText(String.valueOf(aplicarDescuento));
		}
		
	}


	}

