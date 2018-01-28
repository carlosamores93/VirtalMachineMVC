package tp.pr5.mv.indirecto;

import tp.pr5.mv.Instruction;
import tp.pr5.mv.Memory;
import tp.pr5.mv.OperandStack;
import tp.pr5.mv.ProgramCounter;
import tp.pr5.mv.entrada.InMethod;
import tp.pr5.mv.excepciones.ExceptionMemory;
import tp.pr5.mv.excepciones.ExceptionStack;
import tp.pr5.mv.excepciones.InstructionExecutionException;
import tp.pr5.mv.salida.OutMethod;

public abstract class Indirecto extends Instruction {

	abstract public Instruction parse(String line) throws NumberFormatException;
	abstract public boolean operar(OperandStack op, Memory memoria, ProgramCounter pc ) throws ExceptionStack, ExceptionMemory;
	
	@Override
	public void execute(OperandStack op, Memory memoria, ProgramCounter pc,
			OutMethod out, InMethod in) throws InstructionExecutionException {
		// TODO Auto-generated method stub 
		if(operar(op, memoria, pc)){ // Si es correcto aumentamos el contador de programa
			pc.incrementarPC();
			}
		
	}

}
