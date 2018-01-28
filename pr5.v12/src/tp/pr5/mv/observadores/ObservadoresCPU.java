package tp.pr5.mv.observadores;

import tp.pr5.mv.AccessMemory;
import tp.pr5.mv.AccessPila;

public interface ObservadoresCPU {
	
	public void onHalted();
	public void onInstructionError(String error);
	public void onInstructionStart(String instruccion);
	public void onInstructionEnd(int pc, AccessMemory mem, AccessPila pila, int instr);
	public void onStart(String[] arrayInstrucciones, int numInstrucciones);

	
}
