package hospitalvallesquito_test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import HospitalValleQuito.Hospital;
import HospitalValleQuito.Paciente;

class Hospital_Test {

	Paciente paciente = null; 
	Hospital hospital = null;

	
	void escenario1() {
		paciente = new Paciente("1321313234", "Javier", "Almendariz");
		hospital = new Hospital(12, HospitalValleQuito.Hospital.Ubicacion.AREA_DE_COVID, false);
	}
	
	
	@Test
	@DisplayName("Metodo para mostrar el número del Paciente")
	void darNumeroTest() {
		escenario1();
		hospital.asignarAPaciente(paciente);
		assertEquals("El número del paciente debe ser 12", 12, hospital.darNumero());
	}

	
	@Test
	@DisplayName("Metodo para mostrar la ubicación del Paciente")
	void darUbicacionTest() {
		escenario1();
		hospital.asignarAPaciente(paciente);
		assertEquals("El paciente debe esta en AREA_DE_COVID",  HospitalValleQuito.Hospital.Ubicacion.AREA_DE_COVID, hospital.darUbicacion());
	}
	
	
	@Test
	@DisplayName("Metodo para asignar Paciente")
	void asignarPacienteTest() {
		escenario1();
		hospital.asignarAPaciente(paciente);
		assertEquals("El paciente debe ser Javier Almenariz",  paciente, hospital.darPaciente());
	}
	
	@Test
	@DisplayName("Metodo para Asignar una Cama")
	void CamaAsignadoUsuarioTest() {
		escenario1();
		hospital.asignarAPaciente(paciente);
		hospital.CamaAsignadoUsuario(paciente);
		assertEquals("El usuario debe tener una cama asignada", false, hospital.isAsignado());
		}
	

	@Test
	@DisplayName("Metodo para Designar una Cama")
	void desasignarCamaTest() {
		escenario1();
		hospital.asignarAPaciente(paciente);
		hospital.CamaAsignadoUsuario(paciente);
		hospital.desasignarCama();
		assertEquals("El usuario no debe tener una cama asignada", false, hospital.isAsignado());
		}
	
}
