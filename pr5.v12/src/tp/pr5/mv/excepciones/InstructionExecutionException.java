package tp.pr5.mv.excepciones;


@SuppressWarnings("serial")
public class InstructionExecutionException extends Exception {
	
	public InstructionExecutionException(String line){
		super(line);
	}
}
