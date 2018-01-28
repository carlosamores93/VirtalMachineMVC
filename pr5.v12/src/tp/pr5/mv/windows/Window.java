package tp.pr5.mv.windows;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import tp.pr5.mv.controladores.ControladorSwing;

@SuppressWarnings("serial")
public class Window extends JFrame {
	
	private PanelAccion panelAccion;
	private PanelPrograma panelPrograma;
	private PanelCentro panelCentro;
	private PanelSur panelSur;
	
	public Window(ControladorSwing controladorSwing) {
		
		super("Máquina virtual de TP");
		this.panelAccion = new PanelAccion(controladorSwing);
		controladorSwing.addObserver(panelAccion);
		
		this.panelPrograma = new PanelPrograma(controladorSwing);
		controladorSwing.addObserver(panelPrograma);
		
		this.panelCentro = new PanelCentro(controladorSwing);
		
		this.panelSur = new PanelSur();
		controladorSwing.addObserver(panelSur);
		controladorSwing.addObserverPila(panelSur);
		controladorSwing.addObserverMemoria(panelSur);
		
		this.add(panelAccion, BorderLayout.NORTH);
		this.add(panelPrograma, BorderLayout.WEST);
		this.add(panelCentro, BorderLayout.CENTER);
		this.add(panelSur, BorderLayout.SOUTH);
		
		
	}

}
