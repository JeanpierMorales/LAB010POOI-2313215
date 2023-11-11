import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ArrayList<Paciente> listaPacientes = new ArrayList<>();
        ArrayList<Medico> listaMedicos = new ArrayList<>();
        Scanner ingresar = new Scanner(System.in);
        Random ran = new Random();
        String [] nombresPacientes = {"Carlos", "Juan", "Pedro", "Luz", "Sabrina", "Leo", "Carmen"}; 
        String [] direccionesPacientes = {"Calle a", "Calle b", "Calle c", "Calle d", "Calle e", "Calle f", "Calle g"};  
        String [] nombresMedicos = {"Ivan", "Joaquin", "Martha", "Luciano ", "Sandra", "Rogelio", "Susana"}; 
        String [] especialidades = {"Pediatria", "Neurologia", "Psiquiatria", "Medicina Interna", "Medicina de Emergencia", "Cirugia General", "Psiquiatria"}; 
        // Agregar pacientes de ejemplo
        for (int i = 0; i < 7; i++) {
            listaMedicos.add(new Medico(ran.nextInt(699999), nombresMedicos[i], especialidades[i]));
        }
        for (int i = 0; i < 7; i++) {
            Medico medicoRandom= listaMedicos.get(ran.nextInt(listaMedicos.size()));
            listaPacientes.add(new Paciente(ran.nextInt(99999999+1), nombresPacientes[i], direccionesPacientes[i], (50+ran.nextInt(10)), ran.nextInt(30), medicoRandom));
        }

        Paciente.mostrarInformacionPacientes(listaPacientes);
        
        System.out.println("REALIZA ALGUNA DE LAS SIGUIENTES ACTIVIDADES: ");

        Paciente.opciones();

        int eleccion = ingresar.nextInt();

        // Validar la elección del usuario
        while (eleccion < 1 || eleccion > 10) {
            System.out.println("Ingrese una opción válida: ");
            eleccion = ingresar.nextInt();
        }

        switch (eleccion) {
            case 1:
                Paciente.registrarPaciente(listaPacientes);
                break;
            case 2:
                int borrar;
                System.out.println("Ingrese el indice de la persona que desee eliminar: ");
                borrar = ingresar.nextInt();
                Paciente.eliminarDatos(listaPacientes, borrar);
                Paciente.mostrarInformacionPacientes(listaPacientes);
                break;
            case 3:
                System.out.println("Ingesel el Dni de la persona a modificar datos: ");
                int buscarDNI = ingresar.nextInt();
                Paciente.modificarDatos(listaPacientes, buscarDNI);
                break;
            case 4:
                System.out.println("El peso que tiene mayor presencia es: "+ Paciente.obtenerPesoMasRepetido(listaPacientes));
                break;
            case 5:
                Paciente.pacientesConPesoRepetitivo(listaPacientes);
                break;
            case 6:
                Paciente.mayorMenorPeso(listaPacientes);
                break;
            case 7:
                Paciente.dividirRangoPesos(listaPacientes);
                break;
            case 8:
                Paciente.listarPacientesNombre(listaPacientes);
                break;
            case 9:
                System.out.println("Ingesel el Dni de la persona a modificar datos: ");
                int buscarDni = ingresar.nextInt();
                Paciente.hallarMedico(listaPacientes, buscarDni);

                break;
            case 10:
                Paciente.buscarDoctoresPorEspecialidad(listaMedicos);
                break;
            default:
                break;
        }
        
        // Cerrar el Scanner
        ingresar.close();
    }
}
