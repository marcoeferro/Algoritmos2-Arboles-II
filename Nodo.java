package arbolBinario; 
public class Nodo
{
	protected Object dato;
	protected Nodo ramaIzdo;
	protected Nodo ramaDcho;
	
	//constructores
	public Nodo(Object valor){
		dato = valor;
		this.ramaIzdo = null;
		this.ramaDcho = null;
	}
	
	@Override
	public String toString() {
		return String.valueOf(dato);
	}

	// Getters
	public Object valorNodo(){ 
		return dato; }
	public Nodo subarbolIzdo(){ 
		return ramaIzdo; }
	public Nodo subarbolDcho(){ 
		return ramaDcho; }
	
	//Setters
	public void nuevoValor(Object d){ 
		dato = d; }
	public void ramaIzdo(Nodo n){ 
		ramaIzdo = n; }
	public void ramaDcho(Nodo n){ 
		ramaDcho = n; }
}

