package tp.pr5.mv.excepciones;

@SuppressWarnings("serial")
public class ExceptionMemory extends InstructionExecutionException {
	
	public ExceptionMemory(String instr, int dir){
		super("Error ejecutando " + instr + ": direccion vacia (dir " + dir + ")");
	}
	
}
