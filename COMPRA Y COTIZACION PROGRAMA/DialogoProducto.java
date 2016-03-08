import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.*;
import javax.swing.BorderFactory.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.*;
import javax.swing.table.*;

public class DialogoProducto extends JDialog{
	
	private JFrame ventana;
	
	private JButton btnagregar;
	private JButton btncancelar;
	
	private DefaultTableModel tablaModel;
	private JTable tblProducto;
	private TableColumnModel columnModel;
	
	private String idfacturaclick;
	
	private JLabel  lblnombre_producto; 
	private JLabel  lblcantidad_producto; 
	private JLabel  lblcodigo_producto;
	private JLabel  lblprecio_producto;
	private JLabel  imagen;
	
	int calculoBruto =0;
	int calculoBruto2 = 0;
	
	private JTextField txtno_factura;
	private JTextField txtnombre_producto;
	private JTextField txtcantidad_producto;
	private JTextField txtcodigo_producto;
	private JTextField txtprecio_producto;
	
	private JTextField txttotal_bruto;
	private JTextField txtdescuento;
	private JTextField txtimpuesto;
	private JTextField txtvalor_neto; 

	
	
	private JPanel  panelcentro,panelcentroarriba,panelcentroabajo,panelabajo,panelimagen;
	
	private TitledBorder titulobordepanel;
	private Border negro;
	
	public DialogoProducto(JFrame ventana, String titulo, boolean comportamiento, JTable tblProducto, DefaultTableModel tablaModel,TableColumnModel columnModel,JTextField txtno_factura,JTextField txttotal_bruto, JTextField txtdescuento, JTextField txtimpuesto, JTextField txtvalor_neto){
		super (ventana, titulo, comportamiento);
		this.ventana = ventana;
		this.tblProducto = tblProducto;
		this.tablaModel = tablaModel;
		this.columnModel = columnModel;
		this.txtno_factura = txtno_factura;
		this.txttotal_bruto = txttotal_bruto;
		this.txtdescuento = txtdescuento;
		this.txtimpuesto = txtimpuesto;
		this.txtvalor_neto = txtvalor_neto;
		gui();
		ini();
		
	}
	
	// public DialogoProducto(JTable tblProducto, DefaultTableModel tablaModel){
		// this.tblProducto = tblProducto;
		// this.tablaModel = tablaModel;
	// }
	
	public void ini(){
		
		//setLayout(new BorderLayout());
		
		setSize(670,200);
		setLocationRelativeTo(ventana);
		setResizable(false);
		
		
		
		
	}
	
	public void gui(){
	
//---------------Panel central--------------------------
	panelcentro = new JPanel();
	panelcentro.setLayout(new GridLayout(2,0,-5,-5));
	panelcentro.setBackground(Color.WHITE);
	
	negro = BorderFactory.createEtchedBorder();
	
	titulobordepanel = BorderFactory.createTitledBorder(negro, "Registrar producto");
	titulobordepanel.setTitleJustification(TitledBorder.CENTER);
	titulobordepanel.setTitleColor(new Color(48,138,255));
	
	panelcentro.setBorder(titulobordepanel);
	
//--------------panelcentroarriba--------
	panelcentroarriba  =new JPanel();
	panelcentroarriba.setLayout(new FlowLayout());
	panelcentroarriba.setBackground(Color.WHITE);
	
	
	lblnombre_producto = new JLabel("Nombre Producto ");
	lblnombre_producto.setFont(new Font("Arial",1,15));
	lblnombre_producto.setForeground(new Color(48,138,255));
	
	lblcodigo_producto = new JLabel("  Codigo Producto");
	lblcodigo_producto.setFont(new Font("Arial",1,15));
	lblcodigo_producto.setForeground(new Color(48,138,255));
	
	txtnombre_producto = new JTextField(15);
	txtcodigo_producto = new JTextField(5);
	
	panelcentroarriba.add(lblnombre_producto);
	panelcentroarriba.add(txtnombre_producto);
	panelcentroarriba.add(lblcodigo_producto);
	panelcentroarriba.add(txtcodigo_producto);
	
//--------panel centro abajo---------------------
	panelcentroabajo = new JPanel();
	panelcentroabajo.setLayout(new FlowLayout(FlowLayout.CENTER));
	panelcentroabajo.setBackground(Color.WHITE);
	
	lblprecio_producto = new JLabel("Precio Producto");
	lblprecio_producto.setFont(new Font("Arial",1,15));
	lblprecio_producto.setForeground(new Color(48,138,255));
	
	lblcantidad_producto = new JLabel("Cantidad producto");
	lblcantidad_producto.setFont(new Font("Arial",1,15));
	lblcantidad_producto.setForeground(new Color(48,138,255));
	
	txtprecio_producto = new JTextField(9);
	txtcantidad_producto = new JTextField(5);
	
	panelcentroabajo.add(lblprecio_producto);
	panelcentroabajo.add(txtprecio_producto);
	panelcentroabajo.add(lblcantidad_producto);
	panelcentroabajo.add(txtcantidad_producto);

	
//-----------anandiendo los paneles al panel centro
	panelcentro.add(panelcentroarriba);
	panelcentro.add(panelcentroabajo);
	
//----------------panel abajo-------------------
	panelabajo = new JPanel();
	panelabajo.setBackground(Color.WHITE);
	panelabajo.setLayout(new FlowLayout(FlowLayout.RIGHT));
	
	
	
	btnagregar = new JButton("Agregar Producto");
	
	btncancelar = new JButton("Cancelar");
	//btncancelar.setForeground(new Color(48,138,255));
	
	panelabajo.add(btnagregar);
	panelabajo.add(btncancelar);
	
//-----------panel para imagen---------
	panelimagen = new JPanel();
	panelimagen.setLayout(new BorderLayout());
	panelimagen.setBackground(Color.WHITE);
	imagen = new JLabel(new ImageIcon("imagenes/barcode12.png"));
	panelimagen.add(imagen);
	
//------------anandiendo panel al dialogo---------------

	
		add(panelcentro, BorderLayout.CENTER);
		add(panelabajo, BorderLayout.SOUTH);
		add(panelimagen, BorderLayout.EAST);
		//--------------agregando eventos
		
		btnagregar.setActionCommand("AgregarProducto");
		
		 ManejaDialogoEvento evento = new ManejaDialogoEvento(this);
		btncancelar.addActionListener(evento);
		
		 ManejaFrameEvento eventoFrame = new ManejaFrameEvento(this,tblProducto, tablaModel, columnModel,txtnombre_producto, txtcodigo_producto,txtprecio_producto,txtcantidad_producto,txtno_factura,txttotal_bruto, txtdescuento, txtimpuesto, txtvalor_neto);
		 btnagregar.addActionListener(eventoFrame);

		 
		 txtdescuento.addCaretListener(eventoFrame);
	}
	
	
	
	public static void main(String [] args){
		//new DialogoProducto(null, "Agregar Producto", true);
		
		
	}
	
	
}