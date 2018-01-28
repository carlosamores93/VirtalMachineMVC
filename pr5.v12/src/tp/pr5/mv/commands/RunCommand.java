package tp.pr5.mv.commands;

import java.io.IOException;

import tp.pr5.mv.CPU;
import tp.pr5.mv.CommandInterpreter;
import tp.pr5.mv.excepciones.InstructionExecutionException;

public class RunCommand extends StepCommand {

	@Override
	public CommandInterpreter parse(String line) {
		// TODO Auto-generated method stub
		CommandInterpreter comando = null;
		String [] subCadenas = line.split(" ");
		if(subCadenas.length == 1 && subCadenas[0].equalsIgnoreCase("RUN")){
			comando = new RunCommand();
		}
		return comando;
	}

	@Override
	public boolean executeComand(CPU cpu) throws InstructionExecutionException, IOException{
		// TODO Auto-generated method stub
		while(!cpu.finalInstruciones() && !cpu.isHalt()){
			cpu.step();
		}
		return true;
	}
	
	
}
