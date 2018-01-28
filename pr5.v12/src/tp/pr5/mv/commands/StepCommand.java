package tp.pr5.mv.commands;

import java.io.IOException;

import tp.pr5.mv.CPU;
import tp.pr5.mv.CommandInterpreter;
import tp.pr5.mv.excepciones.InstructionExecutionException;

abstract public class StepCommand extends CommandInterpreter {
	
	public abstract CommandInterpreter parse(String line);
	public abstract boolean executeComand(CPU cpu) throws InstructionExecutionException, IOException;
	
}
