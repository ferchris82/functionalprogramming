package functionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProgramacionFuncional {
    
    public static void main(String[] args) {
        
        List<Personas> personas = Arrays.asList(
            new Personas("Karina", 35),
            new Personas("Gloria", 34),
            new Personas("Natalia", 28),
            new Personas("Johana", 36),
            new Personas("Lina", 33)
        );

        //Función Pura
        Predicate<Personas> esMayorde25 = persona -> persona.getEdad() > 25;
        //Función de order Superior
        List<Personas> mayoresDe25 = filtrarPersonas(personas, esMayorde25);
        mayoresDe25.forEach(persona -> System.out.println(persona.toString()));

        List<Personas> personasInmutables = Collections.unmodifiableList(personas);

        try {
            personasInmutables.add(new Personas("Martha", 50));
        } catch (Exception ex) {
            System.out.println("Error inmutable "+ ex);
        }
    }
         
    private static List<Personas> filtrarPersonas(List<Personas>personas, Predicate<Personas> esMayorDe25){
        return personas.stream().filter(esMayorDe25).collect(Collectors.toList());
    }
}
