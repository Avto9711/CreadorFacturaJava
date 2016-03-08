import javax.swing.*;
import java.awt.*;
import javax.swing.table.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.*;
import javax.swing.text.JTextComponent;





public class CompraCotizacion extends JFrame{

	private JLabel imagenfactura;
	
	private JComboBox cbmetodo_compra;
	
	private TextPrompt tp7;
	
	private JTable tblProducto;
	private JScrollPane tblscroll;
	
	private JLabel  lblno_factura;
	private JLabel  lblciudad;
	private JLabel  lblnombre_cliente;
	private JLabel  lblfechacompra; 
	private JLabel  lblrnc; 
	private JLabel  lblmetodo_compra; 
	private JLabel  lbltotal_bruto; 
	private JLabel	lbldescuento;
	private JLabel  lblimpuesto;
	private JLabel  lblvalor_neto;
	private JLabel  lblimagenparapaneldelosbotonesabajo;
	
	private JButton btnguardar;
	private JButton btnlimpiartodo;
	
	private TitledBorder titulobordetabla;
	private Border negro;
	
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
	
	
	
	private JMenuBar barramenu;
	private JMenu anadir,ver ;
	private JMenuItem productocomprado,crearFactura, productocotizado, productoscomprado, productoscotizado, factura,verfactura,vercotizacion; 
	private JPanel pestanafactura, pestanafacturapanel1,pestanafacturapanel2,pestanafacturapanel3,panelbotonespestanafacturabajo,panelparatabla,panelparabotonestxtylabel,panelparacentrarbotonesdelpaneldeabajo;
	private JTabbedPane panelConFichas;
	
	private DefaultTableModel tablaModel;
	private TableColumnModel columnModel;
	//-------------------------
	
	
	private JLabel imagencotizacion;
	
	
	
	private TextPrompt tp7_cotizacion;
	
	
	private JTable tbcotizacion;
	private JScrollPane tblscroll_cotizacion;
	
	private JLabel  lblno_cotizacion;
	private JLabel  lblciudad_cotizacion;
	private JLabel  lblnombre_cliente_cotizacion;
	private JLabel  lblfechacotizacion; 
	private JLabel  lblrnc_cotizacion;  
	private JLabel  lbltotal_bruto_cotizacion; 
	private JLabel	lbldescuento_cotizacion;
	private JLabel  lblimpuesto_cotizacion;
	private JLabel  lblvalor_neto_cotizacion;
	private JLabel  lblimagenparapaneldelosbotonesabajocotizacion;
	
	private JButton btnguardar_cotizacion;
	private JButton btnlimpiartodo_cotizacion;
	private JButton btnAgregarProducto;
	private JButton btnAgregarProductoFactura;
	
	private TitledBorder titulobordetabla_cotizacion;
	private Border negro_cotizacion;
	
	private JTextField txtno_cotizacion;
	private JTextField txtciudad_cotizacion;
	private JTextField txtnombre_cliente_cotizacion;
	private JTextField txtfechacotizacion;
	private JTextField txtrnc_cotizacion;
	private JTextField txttotal_bruto_cotizacion;
	private JTextField txtdescuento_cotizacion;
	private JTextField txtimpuesto_cotizacion;
	private JTextField txtvalor_neto_cotizacion;
	
	
	
	
	private JPanel  pestanacotizacionpanel1,pestanacotizacionpanel2,pestanacotizacionpanel3,pestanacotizacion,panelbotonespestanacotizacionbajo,panelparatabla_cotizacion,panelparabotonestxtylabel_cotizacion,panelparacentrarbotonesdelpaneldeabajocotizacion;
	
	private DefaultTableModel tablamodel_cotizacion;
	
	
	//----------------------------
	
	
	
	
	public CompraCotizacion(String titulo){
		super(titulo);
		gui();
		ini();
		
		
	}
	
	public CompraCotizacion(JComboBox cbmetodo_compra){
		this.cbmetodo_compra = cbmetodo_compra;
	}
	
	public void ini(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(900,600);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);	
	
	}
	
	public void gui(){
//--------------------SETEANDO LOOK AND FEEL---------------------------------


try{
  
 
UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
}
catch (Exception e)
 {
  e.printStackTrace();
 }


//----------------------------------------------------------------------------
		
		
		
		
		
		
		
		
		// creando los menu item
	
		productocomprado = new JMenuItem("Producto");
		crearFactura = new JMenuItem("Factura / Cotizaci\u00f3n");
		
		verfactura = new JMenuItem("Facturas");
		vercotizacion = new JMenuItem("Cotizaciones");
		
		// panel con pestanas
		
		panelConFichas = new JTabbedPane();	
		panelConFichas.setBackground(Color.WHITE);
		
		
//------------pestanas---------
		// pestana factura
		
		pestanafactura = new JPanel();
		pestanafactura.setLayout(new BorderLayout());
		pestanafactura.setBackground(Color.WHITE);
	
		pestanafacturapanel1 = new JPanel();
		pestanafacturapanel1.setLayout(new FlowLayout(FlowLayout.LEFT,15,0));
		pestanafacturapanel1.setBackground(Color.WHITE);
		pestanafacturapanel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Datos Factura "));
		
		pestanafacturapanel2 = new JPanel();
		pestanafacturapanel2.setLayout(new BorderLayout(-3,-50));
		pestanafacturapanel2.setBackground(Color.WHITE);
		

		
		lblnombre_cliente = new JLabel("Nombre del Cliente");
		lblnombre_cliente.setFont(new Font("Microsoft PhagsPa",1,15));
		
		txtnombre_cliente = new JTextField(20);
		
		lblrnc = new JLabel("RNC                      ");
		lblrnc.setFont(new Font("Microsoft PhagsPa",1,15));
		
		txtrnc = new JTextField(17);
		
		lblciudad = new JLabel("Ciudad                      ");
		lblciudad.setFont(new Font("Microsoft PhagsPa",1,15));
		
		txtciudad = new JTextField(20);
		
		
		
		lblfechacompra = new JLabel("Fecha de Compra");
		lblfechacompra.setFont(new Font("Microsoft PhagsPa",1,15));
		
		txtfechacompra = new JTextField(17);
		
		lblno_factura = new JLabel("N\u00famero de Factura");
		lblno_factura.setFont(new Font("Microsoft PhagsPa",1,15));
		
		txtno_factura = new JTextField(20);
		
		lblmetodo_compra = new JLabel("M\u00e9todo de Compra");
		lblmetodo_compra.setFont(new Font("Microsoft PhagsPa",1,15));
		
		String arreglo_metodo_compra  [] = {" ","Cr\u00e9dito", "Contado"};
		cbmetodo_compra = new JComboBox(arreglo_metodo_compra);
		cbmetodo_compra.setBackground(Color.WHITE);
		cbmetodo_compra.setForeground(new Color(48,138,255));
		
		
		
		imagenfactura = new JLabel(new ImageIcon("imagenes/receive.png"));
		
		pestanafacturapanel1.add(lblnombre_cliente);
		pestanafacturapanel1.add(txtnombre_cliente);
		
		pestanafacturapanel1.add(lblrnc);
		pestanafacturapanel1.add(txtrnc);
		
		pestanafacturapanel1.add(lblciudad);
		pestanafacturapanel1.add(txtciudad);
		
		pestanafacturapanel1.add(lblfechacompra);
		pestanafacturapanel1.add(txtfechacompra);
		
		pestanafacturapanel1.add(lblno_factura);
		pestanafacturapanel1.add(txtno_factura);
		
		pestanafacturapanel1.add(lblmetodo_compra);
		pestanafacturapanel1.add(cbmetodo_compra);
		
		imagenfactura = new JLabel(new ImageIcon("imagenes/receive.png"));
		
		pestanafacturapanel2.add(pestanafacturapanel1,BorderLayout.CENTER);
		pestanafacturapanel2.add(imagenfactura, BorderLayout.EAST);
	
		
		//creando una tabla para la factura
		panelparatabla = new JPanel(new BorderLayout());
		panelparatabla.setBackground(Color.WHITE);
		String tbltitulo [] = {"Nombre del producto","C\u00f3digo de Producto ","Precio de (los) producto(s)","Cantidad de productos"};
		tablaModel = new DefaultTableModel(null, tbltitulo);
		
		tblProducto = new JTable(tablaModel);
		// BaseDatos gestor = new BaseDatos();
		// gestor.recargarTabla(tblProducto, tablaModel);
		
		
		negro = BorderFactory.createEtchedBorder();
		
		titulobordetabla = BorderFactory.createTitledBorder(negro, "Producto (s)");
		titulobordetabla.setTitleJustification(TitledBorder.LEFT);
		panelparatabla.setBorder(titulobordetabla);
		
		tblProducto.setFont(new Font("Microsoft PhagsPa",1,15));
		tblProducto.setEnabled(false);
		tblProducto.setBackground(Color.WHITE);
		
		 columnModel = tblProducto.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(230);
		columnModel.getColumn(1).setPreferredWidth(200);
		columnModel.getColumn(2).setPreferredWidth(240);
		columnModel.getColumn(3).setPreferredWidth(190);
		tblProducto.setRowHeight(20);
		tblProducto.setAutoResizeMode(tblProducto.AUTO_RESIZE_OFF);
		
					

		tblscroll = new JScrollPane(tblProducto, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panelparatabla.add(tblscroll);
		
		JTableHeader  tableHeader =  tblProducto.getTableHeader();
		tableHeader.setBackground(Color.WHITE);
		tableHeader.setFont(new Font("Microsoft PhagsPa",1,15));
		tableHeader.setForeground(new Color(48,138,255));
		

//-------------------Panel para tota,descuento,impuestos,neto;
		panelparabotonestxtylabel = new JPanel(new GridLayout(4,2));
		panelparabotonestxtylabel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Informacion final"));
		panelparabotonestxtylabel.setBackground(Color.WHITE);
		
		
		panelbotonespestanafacturabajo = new JPanel(new BorderLayout());
		panelbotonespestanafacturabajo.setBackground(Color.WHITE);
		
		//anadiendo los label y txt al panelparabotonestxtylabel
		
		lbltotal_bruto = new JLabel("Valor Bruto: ");
		lbltotal_bruto.setFont(new Font("Microsoft PhagsPa",1,15));
		
		
		txttotal_bruto = new JTextField(12);
		txttotal_bruto.setEditable(false);
		
		lbldescuento = new JLabel("Descuento: ");
		lbldescuento.setFont(new Font("Microsoft PhagsPa",1,15));
		
		
		txtdescuento = new JTextField(12);
		txtdescuento.setEditable(true);
		//objeto TextPrompt para poder setiar el texto "fantasme en el JTextField"
		tp7 = new TextPrompt("Descuento en % ", txtdescuento);
		
		lblimpuesto = new JLabel("Impuestos: ");
		lblimpuesto.setFont(new Font("Microsoft PhagsPa",1,15));
		
		
		txtimpuesto = new JTextField(12);
		txtimpuesto.setEditable(false);
		
		lblvalor_neto = new JLabel("Valor Neto: ");
		lblvalor_neto.setFont(new Font("Microsoft PhagsPa",1,15));
		
		txtvalor_neto = new JTextField(12);
		txtvalor_neto.setEditable(false);
		
		panelparabotonestxtylabel.add(lbltotal_bruto);
		panelparabotonestxtylabel.add(txttotal_bruto);
		
		panelparabotonestxtylabel.add(lbldescuento);
		panelparabotonestxtylabel.add(txtdescuento);
		
		panelparabotonestxtylabel.add(lblimpuesto);
		panelparabotonestxtylabel.add(txtimpuesto);
		
		panelparabotonestxtylabel.add(lblvalor_neto);
		panelparabotonestxtylabel.add(txtvalor_neto);
		
		
		
		
		// anadiendo los botones al panelparacentrarbotonesdelpaneldeabajo
		
		panelparacentrarbotonesdelpaneldeabajo = new JPanel(new BorderLayout());
		panelparacentrarbotonesdelpaneldeabajo.setBackground(Color.WHITE);
		panelparacentrarbotonesdelpaneldeabajo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Acciones"));
		
		lblimagenparapaneldelosbotonesabajo = new JLabel(new ImageIcon("imagenes/VMETAICON.png"));
		
		btnguardar = new JButton("Guardar");
		btnguardar.setBackground(Color.WHITE);
		btnguardar.setForeground(new Color(48,138,255));
		
		btnlimpiartodo = new JButton("Limpiar TODO");
		btnlimpiartodo.setBackground(Color.WHITE);
		btnlimpiartodo.setForeground(new Color(48,138,255));
		
		btnAgregarProductoFactura = new JButton("Agregar Producto");
		btnAgregarProductoFactura.setBackground(Color.WHITE);
		btnAgregarProductoFactura.setForeground(new Color(48,138,255));
		
		
		panelparacentrarbotonesdelpaneldeabajo.add(btnlimpiartodo, BorderLayout.NORTH);
		panelparacentrarbotonesdelpaneldeabajo.add(lblimagenparapaneldelosbotonesabajo);
		panelparacentrarbotonesdelpaneldeabajo.add(btnguardar, BorderLayout.SOUTH);
		panelparacentrarbotonesdelpaneldeabajo.add(btnAgregarProductoFactura, BorderLayout.WEST);
		
		panelbotonespestanafacturabajo.add(panelparacentrarbotonesdelpaneldeabajo);
		panelbotonespestanafacturabajo.add(panelparabotonestxtylabel, BorderLayout.EAST);
		
		

		
		
		// Agregando los paneles en el panel factura
		pestanafactura.add(pestanafacturapanel2, BorderLayout.NORTH);
		pestanafactura.add(panelparatabla, BorderLayout.CENTER);
		pestanafactura.add(panelbotonespestanafacturabajo, BorderLayout.SOUTH);
		
		
//---------------------------------------pestana cotizacion--------------------------------------------------------------------
		
		pestanacotizacion = new JPanel();
		pestanacotizacion.setLayout(new BorderLayout());
		pestanacotizacion.setBackground(Color.WHITE);
	
		pestanacotizacionpanel1 = new JPanel();
		pestanacotizacionpanel1.setLayout(new GridLayout(5,3));
		pestanacotizacionpanel1.setBackground(Color.WHITE);
		pestanacotizacionpanel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Datos Cotizaci\u00f3n"));
		
		pestanacotizacionpanel2 = new JPanel();
		pestanacotizacionpanel2.setLayout(new BorderLayout(5,0));
		pestanacotizacionpanel2.setBackground(Color.WHITE);
		

		
		lblnombre_cliente_cotizacion = new JLabel("Nombre del Cliente");
		lblnombre_cliente_cotizacion.setFont(new Font("Microsoft PhagsPa",1,15));
		
		txtnombre_cliente_cotizacion = new JTextField(20);
		
		lblrnc_cotizacion = new JLabel("RNC                    ");
		lblrnc_cotizacion.setFont(new Font("Microsoft PhagsPa",1,15));
		
		txtrnc_cotizacion = new JTextField(17);
		
		lblciudad_cotizacion = new JLabel("ciudad                       ");
		lblciudad_cotizacion.setFont(new Font("Microsoft PhagsPa",1,15));
		
		txtciudad_cotizacion = new JTextField(20);
		
		
		
		lblfechacotizacion = new JLabel("Fecha de Cotizaci\u00f3n");
		lblfechacotizacion.setFont(new Font("Microsoft PhagsPa",1,15));
		
		txtfechacotizacion = new JTextField(17);
		
		lblno_cotizacion = new JLabel("N\u00famero de Cotizaci\u00f3n");
		lblno_cotizacion.setFont(new Font("Microsoft PhagsPa",1,15));
		
		txtno_cotizacion = new JTextField(20);
		
				
		
		
		imagencotizacion = new JLabel(new ImageIcon("imagenes/receive.png"));
		
		pestanacotizacionpanel1.add(lblnombre_cliente_cotizacion);
		pestanacotizacionpanel1.add(txtnombre_cliente_cotizacion);
		
		pestanacotizacionpanel1.add(lblrnc_cotizacion);
		pestanacotizacionpanel1.add(txtrnc_cotizacion);
		
		pestanacotizacionpanel1.add(lblciudad_cotizacion);
		pestanacotizacionpanel1.add(txtciudad_cotizacion);
		
		pestanacotizacionpanel1.add(lblfechacotizacion);
		pestanacotizacionpanel1.add(txtfechacotizacion);
		
		pestanacotizacionpanel1.add(lblno_cotizacion);
		pestanacotizacionpanel1.add(txtno_cotizacion);
		
		
		
		imagencotizacion = new JLabel(new ImageIcon("imagenes/receive.png"));
		
		pestanacotizacionpanel2.add(pestanacotizacionpanel1,BorderLayout.CENTER);
		pestanacotizacionpanel2.add(imagencotizacion, BorderLayout.EAST);
	
		
		//creando una tabla para la cotizacion
		panelparatabla_cotizacion = new JPanel(new BorderLayout());
		panelparatabla_cotizacion.setBackground(Color.WHITE);
		String tbltitulo_cotizacion [] = {"Nombre del producto","C\u00f3digo de Producto ","Precio de (los) producto(s)","Cantidad de productos"};
		tablamodel_cotizacion = new DefaultTableModel(null, tbltitulo_cotizacion);
		tbcotizacion = new JTable(tablamodel_cotizacion);
		
		negro_cotizacion = BorderFactory.createEtchedBorder();
		
		titulobordetabla_cotizacion = BorderFactory.createTitledBorder(negro_cotizacion, "Cotizaci\u00f3n");
		titulobordetabla_cotizacion.setTitleJustification(TitledBorder.LEFT);
		panelparatabla_cotizacion.setBorder(titulobordetabla_cotizacion);
		
		tbcotizacion.setFont(new Font("Microsoft PhagsPa",1,15));
		tbcotizacion.setEnabled(false);
		tbcotizacion.setBackground(Color.WHITE);
		
		TableColumnModel columnModel_Cotizacion = tbcotizacion.getColumnModel();
		columnModel_Cotizacion.getColumn(0).setPreferredWidth(230);
		columnModel_Cotizacion.getColumn(1).setPreferredWidth(200);
		columnModel_Cotizacion.getColumn(2).setPreferredWidth(240);
		columnModel_Cotizacion.getColumn(3).setPreferredWidth(190);
		tbcotizacion.setRowHeight(20);
		tbcotizacion.setAutoResizeMode(tbcotizacion.AUTO_RESIZE_OFF);
		
		tblscroll_cotizacion = new JScrollPane(tbcotizacion, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panelparatabla_cotizacion.add(tblscroll_cotizacion);
		
		JTableHeader  tableHeader_cotizacion =  tbcotizacion.getTableHeader();
		tableHeader_cotizacion.setBackground(Color.WHITE);
		tableHeader_cotizacion.setFont(new Font("Microsoft PhagsPa",1,15));
		tableHeader_cotizacion.setForeground(new Color(48,138,255));
		
//-------------------Panel para tota,descuento_cotizacion,impuesto_cotizacions,neto;
		panelparabotonestxtylabel_cotizacion = new JPanel(new GridLayout(4,2));
		panelparabotonestxtylabel_cotizacion.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Informacion final"));
		panelparabotonestxtylabel_cotizacion.setBackground(Color.WHITE);
		
		
		panelbotonespestanacotizacionbajo = new JPanel(new BorderLayout());
		panelbotonespestanacotizacionbajo.setBackground(Color.WHITE);
		
		//anadiendo los label y txt al panelparabotonestxtylabel_cotizacion
		
		lbltotal_bruto_cotizacion = new JLabel("Valor Bruto: ");
		lbltotal_bruto_cotizacion.setFont(new Font("Microsoft PhagsPa",1,15));
		
		
		txttotal_bruto_cotizacion = new JTextField(12);
		txttotal_bruto_cotizacion.setEditable(false);
		
		lbldescuento_cotizacion = new JLabel("Descuento: ");
		lbldescuento_cotizacion.setFont(new Font("Microsoft PhagsPa",1,15));
		
		
		txtdescuento_cotizacion = new JTextField(12);
		txtdescuento_cotizacion.setEditable(true);
		//objeto TextPrompt para poder setiar el texto "fantasme en el JTextField"
		tp7_cotizacion = new TextPrompt("Ingrese el descuento", txtdescuento_cotizacion);
		
		lblimpuesto_cotizacion = new JLabel("Impuesto: ");
		lblimpuesto_cotizacion.setFont(new Font("Microsoft PhagsPa",1,15));
		
		
		txtimpuesto_cotizacion = new JTextField(12);
		txtimpuesto_cotizacion.setEditable(false);
		
		lblvalor_neto_cotizacion = new JLabel("Valor Neto: ");
		lblvalor_neto_cotizacion.setFont(new Font("Microsoft PhagsPa",1,15));
		
		txtvalor_neto_cotizacion = new JTextField(12);
		txtvalor_neto_cotizacion.setEditable(false);
		
		//anadiendo  los label y los textfields al panel 
		
		panelparabotonestxtylabel_cotizacion.add(lbltotal_bruto_cotizacion);
		panelparabotonestxtylabel_cotizacion.add(txttotal_bruto_cotizacion);
		
		panelparabotonestxtylabel_cotizacion.add(lbldescuento_cotizacion);
		panelparabotonestxtylabel_cotizacion.add(txtdescuento_cotizacion);
		
		panelparabotonestxtylabel_cotizacion.add(lblimpuesto_cotizacion);
		panelparabotonestxtylabel_cotizacion.add(txtimpuesto_cotizacion);
		
		panelparabotonestxtylabel_cotizacion.add(lblvalor_neto_cotizacion);
		panelparabotonestxtylabel_cotizacion.add(txtvalor_neto_cotizacion);
		
		
		
		
		// anadiendo los botones al panelparacentrarbotonesdelpaneldeabajocotizacioncotizacion
		
		panelparacentrarbotonesdelpaneldeabajocotizacion = new JPanel(new BorderLayout());
		panelparacentrarbotonesdelpaneldeabajocotizacion.setBackground(Color.WHITE);
		panelparacentrarbotonesdelpaneldeabajocotizacion.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Acciones"));
		
		lblimagenparapaneldelosbotonesabajocotizacion = new JLabel(new ImageIcon("imagenes/VMETAICON.png"));
		
		btnguardar_cotizacion = new JButton("Guardar");
		btnguardar_cotizacion.setBackground(Color.WHITE);
		btnguardar_cotizacion.setForeground(new Color(48,138,255));
		
		btnAgregarProducto = new JButton("Agregar Producto");
		btnAgregarProducto.setBackground(Color.WHITE);
		btnAgregarProducto.setForeground(new Color(48,138,255));
		
		btnlimpiartodo_cotizacion = new JButton("Limpiar TODO");
		btnlimpiartodo_cotizacion.setBackground(Color.WHITE);
		btnlimpiartodo_cotizacion.setForeground(new Color(48,138,255));
		
		panelparacentrarbotonesdelpaneldeabajocotizacion.add(btnlimpiartodo_cotizacion, BorderLayout.NORTH);
		panelparacentrarbotonesdelpaneldeabajocotizacion.add(lblimagenparapaneldelosbotonesabajocotizacion);
		panelparacentrarbotonesdelpaneldeabajocotizacion.add(btnguardar_cotizacion, BorderLayout.SOUTH);
		panelparacentrarbotonesdelpaneldeabajocotizacion.add(btnAgregarProducto, BorderLayout.WEST);
		
		panelbotonespestanacotizacionbajo.add(panelparacentrarbotonesdelpaneldeabajocotizacion);
		panelbotonespestanacotizacionbajo.add(panelparabotonestxtylabel_cotizacion, BorderLayout.EAST);
		

		
		
		// Agregando los paneles en el panel cotizacion
		pestanacotizacion.add(pestanacotizacionpanel2, BorderLayout.NORTH);
		pestanacotizacion.add(panelparatabla_cotizacion, BorderLayout.CENTER);
		pestanacotizacion.add(panelbotonespestanacotizacionbajo, BorderLayout.SOUTH);
		
		
		
		
//----------------------------------------------	
		
		//anadiendo las pestanas
		panelConFichas.addTab("Factura", null, pestanafactura, "Factura");
		
		panelConFichas.addTab("Cotizaci\u00f3n", null, pestanacotizacion,"Cotizaci\u00f3n");
		panelConFichas.setBackgroundAt(0, Color.WHITE);
	
//------------------------------------------------------------------------------------------------
		// setiando los menuitem al menu
		anadir = new JMenu();

		
		anadir.add(crearFactura);
		anadir.setIcon(new ImageIcon("imagenes/add186.png"));
		
		ver = new JMenu();

		ver.add(verfactura);
		ver.add(vercotizacion);
		ver.setIcon(new ImageIcon("imagenes/view23.png"));
		
		//anadiendo el menu a la barra de menu
		barramenu = new JMenuBar();
		
		barramenu.setBackground(Color.WHITE);
		
		// orientando la barramenu a la derecha
		
		barramenu.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT); 
		 
		barramenu.add(anadir);
		barramenu.add(ver);
		barramenu.add(Box.createHorizontalGlue()); 
		
		// anadiendo la barra de menu a la ventana
		
		setJMenuBar(barramenu);
		
		//creando un panel fabuloso
		
		
		// anadiendo el panel  a la ventana
		add(panelConFichas);
		
		
//------------------------------------------------------------------------------------------
		
	//	DialogoProducto producto = new DialogoProducto(tblProducto,tablaModel);
		
		
		
		ManejaCotizacionEvento eventoCotizacion = new ManejaCotizacionEvento(this, tbcotizacion, tablamodel_cotizacion, columnModel_Cotizacion,txtnombre_cliente_cotizacion,txtrnc_cotizacion,txtciudad_cotizacion,txtfechacotizacion,txtno_cotizacion,txttotal_bruto_cotizacion, txtdescuento_cotizacion,txtimpuesto_cotizacion,txtvalor_neto_cotizacion,lblimagenparapaneldelosbotonesabajocotizacion);
		
		lblimagenparapaneldelosbotonesabajocotizacion.addMouseListener(eventoCotizacion);
		btnguardar_cotizacion.addActionListener(eventoCotizacion);
		btnlimpiartodo_cotizacion.addActionListener(eventoCotizacion);
		btnAgregarProducto.addActionListener(eventoCotizacion);
		//productocotizado.addActionListener(eventoCotizacion);
		vercotizacion.addActionListener(eventoCotizacion);
		
		ManejaFrameEvento evento = new ManejaFrameEvento(this, tblProducto,tablaModel, columnModel,txtnombre_cliente,txtrnc,txtciudad,txtfechacompra,txtno_factura,cbmetodo_compra,txttotal_bruto,txtdescuento,txtimpuesto,txtvalor_neto,lblimagenparapaneldelosbotonesabajocotizacion);

		
		lblimagenparapaneldelosbotonesabajo.addMouseListener(evento);
		btnguardar.addActionListener(evento);
		btnlimpiartodo.addActionListener(evento);
		
		crearFactura.addActionListener(evento);
		verfactura.addActionListener(evento);
		btnAgregarProductoFactura.addActionListener(evento);
		
		
	}
	
	public static void main(String [] args){
		
		// new CompraCotizacion("Luenlu");
		
			
		Login login = new Login(null,"Login",true);
		login.show();
		
	}
	
}