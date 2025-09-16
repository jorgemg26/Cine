package clases;



public class Pelicula {
    
    String titulo;
    int duracion;
    int edadMinima;
    double precio;
    String director;
    int numeroSala;
    
    public Pelicula (String titulo, int duracion, int edadMinima, double precio, String director, int numeroSala){
        this.titulo=titulo;
        this.duracion=duracion;
        this.edadMinima=edadMinima;
        this.precio=precio;
        this.director=director;
        this.numeroSala=numeroSala;
    }
    
    public String getTitulo (){
        return titulo;
    }
    public int getEdadMinima(){
        return edadMinima;
    }
    public double getPrecio(){
        return precio;
    }
    public int getNumeroSala(){
        return numeroSala;
    }
    
    public void MostrarPelicula(){
        System.out.println("titulo: " + titulo + " |" + " duracion: " + duracion + " min" + " |" + " edad minima: " + edadMinima + " |" + " precio: " + precio + " |" + " director: " + director + " |" + " sala " + numeroSala);
    }
}
