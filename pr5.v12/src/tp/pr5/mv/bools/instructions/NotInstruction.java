package tp.pr5.mv.bools.instructions;
import tp.pr5.mv.*;
import tp.pr5.mv.bools.Booleans;
import tp.pr5.mv.excepciones.ExceptionStack;

public class NotInstruction extends Booleans {

	@Override
	public boolean operar(OperandStack op) throws ExceptionStack {
		// TODO Auto-generated method stub
		boolean ok = true; // 0 -> false    1 -> cierto
		if(op.sizePila() >= 1){
			int cima;
			cima = op.getValorPila(op.sizePila() - 1);
			op.desapilar();
			if (cima ==  0){ // Si la cima igual a cero, es false y lo niego y apilo true
				op.apilar(1);
			}else{
				op.apilar(0); // Apilo falso
			}
		}else{
			ok = false;
			throw new ExceptionStack("NOT", op.sizePila());
		}
		return ok;
	}

	@Override
	public Instruction parse(String line) throws NumberFormatException {
		Instruction inst = null;
		// TODO Auto-generated method stub
		String [] subCadenas = line.split(" ");
		if(subCadenas.length == 1 && subCadenas[0].equalsIgnoreCase("NOT")){
			inst = new NotInstruction();
		}
		return inst;
	}
	
	public String toString(){
		return "NOT";
	}
}
