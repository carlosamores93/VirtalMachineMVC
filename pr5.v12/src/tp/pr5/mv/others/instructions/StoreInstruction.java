package tp.pr5.mv.others.instructions;
import tp.pr5.mv.*;
import tp.pr5.mv.entrada.InMethod;
import tp.pr5.mv.excepciones.ExceptionMemory;
import tp.pr5.mv.excepciones.ExceptionStack;
import tp.pr5.mv.others.RestoInstruciones;
import tp.pr5.mv.salida.OutMethod;

public class StoreInstruction extends RestoInstruciones {

	private int n;
	
	public StoreInstruction(){
	}
	
	public StoreInstruction(int num){
		this.n = num;
	}
	
	@Override
	public boolean operar(OperandStack op, Memory memoria, OutMethod out, InMethod in) throws ExceptionMemory, ExceptionStack {
		// TODO Auto-generated method stub
		boolean ok = true;
		int cima;
		if((op.sizePila()) > 0 && (n >= 0)){
			cima =  op.getValorPila(op.sizePila() - 1);
			memoria.escribirEnMemoria(n, cima);
			op.desapilar();
		} else{
			ok = false;
			throw new ExceptionStack("STORE", op.sizePila());
		}
		return ok;
	}

	@Override
	public Instruction parse(String line) throws NumberFormatException{
		Instruction inst = null;
		// TODO Auto-generated method stub
		String [] subCadenas = line.split(" ");
		if(subCadenas.length == 2 && subCadenas[0].equalsIgnoreCase("STORE")){
			try {
				this.n = Integer.parseInt(subCadenas[1]);
				if(this.n >= 0){
				inst = new StoreInstruction(n);
				}
			} catch (NumberFormatException e) {
				// TODO: handle exception
				throw new NumberFormatException("Error: Instrucción incorrecta");
			}
		}
		return inst;
	}
	
	public String toString(){
		return "STORE " + this.n;
	}
	
}
