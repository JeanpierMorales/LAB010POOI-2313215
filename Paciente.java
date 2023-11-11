import java.util.*;
public class Paciente {
    private int dni;
    private String nombre;
    private String direccion;
    private double peso;
    private double temperatura;
    private Medico medico;
    
    public Paciente(){

    }
    
    
    public Paciente(int dni, String nombre, String direccion, double peso, double temperatura,
            Medico medico) {
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
    public Medico getMedico() {
        return medico;
    }


    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    
    
    public static void mostrarInformacionPacientes(ArrayList<Paciente> listaPacientes) {
        // Ordenar la lista de pacientes por nombre
        Collections.sort(listaPacientes, Comparator.comparing(Paciente::getNombre));

        System.out.println("                 PACIENTES ACTUALES                 ");
        System.out.println("  " + "   DNI      NOMBRE      DIRECCIÓN       PESO     TEMPERATURA");
        int i=1;
        for (Paciente paciente : listaPacientes) {
            
            System.out.println(i+".    " + paciente.getDni() + "    " + paciente.getNombre() + "    " + "  " + paciente.getDireccion() + " " + "   " + paciente.getPeso() + " " + " " + "  " + paciente.getTemperatura());
            i++;
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
    
     //1. Registrar los datos de los pacientes uno a uno

    public static void registrarPaciente(ArrayList<Paciente> listaPacientes){
        System.out.println(" \n INGRESANDO NUEVO PACIENTE....  \n" );
        Scanner cs = new Scanner(System.in);
        int dni;
        String nom, direccion;
        double peso, temp;
        System.out.println("REGISTREMOS UN NUEVO PACIENTE!!: ");
        System.out.print("Ingrese su DNI: ");
        dni=cs.nextInt();
        System.out.print("Ingrese su Nombre: ");
        nom=cs.nextLine();
        System.out.print("Ingrese Su Dirección: ");
        direccion=cs.nextLine();
        System.out.print("Ingrese su Peso: ");
        peso=cs.nextDouble();
        System.out.print("Ingrese su Temperatura: ");
        temp=cs.nextDouble();
        Paciente p=new Paciente(dni,nom,direccion,peso,temp);
        listaPacientes.add(p);
        System.out.println("\nRegistro exitoso!");
        cs.close();
    }
    //2. Eliminar los datos de un paciente dado su posición una lista.
    public static void eliminarDatos(ArrayList<Paciente> listaPacientes, int borrar){
        listaPacientes.remove(borrar);
        System.out.println("Se ha eliminado al paciente con exito! \n" );

    } 

    //3. Modificar los datos de un paciente de la lista.
    public static void modificarDatos(ArrayList<Paciente> listaPacientes, int dni) {
        Scanner sc = new Scanner(System.in);
        // Buscar el paciente con el dni que nos dan 
        boolean encontrado = false;
        for (Paciente paciente : listaPacientes) {
            if (paciente.getDni() == dni) {
                System.out.println("Modificando...");

                // Solicitar nuevos datos
                System.out.print("Nuevo nombre: ");
                String nuevoNombre = sc.next();
                paciente.setNombre(nuevoNombre);

                System.out.print("Nueva dirección: ");
                String nuevaDireccion = sc.next();
                paciente.setDireccion(nuevaDireccion);

                System.out.print("Nuevo peso: ");
                double nuevoPeso = sc.nextDouble();
                paciente.setPeso(nuevoPeso);

                System.out.print("Nueva temperatura: ");
                double nuevaTemperatura = sc.nextDouble();
                paciente.setTemperatura(nuevaTemperatura);
                System.out.println("Los cambios se han guardado correctamente.");
                System.out.println("NUEVA DATA DE PACIENTES CON");
                Paciente.mostrarInformacionPacientes(listaPacientes);

                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("El DNI ingresado no se encuentra en la lista de pacientes");
        }
        sc.close();
    }
    
    //4. Mostrar el peso que más se repite en la lista.
    public static double obtenerPesoMasRepetido(ArrayList<Paciente> listaPacientes) {
        double pesoMasRepetido = 0;
        int maxConteo = 0;

        for (Paciente paciente : listaPacientes) {
            double peso = paciente.getPeso();
            int conteo = 0;

            // Contar las veces que aparece del peso en la lista
            for (Paciente otroPaciente : listaPacientes) {
                if (otroPaciente.getPeso() == peso) {
                    conteo++;
                }
            }
            if (conteo > maxConteo) {
                maxConteo = conteo;
                pesoMasRepetido = peso;
            }
        }

        return pesoMasRepetido;
    }

    //5. Mostrar la cantidad de pacientes que tienen el peso que más se repite;
    public static void pacientesConPesoRepetitivo(ArrayList<Paciente> listaPacientes){
        int total=0;
        for (Paciente paciente : listaPacientes) {
            if (paciente.getPeso()== obtenerPesoMasRepetido(listaPacientes)){
                total++;
            }
        }
        System.out.println("El total de pacientes que tiene el peso que más se repiten son " + total);
    }
    
    //6. Mostrar el peso mayor y menor.
    public static void mayorMenorPeso(ArrayList<Paciente> listaPacientes){
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;

        for (Paciente paciente : listaPacientes) {
            double peso = paciente.getPeso();

            // Actualizar el peso mayor
            if (peso > max) {
                max = peso;
            }
            if (peso < min) {
                min = peso;
            }
        }

        // Mostrar los resultados
        System.out.println("Peso mayor: " + max);
        System.out.println("Peso menor: " + min);
    }
    
    //7. Dividir el rango de pesos por 4
    public static void dividirRangoPesos(ArrayList<Paciente> listaPacientes) {
        if (listaPacientes.isEmpty()) {
            System.out.println("La lista de pacientes está vacía.");
            return;
        }
    
        // Encontrar el peso máximo y mínimo en la lista de pacientes
        double pesoMaximo = Double.MIN_VALUE;
        double pesoMinimo = Double.MAX_VALUE;
    
        for (Paciente paciente : listaPacientes) {
            double peso = paciente.getPeso();
    
            // Actualizar el peso máximo
            if (peso > pesoMaximo) {
                pesoMaximo = peso;
            }
    
            // Actualizar el peso mínimo
            if (peso < pesoMinimo) {
                pesoMinimo = peso;
            }
        }
    
        // Definir los límites de los 4 rangos
        double limite1 = pesoMinimo + (pesoMaximo - pesoMinimo) / 4;
        double limite2 = limite1 + (pesoMaximo - pesoMinimo) / 4;
        double limite3 = limite2 + (pesoMaximo - pesoMinimo) / 4;
    
        // Contadores para cada rango
        int rango1 = 0, rango2 = 0, rango3 = 0, rango4 = 0;
    
        // Contar la cantidad de personas en cada rango
        for (Paciente paciente : listaPacientes) {
            double peso = paciente.getPeso();
    
            if (peso <= limite1) {
                rango1++;
            } else if (peso <= limite2) {
                rango2++;
            } else if (peso <= limite3) {
                rango3++;
            } else {
                rango4++;
            }
        }
    
        // Mostrar los resultados
        System.out.println("Cantidad de personas en el rango de " + pesoMinimo + " a " + limite1 + ": " + rango1);
        System.out.println("Cantidad de personas en el rango de " + limite1 + " a " + limite2 + ": " + rango2);
        System.out.println("Cantidad de personas en el rango de " + limite2 + " a " + limite3 + ": " + rango3);
        System.out.println("Cantidad de personas en el rango de " + limite3 + " a " + pesoMaximo + ": " + rango4);
    }
    
    //8. Mostrar la lista de pacientes ordenados por 
    public static void listarPacientesNombre(ArrayList<Paciente> listaPacientes) {
        // Ordenar la lista de pacientes por nombre
        Collections.sort(listaPacientes, Comparator.comparing(Paciente::getNombre));

        System.out.println("                 PACIENTES ACTUALES                 ");
        System.out.println("  " + "   NOMBRE      DNI      DIRECCIÓN       PESO     TEMPERATURA");
        int i=1;
        for (Paciente paciente : listaPacientes) {
            System.out.println(i+ ".    " + paciente.getNombre() + "    " + paciente.getDni() + "    " + "  " + paciente.getDireccion() + " " + "   " + paciente.getPeso() + " " + " " + "  " + paciente.getTemperatura());
            i++;
        }
    }
   
   //9. Dado un paciente indicar qué doctor lo atendió
    public static void hallarMedico(ArrayList<Paciente> listaPacientes, int dni) {
        Scanner sc = new Scanner(System.in);
        // Buscar el paciente con el dni que nos dan 
        boolean encontrado = false;
        for (Paciente paciente : listaPacientes) {
            if (paciente.getDni() == dni) {
                System.out.println( paciente.getMedico().toString());
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("El DNI ingresado no se encuentra en la lista de pacientes");
        }
        sc.close();
    }

   //10. Operación 10 Buscar a los doctores por especialidad.
   public static void buscarDoctoresPorEspecialidad(ArrayList<Medico> listaMedicos) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Ingrese la especialidad a buscar: ");
    String especialidadBuscada = sc.next();

    System.out.println("Doctores con especialidad '" + especialidadBuscada + "':");
    boolean encontrados = false;

    for (Medico medico : listaMedicos) {
        if (medico.tieneEspecialidad(especialidadBuscada)) {
            System.out.println(medico);
            encontrados = true;
        }
    }

    if (!encontrados) {
        System.out.println("No se encontraron doctores con la especialidad '" + especialidadBuscada + "'.");
    }

    sc.close();
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