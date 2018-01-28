package tp.pr5.mv.commands;

import java.io.IOException;

import tp.pr5.mv.CPU;
import tp.pr5.mv.CommandInterpreter;
import tp.pr5.mv.excepciones.InstructionExecutionException;

public class StepsCommand extends StepCommand {
	
	private int n;
	
	public StepsCommand(){
		this.n = 1;  
	}
	
	public StepsCommand(int num){
		this.n = num;
	}
	
	@Override
	public boolean executeComand(CPU cpu) throws InstructionExecutionException, IOException{
		// TODO Auto-generated method stub
		while(this.n != 0 && !cpu.isHalt()){
			cpu.step();
			this.n--;
		}
		return true;
	}
	
	@Override
	public CommandInterpreter parse(String line) {
		// TODO Auto-generated method stub
		CommandInterpreter comando = null;
		String [] subCadenas = line.split(" ");
		if(subCadenas.length == 2 && subCadenas[0].equalsIgnoreCase("STEP")){
			this.n = Integer.parseInt(subCadenas[1]);
			if(this.n >= 0){
				comando = new StepsCommand(this.n);
				}
		}else if(subCadenas.length == 1 && subCadenas[0].equalsIgnoreCase("STEP")){
			comando = new StepsCommand();
		}
		return comando;
	}

}
