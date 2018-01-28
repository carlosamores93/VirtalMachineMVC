package tp.pr5.mv.windows;

import java.util.Vector;

import javax.swing.AbstractListModel;
import javax.swing.ListModel;

@SuppressWarnings("serial")
public class StackModel extends AbstractListModel<Object> implements ListModel<Object> {

	//He mirado los metodos desde esta pagina 
	//http://docs.oracle.com/javase/6/docs/api/javax/swing/AbstractListModel.html
	
	private Vector<Integer> listaPila;
	
	public StackModel(){
		listaPila =  new Vector<Integer>();
	}
	
	@Override
	public int getSize() {
		return listaPila.size();
	}

	@Override
	public Object getElementAt(int index) {
	// Este metodo es el que actualiza la tabla que mostramos por la ventana
		if(index >= listaPila.size()){
			return null;
		}
		else{
			return listaPila.get(index);
		}
	}
	
	public void apila(int valor){
		listaPila.add(0, valor); // Cuando apilamos, "valor" ponemos al principio del Vector
		// Actualizamos la vista del panel, y para eso pasamos el principio y el final del vector
		this.fireContentsChanged(this, 0, this.getSize());
	}
	
	public void desapila(){
		listaPila.remove(0); // Desapilamos el elemento primero del vector
		this.fireContentsChanged(this, 0, listaPila.size());
	}

}
