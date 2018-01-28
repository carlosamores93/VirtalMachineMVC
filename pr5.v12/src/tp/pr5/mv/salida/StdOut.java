package tp.pr5.mv.salida;

import tp.pr5.mv.windows.PanelSalida;

public class StdOut implements OutMethod {

	@Override
	public void write(int n) {
		// TODO Auto-generated method stub
		System.out.print((char)n);
	}

	@Override
	public void setPanelSalida(PanelSalida panelSalida) {
		// TODO Auto-generated method stub
		
	}

}
