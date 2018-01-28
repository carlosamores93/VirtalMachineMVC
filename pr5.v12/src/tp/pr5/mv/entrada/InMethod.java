package tp.pr5.mv.entrada;

import java.io.IOException;
import tp.pr5.mv.windows.PanelEntrada;

public interface InMethod {

	abstract int read() throws IOException;
	
	abstract void setPanelEntrada(PanelEntrada panelEntrada);
}
