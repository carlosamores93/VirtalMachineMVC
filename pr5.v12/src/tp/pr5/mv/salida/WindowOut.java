package tp.pr5.mv.salida;

import java.io.IOException;
import tp.pr5.mv.windows.PanelSalida;

public class WindowOut implements OutMethod {

	private OutMethod decorador;
	private PanelSalida outPanel;
	//private boolean salida;
	
	public WindowOut(OutMethod out){
		this.decorador = out;
		//this.salida = true;
	}
	
	//public WindowOut() {
		// TODO Auto-generated constructor stub
		//this.salida = false;
	//}

	@Override
	public void write(int n) throws IOException {
		//if(salida){ // Si hay fichero de salida escribimos en el de salida, sino nada
		decorador.write((char)n);
		//}
		outPanel.write((char)n);
	}

	@Override
	public void setPanelSalida(PanelSalida panelSalida) {
		// TODO Auto-generated method stub
		this.outPanel = panelSalida;
	}

}
