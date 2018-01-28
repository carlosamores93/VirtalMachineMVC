package tp.pr5.mv.controladores;

import java.io.IOException;

import tp.pr5.mv.CPU;
import tp.pr5.mv.commands.RunCommand;
import tp.pr5.mv.excepciones.InstructionExecutionException;
import tp.pr5.mv.observadores.ObservadoresCPU;

public class ControladorBatch {
	
	private CPU cpu;
	
	public ControladorBatch(CPU cpu2) {
		// TODO Auto-generated constructor stub
		this.cpu = cpu2;
	}

	public void start() {
		// TODO Auto-generated method stub
		cpu.start();
		
		RunCommand run = new RunCommand();
		try {
			run.executeComand(cpu);
		} catch (InstructionExecutionException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}

	public void addObservador(ObservadoresCPU observador ) {
		// TODO Auto-generated method stub
		cpu.addObservadorCPU(observador);
	}

}
