package arbolBinario;
import java.util.Scanner;
public class main{
    public static void main (String [] args){
     
        int condicion=99,rta=99,contador_nodos=0;
        int nvo_nodo=99;
        Scanner input = new Scanner(System.in);
        ArbolBinario arbol = new ArbolBinario() ;
    
        do{
            System.out.print("\n[1] Añadir Nodo \n");
            System.out.print("[2] Mostrar Arbol (prenorden)\n");
            System.out.print("[3] Recorrer pre orden in orden post orden \n");
            System.out.print("[0] Salir del programa \n");
            rta=input.nextInt();
            input.nextLine();
            
            switch(rta){
                case 1:
                    
                    do{
                            
                        if (contador_nodos==0){//verifica si se inserto la raiz o no
                            String valor;
                            System.out.print("\n Ingrese el valor del nodo raiz \n");
                            valor = input.nextLine();
                            arbol = new ArbolBinario(valor);
                            contador_nodos++;
                        }
                        
                        String valor;
                        System.out.print("\n Ingrese el valor de un nodo \n");
                        valor = input.nextLine();
                        Nodo nodo = new Nodo(valor);
                        arbol.insertar(nodo);
                        System.out.print("\n¿Desea Ingresar nuevo nodo ? (si=1 / no=0)\n");
                        nvo_nodo=input.nextInt();
                        input.nextLine();
                    }while (nvo_nodo !=0);
                    break;
                case 2:
                    arbol.preorden(arbol.raiz);
                    System.out.print("\n");
                    break;
                case 3:
                    System.out.print("\n Recorrido en Orden :\n");
                    arbol.inorden(arbol.raiz);
                    System.out.print("\nRecorrido en pre Orden : \n");
                    arbol.preorden(arbol.raiz);
                    System.out.print("\nRecorrido en Post Orden : \n");
                    arbol.postorden(arbol.raiz);
                    break;
                case 0 :
                    condicion = 0;
                    break;
                default:
                    System.out.print("La opcion ingresa no es valida\n");
                    break;
    
            }
        }while(condicion!= 0);
        System.out.print("Ejecucion Terminada \n");
    
        input.close();
    };
}



