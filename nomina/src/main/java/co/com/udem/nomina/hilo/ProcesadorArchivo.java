package co.com.udem.nomina.hilo;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import co.com.udem.nomina.util.LecturaArchivo;
import co.com.udem.nomina.util.PoblarEstructura;

public class ProcesadorArchivo implements Runnable{
	
	String mensaje = "";
	private static final Logger logger = LogManager.getLogger(ProcesadorArchivo.class);
	Thread t;
	
	public void iniciarHilo() {
		t = new Thread(this);
		t.start();
	}
	
	public void run() {
		BasicConfigurator.configure();
		while(true) {
			try {
				Thread.sleep(20000);
				mensaje = LecturaArchivo.leerArchivo();
				int cantidadRegistros = PoblarEstructura.tamanoHashMap();
				if(cantidadRegistros == 3) {
					break;
				}
			} catch (InterruptedException e) {
				logger.error(e.getMessage());
				Thread.currentThread().interrupt();
			}
		}
		
	}
}
