package tp.pr5.mv.windows;

public class CeldaMemoria {
private int direccion, valor;
	
	public CeldaMemoria(int dir, int val){
		this.direccion = dir;
		this.valor = val;
	}

	public int getDireccion(){
		return direccion;
	}
	
	public int getValor(){
		return valor;
	}

	public void setCelda(CeldaMemoria celda) {
		// TODO Auto-generated method stub
		this.direccion = celda.direccion;
		this.valor = celda.valor;
	}
}
