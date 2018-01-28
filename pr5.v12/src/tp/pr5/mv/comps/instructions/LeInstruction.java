package tp.pr5.mv.comps.instructions;
import tp.pr5.mv.*;
import tp.pr5.mv.comps.Comparaciones;
import tp.pr5.mv.excepciones.ExceptionStack;

public class LeInstruction extends Comparaciones {

	@Override
	public boolean operar(OperandStack op) throws ExceptionStack {
		// TODO Auto-generated method stub
		int resultado;
		boolean ok = true;
		if(op.sizePila() >= 2){
			int cima = op.getValorPila(op.sizePila() -1);
			int subcima = op.getValorPila(op.sizePila() -2);
			op.desapilar();
			op.desapilar();
			if(subcima <= cima){
				resultado = 1;
			}else{
				resultado = 0;
			}
			op.apilar(resultado);
		}else{
			ok = false;
			throw new ExceptionStack("LE", op.sizePila());
		}
		return ok;
	}

	@Override
	public Instruction parse(String line) throws NumberFormatException {
		Instruction inst = null;
		// TODO Auto-generated method stub
		String [] subCadenas = line.split(" ");
		if(subCadenas.length == 1 && subCadenas[0].equalsIgnoreCase("LE")){
			inst = new LeInstruction();
		}
		return inst;
	}
	
	public String toString(){
		return "LE";
	}
	
}
