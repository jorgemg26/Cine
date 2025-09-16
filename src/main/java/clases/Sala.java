package clases;

import java.util.ArrayList;

public class Sala {
    
    int numeroSala; 
    ArrayList <Asiento> asientos = new ArrayList <>();
    Pelicula pelicula;
    
    public Sala (int numeroSala, int columnas, int filas, Pelicula pelicula){       //Cuando demos valores, daremos la dimension de la matriz
        this.numeroSala=numeroSala;
        for (int i=0; i<columnas; i++){      //Creamos los asientos de la sala (que es un ArrayList) asi que cargamos el ArrayList de asientos
            char columna = (char)('A'+i);
            for(int j=filas; j>=1; j--){
                asientos.add(new Asiento (numeroSala, columna, j));
            }
        }
        this.pelicula=pelicula;
    }

    public int getNumeroSala(){
        return numeroSala;
    }
    public Pelicula getPelicula(){
        return pelicula;
    }
    
    public boolean HaySitio(){      //Comprobamos si hay sitio. Si hay sitio, saldra true y se saldra del metodo. Si no hay sitio saldra false
        for(int i=0; i<asientos.size(); i++){
            if (!asientos.get(i).ocupado()){ 
                    return true;        //Si hay huecos sale true
             }
        }
        return false;           //Si no hay huecos sale false
    }
    
    public boolean AsientoVacio(int fila, char columna){        //Comprobamos si un sitio en concreto esta vacio
        for (int i=0; i<asientos.size(); i++){
            if (asientos.get(i).getFila()==fila && asientos.get(i).getLetra()==columna){      //Para encontrar ese asiento concreto
                return !asientos.get(i).ocupado();            //Si no esta ocupado sale true
            }
        }
        return false;           //Si esta ocupado sale false
    }
    
    public void UbicacionAsientos (){       //Para mostrar los asientos en la sala
        for (int i=0; i<asientos.size(); i++){
            asientos.get(i).MostrarAsiento();
        }
    }
    
    public int IndiceAsientos (int fila, char columna){
        for (int i=0; i<asientos.size(); i++){
            if (asientos.get(i).getFila()==fila && asientos.get(i).getLetra()==columna){      //Para encontrar ese asiento concreto
                return asientos.indexOf(i);
            }
        }
        return -1;
    }
    
    public char getColumna (char columna){
        return columna;
    }
    
    public int getFila (int fila){
        return fila;
    }
    
    public void MostrarSala(){
        System.out.println(numeroSala + " " + asientos + " " + pelicula);
    }
}
