package tp.pr5.mv;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import tp.pr5.mv.controladores.ControladorBatch;
import tp.pr5.mv.controladores.ControladorInteractive;
import tp.pr5.mv.controladores.ControladorSwing;
import tp.pr5.mv.entrada.*;
import tp.pr5.mv.salida.*;
import tp.pr5.mv.windows.Window;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		boolean  asmCargado = false, modoBatch = true, input = false, output = false;
		boolean modoWindow = false, modoInteractivo = false;
		Scanner sc = new Scanner(System.in);
		final CPU cpu = new CPU();
		InstructionParser instructionParser = new InstructionParser();
		ProgramMV programa = new ProgramMV();
		CommandLineParser parser = new BasicParser();
		Options options = new Options();
		
		options.addOption("a", "asm", true, "Fichero con el codigo en ASM del programa a ejecutar. Obligatorio en modo batch.");
		options.getOption("a").setArgName("asmfile");
		
		options.addOption("h", "help", false, "Muestra esta ayuda");
		
		options.addOption("i", "in", true, "Entrada del programa de la maquina-p.");
		options.getOption("i").setArgName("infile");
		
		
		options.addOption("m", "mode", true, "Modo de funcionamiento (batch | interactive). Por defecto, batch.");
		options.getOption("m").setArgName("mode");
		
		options.addOption("o", "out", true, "Fichero donde se guarda la salida del programa de la maquina-p.");
		options.getOption("o").setArgName("outfile");
		
		if(args.length == 0){
			System.err.println("Uso incorrecto: Fichero ASM no especificado.");
			System.err.println("Use -h/-help para mas detalles.");
			System.exit(1);	
		}
		
		try {
			CommandLine cmd = parser.parse(options, args);
			try {
				if(cmd.hasOption("h") || cmd.hasOption("help")){	
					HelpFormatter formato = new HelpFormatter();
					formato.printHelp("tp.pr3.mv.Main [-a <asmfile>] [-h] [-i <infile>] [-m <mode>] [-o <outfile>]", options);	
					System.exit(1);
				}
			} catch (NullPointerException e) {
				// TODO: handle exception
				System.out.println(e.getMessage());	
			}
			
			if(cmd.hasOption("i") || cmd.hasOption("in")){
				input = true;
			}
			
			if(cmd.hasOption("o") || cmd.hasOption("out")){
				output = true;
			}
			
			if(cmd.hasOption("a") || cmd.hasOption("asm")){
				try {
					cargarFicheroASM(programa, cmd.getOptionValue("a"), instructionParser);
					asmCargado = true;
					cpu.loadProgram(programa); // cargamos en CPU el prgrama
				} catch (Exception e) {
					// TODO: handle exception
					System.err.println(e.getMessage());
					System.exit(2);
				}
			}
			
			
			if(cmd.hasOption("mode") || cmd.hasOption("m")){
				if(cmd.getOptionValue("m").equalsIgnoreCase("BATCH")){
					modoBatch = true;
				}else if(cmd.getOptionValue("m").equalsIgnoreCase("INTERACTIVE")){
					modoBatch = false;
					modoInteractivo = true;
				}else if(cmd.getOptionValue("m").equalsIgnoreCase("WINDOW")){
					modoBatch = false;
					modoWindow = true;
				}else{
					System.err.println("Uso incorrecto: Modo incorrecto (parametro -m/--mode)");
					System.err.println("Use -h/-help para mas detalles.");
					System.exit(2);
				}
			}
			
			if(modoBatch){
				// Estamos en modo batch
				if(input){
					// Si se ha cargado el fichero entrada
					try {
						InMethod entrada = new FileIn(new FileInputStream(cmd.getOptionValue("i")));
						cpu.loadEntrada(entrada);
					} catch (Exception e) {
						// TODO: handle exception
						System.err.println("Uso incorrecto: Error al acceder al fichero de entrada ("+ cmd.getOptionValue("i") + ")");
						System.err.println("Use -h/-help para mas detalles.");
						System.exit(2);
					}		
				}else{
					InMethod entrada = new StdIn(new BufferedInputStream(System.in));
					cpu.loadEntrada(entrada);
				}
				if(output){
					// Si se ha cargado el fichero salida
					OutMethod salida = new FileOut(new FileOutputStream(cmd.getOptionValue("o")));
					cpu.loadSalida(salida);
				}else{
					OutMethod salida = new StdOut();
					cpu.loadSalida(salida);
				}
				
				if(asmCargado){
					
					ControladorBatch controladorBatch = new ControladorBatch(cpu);
					VistaBatch vistaBatch = new VistaBatch(controladorBatch);
					controladorBatch.addObservador(vistaBatch);
					controladorBatch.start();
					
				}else{
					System.err.println("Uso incorrecto: Fichero ASM no especificado.");
					System.err.println("Use -h/-help para mas detalles.");
					System.exit(1);
				}
				
				
			}else if(modoInteractivo){
				// Estamos en modo interactivo
				if(input){
					// Si se ha cargado el fichero entrada
					try {
						InMethod entrada = new FileIn(new FileInputStream(cmd.getOptionValue("i")));
						cpu.loadEntrada(entrada);
					} catch (Exception e) {
						// TODO: handle exception
						System.err.println("Uso incorrecto: Error al acceder al fichero de entrada ("+ cmd.getOptionValue("i") + ")");
						System.err.println("Use -h/-help para mas detalles.");
						System.exit(2);
					}
				}else{
					InMethod entrada = new NullIn();
					cpu.loadEntrada(entrada);
				}
				if(output){
					// Si se ha cargado el fichero salida
					OutMethod salida = new FileOut(new FileOutputStream(cmd.getOptionValue("o")));
					cpu.loadSalida(salida);
				}else{
					OutMethod salida = new NullOut();
					cpu.loadSalida(salida);
				}
				if(asmCargado){
					
					ControladorInteractive controladorInteractive = new ControladorInteractive(cpu);
					VistaInteractive vistaInteractive = new VistaInteractive(controladorInteractive);
					controladorInteractive.addObservador(vistaInteractive);
					controladorInteractive.start();
					
				}else{
					
					cargaIterativa(programa, cpu, instructionParser, sc);
					cpu.loadProgram(programa); // Cargamos el programa en la cpu
					ControladorInteractive controladorInteractive = new ControladorInteractive(cpu);
					VistaInteractive vistaInteractive = new VistaInteractive(controladorInteractive);
					controladorInteractive.addObservador(vistaInteractive);
					controladorInteractive.start();
				}
				
			}else if(modoWindow){
				// Estamos en modo window ***********************************************************************************
				if(input){
					// Si se ha cargado el fichero entrada, lo cargamos en el PanelEntrada
					try {
						InMethod entrada = new WindowIn(new FileInputStream(cmd.getOptionValue("i")), cmd.getOptionValue("i"));
						cpu.loadEntrada(entrada);
					} catch (FileNotFoundException  e) {
						// SAle esta exception cuando no nombre de fichero de entrada es incorrecto y terminamos el programa.
						System.err.println("Uso incorrecto: Error al acceder al fichero de entrada ("+ cmd.getOptionValue("i") + ")");
						System.err.println("Use -h/-help para mas detalles.");
						System.exit(2);
					}		
				}else{
					InMethod entrada = new NullIn();
					cpu.loadEntrada(entrada);
				}
				
				
				if(output){
					// Si se ha cargado el fichero salida
					OutMethod salida = new WindowOut(new FileOut(new FileOutputStream(cmd.getOptionValue("o"))));
					cpu.loadSalida(salida);
				}else{
					OutMethod salida = new WindowOut(new NullOut());
					cpu.loadSalida(salida);
				}
				
				if(asmCargado){
					SwingUtilities.invokeLater(new Runnable() {
						@Override
						public void run() {
							// TODO Auto-generated method stub
							ControladorSwing controladorSwing = new ControladorSwing(cpu);
							Window window = new Window(controladorSwing);
							controladorSwing.start(window);
							window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						}
					});
				}else{
					System.err.println("Uso incorrecto: Fichero ASM no especificado.");
					System.err.println("Use -h/-help para mas detalles.");
					System.exit(1);
				}
				
				
			}
			
			
		} catch (ParseException e) {
			System.err.println("Uso incorrecto: " + e.getMessage());
			System.err.println("Use -h/-help para mas detalles.");
			System.exit(1);
		}
		
		sc.close();
	}
	

	private static void cargaIterativa(ProgramMV programa, CPU cpu, InstructionParser instructionParser, Scanner sc) {
		// TODO Auto-generated method stub
		// Carga iterativa.
		String cadena;
		boolean seguir = true;
		Instruction instruccion;
		
		System.out.println("Introduce el programa fuente");
		do{
			System.out.print("> ");
			cadena = sc.nextLine();
			if(cadena.equalsIgnoreCase("END")){
				seguir = false;
			}else{
				
				try {
					instruccion = instructionParser.parse(cadena);
					if(instruccion == null){
						System.out.println("Error: Instrucción incorrecta");
					}else{
						// Cuando la instruccion es correcta añadimos al programa
						programa.agregarInstruccion(instruccion);
					}
				} catch (NumberFormatException e) {
					System.out.println(e.getMessage());
				}
				
			}
			
		}while(seguir);
	}


	private static void cargarFicheroASM(ProgramMV programa, String archivo, InstructionParser instructionParser) throws IOException, Exception{
		
		String linea = null;
		String [] subCadena = null;
		
		try {
			FileReader file = new FileReader(archivo);
			@SuppressWarnings("resource")
			BufferedReader line = new BufferedReader(file);
			
			linea = line.readLine();
			
			
			while (linea != null) {
				if(linea.equalsIgnoreCase(";")){
					linea = line.readLine();
				}else{
					subCadena = linea.split(";");
					subCadena[0] = subCadena[0].trim(); // Quitamos los espacios en blanco del principio y el final
					
					if(!subCadena[0].equals("")){
						Instruction instr = instructionParser.parse(subCadena[0]);
						if(instr != null){
							// Si va todo bien, añadimos al programaMV la instruccion
							programa.agregarInstruccion(instr);	
						}else{
							throw new Exception("Error en el programa. Línea: " + subCadena[0] + " ; Este programa falla al cargar");
						}
					}
					
					linea = line.readLine();	
				}
			}
			line.close();
		} catch (IOException e) {
			throw new IOException("Se ha producido un error en la lectura del archivo ASM.");
		}		
	}

}
