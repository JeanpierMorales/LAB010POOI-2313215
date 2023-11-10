import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList <Paciente> listapaPacientes= new ArrayList<>();
        ArrayList <Medico> listaMedicos = new ArrayList<>();

        Scanner ingresar= new Scanner(System.in);
        int eleccion, op1, op2, op3, op4, op5, op6, op7, op8, op9, op10;
        System.out.println("Opcion 1: Eliminar los datos de un paciente dado su posición una lista.");
        System.out.println("Opcion 2: Modificar los datos de un paciente de la lista.");
        System.out.println("Opcion 3: Mostrar el peso que más se repite en la lista.");
        System.out.println("Opcion 4: Mostrar la cantidad de pacientes que tienen el peso que más se repite;");
        System.out.println("Opcion 5: Mostrar el peso mayor y menor.");
        System.out.println("Opcion 6: Dividir el rango de pesos por 4,");
        System.out.println("Opcion 7: Mostrar la lista de pacientes ordenados por apellidos");
        System.out.println("Opcion 8: Dado un paciente indicar qué doctor lo atendió");
        System.out.println("Opcion 9: Buscar a los doctores por especialidad.");
        System.out.println("Ingrese la opción que desee realizar: ");
        System.out.println(" ");
        System.out.println("Opcion 10: Registrar los datos de los pacientes uno a uno");    
        eleccion = ingresar.nextInt();
        while(eleccion>10 && eleccion<1){
            System.out.println("Ingrese una opción valida: ");
            eleccion = ingresar.nextInt();
        }
        switch(eleccion) {
            case 1:

                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            default:
                break;
        }

    }
}
