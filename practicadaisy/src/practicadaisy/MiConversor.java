package practicadaisy;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MiConversor {

	private JFrame frmConversorDeMonedas;
	private JTextField valor;
	private JComboBox<Moneda> opciones;
	private JLabel resultado;
	
	public enum Moneda{
		pesos_dolar,
		pesos_euro,
		pesos_bolivar,
		dolar_pesos,
		euro_pesos,
		bolivar_pesos
	}
	
	public double dolar = 820;
	public double euro = 918;
	public double bolivar = 0.0353;
	
	public double valorInput = 0.00;
	private JButton botonConvertir;
	private JButton botonSalir;
	private JMenuBar menuBar_1;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MiConversor window = new MiConversor();
					window.frmConversorDeMonedas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MiConversor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConversorDeMonedas = 	new JFrame();
		frmConversorDeMonedas.setForeground(Color.PINK);
		frmConversorDeMonedas.setTitle("                                       CONVERSOR DE MONEDAS");
		frmConversorDeMonedas.setBackground(new Color(238, 130, 238));
		frmConversorDeMonedas.setBounds(100, 100, 678, 354);
		frmConversorDeMonedas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConversorDeMonedas.getContentPane().setLayout(null);
		
		valor = new JTextField();
		valor.setFont(new Font("Arial", Font.PLAIN, 12));
		valor.setBackground(Color.WHITE);
		valor.setBounds(48, 82, 123, 20);
		frmConversorDeMonedas.getContentPane().add(valor);
		valor.setColumns(10);
		
		opciones = new JComboBox<Moneda>();
		opciones.setModel(new DefaultComboBoxModel<Moneda>(Moneda.values()));
		opciones.setBounds(48, 119, 123, 22);
		frmConversorDeMonedas.getContentPane().add(opciones);
		
		// evento boton
		botonConvertir = new JButton("Convertir");
		botonConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonConvertir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Convertir();
			}
		});
		botonConvertir.setBounds(185, 119, 89, 23);
		frmConversorDeMonedas.getContentPane().add(botonConvertir);
		
		resultado = new JLabel("00.00");
		resultado.setBounds(185, 82, 89, 20);
		frmConversorDeMonedas.getContentPane().add(resultado);
		
		JLabel lblNewLabel = new JLabel("INGRESE MONTO ");
		lblNewLabel.setBackground(Color.CYAN);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(117, 44, 113, 16);
		frmConversorDeMonedas.getContentPane().add(lblNewLabel);
		
		botonSalir = new JButton("SALIR");
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		botonSalir.setBounds(114, 170, 85, 21);
		frmConversorDeMonedas.getContentPane().add(botonSalir);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\dyp27\\OneDrive\\Imágenes\\IMAGENES DAISY\\monedas.jpeg"));
		lblNewLabel_1.setBounds(400, 44, 206, 197);
		frmConversorDeMonedas.getContentPane().add(lblNewLabel_1);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(144, 12, 101, 22);
		frmConversorDeMonedas.getContentPane().add(menuBar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mntmNewMenuItem.setBounds(20, 26, 32, 20);
		frmConversorDeMonedas.getContentPane().add(mntmNewMenuItem);
		
		menuBar_1 = new JMenuBar();
		frmConversorDeMonedas.setJMenuBar(menuBar_1);
		
		mnNewMenu = new JMenu("COLORES");
		menuBar_1.add(mnNewMenu);
		
		mntmNewMenuItem_1 = new JMenuItem("gris ");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			private Frame contentPane;

			public void actionPerformed(ActionEvent e) {
				contentPane = null;
				contentPane.setBackground(Color.LIGHT_GRAY);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
	}
	
	// funcion del boton
	public void Convertir() {
		// validacion de números
		if(Validar(valor.getText())) {
			Moneda moneda = (Moneda) opciones.getSelectedItem();
			
			switch (moneda) {
			
			case pesos_dolar: 
				PesosAMoneda(dolar);
				break;
			case pesos_euro: 
				PesosAMoneda(euro);
				break;
			case pesos_bolivar: 
				PesosAbolivar(bolivar);
				break;
			case dolar_pesos: 
				MonedaAPesos(dolar);
				break;
			case euro_pesos: 
				MonedaAPesos(euro);
				break;
			case bolivar_pesos: 
				bolivarAPesos(bolivar);
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + moneda);
			
			}		
		}
	}
	
	private void bolivarAPesos(double bolivar2) {
		// TODO Auto-generated method stub
		double res = valorInput * bolivar;
		resultado.setText(Redondear(res));
	}

	private void PesosAbolivar(double bolivar2) {
		// TODO Auto-generated method stub
		double res = valorInput * bolivar;
		resultado.setText(Redondear(res));
	}

	public void PesosAMoneda(double moneda) {
		double res = valorInput / moneda;
		resultado.setText(Redondear(res));
	}
	
	public void MonedaAPesos(double moneda) {
		double res = valorInput * moneda;
		resultado.setText(Redondear(res));
	}
	
	// redondear decimales
	public String Redondear(double valor) {
		DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.HALF_UP);
		return df.format(valor);
	}
	
	// validar input
	public boolean Validar(String texto) {
		try {
			double x = Double.parseDouble(texto);
			if(x > 0);
			valorInput = x;
			return true;
		}catch(NumberFormatException e) {
			resultado.setText("Solamente números !!");
			return false;
		}
	}
}