package tp.pr5.mv.salida;

import java.io.FileOutputStream;
import java.io.IOException;

import tp.pr5.mv.windows.PanelSalida;

public class FileOut implements OutMethod {

	private FileOutputStream out;
	
	public FileOut(FileOutputStream out){
		this.out = out;
	}
	
	@Override
	public void write(int n) throws IOException {
		out.write((char)n);
	}

	@Override
	public void setPanelSalida(PanelSalida panelSalida) {
		// TODO Auto-generated method stub
		
	}

}
