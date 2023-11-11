import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        String [] especialidades = {"Pediatría", "Neurología", "Psiquiatría", "Medicina Interna", "Medicina de Emergencia", "Cirugía General", "Psiquiatría"}; 
        // Agregar pacientes de ejemplo
        for (int i = 0; i < 7; i++) {
            listaPacientes.add(new Paciente(ran.nextInt(99999999+1), nombresPacientes[i], direccionesPacientes[i], (50+ran.nextInt(10)), ran.nextInt(30)));
        }
        for (int i = 0; i < 7; i++) {
            listaMedicos.add(new Medico(ran.nextInt(699999), nombresMedicos[i], especialidades[i]));
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
                // Implementa la lógica para eliminar un paciente de la lista
                break;
            case 2:
                // Implementa la lógica para eliminar un paciente de la lista
                break;
            case 3:
                // Implementa la lógica para eliminar un paciente de la lista
                break;
            case 4:
                // Implementa la lógica para eliminar un paciente de la lista
                break;
            case 5:
                // Implementa la lógica para eliminar un paciente de la lista
                break;
            case 6:
                // Implementa la lógica para eliminar un paciente de la lista
                break;
            case 7:
                // Implementa la lógica para eliminar un paciente de la lista
                break;
            case 8:
                Paciente.listarPacientesNombre(listaPacientes);
                break;
            case 9:
                // Implementa la lógica para eliminar un paciente de la lista
                break;
            case 10:
                // Implementa la lógica para eliminar un paciente de la lista
                break;
            default:
                break;
        }
        
        // Cerrar el Scanner
        ingresar.close();
    }
}
