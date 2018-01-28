package tp.pr5.mv;

public class DataMemoryRegister {
	
	private int posicion;
	private int valor;
	
	public DataMemoryRegister(){
		this.posicion = 0;
		this.valor = 0;
	}
	
	public DataMemoryRegister(int pos, int valor){
		this.posicion = pos;
		this.valor = valor;
	}
	
	public int getValor(){
		return this.valor;
	}
	
	public int getPosicion(){
		return this.posicion;
	}
	
}
