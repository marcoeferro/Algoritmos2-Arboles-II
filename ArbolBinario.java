package arbolBinario;

public class ArbolBinario

{
    protected Nodo raiz;
    
    //contructores
    public ArbolBinario(){
        
        raiz = null;
    }
    
    public ArbolBinario(Object dato){
        this.raiz = new Nodo(dato);
    }
    
    //Metodos
    public Nodo buscarNodo(Object dato){
        Nodo actual = raiz;
        int datonodo = Integer.parseInt((String.valueOf(dato)));
        
        while (actual != null){
            
            if(datonodo<Integer.parseInt((actual.dato.toString()))){
                actual = actual.ramaIzdo;
            }else if(datonodo>Integer.parseInt((actual.dato.toString()))){
                actual = actual.ramaDcho;
            }else if (Integer.parseInt(actual.toString()) == datonodo){
               return actual;
            }
        }
        return null;
    }

    public void insertar(Nodo nodo){
        Nodo actual = raiz;
        Nodo anterior = new Nodo(null);
        int datonodo = Integer.parseInt((nodo.dato.toString()));
        while (actual != null){
            anterior = actual;
            if(datonodo<Integer.parseInt((actual.dato.toString()))){
                actual = actual.subarbolIzdo();
            }else if(datonodo>Integer.parseInt((actual.dato.toString()))){
                actual = actual.subarbolDcho();
            }else {
                System.out.print("\n El valor insertado ya existe \n");
                return;
            }
        }
        if(datonodo>Integer.parseInt((anterior.dato.toString()))){
            anterior.ramaDcho = nodo;

        }else if(datonodo<Integer.parseInt((anterior.dato.toString()))){
            anterior.ramaIzdo=nodo;
        }else {
            System.out.print("\n El valor insertado ya existe \n");
            return;
        }

        
    }
  
    
    public void eliminar(Object dato){
        
        Nodo elim = buscarNodo(dato);
        
        if(elim.subarbolIzdo()!=null){
            Nodo aux_izq =elim.subarbolIzdo();
            insertar(aux_izq);
        }else if (elim.subarbolDcho()!=null){
            Nodo aux_Dcho =elim.subarbolDcho();
            insertar(aux_Dcho);
        }
        
        System.out.print("\n Nodo eliminado");
        
    }
    

    // Recorrido de un árbol binario en preorden
    public static void preorden(Nodo nodo){
        
        System.out.print(" ["+String.valueOf(nodo)+"] ");
        
        if (nodo.subarbolIzdo() != null){
            preorden(nodo.subarbolIzdo());
        }
        
        if (nodo.subarbolDcho() != null){
            preorden(nodo.subarbolDcho());
        }
        
    }

    // Recorrido de un árbol binario en inorden
    public static void inorden(Nodo nodo){
        
        
        if (nodo.subarbolIzdo() != null){
            inorden(nodo.subarbolIzdo());
        }
        
        System.out.print(" ["+String.valueOf(nodo)+"] ");
        
        if (nodo.subarbolDcho() != null){
            inorden(nodo.subarbolDcho());
        }
        
    }
    
    // Recorrido de un árbol binario en postorden
    public static void postorden(Nodo nodo){
        
        if (nodo.subarbolIzdo() != null){
            postorden(nodo.subarbolIzdo());
        }
        
        if (nodo.subarbolDcho() != null){
            postorden(nodo.subarbolDcho());
        }
        
        System.out.print(" ["+String.valueOf(nodo)+"] ");
        
    }

}