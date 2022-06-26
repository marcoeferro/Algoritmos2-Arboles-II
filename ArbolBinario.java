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
    
    //METODOS Y PROCEDIMIENTOS

    //Busca un nodo dentro del arbol y si existe lo devuelve sino devuelve null
    public Nodo buscarNodo(Object dato){
        Nodo actual = raiz;
        int dato_nodo;
        if(dato !=null){
            
            dato_nodo = Integer.parseInt(dato.toString());
        
            while (actual != null){
                
                if(dato_nodo<Integer.parseInt((actual.dato.toString()))){
                    actual = actual.ramaIzdo;
                }else if(dato_nodo>Integer.parseInt((actual.dato.toString()))){
                    actual = actual.ramaDcho;
                }else if (Integer.parseInt(actual.toString()) == dato_nodo){
                return actual;
                }
            }
        }else {
            return null;
        }
        
        return null;
    }

    //Inserta Nodos al arbol
    public void insertar(Nodo nodo){
        Nodo actual = raiz;
        Nodo anterior = new Nodo(null);
        
        int dato_nodo;
        
        //Nodos para las rotaciones
        Nodo n0=new Nodo(null);
        Nodo n=new Nodo(null);
        Nodo n1=new Nodo(null);

        /*verifica que el nodo no sea nulo */ 
        if (nodo !=null){
            
            dato_nodo = Integer.parseInt((String.valueOf(nodo.dato)));
            
            //Busca el nodo para Verificar que no exista dentro del arbol
            Nodo nodoBuscado = buscarNodo(nodo.dato);
            
            if (nodoBuscado == null){

                actualizarFe(raiz,nodo.dato);

                while (actual != null){
            
                    if(n.dato!=null && (actual.fe==1 || actual.fe==-1)){
                        n1=actual;
                    }
                    if(actual.fe==-2 || actual.fe==2){
                        n=actual;
                        n0=anterior;
                    }
                    
                    anterior = actual;
                    
                    if(Integer.parseInt(nodo.dato.toString()) < Integer.parseInt(actual.dato.toString())){
                        actual = actual.subarbolIzdo();
                    }else if(Integer.parseInt(nodo.dato.toString()) > Integer.parseInt(actual.dato.toString())){
                        actual = actual.subarbolDcho();
                    }
                }

            }
            else{
                System.out.print("\n El valor ingresado ya existe \n");
                return;
            }

        }else{
            return;
        }       
        
        //Inserta el nodo
        if(dato_nodo>Integer.parseInt((anterior.dato.toString()))){
            anterior.ramaDcho = nodo;

        }else if(dato_nodo<Integer.parseInt((anterior.dato.toString()))){
            anterior.ramaIzdo=nodo;
        }
        
        /* una vez insertado el nodo procede a realizar las rotaciones 
        el nodo n0 se guarda para insertar el nodo n1 */
        switch(n.fe){
            case -2:
                
                if(n1.fe==1){
                   if(n0.subarbolIzdo()==n){
                        n0.ramaIzdo=rotacionID(n, n1);
                    }else if (n0.subarbolDcho()==n){
                        n0.ramaDcho=rotacionID(n, n1);
                    }
                }
                if(n1.fe== (int)(-1)){
                    if(n0.subarbolIzdo()==n){
                        n0.ramaIzdo=rotacionII(n, n1);
                    }else if (n0.subarbolDcho()==n){
                        n0.ramaDcho=rotacionII(n, n1);
                    }
                }
                break;
            case 2:
                if(n1.fe==1){
                    if(n0.subarbolIzdo()==n){
                        n0.ramaIzdo=rotacionDD(n, n1);
                    }else if (n0.subarbolDcho()==n){
                        n0.ramaDcho=rotacionDD(n, n1);
                    }
                }else if(n1.fe==-1){
                    if(n0.subarbolIzdo()==n){
                        n0.ramaIzdo=rotacionDI(n, n1);
                    }else if (n0.subarbolDcho()==n){
                        n0.ramaDcho=rotacionDI(n, n1);
                    }
                }
                break;
        }

    }
    
    //Actualiza factores de equilibrio
    public void actualizarFe(Nodo nodo,Object dato){
        
        if(nodo==null){
            return;
        }

        if(Integer.parseInt(dato.toString()) < Integer.parseInt(nodo.dato.toString())) { 
            nodo.fe--;
            actualizarFe(nodo.subarbolIzdo(), dato);

        }else if (Integer.parseInt(dato.toString()) > Integer.parseInt(nodo.dato.toString())){
            nodo.fe++;
            actualizarFe(nodo.subarbolDcho(), dato);
        }

    }

    //Elimina Nodos
    public void eliminar(Object dato){
        
        Nodo actual = raiz;
        Nodo anterior =null;
        
        Nodo n0=new Nodo(null);
        Nodo n=new Nodo(null);
        Nodo n1=new Nodo(null);


        if (raiz.dato!=dato){
            while (actual.dato != dato){
            
                if(Integer.parseInt((dato.toString())) < Integer.parseInt((actual.dato.toString()))){
                    actual.fe++;
                    if (n!=null && n1==null){
                        n1 =actual;
                    }
                    if(actual.fe == 2 ){
                        n=actual;
                        n0=anterior;
                    }
                    anterior=actual;
                    actual = actual.ramaIzdo;
                }else if(Integer.parseInt((dato.toString())) > Integer.parseInt((actual.dato.toString()))){
                    actual.fe--;
                    if (n!=null && n1==null){
                        n1 =actual;
                    }
                    if(actual.fe == 2 ){
                        n=actual;
                        n0=anterior;
                    }
                    anterior=actual;
                    actual = actual.ramaDcho;
                }
            }


            if (anterior.subarbolDcho()==actual){
                anterior.ramaDcho=actual.ramaIzdo;
            }else{
                anterior.ramaIzdo=actual.ramaIzdo;
            }
            
            switch(n.fe){
                case -2:
                    if(n1.fe==1){
                        if(n0.subarbolIzdo()==n){
                            n0.ramaIzdo=rotacionID(n, n1);
                        }else if (n0.subarbolDcho()==n){
                            n0.ramaDcho=rotacionID(n, n1);
                        }
                    }else if(n1.fe==-1){
                        if(n0.subarbolIzdo()==n){
                            n0.ramaIzdo=rotacionII(n, n1);
                        }else if (n0.subarbolDcho()==n){
                            n0.ramaDcho=rotacionII(n, n1);
                        }
                    }
                    break;
                case 2:
                    if(n1.fe==1){
                        if(n0.subarbolIzdo()==n){
                            n0.ramaIzdo=rotacionDD(n, n1);
                        }else if (n0.subarbolDcho()==n){
                            n0.ramaDcho=rotacionDD(n, n1);
                        }
                    }else if(n1.fe==-1){
                        if(n0.subarbolIzdo()==n){
                            n0.ramaIzdo=rotacionDI(n, n1);
                        }else if (n0.subarbolDcho()==n){
                            n0.ramaDcho=rotacionDI(n, n1);
                        }
                    }
                    break;
            }

            insertar(actual.ramaDcho);

        }else{
            raiz=null;
        }        
        System.out.print("\n Nodo eliminado");
        
    }
    
    //RECORRIDOS

    // Recorrido de un árbol binario en preorden
    public  void preorden(Nodo nodo){
        
        System.out.print(" ["+String.valueOf(nodo.dato)+"] ");
        
        if (nodo.subarbolIzdo() != null){
            preorden(nodo.subarbolIzdo());
        }
        
        if (nodo.subarbolDcho() != null){
            preorden(nodo.subarbolDcho());
        }
        
    }

    // Recorrido de un árbol binario en inorden
    public  void inorden(Nodo nodo){
        
        
        if (nodo.subarbolIzdo() != null){
            inorden(nodo.subarbolIzdo());
        }
        
        System.out.print(" ["+String.valueOf(nodo)+"] ");
        
        if (nodo.subarbolDcho() != null){
            inorden(nodo.subarbolDcho());
        }
        
    }
    
    // Recorrido de un árbol binario en postorden
    public  void postorden(Nodo nodo){
        
        if (nodo.subarbolIzdo() != null){
            postorden(nodo.subarbolIzdo());
        }
        
        if (nodo.subarbolDcho() != null){
            postorden(nodo.subarbolDcho());
        }
        
        System.out.print(" ["+String.valueOf(nodo)+"] ");
        
    }

    //ROTACIONES 

    private Nodo rotacionII(Nodo n, Nodo n1){
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
    
    private Nodo rotacionDD(Nodo n, Nodo n1){
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

    private Nodo rotacionID(Nodo n, Nodo n1){
        Nodo n2;
        n2 = (Nodo) n1.subarbolDcho();
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

    private Nodo rotacionDI(Nodo n, Nodo n1){
        Nodo n2;
        n2 = (Nodo)n1.subarbolIzdo();
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