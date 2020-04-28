package co.com.udem.nomina.util;

import java.io.InputStream;
import java.util.Scanner;

import co.com.udem.nomina.dto.EmpleadoDTO;

public class LecturaArchivo {
	
	static InputStream archivoNomina = null;
	
	public static String leerArchivo() {
		
		archivoNomina = ClassLoader.class.getResourceAsStream("/nominaEmpleados.txt");
		Scanner scanner = null;
		String mensaje = "";
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
		PoblarEstructura.imprimirHashMap();
	}
	                         
	
}
