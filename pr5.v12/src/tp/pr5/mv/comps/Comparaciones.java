package tp.pr5.mv.comps;
import tp.pr5.mv.*;
import tp.pr5.mv.entrada.InMethod;
import tp.pr5.mv.excepciones.ExceptionStack;
import tp.pr5.mv.excepciones.InstructionExecutionException;
import tp.pr5.mv.salida.OutMethod;

abstract public class Comparaciones extends Instruction {
	
	@Override
	abstract public Instruction parse(String line) throws NumberFormatException;
	abstract public boolean operar(OperandStack op) throws ExceptionStack;
	
	@Override
	public void execute(OperandStack op, Memory memoria, ProgramCounter programC, OutMethod out, InMethod in) throws InstructionExecutionException {
		// TODO Auto-generated method stub
		if(operar(op)){
			programC.incrementarPC();
			programC.incrementarInstrcEjecutar();
		}
	}

	

}
