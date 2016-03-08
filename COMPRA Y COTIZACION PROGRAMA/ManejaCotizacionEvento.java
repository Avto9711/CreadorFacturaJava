
import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.*;
import javax.swing.text.JTextComponent;
import java.awt.event.*;

import javax.swing.event.*;
import org.hibernate.*;




public class ManejaCotizacionEvento extends MouseAdapter implements  ActionListener, CaretListener{
	
	private JFrame ventana;
	private JDialog dialogo;
	private JList  list;
	private DefaultListModel listmodel;
	private JLabel imagencotizacion;

	private JTextField txtbuscar;
	private JPopupMenu menuflotante;

	private String idfacturaclick;
	private TextPrompt tp7_cotizacion;

	
	private JScrollPane tblscroll_cotizacion;
	
	
	private JTextField txtno_cotizacion;
	private JTextField txtciudad_cotizacion;
	private JTextField txtnombre_cliente_cotizacion;
	private JTextField txtfechacotizacion;
	private JTextField txtrnc_cotizacion;
	private JTextField txttotal_bruto_cotizacion;
	private JTextField txtdescuento_cotizacion;
	private JTextField txtimpuesto_cotizacion;
	private JTextField txtvalor_neto_cotizacion;
	
	
	private String productoNombre;
	
	private JTextField txtnombre_producto; 
	private JTextField txtcodigo_producto;
	private JTextField txtprecio_producto; 
	private JTextField txtcantidad_producto;
	
	
	private JTable tbcotizacion;
	private DefaultTableModel tablamodel_cotizacion;
	private TableColumnModel columnModel_Cotizacion;
	private JLabel lblimagenparapaneldelosbotonesabajocotizacion;
	int calculoBruto2 ;

	BaseDatos gestor = new BaseDatos();
	


	public ManejaCotizacionEvento(JFrame ventana ,JTable tbcotizacion, DefaultTableModel tablamodel_cotizacion, TableColumnModel columnModel_Cotizacion, JTextField txtnombre_cliente_cotizacion,JTextField txtrnc_cotizacion, JTextField txtciudad_cotizacion, JTextField txtfechacotizacion, JTextField txtno_cotizacion, JTextField txttotal_bruto_cotizacion, JTextField txtdescuento_cotizacion, JTextField txtimpuesto_cotizacion, JTextField txtvalor_neto_cotizacion, JLabel lblimagenparapaneldelosbotonesabajocotizacion){
	this.ventana = ventana;
	this.tbcotizacion = tbcotizacion;
	this.tablamodel_cotizacion = tablamodel_cotizacion;
	this.columnModel_Cotizacion = columnModel_Cotizacion;
	this.txtnombre_cliente_cotizacion = txtnombre_cliente_cotizacion;  
	this.txtrnc_cotizacion = txtrnc_cotizacion;
	this.txtciudad_cotizacion = txtciudad_cotizacion;
	this.txtfechacotizacion = txtfechacotizacion;
	this.txtno_cotizacion = txtno_cotizacion;
	this.txttotal_bruto_cotizacion = txttotal_bruto_cotizacion;
	this.txtdescuento_cotizacion = txtdescuento_cotizacion;
	this.txtimpuesto_cotizacion = txtimpuesto_cotizacion;
	this.txtvalor_neto_cotizacion = txtvalor_neto_cotizacion;
	this.lblimagenparapaneldelosbotonesabajocotizacion = lblimagenparapaneldelosbotonesabajocotizacion;
	
		restriccionTextosyNumeroEspacios(txtciudad_cotizacion,txtrnc_cotizacion,txtfechacotizacion,txtno_cotizacion);
				//restriccionDialogoProducto(txtcodigo_producto,txtprecio_producto,txtcantidad_producto);
	}
	
	public ManejaCotizacionEvento(JDialog dialogo,JTable tbcotizacion, DefaultTableModel tablamodel_cotizacion,TableColumnModel columnModel_Cotizacion, JTextField txtnombre_producto, JTextField txtcodigo_producto,JTextField txtprecio_producto, JTextField txtcantidad_producto,JTextField txtno_cotizacion,JTextField txttotal_bruto_cotizacion, JTextField txtdescuento_cotizacion, JTextField txtimpuesto_cotizacion, JTextField txtvalor_neto_cotizacion){
		this.dialogo = dialogo;
		this.tbcotizacion = tbcotizacion;
		this.tablamodel_cotizacion = tablamodel_cotizacion;
		this.columnModel_Cotizacion = columnModel_Cotizacion;
		this.txtnombre_producto = txtnombre_producto;
		this.txtcodigo_producto = txtcodigo_producto;
		this.txtprecio_producto = txtprecio_producto;
		this.txtcantidad_producto = txtcantidad_producto;
		this.txtno_cotizacion = txtno_cotizacion;
		this.txttotal_bruto_cotizacion = txttotal_bruto_cotizacion;
		this.txtdescuento_cotizacion = txtdescuento_cotizacion;
		this.txtimpuesto_cotizacion = txtimpuesto_cotizacion;
		this.txtvalor_neto_cotizacion = txtvalor_neto_cotizacion;

		restriccionDialogoProducto(txtcodigo_producto,txtprecio_producto,txtcantidad_producto);
				

	}
	
	public ManejaCotizacionEvento(JDialog dialogo, JList list,JTable tbcotizacion,DefaultTableModel tablamodel_cotizacion,TableColumnModel columnModel_Cotizacion, DefaultListModel listmodel,JTextField txtbuscar, JPopupMenu menuflotante,String idfacturaclick,	JTextField txtnombre_cliente_cotizacion,JTextField txtrnc_cotizacion, JTextField txtciudad_cotizacion, JTextField txtfechacotizacion, JTextField txtno_cotizacion, JTextField txttotal_bruto_cotizacion, JTextField txtdescuento_cotizacion, JTextField txtimpuesto_cotizacion, JTextField txtvalor_neto_cotizacion){
		
			this.dialogo = dialogo;
			this.list = list;
			this.listmodel = listmodel;
			this.tbcotizacion = tbcotizacion;
			this.tablamodel_cotizacion = tablamodel_cotizacion;
			this.columnModel_Cotizacion = columnModel_Cotizacion;
			this.txtbuscar = txtbuscar;
			this.menuflotante = menuflotante;
			this.idfacturaclick = idfacturaclick;
			this.txtnombre_cliente_cotizacion = txtnombre_cliente_cotizacion;
			this.txtrnc_cotizacion = txtrnc_cotizacion;
			this.txtciudad_cotizacion = txtciudad_cotizacion;
			this.txtfechacotizacion = txtfechacotizacion;
			this.txtno_cotizacion = txtno_cotizacion;
			this.txttotal_bruto_cotizacion = txttotal_bruto_cotizacion;
			this.txtdescuento_cotizacion = txtdescuento_cotizacion;
			this.txtimpuesto_cotizacion = txtimpuesto_cotizacion;
			this.txtvalor_neto_cotizacion = txtvalor_neto_cotizacion;
			
			gestor = new BaseDatos();
			gestor.llenarLista("Cotizacion",list, listmodel);
			//tblProducto.setColumnModel(columnModel);
			//buscar(txtbuscar);
	}
	
	public void actionPerformed(ActionEvent e ){
		String label  = e.getActionCommand();
			if(label.equals("Cotizaciones")){

					 VerCotizacion cotizacion = new VerCotizacion(ventana, "Ver Cotizaciones", true,tbcotizacion,tablamodel_cotizacion,columnModel_Cotizacion,txtnombre_cliente_cotizacion,txtrnc_cotizacion,txtciudad_cotizacion,txtfechacotizacion,txtno_cotizacion,txttotal_bruto_cotizacion,txtdescuento_cotizacion,txtimpuesto_cotizacion,txtvalor_neto_cotizacion);
					 cotizacion.show();
					
			}
			
			if(label.equals("Guardar")){
			if(txtnombre_cliente_cotizacion.getText().equals("")  || txtciudad_cotizacion.getText().equals("") || txtfechacotizacion.getText().equals("") || txtrnc_cotizacion.getText().equals("") || txtno_cotizacion.getText().equals("") ||txttotal_bruto_cotizacion.getText().equals("")|| txtimpuesto_cotizacion.getText().equals("") ||txtvalor_neto_cotizacion.getText().equals("0.0")){
							restriccion();
				}else{
					if(txtno_cotizacion.isEditable()){
					gestor.guardarCotizacion(txtnombre_cliente_cotizacion.getText(), txtrnc_cotizacion.getText(), txtciudad_cotizacion.getText(), txtfechacotizacion.getText(), Long.parseLong(txtno_cotizacion.getText()), Double.valueOf((txttotal_bruto_cotizacion.getText())), Double.parseDouble((txtdescuento_cotizacion.getText())),18,Double.parseDouble(txtvalor_neto_cotizacion.getText()));
					guardarTablaProducto();
					}else{
						JOptionPane.showMessageDialog(null, "No es posible  guardar  o la Cotizaci\u00f3n mientras est\u00e9 leyendo ,cree una nueva Cotizaci\u00f3n", "Aviso", JOptionPane.WARNING_MESSAGE);

					}
				}
			}
			
			if(label.equals("Eliminar")){
				
				gestor.eliminarCotizacion("Cotizacion", Long.parseLong(idfacturaclick));
				gestor.llenarLista("Cotizacion",list, listmodel);

			}
			
			if (label.equals("Cargar")){
				borrarTabla();
				gestor.cargarCotizacion( idfacturaclick,  txtnombre_cliente_cotizacion, txtrnc_cotizacion,  txtciudad_cotizacion,  txtfechacotizacion,  txtno_cotizacion,  txttotal_bruto_cotizacion,  txtdescuento_cotizacion,  txtimpuesto_cotizacion,  txtvalor_neto_cotizacion);
				gestor.recargarTablaCotizacion(idfacturaclick, tbcotizacion, tablamodel_cotizacion, columnModel_Cotizacion);
				deshabilitarCampos();
				dialogo.hide();
			}
			
			if(label.equals("Limpiar TODO")){
				if(txtno_cotizacion.isEditable()){

						for(int i = 0; i<tbcotizacion.getRowCount(); i++){
							((DefaultTableModel)tbcotizacion.getModel()).removeRow(i);
						}
							for(int i = 0; i<tbcotizacion.getRowCount(); i++){
							((DefaultTableModel)tbcotizacion.getModel()).removeRow(i);
						}
							for(int i = 0; i<tbcotizacion.getRowCount(); i++){
							((DefaultTableModel)tbcotizacion.getModel()).removeRow(i);
						}
							for(int i = 0; i<tbcotizacion.getRowCount(); i++){
							((DefaultTableModel)tbcotizacion.getModel()).removeRow(i);
						}
						
						limpiarTodo();
					}else{
						JOptionPane.showMessageDialog(null, "No es posible eliminar los datos de una factura mientras la lees.", "Aviso", JOptionPane.WARNING_MESSAGE);

					}
				}
				
			if(label.equals("Agregar Producto")){
				DialogoProductoCotizacion producto = new DialogoProductoCotizacion(ventana,"Agregar Producto", true, tbcotizacion, tablamodel_cotizacion, columnModel_Cotizacion, txtno_cotizacion, txttotal_bruto_cotizacion, txtdescuento_cotizacion, txtimpuesto_cotizacion, txtvalor_neto_cotizacion);
				producto.show();
				
			}
			if(label.equals("Agregar")){
				
				insertarTablaProducto();
				sumarTxtBruto();
				dialogo.hide();
	
			}
	}	

	public void mouseClicked(MouseEvent e){
		Object fuente = e.getSource();
		
			if(fuente instanceof JLabel){
				if(e.getClickCount() == 1){
				abrirDialogoAcercaDePorImagen();
				
				
				}
			}
		
	}
	
	public void abrirDialogoAcercaDePorImagen(){
		DialogAcercaDe acercade = new DialogAcercaDe(ventana, "Acerca de ", true);
				acercade.show();
	}
	
	public void caretUpdate(CaretEvent e){
			calcularNeto();		
		}
		
	public void insertarTablaProducto(){
		
		String [] fila  = new String [4];

		fila[0] = txtnombre_producto.getText();
		fila[1] = txtcodigo_producto.getText();
		fila[2] = txtprecio_producto.getText();
		fila[3] = txtcantidad_producto.getText();

		tablamodel_cotizacion.addRow(fila);
		tbcotizacion.setModel(tablamodel_cotizacion);
					
	}
	
	public void guardarTablaProducto(){
		
		for(int i = 0; i<tbcotizacion.getRowCount(); i++){
							
			System.out.print(tbcotizacion.getValueAt(i,0).toString() +  " ");
			System.out.print(tbcotizacion.getValueAt(i,1).toString()  +  " ");
			System.out.print(tbcotizacion.getValueAt(i,2).toString()  +  " ");
			System.out.println(tbcotizacion.getValueAt(i,3).toString()  +  " ");
					
			gestor.guardarProductoCotizacion(String.valueOf((tbcotizacion.getValueAt(i,0).toString())),Integer.parseInt(tbcotizacion.getValueAt(i,1).toString()),Integer.parseInt(tbcotizacion.getValueAt(i,2).toString()), Integer.parseInt(tbcotizacion.getValueAt(i,3).toString()),Long.parseLong(txtno_cotizacion.getText()));
	
		}
	}
	
	public void restriccionDeNumeroyEspacios(JTextComponent componentedetexto){
		componentedetexto.addKeyListener(new KeyAdapter() { 
		public void keyTyped(KeyEvent e){
			char c = e.getKeyChar();
			char espacios = e.getKeyChar();
			
			if(Character.isDigit(c)){
				
				JOptionPane.showMessageDialog(null, "Lo sentimos no es posible insertar digitos en este campo.", "Aviso", JOptionPane.WARNING_MESSAGE);
				e.consume();
			}
			
			if(espacios == ' '){
				
				JOptionPane.showMessageDialog(null, "Lo sentimos no se permiten espacios en este campo.", "Aviso", JOptionPane.WARNING_MESSAGE);
				e.consume();
			}
		}
		});	
	}
	
	public void restriccionDeEspaciosyLetras(JTextComponent componentedetexto){
		
		componentedetexto.addKeyListener(new KeyAdapter() { 
		public void keyTyped(KeyEvent e){
			char letra  = e.getKeyChar();
			char espacios = e.getKeyChar();
			char simbolo = e.getKeyChar();
	
			
				if(espacios == ' '){
					
					JOptionPane.showMessageDialog(null, "Lo sentimos no se permiten espacios en este campo.", "Aviso", JOptionPane.WARNING_MESSAGE);
					e.consume();
				}
				
				if(Character.isAlphabetic(letra)){
					
					JOptionPane.showMessageDialog(null, "Lo sentimos no se permiten letras en este campo.", "Aviso", JOptionPane.WARNING_MESSAGE);
					e.consume();
					
				}
				
				if(simbolo == '+' || simbolo == '-'|| simbolo == '*'){
					e.consume();

				}
				
		}
		});	
	}
	
	public void restriccionTextosyNumeroEspacios( JTextField txtciudad_cotizacion,JTextField txtrnc_cotizacion, JTextField txtfechacotizacion, JTextField txtno_cotizacion){

		//restriccionDeNumeroyEspacios(txtciudad);
		restriccionDeEspaciosyLetras(txtrnc_cotizacion);
		restriccionDeEspaciosyLetras(txtfechacotizacion);
		restriccionDeEspaciosyLetras(txtno_cotizacion);
		restriccionDeEspaciosyLetras(txtdescuento_cotizacion);
	}

	public void restriccionDialogoProducto(JTextField txtcodigo_producto, JTextField txtprecio_producto, JTextField txtcantidad_producto){
		restriccionDeEspaciosyLetras(txtprecio_producto);
		restriccionDeEspaciosyLetras(txtcodigo_producto);
		restriccionDeEspaciosyLetras(txtcantidad_producto);
		
	}
	
	public void limpiarTodo(){
		txtnombre_cliente_cotizacion.setText("");
		txtrnc_cotizacion.setText("");
		txtciudad_cotizacion.setText("");
		txtfechacotizacion.setText("");
		txtno_cotizacion.setText("");
		txttotal_bruto_cotizacion.setText("");
		txtdescuento_cotizacion.setText("");
		txtimpuesto_cotizacion.setText("18.0");
		txtvalor_neto_cotizacion.setText("");
		
	}
	
	public void restriccion (){
	JLabel aviso  = new JLabel("Error, Debe llenar todos los campos de Datos Coizaci\u00f3n");
			aviso.setFont(new Font("Microsoft PhagsPa",1,15));
					JOptionPane.showMessageDialog(null, aviso, "Error", JOptionPane.WARNING_MESSAGE);
					
	}
	
	public void sumarTxtBruto(){
		
			int precioProducto = Integer.parseInt(txtprecio_producto.getText());
		
		 	for(int i = 0; i<tbcotizacion.getRowCount(); i++){
					calculoBruto2 += Integer.valueOf(tbcotizacion.getValueAt(i,2).toString());
				}
		 
		txttotal_bruto_cotizacion.setText(String.valueOf(calculoBruto2) );
		System.out.println("");
		
		//public void calculoPrecio(JTextField txtprecio_producto, JTextField txtdescuento, JTextField txtimpuesto, JTextField txtvalor_neto){
		
	
	}
	
	public void calcularNeto(){
		txtimpuesto_cotizacion.setText("18.0");
		if (txtdescuento_cotizacion.getText().equals("")){
			txtvalor_neto_cotizacion.setText("0.0");
		}else{
			
			double precioProductoparacalcular = Double.valueOf(txttotal_bruto_cotizacion.getText());
				double descuentoProducto = Double.valueOf(txtdescuento_cotizacion.getText());
					//double impuestoProducto = Double.valueOf(txtimpuesto.getText());
					
					double valorDescuento  = ((precioProductoparacalcular * descuentoProducto) /100);
						double aplicarDescuento = (precioProductoparacalcular - valorDescuento);
					
					
					 double valorImpuesto = ((precioProductoparacalcular * 18)/100);
						double	aplicarImpuestos = (precioProductoparacalcular + valorImpuesto);
					
					 double valorFinal = ((precioProductoparacalcular -  aplicarDescuento) + aplicarImpuestos);
					
					
					// double valorFinalVerdadero = (precioProductoparacalcular -(valorFinal - valorImpuesto));
						txtvalor_neto_cotizacion.setText(String.valueOf(valorFinal));
		}
	}

	public void mousePressed(MouseEvent e){
		Object fuenteevento = e.getSource();
			try{
				if(fuenteevento instanceof JList){
					System.out.println("Llegue");
					
					int localizarpalabra = list.locationToIndex(e.getPoint());
						if(localizarpalabra >= 0){
							list.setSelectedIndex(localizarpalabra);
							
							Object objeto = list.getSelectedValue();
							idfacturaclick = objeto.toString();
							//System.out.println(idfacturaclick);
						}
								if(e.isPopupTrigger() && !idfacturaclick.equals("")){
									menuflotante.show(e.getComponent(), e.getX(), e.getY());
								}else{
									System.out.println("");
								}
				}
				
			
		}catch(Exception ex){
					System.out.println("Error aqui");
					ex.printStackTrace();
					}
		}
	
	public void mouseReleased(MouseEvent e) {
		Object source = e.getSource();
		try{
		if (source instanceof JList){
			
			if (e.isPopupTrigger() && !idfacturaclick.equals("")) {
				
				int localizarpalabra = list.locationToIndex(e.getPoint());
				
				if(localizarpalabra >= 0){
					
					list.setSelectedIndex(localizarpalabra);
					Object objeto = list.getSelectedValue();
					
					idfacturaclick= objeto.toString();
					System.out.println(idfacturaclick);
					
				}
				menuflotante.show(e.getComponent(), e.getX(), e.getY());
			}
		}
		}catch(Exception error){
			
		}
	}
	
	public void borrarTabla(){
		for(int i = 0; i<tbcotizacion.getRowCount(); i++){
			
			((DefaultTableModel)tbcotizacion.getModel()).removeRow(i);
			//tblProducto.getColumnModel();
			
		}
		for(int i = 0; i<tbcotizacion.getRowCount(); i++){
			
			((DefaultTableModel)tbcotizacion.getModel()).removeRow(i);
			//tblProducto.getColumnModel();
			
		}
		for(int i = 0; i<tbcotizacion.getRowCount(); i++){
			
			((DefaultTableModel)tbcotizacion.getModel()).removeRow(i);
			//tblProducto.getColumnModel();
			
		}
		for(int i = 0; i<tbcotizacion.getRowCount(); i++){
			
			((DefaultTableModel)tbcotizacion.getModel()).removeRow(i);
			//tblProducto.getColumnModel();
			
		}
	}
	
	public void deshabilitarCampos(){
		
	this.txtno_cotizacion.setEditable(false);
	this.txtciudad_cotizacion.setEditable(false);
	this.txtnombre_cliente_cotizacion.setEditable(false);
	this.txtfechacotizacion.setEditable(false);
	this.txtrnc_cotizacion.setEditable(false);
	this.txttotal_bruto_cotizacion.setEditable(false);
	this.txtdescuento_cotizacion.setEditable(false);
	this.txtimpuesto_cotizacion.setEditable(false);
	this.txtvalor_neto_cotizacion.setEditable(false);
	
		
	}
}
