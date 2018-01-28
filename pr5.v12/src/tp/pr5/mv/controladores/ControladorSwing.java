package tp.pr5.mv.controladores;

import java.io.IOException;

import tp.pr5.mv.CPU;
import tp.pr5.mv.commands.RunCommand;
import tp.pr5.mv.entrada.InMethod;
import tp.pr5.mv.excepciones.InstructionExecutionException;
import tp.pr5.mv.observadores.ObservadorMemoria;
import tp.pr5.mv.observadores.ObservadoresCPU;
import tp.pr5.mv.observadores.ObservadoresPila;
import tp.pr5.mv.windows.PanelEntrada;
import tp.pr5.mv.windows.PanelSalida;
import tp.pr5.mv.windows.Window;

public class ControladorSwing {
	
	private CPU cpu;
	
	public ControladorSwing(CPU cpu) {
		// TODO Auto-generated constructor stub
		this.cpu = cpu;
	}

	public void push(int val) throws Exception {
		// TODO Auto-generated method stub
		cpu.push(val);
	}

	public void pop() throws Exception {
		// TODO Auto-generated method stub
		cpu.pop();
	}

	public void step(){
		// TODO Auto-generated method stub
		try {
			cpu.step();
		} catch (InstructionExecutionException | IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			//cpu.notificarError(e.getMessage());
		}
	}

	public void run() {
		// TODO Auto-generated method stub
		RunCommand run = new RunCommand();
		try {
			run.executeComand(cpu);
		} catch (InstructionExecutionException | IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			//cpu.notificarError(e.getMessage());
		}
	}

	public void write(int pos, int val) {
		// TODO Auto-generated method stub
		cpu.write(pos, val);
	}
	
	public void addObserverPila(ObservadoresPila observadorPila){
		cpu.addObservadorPila(observadorPila);
	}

	public void addObserverMemoria(ObservadorMemoria observadorMemoria) {
		// TODO Auto-generated method stub
		cpu.addObservadorMemoria(observadorMemoria);
	}

	public void start(Window window) {
		// TODO Auto-generated method stub
		window.pack();
		window.setVisible(true);
		cpu.start();
	}

	public void addObserver(ObservadoresCPU observador) {
		// TODO Auto-generated method stub
		cpu.addObservadorCPU(observador);
	}

	public void setSalidaPanel(PanelSalida panelSalida) {
		// TODO Auto-generated method stub
		cpu.setSalidaPanel(panelSalida);
	}

	public InMethod getEntrada() {
		// TODO Auto-generated method stub
		return cpu.getEntrada();
	}

	public void setEntradaPanel(PanelEntrada panelEntrada) {
		// TODO Auto-generated method stub
		cpu.setEntradaPanel(panelEntrada);
	}

}
