package tp.pr5.mv.jumps.relativos;

import tp.pr5.mv.Instruction;
import tp.pr5.mv.OperandStack;
import tp.pr5.mv.ProgramCounter;
import tp.pr5.mv.excepciones.ExceptionStack;
import tp.pr5.mv.jumps.Saltos;

public class RjumpInstruction extends Saltos {
	
	private int n;
	
	public RjumpInstruction(){
	}
	
	public RjumpInstruction(int num){
		this.n = num;
	}
	
	@Override
	public boolean operar(OperandStack op, ProgramCounter programC) throws ExceptionStack {
		// TODO Auto-generated method stub
		boolean ok = true;
		int num = programC.getInstrEjecutar();
		num = num + n;
		programC.setIntrEjecutar(num);
		return ok;
	}

	@Override
	public Instruction parse(String line) throws NumberFormatException {
		// TODO Auto-generated method stub
		Instruction inst = null;
		String [] subCadenas = line.split(" ");
		if(subCadenas.length == 2 && subCadenas[0].equalsIgnoreCase("RJUMP")){
			try {
				this.n = Integer.parseInt(subCadenas[1]);
				inst = new RjumpInstruction(n);
			} catch (NumberFormatException e) {
				// TODO: handle exception
				throw new NumberFormatException("Error: Instrucción incorrecta");
			}
			
		}
		return inst;
	}
	
	public String toString(){
		return "RJUMP " + this.n;
	}
	
}
