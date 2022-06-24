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
        int dato_nodo = Integer.parseInt((String.valueOf(dato)));
        
        while (actual != null){
            
            if(dato_nodo<Integer.parseInt((actual.dato.toString()))){
                actual = actual.ramaIzdo;
            }else if(dato_nodo>Integer.parseInt((actual.dato.toString()))){
                actual = actual.ramaDcho;
            }else if (Integer.parseInt(actual.toString()) == dato_nodo){
               return actual;
            }
        }
        return null;
    }

    public void insertar(Nodo nodo){
        Nodo actual = raiz;
        Nodo anterior = new Nodo(null);
        int dato_nodo = Integer.parseInt((nodo.dato.toString()));
        
        //Busca el nodo para Verificar que no exista 
        Nodo nodoBuscado = buscarNodo(nodo.dato);
        
        if (nodoBuscado == null){
            while (actual != null){
                anterior = actual;
                if(dato_nodo<Integer.parseInt((actual.dato.toString()))){
                    actual.fe--;
                    actual = actual.subarbolIzdo();
                }else if(dato_nodo>Integer.parseInt((actual.dato.toString()))){
                    actual.fe++;
                    actual = actual.subarbolDcho();
                }
            }
        }else{
            System.out.print("\n El valor insertado ya existe \n");
            return;
        }       
        if(dato_nodo>Integer.parseInt((anterior.dato.toString()))){
            anterior.ramaDcho = nodo;

        }else if(dato_nodo<Integer.parseInt((anterior.dato.toString()))){
            anterior.ramaIzdo=nodo;
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
    
    //RECORRIDOS

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

    //ROTACIONES 

    private NodoAvl rotacionII(NodoAvl n, NodoAvl n1){
        n.ramaIzdo(n1.subarbolDcho());
        n1.ramaDcho(n);
        // actualización de los factores de equilibrio 
        if (n1.fe == -1){ // se cumple en la inserción 
            n.fe = 0;
            n1.fe = 0;
        }else{
            n.fe = -1;
            n1.fe = 1;
        }
        return n1;
    }
    
    private NodoAvl rotacionDD(NodoAvl n, NodoAvl n1){
    n.ramaDcho(n1.subarbolIzdo());
    n1.ramaIzdo(n);
    // actualización de los factores de equilibrio 
    if (n1.fe == +1){ // se cumple en la inserción
        n.fe = 0;
        n1.fe = 0;
    }
    else{
        n.fe = +1;
        n1.fe = -1;
    }
    return n1;
    }

    private NodoAvl rotacionID(NodoAvl n, NodoAvl n1){
    NodoAvl n2;
    n2 = (NodoAvl) n1.subarbolDcho();
    n.ramaIzdo(n2.subarbolDcho());
    n2.ramaDcho(n);
    n1.ramaDcho(n2.subarbolIzdo());
    n2.ramaIzdo(n1);
    // actualización de los factores de equilibrio
    if (n2.fe == +1){
        n1.fe = -1;
    }else{
        n1.fe = 0;
    }if (n2.fe == -1){
        n.fe = 1;
    }else{
        n.fe = 0;
    }
    n2.fe = 0;
    return n2;
    }
    private NodoAvl rotacionDI(NodoAvl n, NodoAvl n1){
        NodoAvl n2;
        n2 = (NodoAvl)n1.subarbolIzdo();
        n.ramaDcho(n2.subarbolIzdo());
        n2.ramaIzdo(n);
        n1.ramaIzdo(n2.subarbolDcho());
        n2.ramaDcho(n1);
        // actualización de los factores de equilibrio
        if (n2.fe == +1)
            n.fe = -1;
        else
            n.fe = 0;
        if (n2.fe == -1)
            n1.fe = 1;
        else
            n1.fe = 0;
        n2.fe = 0;
        return n2;
    }

}