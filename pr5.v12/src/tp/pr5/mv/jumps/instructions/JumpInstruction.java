package tp.pr5.mv.jumps.instructions;
import tp.pr5.mv.*;
import tp.pr5.mv.excepciones.ExceptionStack;
import tp.pr5.mv.jumps.Saltos;

public class JumpInstruction extends Saltos {

	private int n;
	
	public JumpInstruction(){
	}
	
	public JumpInstruction(int num){
		this.n = num;
	}
	
	@Override
	public boolean operar(OperandStack op, ProgramCounter programC) throws ExceptionStack {
		// TODO Auto-generated method stub
		boolean ok = true;
		programC.setIntrEjecutar(n);
		return ok;
	}

	@Override
	public Instruction parse(String line) throws NumberFormatException {
		Instruction inst = null;
		// TODO Auto-generated method stub
		String [] subCadenas = line.split(" ");
		if(subCadenas.length == 2 && subCadenas[0].equalsIgnoreCase("JUMP")){
			try {
				this.n = Integer.parseInt(subCadenas[1]);
				if(this.n >= 0){
					inst = new JumpInstruction(n);
					}
			} catch (NumberFormatException e) {
				// TODO: handle exception
				throw new NumberFormatException("Error: Instrucción incorrecta");
			}	
		}
		return inst;
	}
	
	public String toString(){
		return "JUMP " + this.n;
	}
	
}
