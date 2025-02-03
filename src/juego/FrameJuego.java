package juego;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;

public class FrameJuego {

	private JFrame frame;
	private JPanel panelPrincipal;
	private JButton[][] cartas;
	private JLayeredPane layeredPane;
	private int panelWidth = 520;
	private int panelHeight= 350;
	private Timer timer;
	private ArrayList<JButton>parElegido;
	private Map<JButton, String>aciertos;
	private boolean esPrimerCarta=true;


	public FrameJuego(Tablero t) {
	
		frame = new JFrame();
		frame.setBounds(100, 100, 540, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		parElegido=new ArrayList<JButton>();
		aciertos=new HashMap<JButton, String>();
		
		panelPrincipal = new JPanel(new GridLayout(4, 4, 2, 2));
		panelPrincipal.setBounds(30, 10, 472, 350);
		panelPrincipal.setVisible(true);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(panelPrincipal);
		
		cartas=new JButton[t.getDimension()][t.getDimension()];
		
		cargarCartas(panelPrincipal, t);
		
		for (int i = 0; i < cartas.length; i++) {
			for (int j = 0; j < cartas[0].length; j++) {
				final int fil = i;
				final int col = j;
				cartas[i][j].addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						cartas[fil][col].setText(t.getTabla()[fil][col].getPalabra());
						
						mostrarCartaElegida(t, cartas[fil][col], fil, col);
						
						if(esPrimerCarta) {
							primerCartaElegida(cartas[fil][col], t,  fil, col);
							parElegido.add(cartas[fil][col]);
						}
						
						else {
							inhabilitarBoton(cartas[fil][col], t, fil, col);
							parElegido.add(cartas[fil][col]);
							verificarPar(parElegido.get(0), parElegido.get(1));
							inhabilitarCartasNoSeleccionadas(parElegido.get(0), parElegido.get(1), t);
							tiempo(parElegido.get(0), parElegido.get(1));
							//habilitarCartasEnJuego();
						}
							
						

					}
				});
			}
		}
		
		
		
	}

	
//--------------------------------------------------------------------------------------	
	
	public void cambiarPanel(JPanel panel) {
		panel.setVisible(true);
		this.layeredPane.removeAll();
		this.layeredPane.add(panel);
		this.layeredPane.repaint();
		this.layeredPane.revalidate();
	}
	
	
	public void cargarCartas(JPanel p, Tablero t) {
		
	for (int i = 0; i < t.getDimension(); i++) {
		for (int j = 0; j < t.getDimension(); j++) {
			JButton carta = new JButton();
			this.cartas[i][j] = carta;
			carta.setText(t.getTabla()[i][j].getPalabra());
			carta.setFocusPainted(false);
			carta.setContentAreaFilled(false); // para evitar que se muestre cuando pulso
			p.add(carta);

		}

	}
}
	public void primerCartaElegida(JButton b, Tablero t, int fil, int col) {
			
		//	b.setOpaque(false);
		//	b.setBackground(new Color(0, 0, 0, 0));
			inhabilitarBoton(b, t, fil, col);
			this.esPrimerCarta=false;
	}

	
    public ImageIcon escalarImagen(ImageIcon icono, int ancho, int alto) {
        Image imgOriginal = icono.getImage(); // Obtener la imagen del ImageIcon
        Image imgEscalada = imgOriginal.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH); // Escalar la imagen
        return new ImageIcon(imgEscalada); // Devolver el ImageIcon escalado
    }
	
	public void mostrarCartaElegida(Tablero t, JButton b, int fil, int col) {
		if(!t.getTabla()[fil][col].getImagen().equals(null)) {
			System.out.println("tiene imagen");
		}
		
        	
		b.setIcon(escalarImagen(t.getTabla()[fil][col].getImagen(), panelWidth/4, panelHeight/4));
        	
        
	}
	
	public void tiempo(JButton b1, JButton b2) {
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				//inhabilitarBoton(b2);
				if(!verificarPar(b1, b2)) {
					b1.setIcon(null);
					b2.setIcon(null);
					//b1.setEnabled(true);
					//b2.setEnabled(true);
				}
				
				
				esPrimerCarta=true;
				parElegido.remove(0);
				parElegido.remove(1);
				habilitarCartasEnJuego();

			
			}
		});
	
		// Me aseguro de que el Timer se ejecute solo una vez
		timer.setRepeats(false);
		timer.start();
		
	}
	
	public boolean verificarPar(JButton b1, JButton b2) {
			if (b1.getText().equals(b2.getText())) {
				this.aciertos.put(b1, b1.getText());
				this.aciertos.put(b2, b2.getText());
				return true;
				

			} else {
				return false;
			}
	}
	
	public void inhabilitarCartasNoSeleccionadas(JButton b1, JButton b2, Tablero t) {
		for(int i=0; i<this.cartas.length; i++) {
			for(int j=0; j<this.cartas.length; j++) {
				if(!this.aciertos.containsKey(cartas[i][j]) && !cartas[i][j].equals(b1) && !cartas[i][j].equals(b2)) {
					inhabilitarBoton(cartas[i][j], t, i, j);
					
				}
			}
		}
	}
	
	public void habilitarCartasEnJuego() {
		for(int i=0; i<this.cartas.length; i++) {
			for(int j=0; j<this.cartas.length; j++) {
				if(!this.aciertos.containsKey(cartas[i][j])) {
					cartas[i][j].setEnabled(true);
					
				}
			}
		}
	}
	
	public void inhabilitarBoton(JButton b, Tablero t, int fil, int col) {
		b.setEnabled(false);
		b.setDisabledIcon(escalarImagen(t.getTabla()[fil][col].getImagen(),panelWidth/4, panelHeight/4));
	}

	public JFrame getFrame() {
		return this.frame;
	}
	


}
