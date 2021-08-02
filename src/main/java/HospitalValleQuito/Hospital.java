package HospitalValleQuito;

import com.mongodb.BasicDBObject;

public class Hospital {
	     // Enumeradores para las ubicaciones de las camas.     
	    public enum Ubicacion {
	    	AREA_DE_COVID,

	    	AREA_DE_CIRUJIAS,

	    	AREA_DE_QUEMADOS
	    }
	    
	 // Atributos
	    public int numero;

	    public Ubicacion ubicacion;

	    public Paciente paciente;
	    
	    public boolean asignado = false;

	    // Constructores

	    // Crea la cama con su número identificador. 
	    
	    public Hospital( int pNumero,  Ubicacion pUbicacion, boolean asignado )
	    {
	        numero = pNumero;
	        ubicacion = pUbicacion;
	        // Inicialmente no hay ningún huesped en la habitacion
	        this.asignado = false;
	        
	        this.paciente = null;
	        
	    }

	    // Métodos
	    //Asigna la cama al paciente recibido como parámetro.
	    
	    public void asignarAPaciente( Paciente pPaciente )
	    {
	        paciente = pPaciente;
	    }

	    //Designa la cama al huesped. La cama queda nuevamente libre. 
	    
	    public void desasignarCama( )
	    {
	        paciente = null;
	    }

	    //Indica si la cama está asignada.

	    public boolean CamaAsignada( )
	    {

	        if( null == paciente)
	        {
	            asignado = false;
	        }
	        return asignado;
	    }

	    // Indica si la Cama está asignada al paciente recibido como parámetro.
	     
	    public boolean CamaAsignadoUsuario( Paciente pUsuario )
	    {
	        if( null == paciente )
	        {
	        	asignado = false;
	        }
	        else if( paciente.igualA( pUsuario ) )
	        {
	        	asignado = true;
	        }

	        return asignado;
	    }

	    //Retorna el número de la cama.
	    
	    public int darNumero( )
	    {
	        return numero;
	    }
	    
	    
	    // Retorna la ubicación de la cama.
	     
	    public Ubicacion darUbicacion( )
	    {
	        return ubicacion;
	    }

	    // Retorna el huesped asignado a la cama

	    public Paciente darPaciente( )
	    {
	        return paciente;
	    }

		public boolean isAsignado() {
			return asignado;
		}

		public void setAsignado(boolean asignado) {
			this.asignado = asignado;
		}

		
		
		public BasicDBObject toDBObjectHospital_Valles_Quito_Hospital() {
			BasicDBObject dbObjectHospital = new BasicDBObject();
			dbObjectHospital.append("Paciente", this.darPaciente());
			dbObjectHospital.append("Numero", this.darNumero());
			dbObjectHospital.append("Cama asignada", this.isAsignado());
			return dbObjectHospital;
		}
}
