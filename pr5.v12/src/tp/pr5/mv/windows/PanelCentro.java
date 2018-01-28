package tp.pr5.mv.windows;


import java.awt.GridLayout;

import javax.swing.JPanel;
import tp.pr5.mv.controladores.ControladorSwing;

@SuppressWarnings("serial")
public class PanelCentro extends JPanel {
	
	
	private JPanel panelNorte, panelSur;
	private PanelSalida panelSalida;
	private PanelEntrada panelEntrada;
	private PanelPila panelPila;
	private PanelMemoria panelMemoria;
	
	public PanelCentro(ControladorSwing controladorSwing) {
		// TODO Auto-generated constructor stub
		this.panelNorte = new JPanel();
		
		this.panelPila = new PanelPila(controladorSwing);
		controladorSwing.addObserverPila(panelPila);		
		//cpu.setStackPanel(panelPila);
		
		this.panelMemoria = new PanelMemoria(controladorSwing);
		controladorSwing.addObserverMemoria(panelMemoria);
		//controladorSwing.setMemoryPanel(panelMemoria);
		
		this.panelSur = new JPanel();
		
		this.panelEntrada = new PanelEntrada();
		if(controladorSwing.getEntrada() != null){
			controladorSwing.setEntradaPanel(panelEntrada);
		}
		
		this.panelSalida = new PanelSalida();
		controladorSwing.setSalidaPanel(panelSalida);

		
		setLayout(new GridLayout(2, 1));
		
		panelNorte.setLayout(new GridLayout(1, 2));
		panelNorte.add(panelPila);
		panelNorte.add(panelMemoria);
		add(panelNorte);
		
		panelSur.setLayout(new GridLayout(2, 1));
		panelSur.add(panelEntrada);
		panelSur.add(panelSalida);
		add(panelSur);
		
		
		
	}
}
