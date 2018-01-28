package tp.pr5.mv.jumps;

import tp.pr5.mv.*;
import tp.pr5.mv.entrada.InMethod;
import tp.pr5.mv.excepciones.ExceptionStack;
import tp.pr5.mv.excepciones.InstructionExecutionException;
import tp.pr5.mv.salida.OutMethod;

abstract public class Saltos extends Instruction {

	abstract public boolean operar(OperandStack op, ProgramCounter programC) throws ExceptionStack;
	abstract public Instruction parse(String line) throws NumberFormatException;
	
	@Override
	public void execute(OperandStack op, Memory memoria, ProgramCounter programC, OutMethod out, InMethod in) throws InstructionExecutionException {
		// TODO Auto-generated method stub
		boolean ok = operar(op, programC);
		if(ok){ // Si es correcto aumentamos el contador de programa
			programC.incrementarPC();
			}
	}
	

}
