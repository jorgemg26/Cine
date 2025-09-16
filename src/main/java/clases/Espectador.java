package clases;



public class Espectador {
    
    String nombre;
    int edad;
    double dinero;
    int numeroSala;
    
    public Espectador (String nombre, int edad, double dinero, int numeroSala){
        this.nombre=nombre;
        this.edad=edad;
        this.dinero=dinero;
        this.numeroSala=numeroSala;
    }
    
    public String getNombre (){
        return nombre;
    }
    public int getEdad (){
        return edad;
    }
    public double getDinero (){
        return dinero;
    }
    public int getNumeroSala(){
        return numeroSala;
    }
    
    public boolean TieneEdad(int edadMinima){       //Si espectador es mayor o igual sale true. Si es menos sale false
        return edad>=edadMinima;
    }
    
    public boolean TieneDinero(double precio){      //Si espectador tiene mas dinero sale true. Si Espectador no tiene dinero sale false
        return dinero>=precio;
    }
        
    public void MostrarEspectador (){
        System.out.println("nombre: " + nombre + " |" + " Edad: " + edad + " |" + " dinero: " + dinero + " |" + " sala " + numeroSala);
    }
}
