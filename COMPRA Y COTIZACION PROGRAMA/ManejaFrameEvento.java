import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.*;
import javax.swing.text.JTextComponent;
import java.awt.event.*;

import javax.swing.event.*;
import org.hibernate.*;






public class ManejaFrameEvento extends MouseAdapter implements  ActionListener, CaretListener{

	private JFrame ventana;
	private JDialog dialogo;
	private JLabel lblimagenparapaneldelosbotonesabajocotizacion;


	private JComboBox cbmetodo_compra;

	private String productoNombre;

	private JTextField txtnombre_producto;
	private JTextField txtcodigo_producto;
	private JTextField txtprecio_producto;
	private JTextField txtcantidad_producto;


	private JTextField txtno_factura;
	private JTextField txtciudad;
	private JTextField txtnombre_cliente;
	private JTextField txtfechacompra;
	private JTextField txtrnc;
	private JTextField txtmetodo_compra;
	private JTextField txttotal_bruto;
	private JTextField txtdescuento;
	private JTextField txtimpuesto;
	private JTextField txtvalor_neto;

	int calculoBruto2 ;

	private DefaultTableModel tablaModel;
	private JTable tblProducto;
	private TableColumnModel columnModel;
	BaseDatos gestor = new BaseDatos();

	public ManejaFrameEvento(JFrame ventana ,JTable tblProducto, DefaultTableModel tablaModel, TableColumnModel columnModel, JTextField txtnombre_cliente,JTextField txtrnc, JTextField txtciudad, JTextField txtfechacompra, JTextField txtno_factura,JComboBox cbmetodo_compra, JTextField txttotal_bruto, JTextField txtdescuento, JTextField txtimpuesto, JTextField txtvalor_neto, JLabel lblimagenparapaneldelosbotonesabajocotizacion){
	this.ventana = ventana;
	this.tblProducto = tblProducto;
	this.tablaModel = tablaModel;
	this.columnModel = columnModel;
	this.txtnombre_cliente = txtnombre_cliente;
	this.txtrnc = txtrnc;
	this.txtciudad = txtciudad;
	this.txtfechacompra = txtfechacompra;
	this.txtno_factura = txtno_factura;
	this.cbmetodo_compra = cbmetodo_compra;
	this.txttotal_bruto = txttotal_bruto;
	this.txtdescuento = txtdescuento;
	this.txtimpuesto = txtimpuesto;
	this.txtvalor_neto = txtvalor_neto;
	this.lblimagenparapaneldelosbotonesabajocotizacion = lblimagenparapaneldelosbotonesabajocotizacion;

		restriccionTextosyNumeroEspacios(txtciudad,txtrnc,txtfechacompra,txtno_factura);
	}

	public ManejaFrameEvento(JDialog dialogo,JTable tblProducto, DefaultTableModel tablaModel,TableColumnModel columnModel, JTextField txtnombre_producto, JTextField txtcodigo_producto,JTextField txtprecio_producto, JTextField txtcantidad_producto,JTextField txtno_factura,JTextField txttotal_bruto, JTextField txtdescuento, JTextField txtimpuesto, JTextField txtvalor_neto){
		this.dialogo = dialogo;
		this.tblProducto = tblProducto;
		this.tablaModel = tablaModel;
		this.columnModel = columnModel;
		this.txtnombre_producto = txtnombre_producto;
		this.txtcodigo_producto = txtcodigo_producto;
		this.txtprecio_producto = txtprecio_producto;
		this.txtcantidad_producto = txtcantidad_producto;
		this.txtno_factura = txtno_factura;
		this.txttotal_bruto = txttotal_bruto;
		this.txtdescuento = txtdescuento;
		this.txtimpuesto = txtimpuesto;
		this.txtvalor_neto = txtvalor_neto;
		restriccionDialogoProducto(txtcodigo_producto,txtprecio_producto,txtcantidad_producto);
			//restriccionDialogoProducto(txtcodigo_producto,txtprecio_producto,txtcantidad_producto);

	}


	public ManejaFrameEvento(JFrame ventana){
		this.ventana = ventana;

	}

	public void actionPerformed(ActionEvent e ){

		String label = e.getActionCommand();

				if (label.equals("Producto")){
			DialogoProducto producto = new DialogoProducto(ventana,"Agregar Producto", true, tblProducto, tablaModel, columnModel, txtno_factura, txttotal_bruto, txtdescuento, txtimpuesto, txtvalor_neto);
			producto.show();
		}
				if(label.equals("Agregar Producto")){
				DialogoProducto producto = new DialogoProducto(ventana,"Agregar Producto", true, tblProducto, tablaModel, columnModel, txtno_factura, txttotal_bruto, txtdescuento, txtimpuesto, txtvalor_neto);
				producto.show();

				}
				if(label.equals("Facturas")){
				VerFactura factura = new VerFactura(ventana, "Ver Facturas", true,tblProducto,tablaModel,columnModel,txtnombre_cliente,txtrnc, txtciudad, txtfechacompra,txtno_factura, cbmetodo_compra, txttotal_bruto, txtdescuento, txtimpuesto, txtvalor_neto);

					factura.show();
			}
				if(label.equals("Cancelar")){


				}
				if(label.equals("Guardar")){


				if(txtnombre_cliente.getText().equals("")  || txtciudad.getText().equals("") || txtfechacompra.getText().equals("") || txtrnc.getText().equals("") || txtno_factura.getText().equals("") ||cbmetodo_compra.getSelectedItem().equals("")||txttotal_bruto.getText().equals("")|| txtimpuesto.getText().equals("")||txtvalor_neto.getText().equals("0.0")){
							restriccion();
				}else{
							if(txtno_factura.isEditable()){
							//gestor.guardarFactura(    8844,                                "mielda",                      "81",         "pupu",                  "11/154/2015",                  "Contado",                          10,                                       100.242,                                        84.35,5);
							gestor.guardarFactura(Long.parseLong(txtno_factura.getText()),txtnombre_cliente.getText(),txtrnc.getText(),txtciudad.getText(),txtfechacompra.getText(),(String)(cbmetodo_compra.getSelectedItem()),Integer.valueOf((txtdescuento.getText())), Double.parseDouble((txttotal_bruto.getText())),Double.parseDouble(txtvalor_neto.getText()),18);
							guardarTablaProducto();
							}else{
								JOptionPane.showMessageDialog(null, "No puede guardar una factura mientras la lee.", "Aviso", JOptionPane.WARNING_MESSAGE);

							}

					}
				}
				if(label.equals("Limpiar TODO")){
					if(txtno_factura.isEditable()){

						for(int i = 0; i<tblProducto.getRowCount(); i++){
							((DefaultTableModel)tblProducto.getModel()).removeRow(i);
						}
							for(int i = 0; i<tblProducto.getRowCount(); i++){
							((DefaultTableModel)tblProducto.getModel()).removeRow(i);
						}
							for(int i = 0; i<tblProducto.getRowCount(); i++){
							((DefaultTableModel)tblProducto.getModel()).removeRow(i);
						}
							for(int i = 0; i<tblProducto.getRowCount(); i++){
							((DefaultTableModel)tblProducto.getModel()).removeRow(i);
						}

					limpiarTodo();
					}else{
						JOptionPane.showMessageDialog(null, "No es posible eliminar los datos de una factura mientras la lees.", "Aviso", JOptionPane.WARNING_MESSAGE);

					}
				}
				if(label.equals("AgregarProducto")){

					System.out.println("Entre a agregar producto");
					insertarTablaProducto();
					sumarTxtBruto();
					dialogo.hide();

				}
				if(label.equals("Factura / Cotizaci\u00f3n")){
						ventana.removeNotify();
							CompraCotizacion cc = new CompraCotizacion("LUENLU  COMPRA COTIZACION");
					}
	}

	public void caretUpdate(CaretEvent e){
		if(txtvalor_neto.equals("")){

		}else{
		calcularNeto();
		}
	}

	// metodo restriccion para los textfields para que todo deba de estar lleno
	public void restriccion (){
	JLabel aviso  = new JLabel("Error, Debe llenar todos los campos de " + "Datos factura");
			aviso.setFont(new Font("Microsoft PhagsPa",1,15));
					JOptionPane.showMessageDialog(null, aviso, "Error", JOptionPane.WARNING_MESSAGE);

	}

	// metodo para abrir la imagen
	public void mouseClicked(MouseEvent e){
		Object fuente = e.getSource();

			if(fuente instanceof JLabel){
				if(e.getClickCount() == 1){
				abrirDialogoAcercaDePorImagen();


				}
			}

	}

	// boton que me limpia todos los textfields
	public void limpiarTodo(){
		txtnombre_cliente.setText("");
		txtrnc.setText("");
		txtciudad.setText("");
		txtfechacompra.setText("");
		txtno_factura.setText("");
		cbmetodo_compra.setSelectedIndex(0);
		txttotal_bruto.setText("");
		txtdescuento.setText("");
		txtimpuesto.setText("18.0");
		txtvalor_neto.setText("");

	}
	// abrir dialogo acerca de mediante la imagen de VMeta
	public void abrirDialogoAcercaDePorImagen(){
		DialogAcercaDe acercade = new DialogAcercaDe(ventana, "Acerca de ", true);
				acercade.show();
	}
	// método para que los textfields no me acepten ni numeros ni espacio
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

	// metodo para que no me acepten espacios
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

				if(simbolo == '+' || simbolo == '-'|| simbolo == '*' || simbolo == '.'){
					e.consume();

				}

		}
		});
	}

	// metodo para usar el metodo restriccionDeNumeroyEspacios y restriccionDeEspacios, para que en algunos txt no me acepte ni espacios ni numeros pero en otros que solo no me acepte espacios este método lo llamo en el constructor
	public void restriccionTextosyNumeroEspacios( JTextField txtciudad,JTextField txtrnc, JTextField txtfechacompra, JTextField txtno_factura){

		//restriccionDeNumeroyEspacios(txtciudad);
		restriccionDeEspaciosyLetras(txtrnc);
		restriccionDeEspaciosyLetras(txtfechacompra);
		restriccionDeEspaciosyLetras(txtno_factura);
		restriccionDeEspaciosyLetras(txtdescuento);
	}

	public void restriccionDialogoProducto(JTextField txtcodigo_producto, JTextField txtprecio_producto, JTextField txtcantidad_producto){
		restriccionDeEspaciosyLetras(txtprecio_producto);
		restriccionDeEspaciosyLetras(txtcodigo_producto);
		restriccionDeEspaciosyLetras(txtcantidad_producto);

	}

	public void insertarTablaProducto(){

					String [] fila  = new String [4];

					fila[0] = txtnombre_producto.getText();
					fila[1] = txtcodigo_producto.getText();
					fila[2] = txtprecio_producto.getText();
					fila[3] = txtcantidad_producto.getText();

					tablaModel.addRow(fila);
					tblProducto.setModel(tablaModel);

	}

	public void guardarTablaProducto(){

				for(int i = 0; i<tblProducto.getRowCount(); i++){


					System.out.print(tblProducto.getValueAt(i,0).toString() +  " ");
					System.out.print(tblProducto.getValueAt(i,1).toString()  +  " ");
					System.out.print(tblProducto.getValueAt(i,2).toString()  +  " ");
					System.out.println(tblProducto.getValueAt(i,3).toString()  +  " ");

					gestor.guardarProducto(String.valueOf((tblProducto.getValueAt(i,0).toString())),Integer.parseInt(tblProducto.getValueAt(i,1).toString()),Integer.parseInt(tblProducto.getValueAt(i,2).toString()), Integer.parseInt(tblProducto.getValueAt(i,3).toString()),Long.parseLong(txtno_factura.getText()));


				}

	}

	public void sumarTxtBruto(){

			int precioProducto = Integer.parseInt(txtprecio_producto.getText());

		 	for(int i = 0; i<tblProducto.getRowCount(); i++){
					calculoBruto2 += Integer.valueOf(tblProducto.getValueAt(i,2).toString());
				}

		txttotal_bruto.setText(String.valueOf(calculoBruto2) );
		System.out.println("");

		//public void calculoPrecio(JTextField txtprecio_producto, JTextField txtdescuento, JTextField txtimpuesto, JTextField txtvalor_neto){


	}

	public void calcularNeto(){
		txtimpuesto.setText("18.0");
		if (txtdescuento.getText().equals("")){
			txtvalor_neto.setText("0.0");
		}else{

			double precioProductoparacalcular = Double.valueOf(txttotal_bruto.getText());
				double descuentoProducto = Double.valueOf(txtdescuento.getText());
					//double impuestoProducto = Double.valueOf(txtimpuesto.getText());

					double valorDescuento  = ((precioProductoparacalcular * descuentoProducto) /100);
						double aplicarDescuento = (precioProductoparacalcular - valorDescuento);


					 double valorImpuesto = ((precioProductoparacalcular * 18)/100);
						double	aplicarImpuestos = (precioProductoparacalcular + valorImpuesto);

					 double valorFinal = ((precioProductoparacalcular -  aplicarDescuento) + aplicarImpuestos);

						txtvalor_neto.setText(String.valueOf(valorFinal));
		}
	}

}
