package tp.pr5.mv.others.instructions;
import tp.pr5.mv.*;
import tp.pr5.mv.entrada.InMethod;
import tp.pr5.mv.excepciones.ExceptionMemory;
import tp.pr5.mv.excepciones.ExceptionStack;
import tp.pr5.mv.others.RestoInstruciones;
import tp.pr5.mv.salida.OutMethod;

public class FlipInstruction extends RestoInstruciones {

	@Override
	public boolean operar(OperandStack op, Memory memoria, OutMethod out, InMethod in) throws ExceptionMemory, ExceptionStack {
		// TODO Auto-generated method stub
		boolean ok = true;
		int cima, subcima;
		if(op.sizePila() >= 2){
			cima = op.getValorPila(op.sizePila() - 1);
			subcima = op.getValorPila(op.sizePila() - 2);
			op.desapilar();
			op.desapilar();
			op.apilar(cima);
			op.apilar(subcima);
		}else{
			throw new ExceptionStack("FLIP", op.sizePila());
		}
		return ok;
	}

	@Override
	public Instruction parse(String line) throws NumberFormatException {
		Instruction inst = null;
		// TODO Auto-generated method stub
		String [] subCadenas = line.split(" ");
		if(subCadenas.length == 1 && subCadenas[0].equalsIgnoreCase("FLIP")){
			inst = new FlipInstruction();
		}
		return inst;
	}
	
	public String toString(){
		return "FLIP";
	}
	
}
