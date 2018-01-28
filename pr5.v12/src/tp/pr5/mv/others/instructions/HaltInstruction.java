package tp.pr5.mv.others.instructions;
import tp.pr5.mv.*;
import tp.pr5.mv.entrada.InMethod;
import tp.pr5.mv.excepciones.ExceptionMemory;
import tp.pr5.mv.excepciones.ExceptionStack;
import tp.pr5.mv.others.RestoInstruciones;
import tp.pr5.mv.salida.OutMethod;

public class HaltInstruction extends RestoInstruciones {

	@Override
	public boolean operar(OperandStack op, Memory memoria, OutMethod out, InMethod in) throws ExceptionMemory, ExceptionStack {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Instruction parse(String line) throws NumberFormatException {
		// TODO Auto-generated method stub
		Instruction inst = null;
		// TODO Auto-generated method stub
		String [] subCadenas = line.split(" ");
		if(subCadenas.length == 1 && subCadenas[0].equalsIgnoreCase("HALT")){
			inst = new HaltInstruction();
		}
		return inst;
	}
	
	public String toString(){
		return "HALT";
	}
	
}
