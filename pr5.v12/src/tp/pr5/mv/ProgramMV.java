package tp.pr5.mv;


public class ProgramMV {
	
	private Instruction [] registroInstrucciones;
	private int contador;
	private final int SIZE = 100;
	
	public ProgramMV(){
		this.registroInstrucciones = new Instruction[SIZE];
		this.contador = 0;
	}

	
	public void agregarInstruccion(Instruction instruccion){
		this.registroInstrucciones[contador] = instruccion;
		this.contador++;
	}
	
	
	public String toString(){
		String cadena = "El programa introducido es: \n";
		for (int i = 0; i < contador; i++) {
			cadena = cadena + i + ": " + registroInstrucciones[i] + "\n";
		}
		return cadena;
	}
	
	public Instruction getInstruccion(int pos){
		return registroInstrucciones[pos];
	}
	
	public int getNumInstrucciones(){
		return this.contador;
	}
}
