//import java.awt.Image;

public class Carta {
	private String palabra;
	//private Image imagen;

    public Carta(String p) {
        this.palabra = p;
       // this.imagen = im;
    }

    
    public String getPalabra() {
    	return this.palabra;
    }
    
    public boolean sonIguales(Carta c1, Carta c2) {
    	if(c1.getPalabra().equals(c2.getPalabra()))
    		return true;
    	else
    		return false;
    }
    
   /* // Métodos getter y setter para el atributo imagen
    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }
    */
    
}
