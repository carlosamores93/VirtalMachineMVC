package tp.pr5.mv.others.instructions;

import java.io.IOException;

import tp.pr5.mv.Instruction;
import tp.pr5.mv.Memory;
import tp.pr5.mv.OperandStack;
import tp.pr5.mv.entrada.InMethod;
import tp.pr5.mv.excepciones.ExceptionMemory;
import tp.pr5.mv.excepciones.ExceptionStack;
import tp.pr5.mv.others.RestoInstruciones;
import tp.pr5.mv.salida.OutMethod;

public class InInstruction extends RestoInstruciones {

	@Override
	public Instruction parse(String line) throws NumberFormatException {
		// TODO Auto-generated method stub
		Instruction inst = null;
		String [] subCadenas = line.split(" ");
		if(subCadenas.length == 1 && subCadenas[0].equalsIgnoreCase("IN")){
			inst = new InInstruction();
		}
		return inst;
	}
	
	public String toString(){
		return "IN";
	}

	@Override
	public boolean operar(OperandStack op, Memory memoria, OutMethod out,
			InMethod in) throws ExceptionMemory, ExceptionStack, IOException {
		// TODO Auto-generated method stub
		int cima = in.read();
		op.apilar(cima);
		
		return true;
	}
}
