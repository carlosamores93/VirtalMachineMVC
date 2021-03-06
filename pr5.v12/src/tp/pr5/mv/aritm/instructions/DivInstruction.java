package tp.pr5.mv.aritm.instructions;
import tp.pr5.mv.*;
import tp.pr5.mv.aritm.Aritmeticas;
import tp.pr5.mv.excepciones.ExceptionDivZero;
import tp.pr5.mv.excepciones.ExceptionStack;

public class DivInstruction extends Aritmeticas {
	
	@Override
	public boolean operar(OperandStack pila) throws ExceptionDivZero, ExceptionStack{
		boolean ok = true;
		if(pila.sizePila() >= 2){
			int cima = pila.getValorPila(pila.sizePila() - 1);
			int subcima = pila.getValorPila(pila.sizePila() - 2);
			pila.desapilar();
			pila.desapilar();
			if(cima == 0){
				ok = false;
				throw new ExceptionDivZero();
			}else{
				int result = subcima / cima;
				pila.apilar(result);
			}
		}else{
			ok = false;
			throw new ExceptionStack("DIV", pila.sizePila());
		}
		return ok;
	}

	@Override
	public Instruction parse(String line) throws NumberFormatException {
		Instruction inst = null;
		// TODO Auto-generated method stub
		String [] subCadenas = line.split(" ");
		if(subCadenas.length == 1 && subCadenas[0].equalsIgnoreCase("DIV")){
			inst = new DivInstruction();
		}
		return inst;
	}
	
	public String toString(){
		return "DIV";
	}
}
