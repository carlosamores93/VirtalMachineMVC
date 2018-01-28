package tp.pr5.mv;

import java.util.Vector;

import tp.pr5.mv.observadores.ObservadoresPila;

public class OperandStack implements AccessPila{
	
	private int [] pilaOperandos;
	private int contador;
	private final int SIZE_PILA = 100;
	private Vector<ObservadoresPila> observadores;
	
	public OperandStack(){
		this.pilaOperandos = new int[SIZE_PILA];
		this.contador = 0;
		this.observadores = new Vector<ObservadoresPila>();
	}
	
	public void apilar(int valor){
		this.pilaOperandos[contador] = valor;
		this.contador++;
		notificarPush(valor);
	}
	
	private void notificarPush(int valor) {
		// TODO Auto-generated method stub
		for (ObservadoresPila i : observadores) {
			i.onPush(valor);
		}		
	}

	public void desapilar(){
		this.contador--;
		notificarPop();
	}
	
	private void notificarPop() {
		// TODO Auto-generated method stub
		for (ObservadoresPila i : observadores) {
			i.onPop();
		}
	}

	public int sizePila(){
		return this.contador;
	}
	
	public int getValorPila(int pos){
		return this.pilaOperandos[pos];
	}
	
	
	public void addObserver(ObservadoresPila observadorPila){
		this.observadores.add(observadorPila);
	}
	
	
	@Override
	public String toString(){
		String cadena = "";
		cadena += "Pila de operandos:";
		if(this.contador == 0){
			cadena += " <vacía>";
		}else{
			for(int i = 0; i < contador; i++){
				cadena += " " + this.getValorPila(i);
			}
		}
		return cadena;
	}
	
}
