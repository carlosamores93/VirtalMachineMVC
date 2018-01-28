package tp.pr5.mv.windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import tp.pr5.mv.AccessMemory;
import tp.pr5.mv.AccessPila;
import tp.pr5.mv.controladores.ControladorSwing;
import tp.pr5.mv.observadores.ObservadoresCPU;

@SuppressWarnings("serial")
public class PanelAccion extends JPanel implements ActionListener, ObservadoresCPU{
	
	//private TitledBorder tituloBorde;
	private ImageIcon iconoStep, iconoRun, iconoExit, iconoPause;
	private JButton botonStep, botonRun, botonExit, botonPause;
	private ControladorSwing controlador;
	private boolean error;
	private String mensaje;
	
	public PanelAccion(ControladorSwing controladorSwing) {
		// TODO Auto-generated constructor stub
		//this.tituloBorde = new TitledBorder("Acciones");
		this.mensaje = "";
		this.error = false;
		controlador = controladorSwing;
		this.iconoStep = createImage("step.png");
		this.botonStep = new JButton(iconoStep);
		this.botonStep.addActionListener(this);
		
		this.iconoRun = createImage("run.png");
		this.botonRun  = new JButton(iconoRun);
		this.botonRun.addActionListener(this);
		
		this.iconoPause = createImage("pause.png");
		this.botonPause  = new JButton(iconoPause);
		//this.botonPause.addActionListener(this);
		botonPause.setEnabled(false);
		
		this.iconoExit = createImage("exit.png");
		this.botonExit  = new JButton(iconoExit);
		this.botonExit.addActionListener(this);
		
		
		//this.setBorder(tituloBorde);
		// Otra madera de poner un borde
		this.setBorder(BorderFactory.createTitledBorder("Acciones"));
		this.add(botonStep);
		this.add(botonRun);
		this.add(botonPause);
		this.add(botonExit);
		
		
	}

	private ImageIcon createImage(String nombre) {
		// TODO Auto-generated method stub
		ImageIcon icono = null;
		URL url = this.getClass().getResource("images/" + nombre);
		if(url != null){
			icono = new ImageIcon(url);
		}
		return icono;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//System.out.println(e);
		JButton boton = (JButton) e.getSource();
		if(boton.equals(botonExit)){
			//System.out.println("Boton SALIR pulsado");
			int opcion = JOptionPane.showConfirmDialog(this, 
					"¿Estás seguro de que deseas cerrar la máquina vitual?\n\n "
					+ "Si lo haces deja de ejecutarse la TPMV\n", 
					"¿Salir de la máquina vitual?", 
					JOptionPane.YES_NO_OPTION);
			if(opcion == 0){
				System.exit(0);
			}
		}
		if(boton.equals(botonStep)){
				controlador.step();
				if(error){
					JOptionPane.showConfirmDialog(this, mensaje, 
							"Error al ejercutar una instrucción", JOptionPane.CLOSED_OPTION);
				}
				this.error = false;
			
		}
		
		if(boton.equals(botonRun)){
				controlador.run();
				if(error){
					JOptionPane.showConfirmDialog(this, mensaje, 
							"Error al ejercutar una instrucción", JOptionPane.CLOSED_OPTION);
				}
				this.error = false;
		}
	}
	
	@Override
	public void onStart(String[] arrayInstrucciones, int numInstrucciones) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onHalted() {
		// TODO Auto-generated method stub
		botonStep.setEnabled(false);
		botonRun.setEnabled(false);
	}

	@Override
	public void onInstructionError(String error) {
		// TODO Auto-generated method stub
		this.error = true;
		this.mensaje = error;
		
	}

	@Override
	public void onInstructionStart(String instruccion) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onInstructionEnd(int pc, AccessMemory mem,
			AccessPila pila, int instru) {
		// TODO Auto-generated method stub
		
	}

}