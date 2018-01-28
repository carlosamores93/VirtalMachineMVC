package tp.pr5.mv;

import java.io.IOException;

import tp.pr5.mv.excepciones.InstructionExecutionException;

abstract public class CommandInterpreter {
	
	
	public abstract boolean executeComand(CPU cpu) throws InstructionExecutionException, IOException;
	
	abstract public CommandInterpreter parse(String line);
	
}
