package tp.pr5.mv.jumps.instructions;
import tp.pr5.mv.*;
import tp.pr5.mv.excepciones.ExceptionStack;
import tp.pr5.mv.jumps.Saltos;

public class BtInstruction extends Saltos {
	
	private int n;
	
	public BtInstruction(){
	}
	
	public BtInstruction(int num){
		this.n = num;
	}
	
	@Override
	public boolean operar(OperandStack op, ProgramCounter programC) throws ExceptionStack {
		// TODO Auto-generated method stub
		boolean ok = true;
		if(op.sizePila() >= 1){
			int cima = op.getValorPila(op.sizePila() - 1);
			op.desapilar();
			if(cima != 0){
				programC.setIntrEjecutar(n);
			}else{
				programC.incrementarInstrcEjecutar();
			}
		}else{
			ok = false;
			throw new ExceptionStack("BT", op.sizePila());
		}
		return ok;
	}

	@Override
	public Instruction parse(String line) throws NumberFormatException {
		Instruction inst = null;
		// TODO Auto-generated method stub
		String [] subCadenas = line.split(" ");
		if(subCadenas.length == 2 && subCadenas[0].equalsIgnoreCase("BT")){
			try {
				this.n = Integer.parseInt(subCadenas[1]);
			if(this.n >= 0){
				inst = new BtInstruction(n);
				}
			} catch (NumberFormatException e) {
				// TODO: handle exception
				throw new NumberFormatException("Error: Instrucción incorrecta");
			}
			
		}
		return inst;
	}
	
	public String toString(){
		return "BT " + this.n;
	}
	
}
