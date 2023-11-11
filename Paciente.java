import java.util.*;
public class Paciente {
    
    Scanner scanner=new Scanner (System.in);
    private int dni;
    private String nombre;
    private String direccion;
    private double peso;
    private double temperatura;
    private Medico medico;
    
    public Paciente(){

    }
    
    
    public Paciente(Scanner scanner, int dni, String nombre, String direccion, double peso, double temperatura,
            Medico medico) {
        this.scanner = scanner;
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.peso = peso;
        this.temperatura = temperatura;
        this.medico = medico;
    }


    public Paciente(int dni, String nombre, String direccion, double peso, double temperatura) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.peso = peso;
        this.temperatura = temperatura;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }


    public static void mostrarInformacionPacientes(ArrayList<Paciente> listaPacientes) {
        // Ordenar la lista de pacientes por nombre
        Collections.sort(listaPacientes, Comparator.comparing(Paciente::getNombre));

        System.out.println("                 PACIENTES ACTUALES                 ");
        System.out.println("  " + "   DNI      NOMBRE      DIRECCIÓN       PESO     TEMPERATURA");
        for (Paciente paciente : listaPacientes) {
            System.out.println("    " + paciente.getDni() + "    " + paciente.getNombre() + "    " + "  " + paciente.getDireccion() + " " + "   " + paciente.getPeso() + " " + " " + "  " + paciente.getTemperatura());
        }
    }
     public static void opciones(){
        System.out.println("Opcion 1: Registrar los datos de los pacientes.\n" +
        "Opcion 2: Eliminar los datos de un paciente dado su posición una lista.\n"+
        "Opcion 3: Modificar los datos de un paciente de la lista.\n"+
        "Opcion 4: Mostrar el peso que más se repite en la lista.\n"+
        "Opcion 5: Mostrar la cantidad de pacientes que tienen el peso que más se repite;.\n"+
        "Opcion 6: Mostrar el peso mayor y menor.\n"+
        "Opcion 7: Dividir el rango de pesos por 4,\n"+
        "Opcion 8: Mostrar la lista de pacientes ordenados por apellidos\n"+
        "Opcion 9: Dado un paciente indicar qué doctor lo atendió\n"+
        "Opcion 10: Buscar a los doctores por especialidad. ");
        System.out.println("Ingrese la opción que desee realizar: ");
     }

    public void registrarPasiente(){
        System.out.println("REGISTREMOS UN NUEVO PACIENTE!!: ");
        System.out.println("Ingrese el nombre: ");
        nombre=scanner.nextLine();
        setNombre(nombre);
        
        
    }
    //8: Mostrar la lista de pacientes ordenados por 
    public static void listarPacientesNombre(ArrayList<Paciente> listaPacientes) {
        // Ordenar la lista de pacientes por nombre
        Collections.sort(listaPacientes, Comparator.comparing(Paciente::getNombre));

        System.out.println("                 PACIENTES ACTUALES                 ");
        System.out.println("  " + "   NOMBRE      DNI      DIRECCIÓN       PESO     TEMPERATURA");
        for (Paciente paciente : listaPacientes) {
            System.out.println("    " + paciente.getNombre() + "    " + paciente.getDni() + "    " + "  " + paciente.getDireccion() + " " + "   " + paciente.getPeso() + " " + " " + "  " + paciente.getTemperatura());
        }
    }
    
    


    @Override
    public String toString() {
        return "Paciente" +
                "DNI: " + dni + '\'' +
                "Nombre: " + nombre + '\'' +
                "Direccion: " + direccion + '\'' +
                "Peso: " + peso +
                "Temperatura: " + temperatura +
                "Medico: " + (medico!=null? medico.toString(): "NO SE HA REGISTRADO UN MEDICO PARA ESTE PASIENTE");
    }
}