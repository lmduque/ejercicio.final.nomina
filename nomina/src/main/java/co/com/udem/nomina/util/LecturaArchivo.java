package co.com.udem.nomina.util;

import java.io.InputStream;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import co.com.udem.nomina.dto.EmpleadoDTO;

public class LecturaArchivo {
	
	static InputStream archivoNomina = null;
	private static final Logger logger = LogManager.getLogger(LecturaArchivo.class);
	
	private  LecturaArchivo() {}
	public static String leerArchivo() {
		
		archivoNomina = ClassLoader.class.getResourceAsStream("/nominaEmpleados.txt");
		Scanner scanner = null;
		String mensaje = null;
		try {
			scanner = new Scanner(archivoNomina);
			while(scanner.hasNextLine()) {
				String registro = scanner.nextLine();
				leerRegistro(registro);
				
			}
		} catch (Exception e) {
			mensaje = "El archivo no está en la ruta especificada";
		}finally {
			if(scanner != null) {
				scanner.close();
			}
			
			
		}
		return mensaje;
	}
	
	public static void leerRegistro(String registro) {
		
		Scanner scanner = new Scanner(registro);
		scanner.useDelimiter(",");
		while(scanner.hasNext()) {
			llenarDTO(scanner);
		}
		scanner.close();
	}
	
	public static void llenarDTO(Scanner scanner) {
		EmpleadoDTO empleadoDTO = new EmpleadoDTO();
		empleadoDTO.setNombres(scanner.next());
		empleadoDTO.setApellidos(scanner.next());
		String cedula = scanner.next();			
		empleadoDTO.setCedula(cedula);
		empleadoDTO.setDepartamento(scanner.next());
		empleadoDTO.setSalario(Double.parseDouble(scanner.next()));
		PoblarEstructura.llenarHashMap(empleadoDTO);
		if ( PoblarEstructura.tamanoHashMap() >= 3) {
			logger.info("Se completaron los 3 registros - tamaño hash "+PoblarEstructura.tamanoHashMap() );
			PoblarEstructura.imprimirHashMap();
			PoblarEstructura.vaciarHashMap();
			logger.info("*********Se borraron los 3 registros - toamaño hash "+PoblarEstructura.tamanoHashMap());

		}
	}
	                         
	
}
