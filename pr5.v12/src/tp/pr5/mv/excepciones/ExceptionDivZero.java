package tp.pr5.mv.excepciones;

@SuppressWarnings("serial")
public class ExceptionDivZero extends InstructionExecutionException {
	public ExceptionDivZero(){
		super("División por cero");
	}
}
