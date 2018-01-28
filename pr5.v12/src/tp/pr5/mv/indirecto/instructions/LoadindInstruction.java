package tp.pr5.mv.indirecto.instructions;

import tp.pr5.mv.Instruction;
import tp.pr5.mv.Memory;
import tp.pr5.mv.OperandStack;
import tp.pr5.mv.ProgramCounter;
import tp.pr5.mv.excepciones.ExceptionMemory;
import tp.pr5.mv.excepciones.ExceptionStack;
import tp.pr5.mv.indirecto.Indirecto;

public class LoadindInstruction extends Indirecto {

	@Override
	public Instruction parse(String line) throws NumberFormatException {
		// TODO Auto-generated method stub
		Instruction inst = null;
		String [] subCadenas = line.split(" ");
		if(subCadenas.length == 1 && subCadenas[0].equalsIgnoreCase("LOADIND")){
			inst = new LoadindInstruction();
		}
		return inst;
	}
	
	public String toString(){
		return "LOADIND";
	}

	@Override
	public boolean operar(OperandStack op, Memory memoria, ProgramCounter pc)
			throws ExceptionStack, ExceptionMemory {
		// TODO Auto-generated method stub
		boolean ok = true;
		if(op.sizePila() >= 1){
			int cima = op.getValorPila(op.sizePila() - 1);
			int pos = memoria.estaMemoria(cima); // Lee de la posicion "cima", sino hay nada devuelve -1
			if(pos == -1){
				throw new ExceptionMemory("LOADIND", cima);
			}else{
				op.desapilar();
				op.apilar(memoria.obtenerValor(pos));
				pc.incrementarInstrcEjecutar();
			}
			
		}else{
			ok = false;
			throw new ExceptionStack("LOADIN", op.sizePila());
		}
		return ok;
	}
}
