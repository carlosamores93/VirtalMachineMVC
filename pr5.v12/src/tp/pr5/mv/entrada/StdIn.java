package tp.pr5.mv.entrada;

import java.io.BufferedInputStream;
import java.io.IOException;

import tp.pr5.mv.windows.PanelEntrada;

public class StdIn implements InMethod {

	BufferedInputStream input;
	
	public StdIn(BufferedInputStream input){
		this.input = input;
	}
	
	@Override
	public int read() throws IOException {
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
		// Este metodo ni hace nada
	}

}
