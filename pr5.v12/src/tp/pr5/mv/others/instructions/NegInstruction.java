package tp.pr5.mv.others.instructions;

import tp.pr5.mv.*;
import tp.pr5.mv.entrada.InMethod;
import tp.pr5.mv.excepciones.ExceptionMemory;
import tp.pr5.mv.excepciones.ExceptionStack;
import tp.pr5.mv.others.RestoInstruciones;
import tp.pr5.mv.salida.OutMethod;

public class NegInstruction extends RestoInstruciones {

	@Override
	public boolean operar(OperandStack op, Memory memoria, OutMethod out, InMethod in) throws ExceptionMemory, ExceptionStack {
		// TODO Auto-generated method stub
		boolean ok = true;
		int cima;
		if(op.sizePila() >= 1){
			cima = op.getValorPila(op.sizePila() - 1);
			op.desapilar();
			cima = cima * (-1);
			op.apilar(cima);
		}else{
			ok = false;
			throw new ExceptionStack("NEG", op.sizePila());
		}
		return ok;
	}

	@Override
	public Instruction parse(String line) throws NumberFormatException {
		Instruction inst = null;
		// TODO Auto-generated method stub
		String [] subCadenas = line.split(" ");
		if(subCadenas.length == 1 && subCadenas[0].equalsIgnoreCase("NEG")){
			inst = new NegInstruction();
		}
		return inst;
	}
	
	public String toString(){
		return "NEG";
	}
	
}
