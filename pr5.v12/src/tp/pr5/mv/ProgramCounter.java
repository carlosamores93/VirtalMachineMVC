package tp.pr5.mv;

public class ProgramCounter {
	
	private int contadorPrograma, instruccionEjecutar;
	
	public ProgramCounter(){
		this.contadorPrograma = 0;
		this.instruccionEjecutar = 0;
	}
	
	public void incrementarPC(){
		this.contadorPrograma++;
	}
	
	public void incrementarInstrcEjecutar(){
		this.instruccionEjecutar++;
	}
	
	public int getPC(){
		return this.contadorPrograma;
	}
	
	public void setPC(int num){
		this.contadorPrograma = num;
	}
	
	public int getInstrEjecutar(){
		return this.instruccionEjecutar;
	}
	
	public void setIntrEjecutar(int numInstr){
		this.instruccionEjecutar = numInstr;
	}
	
}
