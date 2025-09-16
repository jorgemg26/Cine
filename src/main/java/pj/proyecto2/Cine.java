package pj.proyecto2;

import clases.Espectador;
import clases.Pelicula;
import clases.Asiento;
import clases.Sala;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Cine {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner (System.in);
        
        Random rand = new Random();
        
        int edad, duracion, edadMinima, numeroSalaEspectador, numeroFilas, numeroColumnas, numeroFila, filaAsiento, salaEspectador, indiceSala, index;
        
        int numeroSalaPelicula=0;   int numeroPelicula=0;   int numeroEspectador=0;
        
        double precio, dinero;
        
        String anadirPelicula, anadirEspectador, nombre, director, titulo;
        
        boolean seguirPelicula, seguirEspectador, precioValido, columnasValidas;
        
        boolean asientoDisponible=true;   
        
        char columnaAsiento, letraColumna;
        
        //Pedimos numero de columnas y filas
        System.out.println("Numero de filas del cine:");        //Se pide al usuario que ingrese el numero de filas del cine
        numeroFilas=scan.nextInt();
        scan.nextLine();
        
        do{
            System.out.println("Numero de columnas del cine (maximo 26)");      //Se pide al usuario que ingrese el numero de columnas del cine. No puede ingresar mas de 26 porque serian mas que el abecedario
            numeroColumnas=scan.nextInt();
            scan.nextLine();
            
            if (numeroColumnas>26 || numeroColumnas<1){     //Si son mas de 26 o menos de 1 columnas se va a repetir el bucle
                columnasValidas=false;
            }
            else{
                columnasValidas=true;
            }
        }
        while(columnasValidas==false);
        System.out.println();

        ArrayList <Pelicula> peliculas = new ArrayList <>();     //Un ArrayList para que pueda añadir las peliculas 
        
        ArrayList <Sala> salas = new ArrayList <>();        //Un ArrayList en el que se iran añadiendo las peliculas a las salas (una pelicula por sala)
        
        ArrayList <Asiento> asientos = new ArrayList<>();       //Cargamos la clase de asientos con los asientos que tenemos
        
        //Añadimos las peliculas
        do{
            System.out.println("Titulo de la pelicula:");
            titulo=scan.nextLine();
            
            System.out.println("Duracion de la pelicula:");      
            duracion=scan.nextInt();
            scan.nextLine();
            
            System.out.println("Edad minima:");
            edadMinima=scan.nextInt();
            scan.nextLine();
            
            do{
                System.out.println("Precio de la pelicula (entre 10 y 20)");     //El precio de la pelicula debe ser entre 10 y 20
                precio=scan.nextDouble();
                scan.nextLine();
                if (precio<10 || precio>20){        //Si no es entre 10 y 20, se le vuelve a pedir un precio valido
                    System.out.println("El precio no es valido");
                    precioValido=false;
                }
                else{
                    precioValido=true;
                }
            }
            while(precioValido==false);
            
            System.out.println("Nombre del director:");
            director=scan.nextLine();
            
            numeroSalaPelicula=numeroSalaPelicula+1;        //Para almacenarlo en la clase Pelicula
            
            numeroPelicula=numeroPelicula+1;        //Para ir contando las peliculas
            
            peliculas.add(new Pelicula (titulo, duracion, edadMinima, precio, director, numeroSalaPelicula));       //Cargamos la clase Pelicula con el ArrayList peliculas para poder añadir varias
            
            salas.add(new Sala (numeroSalaPelicula, numeroFilas, numeroColumnas, peliculas.get(numeroPelicula-1)));       //Cargamos la clase Sala con el ArrayList salas para poder crear varias salas
            
            System.out.println();
            System.out.println("Pelicula guardada: ");
            peliculas.get(numeroPelicula-1).MostrarPelicula();        //Mostramos los datos de las peliculas. Restamos 1 porque la posicion empieza en 0
            System.out.println();
            
            for (int i=0; i<numeroColumnas; i++){      //Creamos los asientos de la sala (que es un ArrayList) asi que cargamos el ArrayList de asientos
                columnaAsiento = (char)('A'+i);
                for(int j=numeroFilas; j>=1; j--){
                asientos.add(new Asiento (numeroSalaPelicula, columnaAsiento, j));
                }
            }
            
            System.out.println("Quieres anadir otra pelicula?");        //Para que se añadan peliculas hasta que el usuario quiera parar
            anadirPelicula=scan.nextLine();
            System.out.println();
            
            if (anadirPelicula.equalsIgnoreCase("si")){
                seguirPelicula=true;
            }
            else {
                seguirPelicula=false;
            }
        }
        while (seguirPelicula==true);

        ArrayList <Espectador> espectadores = new ArrayList<>();        //Un ArrayList para que pueda añadir los espectadores 
        
        //Añadimos los espectadores
        do{
            System.out.println("Nombre del espectador:");
            nombre=scan.nextLine();
            
            System.out.println("La edad del espectador es aleatoia entre 10 y 100 años");       //La edad del espectador va a ser aleatoria entre 10 y 100 años
            edad=rand.nextInt(91)+10;
            
            System.out.println("El dinero del espectador es aleatorio entre 15 y 25");      //El dinero del espectador es aleatorio entre 15 y 25
            dinero=15+(25-15)*rand.nextDouble();        //Como el minimo es 15, a eso se le suma el rango (25-15) y se multiplica por un numero aleatorio entre 0 y 1
            dinero=Math.round(dinero*100)/100;      //Para redondear a 2 decimales
            
            numeroSalaEspectador=rand.nextInt(peliculas.size())+1;       //Esto es para que se le asigne una sala aleatoria (y pelicula aleatoria) al espectador de entre las que hay
            
            numeroEspectador=numeroEspectador+1;        //Para ir contando los espectadores
            
            espectadores.add(new Espectador (nombre, edad, dinero, numeroSalaEspectador));      //Cargamos la clase Espectador con los datos del espectadorpara poder añadir varios
            
            System.out.println();
            System.out.println("Espectador guardado: ");
            espectadores.get(numeroEspectador-1).MostrarEspectador();       //Mostramos los datos de los espectadores. Restamos 1 porque la posicion empieza en 0
            System.out.println();
            
            System.out.println("Quieres anadir otro espectador?");      //Para que se añadan espectadores hasta que el usuario quiera parar
            anadirEspectador=scan.nextLine();
            System.out.println();
            
            if (anadirEspectador.equalsIgnoreCase("si")){
                seguirEspectador=true;
            }
            else {
                seguirEspectador=false;
            }
        }
        while(seguirEspectador==true);
        
        //Comprobamos si el espectador tiene el dinero para la pelicula y la edad minima
        for (int i=0; i<espectadores.size(); i++){
            salaEspectador=espectadores.get(i).getNumeroSala();         //Sacamos el numero de sala de cada espectador para usarlo para asignarle asientos
            indiceSala=salaEspectador-1;
            //Comprobamos que cumpla la edad y el dinero
            if (peliculas.get(indiceSala).getPrecio()<=espectadores.get(i).getDinero() && peliculas.get(indiceSala).getEdadMinima()<=espectadores.get(i).getEdad()){
                if (salas.get(indiceSala).HaySitio()){        //Comprobamos si hay sitio en la sala del espectador
                    do{
                        numeroFila=rand.nextInt(numeroFilas)+1;       //Le damos al espectador una fila aleatoria
                        letraColumna=(char)('A'+ rand.nextInt(numeroColumnas));      //Pasamos la columna a letra (en formato String) para poder comparar
                        for (int j=0; j<asientos.size(); j++){
                            if (numeroFila==asientos.get(j).getFila() && letraColumna==asientos.get(j).getLetra() && asientos.get(j).getNumeroSala()==salaEspectador){    //Para comprobar que el espectador esta en el asiento correcto
                                if (salas.get(indiceSala).AsientoVacio(numeroFila, letraColumna)==true){     //Nos aseguramos que el asiento no esta ocupado
                                    asientoDisponible=true;
                                    asientos.get(j).setEspectador(espectadores.get(i));         //Asignamos el espectador al asiento en concreto
                                    break;
                                } 
                                else{                                                       
                                    asientoDisponible=false;
                                }
                            }
                        }
                    }
                    while(asientoDisponible==false);                                //Si el asiento esta ocupado se repite el bucle
                }
                else{
                    System.out.println("No hay sitio en la sala " + salaEspectador + " asi que el espectador " + espectadores.get(i).getNombre() + " no se ha podido sentar");
                }
            }
            else {
                System.out.println("El espectador " + espectadores.get(i).getNombre() + " no tiene dinero o edad suficiente");
            }
        }
        System.out.println("Los espectadores que cuplen los requisitos han sido asignados en sus asientos");
        
        //Mostramos la informacion de las salas
        for (int i=0; i<salas.size(); i++){             //Mostramos la informacion de la primera sala
            System.out.println("Sala " + salas.get(i).getNumeroSala() + ":");
            System.out.println("Pelicula: ");
            peliculas.get(i).MostrarPelicula();
            System.out.println("Asientos sala " + salas.get(i).getNumeroSala() + ":");
            System.out.print("   ");
            for (int j=0; j<numeroColumnas; j++){           //Imprimimos las leras (las columnas)
                System.out.print((char)('A'+j) + "  ");
            }
            System.out.println(); 
            
            for (int j=numeroFilas; j>0; j--){           //Recorremos las filas para guardarlas en una variable. Imprimimos los numeros (las filas)          
                System.out.print(j);
                if (j<10){                              //Alinear la tabla si hay de un solo digito
                    System.out.print(" ");
                }
                for (int i2=0; i2<numeroColumnas; i2++){        //Recorremos las columnas porque en cada una se va a hacer en la misma linea
                    boolean ocupado=false;
                    for (int j2=0; j2<asientos.size(); j2++){       //Recorremos los asientos para imprimir [X] en busca del que cumpla las condiciones
                        if (asientos.get(j2)!=null && asientos.get(j2).ocupado()){
                            if (asientos.get(j2).getFila()==j && asientos.get(j2).getLetra()==(char)('A'+i2) && asientos.get(j2).getNumeroSala()==salas.get(i).getNumeroSala()){
                                ocupado=true;
                                break;
                            }
                            else{
                                ocupado=false;
                            }
                        }
                    }
                    if (ocupado==true){         //Si esta ocupado imprime [X]
                        System.out.print("[X]");
                    }
                    else {                      //Si no esta ocupado imprime [ ]
                        System.out.print("[ ]");
                    }
                }
                System.out.println();
            }
            
            for (int j=0; j<espectadores.size(); j++){                              //Recorremos los espectadores para imprimir sus datos
                if (espectadores.get(j).getNumeroSala()==salas.get(i).getNumeroSala()){     //Comprobamos que el espectador esta en la sala correcta
                    for (int i2=0; i2<asientos.size(); i2++){                      //Recorremos el ArrayList asientos para encontrar el asiento concreto del espectador
                        if (asientos.get(i2)!=null && asientos.get(i2).ocupado()){                      //Comprobamos que el asiento esta ocupado por el espectador
                            if(asientos.get(i2).getEspectador().getNombre().equalsIgnoreCase(espectadores.get(j).getNombre())){     //Comprobamos que esta ocupado por ese espectador
                                espectadores.get(j).MostrarEspectador();                //Mostramos los espectadores de la sala
                                break;
                            }
                        }
                    }
                }
            }
            System.out.println();
        }
    }
}
