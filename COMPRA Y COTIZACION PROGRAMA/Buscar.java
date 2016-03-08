	import java.awt.event.*;
	import javax.swing.*;
	public class Buscar extends KeyAdapter{
	
	private JTextField txtbuscar;
	private JList  list;
	private DefaultListModel listmodel;
	
	
	public Buscar(JTextField txtbuscar, JList list, DefaultListModel listmodel){
		this.txtbuscar = txtbuscar;
		this.list = list;
		this.listmodel = listmodel;
	}
	
	public void keyReleased(KeyEvent e){
		
		BaseDatos gestor = new BaseDatos();
		gestor.buscar("Factura", (txtbuscar.getText()), list, listmodel);
		
	}
			
	
}