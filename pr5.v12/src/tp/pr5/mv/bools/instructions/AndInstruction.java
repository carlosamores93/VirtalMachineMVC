package tp.pr5.mv.bools.instructions;
import tp.pr5.mv.*;
import tp.pr5.mv.bools.Booleans;
import tp.pr5.mv.excepciones.ExceptionStack;

public class AndInstruction extends Booleans {

	@Override
	public Instruction parse(String line) throws NumberFormatException {
		Instruction inst = null;
		// TODO Auto-generated method stub
		String [] subCadenas = line.split(" ");
		if(subCadenas.length == 1 && subCadenas[0].equalsIgnoreCase("AND")){
			inst = new AndInstruction();
		}
		return inst;
	}

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
			if (cima != 0 && subcima != 0){
				op.apilar(1);
			}else{
				op.apilar(0);
			}
		}else{
			ok = false;
			throw new ExceptionStack("AND", op.sizePila());
		}
		return ok;
	}
	
	public String toString(){
		return "AND";
	}
}
