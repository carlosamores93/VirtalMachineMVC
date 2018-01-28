package tp.pr5.mv.indirecto.instructions;

import tp.pr5.mv.Instruction;
import tp.pr5.mv.Memory;
import tp.pr5.mv.OperandStack;
import tp.pr5.mv.ProgramCounter;
import tp.pr5.mv.excepciones.ExceptionMemory;
import tp.pr5.mv.excepciones.ExceptionStack;
import tp.pr5.mv.indirecto.Indirecto;

public class JumpindInstruction extends Indirecto {

	@Override
	public Instruction parse(String line) throws NumberFormatException {
		// TODO Auto-generated method stub
		Instruction inst = null;
		String [] subCadenas = line.split(" ");
		if(subCadenas.length == 1 && subCadenas[0].equalsIgnoreCase("JUMPIND")){
			inst = new JumpindInstruction();
		}
		return inst;
	}
	
	public String toString(){
		return "JUMPIND";
	}

	@Override
	public boolean operar(OperandStack op, Memory memoria, ProgramCounter pc)
			throws ExceptionStack, ExceptionMemory {
		// TODO Auto-generated method stub
		boolean ok = true;
		if(op.sizePila() >= 1){
			int cima = op.getValorPila(op.sizePila() - 1);
			op.desapilar();
			pc.setIntrEjecutar(cima);
			
		}else{
			ok = false;
			throw new ExceptionStack("JUMPIN", op.sizePila());
		}
		
		return ok;
	}
	
}
