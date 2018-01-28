package tp.pr5.mv.others.instructions;

import tp.pr5.mv.*;
import tp.pr5.mv.entrada.InMethod;
import tp.pr5.mv.excepciones.ExceptionMemory;
import tp.pr5.mv.excepciones.ExceptionStack;
import tp.pr5.mv.others.RestoInstruciones;
import tp.pr5.mv.salida.OutMethod;

public class WriteInstruction extends RestoInstruciones {
	
	private int posicion, valor;
	
	public WriteInstruction(){
		
	}
	
	public WriteInstruction(int pos, int val){
		this.posicion = pos;
		this.valor = val;
	}
	
	@Override
	public boolean operar(OperandStack op, Memory memoria, OutMethod out, InMethod in) throws ExceptionMemory, ExceptionStack {
		// TODO Auto-generated method stub
		boolean ok = true;
		memoria.escribirEnMemoria(posicion, valor);
		return ok;
	}

	@Override
	public Instruction parse(String line) throws NumberFormatException {
		// TODO Auto-generated method stub
		Instruction inst = null;
		String [] subCadenas = line.split(" ");
		if(subCadenas.length == 3 && subCadenas[0].equalsIgnoreCase("WRITE")){
			try {
				this.posicion = Integer.parseInt(subCadenas[1]);
				this.valor = Integer.parseInt(subCadenas[2]);
				if(this.posicion >= 0){
					inst = new WriteInstruction(this.posicion, this.valor);
				}
			} catch (NumberFormatException e) {
				// TODO: handle exception
				throw new NumberFormatException("Error: Instrucción incorrecta");
			}
		}
		return inst;
	}
	
	public String toString(){
		return "WRITE " + this.posicion + " " + this.valor;
	}

}
