package juego;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

public class FrameJuego {

	private JFrame frame;
	private JPanel panelPrincipal;
	private Map<JButton, Point> cartas;
	private JLayeredPane layeredPane;
	private int panelWidth = 520;
	private int panelHeight = 350;
	private Timer timer;
	private ArrayList<JButton> parElegido;
	private Map<JButton, String> aciertos;
	private boolean esPrimerCarta = true;
	private int aciertosJugador1=0;
	private int aciertosJugador2=0;
	private boolean aciertoJ1=false;
	private boolean aciertoJ2=false;
	private JLabel aciertosJ1;
	private JLabel aciertosJ2;

	
	public FrameJuego(Tablero t) {

		frame = new JFrame();
		frame.setBounds(100, 100, 540, 605);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(new Color(203, 186, 160));
		frame.setVisible(true);

		parElegido = new ArrayList<JButton>();
		aciertos = new HashMap<JButton, String>();

		panelPrincipal = new JPanel(new GridLayout(4, 4, 2, 2));
		panelPrincipal.setBounds(30, 10, 472, 350);
		panelPrincipal.setVisible(true);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(panelPrincipal);

		cartas = new HashMap<JButton, Point>();

		cargarCartas(panelPrincipal, t);
		
		JPanel panelTurnos = new JPanel();
		panelTurnos.setBounds(30, 381, 472, 176);
		frame.getContentPane().add(panelTurnos);
		panelTurnos.setLayout(null);
		panelTurnos.setBackground(new Color(203, 186, 160));
		
		JLabel turnoDe = new JLabel("Turno de: ");
		turnoDe.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		turnoDe.setBounds(25, 5, 69, 26);
		panelTurnos.add(turnoDe);
		
		JLabel nombreTurno = new JLabel("Jugador 1");
		nombreTurno.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		nombreTurno.setBounds(93, 5, 79, 26);
		panelTurnos.add(nombreTurno);
		
		JLabel ganador = new JLabel("Ganador/a: ");
		ganador.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		ganador.setBounds(121, 74, 79, 26);
		ganador.setVisible(false);
		panelTurnos.add(ganador);
		
		JLabel nombreGanador = new JLabel("");
		nombreGanador.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		nombreGanador.setBounds(203, 74, 104, 26);
		panelTurnos.add(nombreGanador);
		
		aciertosJ1 = new JLabel("Aciertos jugador 1:");
		aciertosJ1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		aciertosJ1.setBounds(258, 5, 129, 26);
		panelTurnos.add(aciertosJ1);
		
		JLabel cantAciertosJ1 = new JLabel("0");
		cantAciertosJ1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		cantAciertosJ1.setBounds(393, 5, 69, 26);
		panelTurnos.add(cantAciertosJ1);
		
		JLabel cantAciertosJ2 = new JLabel("0");
		cantAciertosJ2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		cantAciertosJ2.setBounds(393, 42, 69, 26);
		panelTurnos.add(cantAciertosJ2);

		
		aciertosJ2 = new JLabel("Aciertos jugador 2:");
		aciertosJ2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		aciertosJ2.setBounds(258, 42, 129, 26);
		panelTurnos.add(aciertosJ2);
		
		JButton btnVolverAJugar = new JButton("VOLVER A JUGAR");
		btnVolverAJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reiniciarJuego();
			}
		});
		btnVolverAJugar.setBounds(153, 121, 170, 32);
		panelTurnos.add(btnVolverAJugar);
		btnVolverAJugar.setBackground(new Color(203, 186, 160));
		btnVolverAJugar.setForeground(new Color(0, 74, 173));
		btnVolverAJugar.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		btnVolverAJugar.setVisible(false);
		
		
		for(Map.Entry<JButton, Point> carta : cartas.entrySet()) {
			JButton b=carta.getKey();
			int posX= carta.getValue().x;
			int posY= carta.getValue().y;
			
			b.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					b.setText(t.getTabla()[posX][posY].getPalabra());
						
					deshabilitarCarta(b, t, carta.getValue());
					mostrarCartaElegida(t, b, posX, posY);
					
					
					
					if (esPrimerCarta) {
						esPrimerCarta = false;
						parElegido.add(b);
					}

					else {
						parElegido.add(b);
						tiempo(parElegido.get(0), parElegido.get(1), t, nombreTurno, () -> {
						    cambioTurno(nombreTurno, cantAciertosJ1, cantAciertosJ2);

						    if((aciertosJugador1 + aciertosJugador2) == 8) {
						        System.out.println(aciertosJugador1 + aciertosJugador2);
						        turnoDe.setVisible(false);
								nombreTurno.setVisible(false);
								btnVolverAJugar.setVisible(true);
						        getResultado(nombreGanador, ganador);
						    }
						});
					}
					
					
								
					
					
				}
			});
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

	public void cargarCartas(JPanel panel, Tablero t) {
	

		for (int i = 0; i < t.getDimension(); i++) {
			for (int j = 0; j < t.getDimension(); j++) {
				Point p= new Point(i, j);
				JButton carta = new JButton();
				this.cartas.put(carta, p);
				carta.setText(t.getTabla()[i][j].getPalabra());
				carta.setFocusPainted(false);
				carta.setContentAreaFilled(false); // para evitar que se muestre cuando pulso
				carta.setBackground(new Color(0, 74, 171));
				panel.add(carta);

			}

		}
	}

	public ImageIcon escalarImagen(ImageIcon icono, int ancho, int alto) {
		Image imgOriginal = icono.getImage(); // Obtener la imagen del ImageIcon
		Image imgEscalada = imgOriginal.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH); // Escalar la imagen
		return new ImageIcon(imgEscalada); // Devolver el ImageIcon escalado
	}

	public void mostrarCartaElegida(Tablero t, JButton b, int fil, int col) {
		b.setIcon(escalarImagen(t.getTabla()[fil][col].getImagen(), panelWidth / 4, panelHeight / 4));
}

	public boolean verificarPar(JButton b1, JButton b2) {
		if (b1.getText().equals(b2.getText())) {
			this.aciertos.put(b1, b1.getText());
			this.aciertos.put(b2, b2.getText());
			return true;

		} else 
			return false;
		
	}
	
	
	public void tiempo(JButton b1, JButton b2, Tablero t, JLabel j,  Runnable callback) {
		
		deshabilitarCartas();
		
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				if (!verificarPar(b1, b2)) {
						b1.setIcon(null);
						b2.setIcon(null);
						aciertoJ1=false;
						aciertoJ2=false;
						
				}
				
				else {
					deshabilitarCarta(b2, t, cartas.get(b2));

					if(j.getText().equals("Jugador 1")) {
						aciertoJ1=true;
						
						aciertosJugador1+=1;
						System.out.println("punto J1 metodo time "+aciertosJugador1);
						System.out.println(aciertoJ1);
				}
					else {
						aciertoJ2=true;
						aciertosJugador2+=1;
						System.out.println("punto J2 metodo time "+aciertosJugador2);
						System.out.println(aciertoJ2);
					}
				}		

					
				
						
				

				

				esPrimerCarta = true;
				parElegido.remove(1);
				parElegido.remove(0);
				
				//habilitarCartasEnJuego(b1, b2);
				habilitarCartas();
	            if (callback != null) {
	                callback.run();
	            }
			}
			
			
		});

		// Me aseguro de que el Timer se ejecute solo una vez
		timer.setRepeats(false);
		timer.start();

	}

	
	private void habilitarCartas() {
	    for (JButton carta : cartas.keySet()) {
	        if (!aciertos.containsKey(carta)) {
	            carta.setEnabled(true);
	        }
	    }
	}
	
	
	  public void deshabilitarCarta(JButton b, Tablero t, Point p) {
		b.setEnabled(false);
		b.setDisabledIcon(escalarImagen(t.getTabla()[p.x][p.y].getImagen(), panelWidth / 4, panelHeight / 4));
	}
	
	  private void deshabilitarCartas() {
		    // Deshabilitar todas las cartas mientras se espera
		    for (JButton carta : cartas.keySet()) {
		        carta.setEnabled(false);
		        carta.setDisabledIcon(carta.getIcon()); // Mantiene la imagen cuando está deshabilitado
		        //carta.setOpaque(false);
		        carta.setContentAreaFilled(false);
		    }
		}

	public JButton getButton(Point pos) {
		for(Map.Entry<JButton, Point> b : cartas.entrySet()) {
			if(b.getValue().equals(pos)) {
				return b.getKey();
			}
		}
		
		return null;
	}
	
	public JLabel getAciertosJ1() {
		return aciertosJ1;
	}
	
	public void cambioTurno(JLabel j, JLabel aciertosJ1, JLabel aciertosJ2) {
		if(j.getText().equals("Jugador 1") && aciertoJ1==false) 
			j.setText("Jugador 2");
			
		
		
		else if(j.getText().equals("Jugador 1") && aciertoJ1==true) {
				aciertosJ1.setText(Integer.toString(aciertosJugador1));
				aciertosJ1.revalidate();
				aciertosJ1.repaint();
			
		}
			
		
		else if(j.getText().equals("Jugador 2") && aciertoJ2==false) 
			j.setText("Jugador 1");
		
		else if(j.getText().equals("Jugador 2") && aciertoJ2==true) {
				aciertosJ2.setText(Integer.toString(aciertosJugador2));
				aciertosJ2.revalidate();
				aciertosJ2.repaint();
		}
			
		
	}
	
	public void getResultado(JLabel n, JLabel g) {
		
			if(aciertosJugador1==4) {
				n.setText("EMPATE");
			}
			
			else {
				if(aciertosJugador1>aciertosJugador2) {
					g.setVisible(true);
					n.setText("Jugador 1");
				}
					
			
				else {
					g.setVisible(true);
					n.setText("Jugador 2");
				}
					
			}
		
	}
	

	public void reiniciarJuego() {
		  frame.dispose(); // Cierra la ventana actual
		  SwingUtilities.invokeLater(() -> new FrameJuego(new Tablero()));
	}
	
	
	public JFrame getFrame() {
		return this.frame;
	}
}
