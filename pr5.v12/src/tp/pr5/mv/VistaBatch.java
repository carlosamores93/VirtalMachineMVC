package tp.pr5.mv;

import tp.pr5.mv.controladores.ControladorBatch;
import tp.pr5.mv.observadores.ObservadoresCPU;

public class VistaBatch implements ObservadoresCPU {
	
	
	public VistaBatch(ControladorBatch controladorBatch){
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onHalted() {
		// TODO Auto-generated method stub
		System.exit(1);
	}

	@Override
	public void onInstructionError(String error) {
		// TODO Auto-generated method stub
		System.err.println(error);
		System.exit(1);
	}

	@Override
	public void onInstructionStart(String instruccion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onInstructionEnd(int pc, AccessMemory mem,
			AccessPila pila, int instru) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onStart(String[] arrayInstrucciones, int numInstrucciones) {
		// TODO Auto-generated method stub
		System.out.println("El programa introducido es:");
		for (int i = 0; i < numInstrucciones; i++) {
			System.out.println(i + ": " + arrayInstrucciones[i]);
		}
	}
	
}
