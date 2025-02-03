package juego;

import javax.swing.ImageIcon;

public class Carta {
	private String palabra;
	private ImageIcon imagen;

	public Carta(String p, ImageIcon i) {
		this.palabra = p;
		this.imagen = i;
	}

	public String getPalabra() {
		return this.palabra;
	}

	public boolean sonIguales(Carta c1, Carta c2) {
		if (c1.getPalabra().equals(c2.getPalabra()))
			return true;
		else
			return false;
	}

	// Métodos getter y setter para el atributo imagen
	public ImageIcon getImagen() {
		return this.imagen;
	}

	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}

}
