
package fundamentos;

public class Automotor {
    private int NumeroLlantas;
    private int PosicionX;
    private String Marca;
    private boolean EstaEncendido;
    
    public void setLlantas (int NumeroLlantas) {
        this.NumeroLlantas = NumeroLlantas;
    }
    
    public void Encender () {
        if (this.EstaEncendido) {
            System.out.println("¡Ya esta encendido!" + " " + this.NumeroLlantas);
        } else {
            this.EstaEncendido = true;
            System.out.println("Listo, ¡Ya esta encendido!" + " " + this.NumeroLlantas);
            }
        }
    public void Apagar () {
        if (this.EstaEncendido) {
            System.out.println("Apagando" + " " + this.NumeroLlantas);
            this.EstaEncendido = false;
            
        }
        else {
            System.out.println("Ya esta apagado" + " " + this.NumeroLlantas);
            this.EstaEncendido = false;
            
        }
        
    }
    }
    
