package tp.pr5.mv;

import java.io.IOException;

import tp.pr5.mv.entrada.InMethod;
import tp.pr5.mv.excepciones.InstructionExecutionException;
import tp.pr5.mv.salida.OutMethod;

abstract public  class Instruction {
	
	abstract public void execute(OperandStack op, Memory memoria, ProgramCounter pc, OutMethod out, InMethod in) throws InstructionExecutionException, IOException;
	
	abstract public Instruction parse (String line) throws NumberFormatException;

}
