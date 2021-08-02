package conexion;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import HospitalValleQuito.Hospital;
import HospitalValleQuito.Paciente;



public class ConexionMongoDB {
	
	public void ConexionMongoDB(ArrayList<Hospital> hospital, ArrayList<Paciente> paciente ) {
		try {
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			
			DB db = mongoClient.getDB("Hospital_Valles_Quito");
			
			DBCollection coll = (DBCollection) db.getCollection("Hospital_Valles_Quito_Hospital");
			System.out.println("Connect coll selected sucessfully");
			
			for(Hospital hos: hospital) {
				coll.insert(hos.toDBObjectHospital_Valles_Quito_Hospital());
			}
			JOptionPane.showMessageDialog(null, "Los datos del paciente en el hospiital han sido guardadas Correctamente en MongoDB");
			
			for(Paciente pacien: paciente) {
				coll.insert(pacien.toDBObjectHospital_Valles_Quito_Paciente());
			}
			JOptionPane.showMessageDialog(null, "Las datos del paciente han sido guardadas Correctamente en MongoDB");
			
		}catch(Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage());	
		}
	}
	
	
}