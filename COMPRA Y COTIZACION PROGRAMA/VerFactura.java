import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.awt.*;




public class VerFactura extends JDialog{
	private JPopupMenu menuflotante;
	
	private JMenuItem menuitemeliminar;
	
	private JFrame ventana;
	
	private JScrollPane scrolllist;
	
	private String idfacturaclick;
	private JButton btncargar;
	private JButton btncancelar;
	
	private JLabel imagenarriba;
	
	private JLabel lblbuscar;
	
	private JTextField txtbuscar;
	
	private JPanel panelparalista,panelbotones,panelparaimagen;
	private JList  list;
	private DefaultListModel listmodel;
	
	private TitledBorder titulobordelista;
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
	private JComboBox cbmetodo_compra;

	private DefaultTableModel tablaModel;
	private JTable tblProducto;
	private TableColumnModel columnModel;

	
	
		 

	
	public VerFactura(JFrame ventana, String titulo, boolean comportamiento,JTable tblProducto,DefaultTableModel tablaModel,TableColumnModel columnModel, JTextField txtnombre_cliente,JTextField txtrnc, JTextField txtciudad, JTextField txtfechacompra, JTextField txtno_factura,JComboBox cbmetodo_compra, JTextField txttotal_bruto, JTextField txtdescuento, JTextField txtimpuesto, JTextField txtvalor_neto){
		
	super(ventana, titulo, comportamiento);
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
		
		
		gui();
		ini();
		
		
	}
	
	
	public void ini(){
		
		setSize(450,550);
		setLocationRelativeTo(ventana);
		setResizable(false);
		
	}
	
	public void gui(){
//---------lista y panel---------
		panelparalista = new JPanel();
		panelparalista.setLayout(new BorderLayout()); 
		panelparalista.setBackground(Color.WHITE);
		
		negro = BorderFactory.createEtchedBorder();
		
		titulobordelista = BorderFactory.createTitledBorder(negro, "LISTA DE FACTURAS GUARDADAS POR ID");
		titulobordelista.setTitleJustification(TitledBorder.CENTER);
		titulobordelista.setTitleColor(new Color(48,138,255));
		titulobordelista.setTitleFont(new Font("Microsoft PhagsPa",1,15));
		
		panelparalista.setBorder(titulobordelista);
		
		
		// listmodel = new DefaultListModel<String>();
		
		// for(int i = 0; i<50; i++){
		// listmodel.addElement("554215" + i);
		// }
		
	
		list = new JList();
		
		list.setFont(new Font("Microsoft PhagsPa",1,20));
		list.setForeground(new Color(48,138,255));
		
		scrolllist = new JScrollPane(list);
	
		panelparalista.add(scrolllist);
	
		
//-----------panel botones
		panelbotones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10,4));
		panelbotones.setBackground(Color.WHITE);
		
		lblbuscar = new JLabel("Buscar");
		lblbuscar.setFont(new Font("Microsoft PhagsPa",1,15));
		
		txtbuscar = new JTextField(12);
		
		btncargar = new JButton("Cargar");
		btncargar.setBackground(Color.WHITE);
		btncargar.setForeground(new Color(48,138,255));
		
		btncancelar = new JButton("Cancelar");
		btncancelar.setBackground(Color.WHITE);
		btncancelar.setForeground(new Color(48,138,255));
		
		panelbotones.add(lblbuscar);
		panelbotones.add(txtbuscar);
		panelbotones.add(btncargar);
		panelbotones.add(btncancelar);
		
//-------------------------------------
	panelparaimagen = new JPanel();
	panelparaimagen.setBackground(Color.WHITE);
	
	imagenarriba = new JLabel(new ImageIcon("imagenes/header.png"));
		panelparaimagen.add(imagenarriba);

	// creando popupMenu
		menuflotante = new JPopupMenu();
		
		
		menuitemeliminar = new JMenuItem("Eliminar");
		
		
		menuflotante.add(menuitemeliminar);
		
		
	// anadiendo los paneles al frame
		add(panelparaimagen, BorderLayout.NORTH);
		add(panelparalista, BorderLayout.CENTER);
		add(panelbotones, BorderLayout.SOUTH);
	// Eventos 
	
		Buscar buscar  = new Buscar(txtbuscar,list,listmodel);
		txtbuscar.addKeyListener(buscar);
	
		ManejaDialogoEvento evento = new ManejaDialogoEvento(this,list,tblProducto,tablaModel,columnModel,listmodel,txtbuscar,menuflotante,idfacturaclick,txtnombre_cliente,txtrnc, txtciudad, txtfechacompra,txtno_factura, cbmetodo_compra, txttotal_bruto, txtdescuento, txtimpuesto, txtvalor_neto);
		
		menuitemeliminar.addActionListener(evento);
		list.addMouseListener(evento);
		btncancelar.addActionListener(evento);
		btncargar.addActionListener(evento);
		
	}
	

	
	
	
	
}

