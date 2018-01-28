package tp.pr5.mv.salida;

import java.io.IOException;

import tp.pr5.mv.windows.PanelSalida;

public interface OutMethod {
	abstract void write(int n) throws IOException;

	abstract void setPanelSalida(PanelSalida panelSalida);
}
