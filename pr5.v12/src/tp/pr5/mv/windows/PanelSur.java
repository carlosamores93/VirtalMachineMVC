package tp.pr5.mv.windows;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tp.pr5.mv.AccessMemory;
import tp.pr5.mv.AccessPila;
import tp.pr5.mv.observadores.ObservadorMemoria;
import tp.pr5.mv.observadores.ObservadoresCPU;
import tp.pr5.mv.observadores.ObservadoresPila;

@SuppressWarnings("serial")
public class PanelSur extends JPanel implements ActionListener, ObservadoresCPU, ObservadoresPila, ObservadorMemoria {
	
	private JLabel numInstr, informacion;
	private JCheckBox memoria, pila;
	
	public PanelSur(){
		
		informacion = new JLabel();
		numInstr = new JLabel("Num. Instruciones ejecutadas: " + 0);
		memoria = new JCheckBox("Memoria modificada");
		pila = new JCheckBox("Pila modificada");
		this.add(informacion);
		this.add(numInstr);
		this.add(memoria);
		this.add(pila);
		memoria.addActionListener(this);
		pila.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JCheckBox cb = (JCheckBox) e.getSource();
		if(cb.equals(memoria)){
			if(memoria.isSelected()){
				memoria.setSelected(false);
			}else{
				memoria.setSelected(true);
			}
		}else{
			if(pila.isSelected()){
				pila.setSelected(false);
			}else{
				pila.setSelected(true);
			}
		}
	}
	
	
	@Override
	public void onStart(String[] arrayInstrucciones, int numInstrucciones) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onHalted() {
		// TODO Auto-generated method stub
		informacion.setVisible(true);
		informacion.setText("Máquina Parada");
		informacion.setForeground(Color.RED);
	}

	@Override
	public void onInstructionError(String error) {
		// TODO Auto-generated method stub
		informacion.setVisible(true);
		informacion.setText("Error instrucción");
		informacion.setForeground(Color.RED);
	}

	@Override
	public void onInstructionStart(String instruccion) {
		// TODO Auto-generated method stub
		informacion.setVisible(false);
		memoria.setSelected(false);
		pila.setSelected(false);
	}

	@Override
	public void onInstructionEnd(int pc, AccessMemory mem,
			AccessPila pila, int instru) {
		// TODO Auto-generated method stub
		numInstr.setText("Num. Instruciones ejecutadas: " + pc);
	}

	@Override
	public void onWrite(int pos, int val) {
		// TODO Auto-generated method stub
		memoria.setSelected(true);
	}

	@Override
	public void onPush(int cima) {
		// TODO Auto-generated method stub
		pila.setSelected(true);
	}

	@Override
	public void onPop() {
		// TODO Auto-generated method stub
		pila.setSelected(true);
	}

	

}
