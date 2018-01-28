package tp.pr5.mv.controladores;

import java.util.Scanner;

import tp.pr5.mv.CPU;
import tp.pr5.mv.CommandInterpreter;
import tp.pr5.mv.CommandParser;
import tp.pr5.mv.Instruction;
import tp.pr5.mv.InstructionParser;
import tp.pr5.mv.VistaInteractive;

public class ControladorInteractive {

	private CPU cpu;
	private boolean continuar;
	
	public ControladorInteractive(CPU cpu) {
		// TODO Auto-generated constructor stub
		this.cpu = cpu;
		continuar = true;
	}

	public void addObservador(VistaInteractive vistaInteractive) {
		// TODO Auto-generated method stub
		cpu.addObservadorCPU(vistaInteractive);
	}

	public void start() {
		// TODO Auto-generated method stub
		cpu.start();
		ejecucionInteractiva();
	}
	
	private void ejecucionInteractiva() {
		Scanner sc = new Scanner(System.in);
		InstructionParser instructionParser = new InstructionParser();
		String cadena;
		Instruction instruccion = null;
		CommandInterpreter comando;
		CommandParser commandParser = new CommandParser();
		do{
			System.out.print("> ");
			cadena = sc.nextLine();
			comando = commandParser.parseCommand(cadena);
			if(comando != null){
				try {
					boolean salir = comando.executeComand(cpu);
					continuar = continuar && salir;
					if(cpu.finalInstruciones()){
						continuar = false;
					}
				} catch (Exception e2) {
					
				}
			}else{
				try {
					instruccion = instructionParser.parsePushPopWrite(cadena);
					if(instruccion == null){
						System.out.println("No te entiendo.");
					}else{
						try {
							cpu.ejecutarInstruccion(instruccion);
						} catch (Exception e) {
						}
					}
				} catch (NumberFormatException e) {
					System.out.println("No te entiendo.");
				}
			}
		}while(continuar);
		sc.close();
	}

	public void terminarEjecucion() {
		// TODO Auto-generated method stub
		this.continuar = false;
	}
	

}
