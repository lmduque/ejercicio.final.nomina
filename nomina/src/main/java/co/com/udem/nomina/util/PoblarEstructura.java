package co.com.udem.nomina.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import co.com.udem.nomina.dto.EmpleadoDTO;

public class PoblarEstructura {

	private static final HashMap<String, EmpleadoDTO> empleados = new HashMap<String, EmpleadoDTO>();
	private static final Logger logger = LogManager.getLogger(PoblarEstructura.class);
	
	public static void llenarHashMap(EmpleadoDTO empleadoDTO) {
		empleados.put(empleadoDTO.getCedula(), empleadoDTO);
	}

	public static void imprimirHashMap() {
		BasicConfigurator.configure();
		Collection<EmpleadoDTO> coleccionEmpleados = empleados.values();
		Iterator<EmpleadoDTO> iterator = coleccionEmpleados.iterator();
		StringBuffer empleados = new StringBuffer();

		while (iterator.hasNext()) {
			EmpleadoDTO empleadoDTO = iterator.next();
			empleados.append(empleadoDTO.getNombres());
			empleados.append(",");
			empleados.append(empleadoDTO.getApellidos());
			empleados.append(",");
			empleados.append(empleadoDTO.getCedula());
			empleados.append(",");
			empleados.append(empleadoDTO.getDepartamento());
			empleados.append(",");
			empleados.append(empleadoDTO.getSalario());
			logger.info(empleados.toString());
		}

	}

	public static int tamanoHashMap() {
		return empleados.size();
	}
}
