package tp.pr5.mv;
import tp.pr5.mv.commands.*;

public class CommandParser {

	private static CommandInterpreter [] ListaComandos = { new QuitCommand(), 
		new RunCommand(), new StepsCommand()};
	
	public  CommandInterpreter parseCommand(String cadena){
		CommandInterpreter comando = null;
		int i = 0;
		boolean salir =  false;
		while(i < ListaComandos.length  && !salir){
			comando = ListaComandos[i].parse(cadena);
			if(comando != null){
				salir = true;
			}else{
				i++;
			}
		}
		return comando;
	}
	
}
