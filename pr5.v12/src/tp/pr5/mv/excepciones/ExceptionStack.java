package tp.pr5.mv.excepciones;

@SuppressWarnings("serial")
public class ExceptionStack extends InstructionExecutionException {

	public ExceptionStack (String instr, int operandos) {
		super("Error ejecutando " + instr + ": faltan operandos en la pila (Hay " + operandos + ")");
	}
	
}
