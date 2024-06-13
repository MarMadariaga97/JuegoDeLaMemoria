import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.SystemColor;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Interfaz {

	private JFrame frame;
	private Tablero t = new Tablero();
	private JButton b00;
	private JButton b01;
	private JButton b02;
	private JButton b03;
	private JButton b10;
	private JButton b11;
	private JButton b12;
	private JButton b13;
	private JButton b20;
	private JButton b21;
	private JButton b22;
	private JButton b23;
	private JButton b30;
	private JButton b31;
	private JButton b32;
	private JButton b33;
	private JLayeredPane layeredPane;
	private JLabel JuegoDeLaMemoria;
	private JLabel lblCantJugadores;
	private JButton primerCartaElegida;



	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz window = new Interfaz();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void cambiarPanel(JPanel panel) {
		panel.setVisible(true);
		this.layeredPane.removeAll();
		this.layeredPane.add(panel);
		this.layeredPane.repaint();
		this.layeredPane.revalidate();
	}
	
	public boolean esPrimerCartaElegida(JButton b) {
		if(primerCartaElegida.equals(null)) {
			this.primerCartaElegida=b;
			System.out.println(primerCartaElegida.getText());
			return true;
		}
		
		return false;	
	}

	public Interfaz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	private void initialize() {
		frame = new JFrame();
		frame.setSize(450, 400);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		this.layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 436, 363);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(null);
		
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 0, 436, 250);
		panelPrincipal.setVisible(false);
		panelPrincipal.setLayout(new GridLayout(4, 4, 5, 5));
		frame.getContentPane().add(panelPrincipal);
        
        b00=new JButton();
        b00.setBounds(1, 0, 90, 60);
        b00.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b00.setText(t.getTabla()[0][0].getPalabra());
			//	if(!esPrimerCartaElegida(b00));
					
			}
		});
        panelPrincipal.add(b00);
		
		b01=new JButton();
		b01.setBounds(111, 0, 190, 60);
		b01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b01.setText(t.getTabla()[0][1].getPalabra());
			}
		});
		panelPrincipal.add(b01);
		
		
        
        b12=new JButton();
        b12.setBounds(221, 67, 104, 61);
        b12.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		b12.setText(t.getTabla()[1][2].getPalabra());
        	}
        });
        
        b10=new JButton();
        b10.setBounds(1, 67, 104, 61);
        b10.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		b10.setText(t.getTabla()[1][0].getPalabra());
        	}
        });
        
        b02=new JButton();
        b02.setBounds(221, 0, 104, 61);
        b02.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		b02.setText(t.getTabla()[0][2].getPalabra());
        	}
        });
        panelPrincipal.add(b02);
        
        b03=new JButton();
        b03.setBounds(331, 0, 104, 61);
        b03.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		b03.setText(t.getTabla()[0][3].getPalabra());
        	}
        });
        panelPrincipal.add(b03);
        panelPrincipal.add(b10);
        
        b11=new JButton();
        b11.setBounds(111, 67, 104, 61);
        b11.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		b11.setText(t.getTabla()[1][1].getPalabra());
        	}
        });
        panelPrincipal.add(b11);
        panelPrincipal.add(b12);
        
        b22=new JButton();
        b22.setBounds(221, 134, 104, 61);
        b22.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		b22.setText(t.getTabla()[2][2].getPalabra());
        	}
        });
        
        b13=new JButton();
        b13.setBounds(331, 67, 104, 61);
        b13.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		b13.setText(t.getTabla()[1][3].getPalabra());
        	}
        });
        panelPrincipal.add(b13);
        
        b20=new JButton();
        b20.setBounds(1, 134, 104, 61);
        b20.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		b20.setText(t.getTabla()[2][0].getPalabra());
        	}
        });
        panelPrincipal.add(b20);
        
        b21=new JButton();
        b21.setBounds(111, 134, 104, 61);
        b21.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		b21.setText(t.getTabla()[2][1].getPalabra());
        	}
        });
        panelPrincipal.add(b21);
        panelPrincipal.add(b22);
        
        
        b31=new JButton();
        b31.setBounds(111, 201, 104, 61);
        b31.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		b31.setText(t.getTabla()[3][1].getPalabra());
        	}
        });
        
        b23=new JButton();
        b23.setBounds(331, 134, 104, 61);
        b23.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		b23.setText(t.getTabla()[2][3].getPalabra());
        	}
        });
        panelPrincipal.add(b23);
        
        b30=new JButton();
        b30.setBounds(1, 201, 104, 61);
        b30.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		b30.setText(t.getTabla()[3][0].getPalabra());
        	}
        });
        panelPrincipal.add(b30);
        panelPrincipal.add(b31);
        
        b32=new JButton();
        b32.setBounds(221, 201, 104, 61);
        b32.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		b32.setText(t.getTabla()[3][2].getPalabra());
        	}
        });
        panelPrincipal.add(b32);
        
        b33=new JButton();
        b33.setBounds(331, 201, 104, 61);
        b33.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		b33.setText(t.getTabla()[3][3].getPalabra());
        	}
        });
        panelPrincipal.add(b33);
        
		
		frame.getContentPane().add(panelPrincipal);
		
		JLabel lblfondo = new JLabel(new ImageIcon("src/Imagenes/fondoAzul.jpg"));
		lblfondo.setBounds(0, 0, 436, 363);
		
		JPanel panelPresentacion = new JPanel();
		panelPresentacion.setBounds(0, 0, 436, 363);
		frame.getContentPane().add(panelPresentacion);
		panelPresentacion.setLayout(null);
		panelPresentacion.add(lblfondo);
		
		JuegoDeLaMemoria = new JLabel("               JUEGO DE LA MEMORIA");
		JuegoDeLaMemoria.setBounds(10, 45, 416, 85);
		JuegoDeLaMemoria.setForeground(new Color(255, 255, 255));
		JuegoDeLaMemoria.setFont(new Font("Arial Black", Font.BOLD, 18));
		
		lblCantJugadores = new JLabel("Ingrese la cantidad de jugadores");
		lblCantJugadores.setForeground(new Color(255, 255, 255));
		lblCantJugadores.setBackground(new Color(255, 255, 255));
		lblCantJugadores.setFont(new Font("Arial", Font.PLAIN, 16));
		lblCantJugadores.setBounds(105, 193, 264, 48);
		
			
			JComboBox<String> comboBox = new JComboBox<String>();
			comboBox.addItem("1");
			comboBox.addItem("2");
			comboBox.setBounds(158, 252, 108, 22);
			
			JButton btnJugar = new JButton("Jugar");
			btnJugar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panelPresentacion.setVisible(false);
					cambiarPanel(panelPrincipal);
				}
			});
			btnJugar.setForeground(SystemColor.black);
			btnJugar.setBackground(SystemColor.white);
			btnJugar.setFont(new Font("Arial", Font.PLAIN, 16));
			btnJugar.setBounds(168, 303, 89, 23);
			
			
			lblfondo.add(JuegoDeLaMemoria, BorderLayout.CENTER);
			lblfondo.add(lblCantJugadores, BorderLayout.CENTER);
			lblfondo.add(comboBox, BorderLayout.CENTER);
			lblfondo.add(btnJugar, BorderLayout.CENTER);
        

        
		
		
	}
}
