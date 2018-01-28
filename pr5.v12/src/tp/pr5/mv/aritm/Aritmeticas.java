package tp.pr5.mv.aritm;
import tp.pr5.mv.*;
import tp.pr5.mv.entrada.InMethod;
import tp.pr5.mv.excepciones.ExceptionDivZero;
import tp.pr5.mv.excepciones.ExceptionStack;
import tp.pr5.mv.salida.OutMethod;

abstract public class Aritmeticas extends Instruction {
	
	
	abstract public boolean operar(OperandStack pila) throws ExceptionDivZero, ExceptionStack;
	
	@Override
	abstract public Instruction parse(String line) throws NumberFormatException;
	
	@Override
	public void execute(OperandStack op, Memory memoria, ProgramCounter programC, 
			OutMethod out, InMethod in) throws ExceptionStack, ExceptionDivZero {
		// TODO Auto-generated method stub 
		if(this.operar(op)){
			programC.incrementarPC();
			programC.incrementarInstrcEjecutar();
		}
	}
}
