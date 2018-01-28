package tp.pr5.mv.windows;


import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelEntrada extends JPanel {
	
	private TitledBorder tituloBorde;
	private JTextArea areaTexto;
	private JScrollPane lugaDeltexto;
	private int contador;
	
	public PanelEntrada() {
		// TODO Auto-generated constructor stub
		contador = 0;
		this.tituloBorde = new TitledBorder("Entrada del programa-p");
		this.areaTexto = new JTextArea(5, 50);
		areaTexto.setEditable(false);
		areaTexto.setFont(new Font("Verdana", 14, 14));
		this.lugaDeltexto = new JScrollPane(areaTexto);
		this.setBorder(tituloBorde);
		this.setLayout(new BorderLayout());
		
		
		this.add(lugaDeltexto);
		
	}
	
	
	// Usamos una variable proivada contador, para mostrar bien en la ventana.
	public String read(String cadenaFichero) {
		// TODO Auto-generated method stub
		String aux;
		aux = "";
		for(int i = 0; i < cadenaFichero.length(); i++){
			if(cadenaFichero.charAt(i) == '\n'){
				aux += "\n";
			}else{
				if(i ==  contador){
					aux += "*";
				}else{
					aux += cadenaFichero.charAt(i);
				}	
			}
		}
		contador++;
		this.areaTexto.setText(aux);	
		return aux;
	}
	
	
	/*
	public String read(String cadenaFichero) {
		// TODO Auto-generated method stub
		boolean primero = false;
		String aux;
		aux = "";
		for(int i = 0; i < cadenaFichero.length(); i++){
			
			if(cadenaFichero.charAt(i) == '\n'){
				aux += "\n";
			}else{
					if((cadenaFichero.charAt(i) != '*')  && !primero){
						primero = true;
						aux += "*";
					}else{
						aux += cadenaFichero.charAt(i);
					}	
			}
		}
		this.areaTexto.setText(aux);	
		return aux;
	}*/



	public void escribeEntrada(String cadenaFichero) {
		// TODO Auto-generated method stub
		this.areaTexto.setText(cadenaFichero);	
	}
	
}
