package tp.pr5.mv.others;
import java.io.IOException;

import tp.pr5.mv.*;
import tp.pr5.mv.entrada.InMethod;
import tp.pr5.mv.excepciones.ExceptionMemory;
import tp.pr5.mv.excepciones.ExceptionStack;
import tp.pr5.mv.excepciones.InstructionExecutionException;
import tp.pr5.mv.salida.OutMethod;

abstract public class RestoInstruciones extends Instruction {

	abstract public boolean operar(OperandStack op, Memory memoria, OutMethod out, InMethod in) throws ExceptionMemory, ExceptionStack, IOException;
	abstract public Instruction parse (String line) throws NumberFormatException;
	
	@Override
	public void execute(OperandStack op, Memory memoria, ProgramCounter programC, OutMethod out, InMethod in) throws InstructionExecutionException, IOException {
		// TODO Auto-generated method stub
		if(operar(op, memoria, out, in)){
			programC.incrementarPC();
			programC.incrementarInstrcEjecutar();
		}
	}

	
}
