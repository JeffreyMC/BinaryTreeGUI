/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinaryTree;

/**
 *
 * @author Jeffrey
 */
public class Funciones {

 
    //NODO RAÍZ
     Nodo root;
     
     //variables String
     private String listaPre = " ";
     private String listaIn = " ";
     private String listaPost = " ";
     
     
    //GETS Y SETS DE LOS ATRIBUTOS 
    public String getListaPre() {
        return listaPre;
    }
    
        /**
     * @param listaPre the listaPre to set
     */
    public void setListaPre(String listaPre) {
        this.listaPre = listaPre;
    }

    /**
     * @param listaIn the listaIn to set
     */
    public void setListaIn(String listaIn) {
        this.listaIn = listaIn;
    }

    /**
     * @param listaPost the listaPost to set
     */
    public void setListaPost(String listaPost) {
        this.listaPost = listaPost;
    }
    
    /**
     * @return the listaIn
     */
    public String getListaIn() {
        return listaIn;
    }

    /**
     * @return the listaPost
     */
    public String getListaPost() {
        return listaPost;
    }
    
    //inserta un nodo
    public void add(int valor){
        root = addRecursivo(root, valor);
    }
    
    //método recursivo
    private Nodo addRecursivo(Nodo actual, int valor){
        if(actual == null){
            return new Nodo(valor);
        }
        
        if(valor < actual.valor){
            actual.izquierda = addRecursivo(actual.izquierda, valor);
        }
        else if(valor > actual.valor){
            actual.derecha = addRecursivo(actual.derecha, valor);
        }else{
            return actual;
        }
        
        return actual;
    }
    
    //imprime nodo
    public void preOrden(Nodo nodo){
        if(nodo != null){
            setListaPre(listaPre + nodo.valor + " - ");
            preOrden(nodo.izquierda);
            preOrden(nodo.derecha);
        }
    }
    
    public void postOrden(Nodo nodo){
        if(nodo != null){
            postOrden(nodo.izquierda);
            postOrden(nodo.derecha);
            setListaPost(listaPost + nodo.valor + " - ");
        }
    }
    
    public void inOrden(Nodo nodo){
        if(nodo != null){
            inOrden(nodo.izquierda);
            setListaIn(listaIn + nodo.valor + " - ");
            inOrden(nodo.derecha);
        }
    }
    
    //muestra la altura del árbol
    public int alturaArbol(Nodo raiz) {
        if (raiz == null) {
            return 0;
        }
        
        //llama a la función de manera recursiva y encuentra
        //la altura de la rama derecha y la rama izquierda del árbol
        int alturaIzquierda = alturaArbol(raiz.izquierda);
        int alturaDerecha = alturaArbol(raiz.derecha);
        //verifica la altura de la derecha u la izquierda
        if (alturaDerecha > alturaIzquierda) {
            return 1 + alturaDerecha;
        } else {
            return 1 + alturaIzquierda;
        }
}
     //eliminar nodo
    public void borrarNodo(int valor){
        borrarRecursivo(root, valor);
    }
    
    private Nodo borrarRecursivo(Nodo actual, int valor){
        if(actual == null)
            return null;
        if(valor == actual.valor){
            //si el nodo es una terminación u hoja
            if(actual.izquierda == null && actual.derecha == null){
                return null;
            }
            
            //si el nodo tiene un hijo
            if(actual.derecha == null)
                return actual.izquierda;
            if(actual.izquierda == null)
                return actual.derecha;
            
            //si el nodo tiene dos hijos
            int valorMasPequeno = encuentraValorMasPequeno(actual.derecha);
            actual.valor = valorMasPequeno;
            actual.derecha = borrarRecursivo(actual.derecha, valorMasPequeno);
            return actual;
        }
        if(valor < actual.valor){
            actual.izquierda = borrarRecursivo(actual.izquierda, valor);
            return actual;
        }
        actual.derecha = borrarRecursivo(actual.derecha, valor);
        return actual;
                    
    }
    
    //encuentra el nodo con el valor más pequeño
    private int encuentraValorMasPequeno(Nodo root){
         return root.izquierda == null ? root.valor : encuentraValorMasPequeno(root.izquierda);   
    }
    
     //encuentra nodo
    public boolean buscaNodo(Nodo actual, int valor){
        if(actual == null)
            return false;
        if(valor == actual.valor){
            return true;
        }
        if(valor <  actual.valor){
            return buscaNodo(actual.izquierda, valor);
        }
        else
            return buscaNodo(actual.derecha, valor);
    }
   
}
