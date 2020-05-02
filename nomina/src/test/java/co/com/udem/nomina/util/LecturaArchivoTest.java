
package co.com.udem.nomina.util;

import static org.junit.Assert.assertNull;

import org.junit.Test;

public class LecturaArchivoTest {

	@Test
	public void existeArchivo() {
		String str = LecturaArchivo.leerArchivo() ; 
		assertNull(str );
	}
}
