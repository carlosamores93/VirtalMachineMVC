package tp.pr5.mv;

import tp.pr5.mv.controladores.ControladorInteractive;
import tp.pr5.mv.observadores.ObservadoresCPU;

public class VistaInteractive implements ObservadoresCPU{

	private ControladorInteractive controlInteractive;
	
	public VistaInteractive(ControladorInteractive controladorInteractive) {
		// TODO Auto-generated constructor stub
		this.controlInteractive = controladorInteractive;
	}

	@Override
	public void onStart(String[] arrayInstrucciones, int numInstrucciones) {
		// TODO Auto-generated method stub
		System.out.println("El programa introducido es:");
		for (int i = 0; i < numInstrucciones; i++) {
			System.out.println(i + ": " + arrayInstrucciones[i]);
		}
	}

	@Override
	public void onHalted() {
		// TODO Auto-generated method stub
		controlInteractive.terminarEjecucion();
	}

	@Override
	public void onInstructionError(String error) {
		// TODO Auto-generated method stub
		System.out.println(error);
	}

	@Override
	public void onInstructionStart(String instruccion) {
		// TODO Auto-generated method stub
		System.out.println("Comienza la ejecucion de " + instruccion);
	}

	@Override
	public void onInstructionEnd(int pc, AccessMemory mem, AccessPila pila, int instru) {
		// TODO Auto-generated method stub
		System.out.println("El estado de la máquina tras ejecutar la instrucción es:");
		System.out.println(mem.toString());
		System.out.println(pila.toString());
		
	}

}
