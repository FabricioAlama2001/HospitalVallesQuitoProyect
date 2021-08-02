package hospitalvallesquito_test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import HospitalValleQuito.Hospital;
import HospitalValleQuito.Paciente;

class Paciente_Test {

	Paciente paciente = null; 
	Hospital hospital = null;
	Paciente paciente2 = null;
	
	void escenario1() {
		paciente = new Paciente("1321313234", "Javier", "Almendariz");
		paciente2 = new Paciente("2374829490", "Sebastian", "López");
	}
	
	
	@Test
	@DisplayName("Metodo para mostrar el número de cedula del Paciente")
	void darCedulaTest() {
		escenario1();
		assertEquals("La cedula del paciente debe ser 1321313234", "1321313234", paciente.darCedula());
	}
	
	
	@Test
	@DisplayName("Metodo para mostrar el nombre del Paciente")
	void darNombreTest() {
		escenario1();
		assertEquals("El nombre del paciente debe ser Javier", "Javier", paciente.darNombre());
	}
	
	
	
	@Test
	@DisplayName("Metodo para mostrar el apellido del Paciente")
	void darApellidoTest() {
		escenario1();
		assertEquals("El apellido del paciente debe ser Almendariz", "Almendariz", paciente.darApellido());
	}
	
	@Test
	@DisplayName("Metodo para verificar la existencia del Paciente")
	void igualA1Test() {
		escenario1();
		assertEquals("El apellido del paciente no debe estar repetido", false, paciente.igualA1(paciente2));
	}
}
