package tp.pr5.mv.entrada;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

import tp.pr5.mv.windows.PanelEntrada;

public class WindowIn implements InMethod {

	private FileInputStream input;
	private PanelEntrada inPanel;
	private String cadenaFichero;

	public WindowIn(FileInputStream input, String nombreEntrada){
		this.input = input;
		try {
			this.cadenaFichero = leerFicheroCompleto(nombreEntrada);
		} catch (IOException e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this.inPanel, "Error: Fichero de entrada no existe.", 
					"Error E/S", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	private String leerFicheroCompleto(String nombreEntrada) throws IOException {
		
		// TODO Auto-generated method stub
		try {
			File arch = new File(nombreEntrada);
			FileReader fr = new FileReader(arch);
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(fr);
			String line;
			cadenaFichero = "";
			while((line=br.readLine())!=null){
				cadenaFichero += line + "\n"; 
			}
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(this.inPanel, "Error de entrada o salida ", 
					"Error E/S", JOptionPane.ERROR_MESSAGE);
		}
		return cadenaFichero;
	}

	
	@Override
	public int read() throws IOException{
		// TODO Auto-generated method stub
		int c = input.read();
		this.cadenaFichero = inPanel.read(this.cadenaFichero);
		if(c == '\r'){
			c = -1;
		}
		return c;
	}


	@Override
	public void setPanelEntrada(PanelEntrada panelEntrada) {
		// TODO Auto-generated method stub
		this.inPanel = panelEntrada;
		inPanel.escribeEntrada(cadenaFichero);
	}

}
