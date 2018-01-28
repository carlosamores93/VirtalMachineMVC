package tp.pr5.mv;

import java.util.Vector;

import tp.pr5.mv.observadores.ObservadorMemoria;

public class Memory implements AccessMemory{
	
	private final int SIZE_MEMORY = 100;
	private int contador;
	private DataMemoryRegister [] registroMemoria;
	private Vector<ObservadorMemoria> observadores;
	
	public Memory(){
		this.registroMemoria = new DataMemoryRegister[SIZE_MEMORY];
		this.contador = 0;
		this.observadores = new  Vector<ObservadorMemoria>();
	}
	
	public void escribirEnMemoria(int pos, int valor){
		DataMemoryRegister aux = new DataMemoryRegister(pos, valor);
		int indice = estaMemoria(pos);
		if(indice == -1){
			int i = 0;
			// Insertamos ordenado si la posicion no esta en memoria
			while ((i < contador) && (registroMemoria[i].getPosicion() < pos)){ 
				i++;
			}
			for (int j = contador; j > i; j--){ // Desplazamos una posici�n a la derecha 
				registroMemoria[j] = registroMemoria[j - 1]; 
		    }
			this.registroMemoria[i] = aux;
			this.contador++;
		}else{
			this.registroMemoria[indice] = aux;
		}
		
		notificarWrite(pos, valor);
	}
	
	
	private void notificarWrite(int pos, int valor) {
		// TODO Auto-generated method stub
		for (ObservadorMemoria i : observadores) {
			i.onWrite(pos, valor);
		}
	}

	// Comprobamos si una posicion ya esta escrita en memoria, si est� se devuelve el indice, sino -1
	public int estaMemoria(int posicion){
		boolean esta = false;
		int i = 0;
		while(i < contador && !esta){
			if(registroMemoria[i].getPosicion() == posicion){
				esta = true;
			}else{
				i++;
				}
		}
		if(!esta){
			i = -1;
		}
		return i;
	}
	
	
	public int obtenerValor(int i){
		return this.registroMemoria[i].getValor();
	}
	
	public int obtenerPosicion(int i){
		return this.registroMemoria[i].getPosicion();
	}
	
	
	public int sizeMemoria(){
		return this.contador;
	}

	public void addObserver(ObservadorMemoria observadorMemoria) {
		// TODO Auto-generated method stub
		observadores.add(observadorMemoria);
	}
	
	@Override
	public String toString(){
		String cadena;
		cadena = "Memoria:";
		if(contador == 0){
			cadena += " <vacía>";
		}else{
			for(int i = 0; i < contador; i++){
				cadena += " [" + this.obtenerPosicion(i) + "]:" + this.obtenerValor(i);
			}
		}
		return cadena;
	}
}