package tp.pr5.mv.bools.instructions;
import tp.pr5.mv.*;
import tp.pr5.mv.bools.Booleans;
import tp.pr5.mv.excepciones.ExceptionStack;

public class OrInstruction extends Booleans {

	@Override
	public boolean operar(OperandStack op) throws ExceptionStack {
		// TODO Auto-generated method stub
		boolean ok = true; // 0 -> false    1 -> cierto
		if(op.sizePila() >= 2){
			int cima, subcima;
			cima = op.getValorPila(op.sizePila() - 1);
			subcima = op.getValorPila(op.sizePila() - 2);
			op.desapilar();
			op.desapilar();
			if ((cima != 0 && subcima != 0) || (cima != 0 && subcima == 0) || (cima == 0 && subcima != 0)){ 
				// Si hay alguna cierta o las dos ciertas -> true
				op.apilar(1);
			}else{
				op.apilar(0);
			}
		}else{
			ok = false;
			throw new ExceptionStack("OR", op.sizePila());
		}
		return ok;
	}

	@Override
	public Instruction parse(String line) throws NumberFormatException {
		Instruction inst = null;
		// TODO Auto-generated method stub
		String [] subCadenas = line.split(" ");
		if(subCadenas.length == 1 && subCadenas[0].equalsIgnoreCase("OR")){
			inst = new OrInstruction();
		}
		return inst;
	}
	
	public String toString(){
		return "OR";
	}
}
