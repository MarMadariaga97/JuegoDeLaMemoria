package juego;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;

public class FramePrincipal {

	private JFrame frame;
	private JPanel panel;

	public FramePrincipal(Tablero t) {
		frame = new JFrame();
		frame.setBounds(100, 100, 540, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		panel = new Panel();
		panel.setBackground(new Color(18, 17, 17));
		panel.setBounds(0, 0, 530, 443);
		frame.setContentPane(panel);
		panel.setLayout(null);
		
		JButton btnJugar = new JButton("JUGAR");
		btnJugar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				FrameJuego f = new FrameJuego(t);
				cambiarFrame(f.getFrame());
			}
			
		});
		btnJugar.setBackground(new Color(203, 186, 160));
		btnJugar.setForeground(new Color(0, 74, 173));
		btnJugar.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		btnJugar.setBounds(205, 393, 105, 29);
		panel.add(btnJugar);
	}

	
	public class Panel extends JPanel{
		@Override
		public void paint(Graphics g) {
			
			ImageIcon imagen= new ImageIcon("src/imagenes/fon.jpg");
			g.drawImage(imagen.getImage(), 0, 0, getWidth(), getHeight(),this);
			
			setOpaque(false);
			super.paint(g);
			
		}
	}
	
	public void cambiarFrame(JFrame otro) {
		this.frame.setVisible(false);
		otro.setVisible(true);
	}

	public JFrame getFrame() {
		return this.frame;
	}
}
