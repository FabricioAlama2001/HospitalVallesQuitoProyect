package main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import HospitalValleQuito.Hospital;
import HospitalValleQuito.Hospital.Ubicacion;
import HospitalValleQuito.Paciente;
import conexion.ConexionMongoDB;

public class Main {

	static ArrayList<Hospital> hospital = new ArrayList<Hospital>();
	static ArrayList<Paciente> paciente = new ArrayList<Paciente>();
	
	public static void main(String[] args) {
		Main main = new Main();
		
		Paciente opaciente = null;
		Hospital ohospital = null;
		Ubicacion u = null;
		
		int op = 0, numero;
		String cedula, nombre, apellido, ubicacion, dato;
		boolean asignado;
		
		
		do {
			try {
				op = Integer.parseInt(JOptionPane.showInputDialog(null, "1. Agregar Paciente\n"
						+ "2. Guardar en la base de datos\n"
						+ "3. Salir\n"
						+ "¿Qué desea hacer?"));
				
			switch(op) {
			case 1:
				cedula = JOptionPane.showInputDialog(null, "Ingrese el número de cedula del paciente");
				nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del paciente");
				apellido = JOptionPane.showInputDialog(null, "Ingrese el apellido del paciente");
				
				opaciente = new Paciente(cedula, nombre, apellido);
				paciente.add(opaciente);
				
				numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número de atencion del paciente"));
				ubicacion = JOptionPane.showInputDialog(null, "Ingrese el area de ubicacion del paciente (AREA_DE_COVID, AREA_DE_CIRUJIAS, AREA_DE_QUEMADOS)");
				if(ubicacion.equals("AREA_DE_COVID")) {
					u = u.AREA_DE_COVID;
				}else if(ubicacion.equals("AREA_DE_CIRUJIAS")) {
					u = u.AREA_DE_CIRUJIAS;
				}else if(ubicacion.equals("AREA_DE_QUEMADOS")) {
					u = u.AREA_DE_QUEMADOS;
				}
				dato = JOptionPane.showInputDialog(null, "Se le asigno una cama al paciente (SI/NO)");
				if(dato.equals("SI")) {
					asignado = true;
				}else {
					asignado = false;
				}
				
				ohospital = new Hospital(numero, u, asignado);
				hospital.add(ohospital);
				
				break;
			case 2:
				main.guardarMongoDb();
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "Programa Finalizado");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opción incorrecta");
			}
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Error " +ex.getMessage());
			}
			
			
		}while(op != 3);
		
	}
		
		public void guardarMongoDb() {
			ConexionMongoDB conexion = new ConexionMongoDB();
			conexion.ConexionMongoDB(hospital, paciente);
		}

}
