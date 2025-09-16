package clases;



public class Asiento {
    
    int numeroSala;
    char letra;
    int fila;
    Espectador espectador;      //Informacion del espectador sentado en el asiento. Si esta vacio es null
    
    public Asiento (int numeroSala, char letra, int fila){
        this.numeroSala=numeroSala;
        this.letra=letra;
        this.fila=fila;
        this.espectador=null;
    }

    Asiento(char c, int fila) {
        throw new UnsupportedOperationException(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public int getNumeroSala(){
        return numeroSala;
    }
    public char getLetra(){
        return letra;
    }
    public int getFila(){
        return fila;
    }
    public String FilaString(){     //Para comparar letras
        return "" + fila;
    }
    public Espectador getEspectador(){
        return espectador;
    }
    
    public void setEspectador(Espectador espectador){
        this.espectador=espectador;
    }
    
    public int EdadEspectador(){
        return espectador.getEdad();
    }
    
    public boolean ocupado(){       //Si espectador esta sentado sale false. Si el espectador no esta sentado sale true
        return espectador!=null;
    }
    
    public String getAsiento(){
        return "" + numeroSala + fila + letra;
    }
    
    public void MostrarAsiento(){       //El espectador sale null si esta vacio el asiento. Si esta ocupado salen los datos del espectador
        System.out.println(numeroSala + " " + letra + " " + fila + " " + espectador);
    }
}
