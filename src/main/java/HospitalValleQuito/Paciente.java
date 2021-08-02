package HospitalValleQuito;

import com.mongodb.BasicDBObject;

public class Paciente {
	// Atributos

    // Cédula del usuario.
     
    private String cedula;

    ///Nombre del usuario.
     
    private String nombre;
    
    // Apellido del usuario.
    private String apellido;

	private Paciente pOtroUsuario;

    // Constructores

    // Crea un usuario con su cédula y nombre.
    
    public Paciente( String pCedula, String pNombre, String pApellido )
    {
        cedula = pCedula;
        nombre = pNombre;
        apellido = pApellido;
    }
    
    
    // Constructor sin parametros
    public Paciente()
    {
        cedula = "";
        nombre = "";
        apellido = "";
    }
    
    

    // Métodos

    // Retorna la cédula del paciente

    public String darCedula( )
    {
        return cedula;
    }

    // Retorna el nombre del paciente

    public String darNombre( )
    {
        return nombre;
    }
    // Retorna el apellido del paciente

    public String darApellido( )
    {
        return apellido;
    }

    // Indica si el usuario es igual a otro.
 
    public boolean igualA1( Paciente pOtroUsuario )
    {
		boolean esIgual = false;
        if( cedula.equals( pOtroUsuario.darCedula( ) ) )
        {
            esIgual = true;
        }

        return esIgual;
    }

	public boolean igualA(Paciente pUsuario) {
		return false;
	}
	
	
	public BasicDBObject toDBObjectHospital_Valles_Quito_Paciente() {
		BasicDBObject dbObjectPaciente = new BasicDBObject();
		dbObjectPaciente.append("Cedula", this.darCedula());
		dbObjectPaciente.append("Nombre", this.darNombre());
		dbObjectPaciente.append("Apellido", this.darApellido());
		return dbObjectPaciente;
	}

}
