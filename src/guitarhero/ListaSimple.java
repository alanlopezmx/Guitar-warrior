package guitarhero;

import java.awt.Color;

public class ListaSimple {
    public Nodo primero;
    public Nodo ultimo;
    public int tamaño;
    public ListaSimple() {
        this.primero = null;
        this.ultimo = null;
        this.tamaño = 0;
    }
//Metodo utilizado para denotar que la lista se encuentra vacia.
    public boolean siVacio() {
        return (this.primero == null);
    }
//Metodo para agregar al final de la lista.
    public Nodo addLast(int color, int tiempo, int duracion, int y, int index) {
        Nodo nuevo = new Nodo(color,tiempo,duracion,y,index);
        if(siVacio()) {
            primero = nuevo;
            ultimo = nuevo;
            nuevo.sig = null;
        }
        else {
            nuevo.sig = null;
            ultimo.sig = nuevo;
            ultimo = nuevo;
        }
        this.tamaño++;
        return nuevo;
    }
    public Nodo addNext(Nodo aux, int color, int tiempo, int duracion, int y, int index){
        Nodo nuevo = new Nodo(color,tiempo,duracion,y,index);
        if (aux==null){
            nuevo.sig = primero;
            primero=nuevo;
        }
        else{
            nuevo.sig = aux.sig;
            aux.sig = nuevo;
        }
        this.tamaño++;
        return nuevo;
    }
//Metodo para borrar al final de la lista.
    public void deleteLast() {
        if(primero == ultimo) {
            primero = null;
            ultimo = null;
        }
        else {
            Nodo actual = primero;
            while(actual.sig != ultimo) {
                actual = actual.sig;
            }
            actual.sig = null;
            ultimo = actual;
        }
        this.tamaño--;
    }
    public void deleteAll(){
        primero=ultimo=null;
        this.tamaño=0;
    }
    public Nodo indexOf(int index){
        Nodo buscado = primero;
        for (int i = 0; i < index; i++) {
            if(buscado.sig!=null)
                buscado=buscado.sig;
        }
        return buscado;
    }
    public Nodo buscaNodoAnt(int tiempo){
        Nodo buscado = primero;
        Nodo aux=null;
        if (buscado!=null){
            for (int i = 0; i < tamaño; i++) {
                if (buscado.tiempo < tiempo){
                    aux=buscado;
                    buscado=buscado.sig;
                }
            }
        }
        return aux;
    }
    public Nodo buscaNodoSig(int tiempo){
        Nodo buscado = primero;
        if (buscado!=null){
            for (int i = 0; i < tamaño; i++) {
                if (buscado.tiempo <= tiempo){
                    buscado=buscado.sig;
                }
            }
        }
        return buscado;
    }
    public Nodo buscaTiempo(int tiempo, int color){
        Nodo buscado = primero;
        if (buscado!=null){
            for (int i = 0; i < tamaño; i++) {
                buscado=indexOf(i);
                if (buscado.tiempo == tiempo && buscado.color == color)
                    return buscado;
                else 
                    buscado=null;
            }
        }
        return buscado;
    }
    public void deleteSel(int index){
	Nodo aux = primero;
        Nodo aux2 = primero;
	for (int i = 0; i < index; i++){
            aux2 = aux; 
	    aux = aux.sig;
	}
	if (aux2 == aux){
	    primero = aux2.sig;
            aux.sig = null;
        }
	else{	
	    if (aux.sig == null){
		ultimo = aux2;
                aux2.sig = null;
            }
            else{
	    	aux2.sig = aux.sig;
                aux.sig = null;
            }
	}
        tamaño--;
    }
    public void deleteNodo(Nodo buscado){
        Nodo aux = primero;
	while (aux.sig!=buscado && aux!=buscado){
                aux = aux.sig;
	}
        if (primero == buscado){
            if (tamaño!=1){
                primero = aux.sig;
                buscado = null;
            }
            else
                primero=ultimo=null;
        }
	else{	
	    if (buscado.sig == null){
		ultimo = aux;
                aux.sig=null;
            }
            else{
	    	aux.sig = buscado.sig;
                buscado.sig=null;
            }
	}
        tamaño--;
    }
    
}

class Nodo {
    Nodo sig;
    int color;
    int tiempo;
    int duracion;
    int y;
    int laux;
    Color color2;
    int index;
    boolean pintar;
    public Nodo(int color, int tiempo, int duracion, int y, int index) {
        this.color = color;
        this.tiempo=tiempo;
        this.duracion=duracion;
        this.y=y;
        laux=0;
        switch (color){
            case 1:
                color2 = Color.GREEN;
                break;
            case 2:
                color2 = Color.RED;
                break;
            case 3:
                color2 = Color.YELLOW;
                break;
            case 4: 
                color2 = Color.BLUE;
                break;
            case 5:
                color2 = Color.ORANGE;
                break;
        }
        this.sig = null;
        this.index=index;
        pintar=true;
    }
    
}
