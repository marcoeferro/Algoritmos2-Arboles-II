package arbolBinario;
import java.util.Scanner;
public class main{
    public static void main(String [] args){
     
        int condicion=99,rta=99,contador_nodos=0;
        int nvo_nodo=99;
        Scanner input = new Scanner(System.in);
        ArbolBinario arbol = new ArbolBinario() ;
    
        do{
            System.out.print("\n[1] Añadir Nodo \n");
            System.out.print("[2] Eliminar Nodo \n");
            System.out.print("[3] Mostrar Arbol (en preorden)\n");
            System.out.print("[4] Recorrer pre orden in orden post orden \n");
            System.out.print("[0] Salir del programa \n");
            rta=input.nextInt();
            input.nextLine();
            
            switch(rta){
                case 1:
                    if (contador_nodos==0){
                        String valor;
                        System.out.print("\n Ingrese el valor del nodo raiz \n");
                        valor = input.nextLine();
                        arbol = new ArbolBinario(valor);
                        contador_nodos++;
                    }else{ 
                        do{
                            String valor;
                            System.out.print("\n Ingrese el valor del nodo \n");
                            valor = input.nextLine();
                            Nodo nodo = new Nodo(valor);
                            arbol.insertar(nodo);
                            System.out.print("\n¿Desea Ingresar nuevo nodo ? (si=1 / no=0)\n");
                            nvo_nodo=input.nextInt();
                            input.nextLine();
                        }while (nvo_nodo !=0);
                    }
                    
                    break;
                case 2:
                    String valor;
                    System.out.print("Ingrese el valor que desea Eliminar \n");
                    valor = input.nextLine();
                    arbol.eliminar(valor);
                    break;
                case 3:
                    ArbolBinario.preorden(arbol.raiz);
                    System.out.print("\n");
                    break;
                case 4:
                    
                    System.out.print("\n Recorrido en Orden :\n");
                    ArbolBinario.inorden(arbol.raiz);
                    System.out.print("\nRecorrido en pre Orden : \n");
                    ArbolBinario.preorden(arbol.raiz);
                    System.out.print("\nRecorrido en Post Orden : \n");
                    ArbolBinario.postorden(arbol.raiz);
                    
                    break;
                case 0 :
                    condicion = 0;
                    break;
                default:
                    System.out.print("La opcion ingresada no es valida\n");
                    break;
    
            }
        }while(condicion!= 0);
        System.out.print("Ejecucion Terminada \n");
    
        input.close();
    };
}



