package tp.pr5.mv.entrada;

import java.io.FileInputStream;
import java.io.IOException;

import tp.pr5.mv.windows.PanelEntrada;

public class FileIn implements InMethod {
	
	private FileInputStream input;
	
	public FileIn(FileInputStream input){
		this.input = input;
	}
	
	
	@Override
	public int read() throws IOException{
		// TODO Auto-generated method stub
	
		int c = input.read();
		if(c == '\r'){
			c = -1;
		}
		return c;
		
		
	}


	@Override
	public void setPanelEntrada(PanelEntrada panelEntrada) {
		// TODO Auto-generated method stub
		// Este metodo no hace nada
	}

}
