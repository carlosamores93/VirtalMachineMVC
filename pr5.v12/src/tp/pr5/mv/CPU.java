package tp.pr5.mv;

import java.io.IOException;
import java.util.Vector;

import tp.pr5.mv.entrada.InMethod;
import tp.pr5.mv.excepciones.InstructionExecutionException;
import tp.pr5.mv.observadores.ObservadorMemoria;
import tp.pr5.mv.observadores.ObservadoresCPU;
import tp.pr5.mv.observadores.ObservadoresPila;
import tp.pr5.mv.salida.OutMethod;
import tp.pr5.mv.windows.PanelEntrada;
import tp.pr5.mv.windows.PanelSalida;


public class CPU {
	
	private Memory memoria;
	private OperandStack pilaOperandos;
	private ProgramMV programMV;
	private ProgramCounter programCounter;
	private OutMethod outMethod;
	private InMethod inMethod;
	private Vector<ObservadoresCPU> observadores;
	private String [] arrayInstrucciones;
	
	public  CPU(){
		this.memoria = new Memory();
		this.pilaOperandos = new OperandStack();
		this.programMV = new ProgramMV();
		this.programCounter = new ProgramCounter();
		this.outMethod = null;
		this.inMethod = null;
		this.observadores = new Vector<ObservadoresCPU>();
	}
	
	public void loadProgram(ProgramMV programa){
		this.programMV = programa;
	}
	
	public void loadSalida(OutMethod salida){
		this.outMethod = salida;
	}
	public void loadEntrada(InMethod entrada){
		this.inMethod = entrada;
	}
	
	
	public InMethod getEntrada(){
		return this.inMethod;
	}
	
	public void ejecutarInstruccion(Instruction instruccion) throws InstructionExecutionException, IOException{
		instruccion.execute(pilaOperandos, memoria, programCounter, outMethod, inMethod);
		int num = programCounter.getInstrEjecutar() - 1;
		programCounter.setIntrEjecutar(num);
		int n = programCounter.getPC() - 1;
		programCounter.setPC(n);
	}
	
	public boolean finalInstruciones(){
		boolean ok = false;
		if(programCounter.getInstrEjecutar()  >= programMV.getNumInstrucciones()){
			ok = true;
			notificarHalt();
		}
		return ok;
	}
	
	public boolean isHalt() throws InstructionExecutionException, IOException{
		Instruction instruccion;
		int pc = programCounter.getInstrEjecutar();
		instruccion = programMV.getInstruccion(pc);
		if(instruccion.toString().equalsIgnoreCase("Halt")){
			notificarStartInstruction(instruccion);
			instruccion.execute(pilaOperandos, memoria, programCounter, outMethod, inMethod);
			notificarEndInstruction();
			notificarHalt();
			return true;
		}else{
			return false;
		}
		
	}

	public void step() throws InstructionExecutionException, IOException{
		Instruction instruccion;
		int pc = programCounter.getInstrEjecutar();
		if(!finalInstruciones() && !isHalt()){
			instruccion = programMV.getInstruccion(pc);
			notificarStartInstruction(instruccion);
			try {
				instruccion.execute(pilaOperandos, memoria, programCounter, outMethod, inMethod);
			} catch (InstructionExecutionException e) {
				// TODO Auto-generated catch block
				notificarError(e.getMessage());
				throw new InstructionExecutionException(e.getMessage());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				notificarError(e.getMessage());
				throw new IOException();
			}
			notificarEndInstruction();
		}
	}
	
	
	private void notificarHalt() {
		// TODO Auto-generated method stub
		for (ObservadoresCPU i : observadores) {
			i.onHalted();
		}
	}

	private void notificarStartInstruction(Instruction instruccion) {
		// TODO Auto-generated method stub
		for (ObservadoresCPU i : observadores) {
			i.onInstructionStart(instruccion.toString());
		}
	}

	private void notificarEndInstruction() {
		// TODO Auto-generated method stub
		for (ObservadoresCPU i : observadores) {
			i.onInstructionEnd(programCounter.getPC(), memoria, pilaOperandos, programCounter.getInstrEjecutar());
		}
	}

	public void write(int pos, int val) {
		// TODO Auto-generated method stub
		memoria.escribirEnMemoria(pos, val);
	}


	public void push(int val) throws Exception {
		// TODO Auto-generated method stub
		if(pilaOperandos.sizePila() > 100){
			throw new Exception();
		}else{
			pilaOperandos.apilar(val);
		}
	}
	
	public void pop() throws Exception{
		// TODO Auto-generated method stub
		if(pilaOperandos.sizePila() > 0){
			this.pilaOperandos.desapilar();
		}else{
			throw new Exception();
		}
	}
	
	
	public void setEntradaPanel(PanelEntrada panelEntrada) {
		// TODO Auto-generated method stub
		inMethod.setPanelEntrada(panelEntrada);
	}
	
	public void setSalidaPanel(PanelSalida panelSalida) {
		// TODO Auto-generated method stub
		outMethod.setPanelSalida(panelSalida);
	}

	public ProgramMV getProgramMV() {
		// TODO Auto-generated method stub
		return this.programMV;
	}
	public void addObservadorPila(ObservadoresPila observadorPila) {
		// TODO Auto-generated method stub
		pilaOperandos.addObserver(observadorPila);
	}

	public void addObservadorMemoria(ObservadorMemoria observadorMemoria) {
		// TODO Auto-generated method stub
		memoria.addObserver(observadorMemoria);
	}

	public void start() {
		// TODO Auto-generated method stub
		for (ObservadoresCPU i : observadores) {
			parseInstrucciones();
			i.onStart(arrayInstrucciones, programMV.getNumInstrucciones());
		}
	}

	private void parseInstrucciones() {
		// TODO Auto-generated method stub
		int numInstruc = programMV.getNumInstrucciones();
		arrayInstrucciones = new String[100];
		for (int i = 0; i < numInstruc; i++) {
			arrayInstrucciones[i] = programMV.getInstruccion(i).toString();
		}
	}

	public void addObservadorCPU(ObservadoresCPU observador) {
		// TODO Auto-generated method stub
		this.observadores.add(observador);
	}

	public void notificarError(String message) {
		// TODO Auto-generated method stub
		for (ObservadoresCPU i : observadores) {
			i.onInstructionError(message);
		}
	}

}
