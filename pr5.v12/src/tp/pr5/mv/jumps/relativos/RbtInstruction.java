package tp.pr5.mv.jumps.relativos;

import tp.pr5.mv.Instruction;
import tp.pr5.mv.OperandStack;
import tp.pr5.mv.ProgramCounter;
import tp.pr5.mv.excepciones.ExceptionStack;
import tp.pr5.mv.jumps.Saltos;

public class RbtInstruction extends Saltos {
	
	private int n;
	
	public RbtInstruction(){
	}
	
	public RbtInstruction(int num){
		this.n = num;
	}
	
	@Override
	public boolean operar(OperandStack op, ProgramCounter programC) throws ExceptionStack {
		// TODO Auto-generated method stub
		boolean ok = true;
		if(op.sizePila() >= 1 ){
			int cima = op.getValorPila(op.sizePila() - 1);
			op.desapilar();
			if(cima != 0){
				int num = programC.getInstrEjecutar();
				num = num + n;
				programC.setIntrEjecutar(num);
			}else{
				programC.incrementarInstrcEjecutar();
			}
		}else{
			throw new ExceptionStack("RBT", op.sizePila());
		}
		return ok;
	}

	@Override
	public Instruction parse(String line) throws NumberFormatException {
		// TODO Auto-generated method stub
		Instruction inst = null;
		String [] subCadenas = line.split(" ");
		if(subCadenas.length == 2 && subCadenas[0].equalsIgnoreCase("RBT")){
			try {
				this.n = Integer.parseInt(subCadenas[1]);
			inst = new RbtInstruction(n);
			} catch (NumberFormatException e) {
				// TODO: handle exception
				throw new NumberFormatException("Error: Instrucción incorrecta");
			}
			
		}
		return inst;
	}
	
	public String toString(){
		return "RBT " + this.n;
	}

}
