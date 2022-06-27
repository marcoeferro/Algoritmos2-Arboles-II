package arbolBinario; 
public class Nodo
{
	protected Object dato;
	protected Nodo ramaIzdo;
	protected Nodo ramaDcho;
	protected int alturaIzq;
	protected int alturaDer;
	protected int fe = alturaDer-alturaIzq;

	//constructores
	public Nodo(Object valor){
		dato = valor;
		this.ramaIzdo = null;
		this.ramaDcho = null;
		this.alturaDer= 0;
		this.alturaIzq= 0;	
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
	public int getFe(){
		return this.fe; }
	public int getAlturaIzq(){
		return this.alturaIzq; }
	public int getAlturaDer(){
		return this.alturaDer; }
	
	//Setters
	public void nuevoValor(Object d){ 
		dato = d; }
	public void ramaIzdo(Nodo n){ 
		ramaIzdo = n; }
	public void ramaDcho(Nodo n){ 
		ramaDcho = n; }
	public void setFe(int fe){
		this.fe=fe;
	}
	public void setAlturaIzq(int altura){
		this.alturaIzq = altura;
		this.fe = alturaDer - alturaIzq;
	}
	public void setAlturaDer(int altura){
		this.alturaIzq = altura;
		this.fe = alturaDer - alturaIzq;
		
	}
}

