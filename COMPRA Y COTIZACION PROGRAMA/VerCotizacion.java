import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.awt.*;

import java.awt.*;
public class VerCotizacion extends JDialog{
	private JPopupMenu menuflotante;
	
	
	private JMenuItem menuitemeliminar;
	private JMenuItem menuitemeditar;

	private String idfacturaclick;

	private JFrame ventana;
	
	private JScrollPane scrolllist;
	
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
	
	
	private JTextField txtno_cotizacion;
	private JTextField txtciudad_cotizacion;
	private JTextField txtnombre_cliente_cotizacion;
	private JTextField txtfechacotizacion;
	private JTextField txtrnc_cotizacion;
	private JTextField txttotal_bruto_cotizacion;
	private JTextField txtdescuento_cotizacion;
	private JTextField txtimpuesto_cotizacion;
	private JTextField txtvalor_neto_cotizacion;
	
	private JTable tbcotizacion;
	private DefaultTableModel tablamodel_cotizacion;
	private TableColumnModel columnModel_Cotizacion;
	
	
	public VerCotizacion(JFrame ventana, String titulo, boolean comportamiento,JTable tbcotizacion,DefaultTableModel tablamodel_cotizacion,TableColumnModel columnModel_Cotizacion, JTextField txtnombre_cliente_cotizacion,JTextField txtrnc_cotizacion, JTextField txtciudad_cotizacion, JTextField txtfechacotizacion, JTextField txtno_cotizacion, JTextField txttotal_bruto_cotizacion, JTextField txtdescuento_cotizacion, JTextField txtimpuesto_cotizacion, JTextField txtvalor_neto_cotizacion){
		
	super(ventana, titulo, comportamiento);
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
		
		titulobordelista = BorderFactory.createTitledBorder(negro, "LISTA DE COTIZACIONES GUARDADAS POR ID");
		titulobordelista.setTitleJustification(TitledBorder.CENTER);
		titulobordelista.setTitleColor(new Color(48,138,255));
		titulobordelista.setTitleFont(new Font("Microsoft PhagsPa",1,15));
		
		panelparalista.setBorder(titulobordelista);
		
		
		listmodel = new DefaultListModel<String>();
		
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
	
	imagenarriba = new JLabel(new ImageIcon("imagenes/headercotizacion.png"));
		panelparaimagen.add(imagenarriba);

	// anadiendo los paneles al frame
		add(panelparaimagen, BorderLayout.NORTH);
		add(panelparalista, BorderLayout.CENTER);
		add(panelbotones, BorderLayout.SOUTH);
		
		//-------------------------------------
		
		menuflotante = new JPopupMenu();
		
		//menuitemeditar = new JMenuItem("Editar");
		menuitemeliminar = new JMenuItem("Eliminar");
		
		menuflotante.add(menuitemeliminar);
		BuscarCotizacion buscar  = new BuscarCotizacion(txtbuscar,list,listmodel);
		txtbuscar.addKeyListener(buscar);
		
		ManejaDialogoEvento cerrar = new ManejaDialogoEvento(this);
		btncancelar.addActionListener(cerrar);
	
		ManejaCotizacionEvento eventoCotizacion = new ManejaCotizacionEvento(this,list,tbcotizacion,tablamodel_cotizacion,columnModel_Cotizacion,listmodel,txtbuscar,menuflotante,idfacturaclick,txtnombre_cliente_cotizacion,txtrnc_cotizacion, txtciudad_cotizacion, txtfechacotizacion,txtno_cotizacion, txttotal_bruto_cotizacion, txtdescuento_cotizacion, txtimpuesto_cotizacion, txtvalor_neto_cotizacion);
		
		menuitemeliminar.addActionListener(eventoCotizacion);
		list.addMouseListener(eventoCotizacion);
		btncancelar.addActionListener(eventoCotizacion);
		btncargar.addActionListener(eventoCotizacion); 
		
		}
	

	
	
	
}
