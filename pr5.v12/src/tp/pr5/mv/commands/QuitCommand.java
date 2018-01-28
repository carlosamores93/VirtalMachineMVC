package tp.pr5.mv.commands;

import tp.pr5.mv.CPU;
import tp.pr5.mv.CommandInterpreter;

public class QuitCommand extends CommandInterpreter {

	@Override
	public boolean executeComand(CPU cpu) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CommandInterpreter parse(String line) {
		// TODO Auto-generated method stub
		CommandInterpreter comando = null;
		String [] subCadenas = line.split(" ");
		if(subCadenas.length == 1 && subCadenas[0].equalsIgnoreCase("QUIT")){
			comando = new QuitCommand();
		}
		return comando;
	}
}
