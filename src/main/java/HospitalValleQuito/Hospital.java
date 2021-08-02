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

	    // Crea la cama con su n�mero identificador. 
	    
	    public Hospital( int pNumero,  Ubicacion pUbicacion, boolean asignado )
	    {
	        numero = pNumero;
	        ubicacion = pUbicacion;
	        // Inicialmente no hay ning�n huesped en la habitacion
	        this.asignado = false;
	        
	        this.paciente = null;
	        
	    }

	    // M�todos
	    //Asigna la cama al paciente recibido como par�metro.
	    
	    public void asignarAPaciente( Paciente pPaciente )
	    {
	        paciente = pPaciente;
	    }

	    //Designa la cama al huesped. La cama queda nuevamente libre. 
	    
	    public void desasignarCama( )
	    {
	        paciente = null;
	    }

	    //Indica si la cama est� asignada.

	    public boolean CamaAsignada( )
	    {

	        if( null == paciente)
	        {
	            asignado = false;
	        }
	        return asignado;
	    }

	    // Indica si la Cama est� asignada al paciente recibido como par�metro.
	     
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

	    //Retorna el n�mero de la cama.
	    
	    public int darNumero( )
	    {
	        return numero;
	    }
	    
	    
	    // Retorna la ubicaci�n de la cama.
	     
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
