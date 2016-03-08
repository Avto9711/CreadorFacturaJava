import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.text.JTextComponent;
import javax.swing.table.*;



public class ManejaDialogoEvento extends MouseAdapter implements ActionListener{
	
	private JList list;
	private DefaultListModel listmodel;
	private JTextField txtbuscar;
	private JPopupMenu menuflotante;
	private String idfacturaclick;
	
	private JTextField campousuario;
	private JPasswordField campocontrasena;
	private JFrame ventana;
	private JDialog dialogo;
	
	
	private BaseDatos gestor;
	
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
	
	public ManejaDialogoEvento( JDialog dialogo,JFrame ventana,JTextField campousuario, JPasswordField campocontrasena){
		this.dialogo = dialogo;
		this.ventana = ventana;
		this.campousuario = campousuario;
		this.campocontrasena = campocontrasena;
		
	}
						
	public ManejaDialogoEvento(JDialog dialogo, JList list,JTable tblProducto,DefaultTableModel tablaModel,TableColumnModel columnModel, DefaultListModel listmodel,JTextField txtbuscar, JPopupMenu menuflotante,String idfacturaclick,	JTextField txtnombre_cliente,JTextField txtrnc, JTextField txtciudad, JTextField txtfechacompra, JTextField txtno_factura,JComboBox cbmetodo_compra, JTextField txttotal_bruto, JTextField txtdescuento, JTextField txtimpuesto, JTextField txtvalor_neto){
		
			this.dialogo = dialogo;
			this.list = list;
			this.listmodel = listmodel;
			this.tblProducto = tblProducto;
			this.tablaModel = tablaModel;
			this.columnModel = columnModel;
			this.txtbuscar = txtbuscar;
			this.menuflotante = menuflotante;
			this.idfacturaclick = idfacturaclick;
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
			
			gestor = new BaseDatos();
			gestor.llenarLista("Factura",list, listmodel);
			
	}
	
	public ManejaDialogoEvento(JDialog dialogo){
		
		this.dialogo = dialogo;
	}
	
	public void actionPerformed(ActionEvent e){
		String label = e.getActionCommand();
		
		if(label.equals("AceptarLogin")){
			if(campousuario.getText().equals("admin") && campocontrasena.getText().equals("1234")){
				dialogo.hide();
				 new CompraCotizacion("LUENLU  COMPRA COTIZACION");
				
				
			}else{
				JLabel error = new JLabel("Error, usuario o contrasena incorrectos");
				error.setFont(new Font ("Arial", 4, 15)); 
				JOptionPane.showMessageDialog(null, error, "Aviso",JOptionPane.WARNING_MESSAGE);
			} 
		}
			if (label.equals("Aceptar")){
				dialogo.hide();
				
			}
			
			
						if (label.equals("CancelarLogin")){
						System.out.println("Mielda");
						dialogo.hide();
						System.exit(-1);
					
						
						
					}
							if(label.equals("Cancelar")){
								dialogo.hide();
								
							}
								if (label.equals("Editar")){
								
								}
									if(label.equals("Eliminar")){
										borrarTabla();
										System.out.println(idfacturaclick);
										gestor.eliminar("Factura", Long.parseLong(idfacturaclick));
										gestor.llenarLista("Factura",list, listmodel);

									}
										if(label.equals("Cargar")){
											borrarTabla();
											gestor.cargarFactura(idfacturaclick,txtnombre_cliente,txtrnc, txtciudad, txtfechacompra,txtno_factura, cbmetodo_compra, txttotal_bruto, txtdescuento, txtimpuesto, txtvalor_neto);
											gestor.recargarTabla(idfacturaclick, tblProducto,tablaModel, columnModel);
											deshabilitarCampos();
											
											System.out.print("hola entre en cargar");
											dialogo.hide();
										}
 
	}

	// evento para llenar la tabla con(idfacturaclick) la factura seleccionada (idfacturaclick)
	public void mouseClicked(MouseEvent e){
		
	}

	//evento para que salga el menu flotante
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
					
				}
				menuflotante.show(e.getComponent(), e.getX(), e.getY());
			}
		}
		}catch(Exception error){
			
		}
	}
	
	public void deshabilitarCampos(){
		
	this.txtno_factura.setEditable(false);
	this.txtciudad.setEditable(false);
	this.txtnombre_cliente.setEditable(false);
	this.txtfechacompra.setEditable(false);
	this.txtrnc.setEditable(false);
	this.cbmetodo_compra.setEditable(false);
	this.txttotal_bruto.setEditable(false);
	this.txtdescuento.setEditable(false);
	this.txtimpuesto.setEditable(false);
	this.txtvalor_neto.setEditable(false);
	this.cbmetodo_compra.setEditable(false);
		
	}
	
	public void borrarTabla(){
		for(int i = 0; i<tblProducto.getRowCount(); i++){
			
			((DefaultTableModel)tblProducto.getModel()).removeRow(i);
			//tblProducto.getColumnModel();
			
		}
	}
	

	
}

