package tp.pr5.mv.jumps.relativos;

import tp.pr5.mv.*;
import tp.pr5.mv.excepciones.ExceptionStack;
import tp.pr5.mv.jumps.Saltos;

public class RbfInstruction extends Saltos {
	
	private int n;
	
	public RbfInstruction(){
	}
	
	public RbfInstruction(int num){
		this.n = num;
	}
	
	
	@Override
	public boolean operar(OperandStack op, ProgramCounter programC) throws ExceptionStack {
		// TODO Auto-generated method stub
		boolean ok = true;
		if(op.sizePila() >= 1 ){
			int cima = op.getValorPila(op.sizePila() - 1);
			op.desapilar();
			if(cima == 0){
				int num = programC.getInstrEjecutar();
				num = num + n;
				programC.setIntrEjecutar(num);
			}else{
				programC.incrementarInstrcEjecutar();
			}
		}else{
			throw new ExceptionStack("RBF", op.sizePila());
		}
		return ok;
	}

	@Override
	public Instruction parse(String line) throws NumberFormatException {
		Instruction inst = null;
		// TODO Auto-generated method stub
		String [] subCadenas = line.split(" ");
		if(subCadenas.length == 2 && subCadenas[0].equalsIgnoreCase("RBF")){
			try {
				this.n = Integer.parseInt(subCadenas[1]);
				inst = new RbfInstruction(n);
			} catch (NumberFormatException e) {
				// TODO: handle exception
				throw new NumberFormatException("Error: Instrucción incorrecta");
			}
			
			
		}
		return inst;
	}
	
	public String toString(){
		return "RBF " + this.n;
	}
	
}
