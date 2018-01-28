package tp.pr5.mv.others.instructions;

import tp.pr5.mv.*;
import tp.pr5.mv.entrada.InMethod;
import tp.pr5.mv.excepciones.ExceptionMemory;
import tp.pr5.mv.excepciones.ExceptionStack;
import tp.pr5.mv.others.RestoInstruciones;
import tp.pr5.mv.salida.OutMethod;

public class LoadInstruction extends RestoInstruciones {
	
	private int n;
	
	public LoadInstruction(){
	}
	
	public LoadInstruction(int num){
		this.n = num;
	}
	
	@Override
	public boolean operar(OperandStack op, Memory memoria, OutMethod out, InMethod in) throws ExceptionMemory, ExceptionStack {
		// TODO Auto-generated method stub
		boolean ok = true;
		int i = memoria.estaMemoria(n); // Si no esta devuelve un -1, si esta devuelve el indice
		if(i == -1){
			ok = false;
			throw new ExceptionMemory("LOAD", n);
		}else{
			op.apilar(memoria.obtenerValor(i));
		}
		return ok;
	}

	@Override
	public Instruction parse(String line) throws NumberFormatException {
		Instruction inst = null;
		// TODO Auto-generated method stub
		String [] subCadenas = line.split(" ");
		if(subCadenas.length == 2 && subCadenas[0].equalsIgnoreCase("LOAD")){
			try {
				this.n = Integer.parseInt(subCadenas[1]);
				if(this.n >= 0){
				inst = new LoadInstruction(n);
				}
			} catch (NumberFormatException e) {
				// TODO: handle exception
				throw new NumberFormatException("Error: Instrucción incorrecta");
			}
			
		}
		return inst;
	}
	
	public String toString(){
		return "LOAD " + this.n;
	}
	
}
