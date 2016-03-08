import javax.swing.*;
import java.awt.*;



public class Login extends JDialog {
	
	private JButton btnaceptar;
	private JButton btncancelar;
	private JPanel panelcentralloginarriba;
	private JPanel panelcentralloginabajo;
	private JPanel panelcentral;
	private JTextField campousuario;
	private JPasswordField campocontrasena;
	private JLabel lblusuario;
	private JLabel lblcontrasena;
	private JLabel imagenlogin;
	private JPanel panelimagenarriba;
	private JPanel panelbotonesabajo;
	private JLabel imagenarriba;
	private JPanel panelimagenlogin;
	private JFrame ventana;
	
	
	
	
	public Login(JFrame ventana,String titulo, boolean comportamiento){
		super(ventana, titulo, comportamiento);
		this.ventana = ventana;
		gui();
		ini();
	}
		
	public Login(){
		
	}
	
	public void ini(){
		setSize(298,243);
		setLocationRelativeTo(ventana);
		setBackground(Color.WHITE);
		Image imagenicono = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Key60.png"));
		setIconImage(imagenicono);
		
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
		
		
		
		
		//creando mis paneles
		panelcentral = new JPanel(new GridLayout(2,0,-2,-2));
		panelcentralloginarriba = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelcentralloginabajo = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		
		panelimagenarriba = new JPanel();
		panelbotonesabajo = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelimagenlogin = new JPanel();
		
		// creando mis texts fields
		
		campousuario = new JTextField(10);
		campocontrasena = new JPasswordField(10);
		
		// creando mi label usuario 
		
		lblusuario = new JLabel("Usuario      ");
		lblusuario.setFont(new Font("Arial", 1, 15));
		
		// creando mi label contrasena
		
		lblcontrasena = new JLabel("Contrase\u00f1a");
		lblcontrasena.setFont(new Font("Arial", 1, 15));
		
		// anandiendo los componentes a mi Panel de arriba
		panelcentralloginarriba.setBackground(Color.WHITE);
		panelcentralloginarriba.add(lblusuario);
		panelcentralloginarriba.add(campousuario);
		
		// creando mi panel de abajo
		panelcentralloginabajo.setBackground(Color.WHITE);
		panelcentralloginabajo.add(lblcontrasena);
		panelcentralloginabajo.add(campocontrasena);
		
		//anadiendo a mi panel central mis  2 paneles (arriba y abajo)
		
		panelcentral.setBackground(Color.WHITE);
		panelcentral.add(panelcentralloginarriba);
		panelcentral.add(panelcentralloginabajo);
		
		//anadiendo el label de arriba al panel de arriba 
		
		imagenlogin = new JLabel(new ImageIcon("headerlogin.png"));
		
		
		panelimagenarriba.add(imagenlogin);
		panelimagenarriba.setBackground(Color.WHITE);
		
		
		
		//anandiendo al panel de abajo mis botones fabulosos
		
		btnaceptar = new JButton("Aceptar");
		btncancelar = new JButton("Cancelar");
		
		btnaceptar.setBackground(Color.WHITE);
		btnaceptar.setForeground(Color.BLACK);
		
		btncancelar.setBackground(Color.WHITE);
		btncancelar.setForeground(Color.BLACK);
		btncancelar.setActionCommand("CancelarLogin");
		
		panelbotonesabajo.setBackground(new Color(27,158,228));
		panelbotonesabajo.add(btnaceptar);
		panelbotonesabajo.add(btncancelar);
		
		// anadiendo mi foto del login a un panel 
		imagenlogin = new JLabel(new ImageIcon("login14.png"));
		panelimagenlogin.setBackground(Color.WHITE);
		panelimagenlogin.add(imagenlogin);
		// anadir imagen al logon
		
		
		
		// anadir los paneles al dialogo
		this.add(panelimagenarriba, BorderLayout.NORTH);
		this.add(panelcentral);
		this.add(panelbotonesabajo, BorderLayout.SOUTH);
		this.add(panelimagenlogin, BorderLayout.EAST);
		
		// asignando mis eventos a botones
		
		// mandando mis eventos
		btnaceptar.setActionCommand("AceptarLogin");
		
		ManejaDialogoEvento evento = new ManejaDialogoEvento(this,ventana,campousuario, campocontrasena);
		btnaceptar.addActionListener(evento);
		btncancelar.addActionListener(evento);
		
	}
	
	public static void main(String [] args){
		new Login(null, "Login", true);
		
	}

	
	
	
	
	
}