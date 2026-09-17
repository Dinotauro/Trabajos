package U1;

public abstract class Logica implements Especial{
	public Persona [] p;
	private int frente;
public Logica(int num) {
	 p = new Persona[num];
	 frente = -1;
}
public boolean Agregar(Persona per) {
	int vacio = -1;
    for(int i = 0; i < p.length; i++) {
        if(p[i] == null) {
            vacio = i;
            break;
        }
    }
    if(vacio == -1) {
    	return false;
    }  
    p[vacio] = per;
    
    if(frente == -1) {
        frente = vacio;
        per.setSiguiente(-1);
        return true;
    }
    
    
    int actual = frente;
    int ant = -1;
    while(actual != -1) {
        if(Rutinas.PonBlancos(per.getNombre(), 30).compareToIgnoreCase(Rutinas.PonBlancos(p[actual].getNombre(), 30)) <  0) {
        	break;
        }
        ant = actual;
        actual = p[actual].getSiguiente();
    }
    if(ant == -1) {
        per.setSiguiente(frente);
        frente = vacio;
    } else {
        per.setSiguiente(actual);
        p[ant].setSiguiente(vacio);
    }
    return true;
}
public boolean Retirar(Persona per) {
    if(frente == -1) return false; 
    
    int actual = frente;
    int anterior = -1;
    
    while(actual != -1 && p[actual] != null) {
        if(Rutinas.PonBlancos(p[actual].getNombre(), 30).compareToIgnoreCase(Rutinas.PonBlancos(per.getNombre(), 30)) == 0) {
            if(anterior == -1) {
            	int temp = p[actual].getSiguiente();
                p[actual] = null;
                frente = temp;
                actual = frente;
            } else {
                int temp = p[actual].getSiguiente();
                p[actual] = null;
                p[anterior].setSiguiente(temp);
                actual = temp;
            }          
            return true;
        }
        
        anterior = actual;
        actual = p[actual].getSiguiente();
    }
    
    return false;
}
public Persona[] Contenido() {
	return  p;
	
}
public String ContenidoCadena() {
	String pcc = "";
	for(int i = 0;i< p.length ; i++) {
		pcc = pcc + " " + p[i]+ " ";
		
		}
	return pcc;
	}
}