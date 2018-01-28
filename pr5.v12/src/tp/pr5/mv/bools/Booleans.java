package tp.pr5.mv.bools;
import tp.pr5.mv.*;
import tp.pr5.mv.entrada.InMethod;
import tp.pr5.mv.excepciones.ExceptionStack;
import tp.pr5.mv.salida.OutMethod;

abstract public class Booleans extends Instruction {

	abstract public boolean operar(OperandStack op) throws ExceptionStack;
	
	@Override
	abstract public Instruction parse(String line) throws NumberFormatException;
	
	@Override
	public void execute(OperandStack op, Memory memoria, ProgramCounter programC, 
			OutMethod out, InMethod in) throws ExceptionStack {
		
		if(this.operar(op)){
			programC.incrementarPC();
			programC.incrementarInstrcEjecutar();
		}
	}

}
