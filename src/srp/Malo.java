package srp;

import java.util.ArrayList;
import java.util.List;

/**
 * ===================== MAL EJEMPLO (viola SRP) =====================
 *
 * La clase Empleado tiene MÁS DE UNA responsabilidad:
 *   1) Guardar datos del empleado.
 *   2) Calcular el salario (lógica de negocio).
 *   3) Guardar el empleado en base de datos (persistencia).
 *   4) Generar un reporte en texto (presentación).
 *
 * Si cambia la forma de calcular el salario, o la forma de guardar en BD,
 * o el formato del reporte, ¡siempre hay que tocar la MISMA clase!
 * Eso significa que tiene varias "razones para cambiar", lo cual viola
 * el Principio de Responsabilidad Única (Single Responsibility Principle).
 */
class EmpleadoMalo {
    private String nombre;
    private double horasTrabajadas;
    private double salarioPorHora;

    public EmpleadoMalo(String nombre, double horasTrabajadas, double salarioPorHora) {
        this.nombre = nombre;
        this.horasTrabajadas = horasTrabajadas;
        this.salarioPorHora = salarioPorHora;
    }

    // Responsabilidad 1: lógica de negocio (cálculo de salario)
    public double calcularSalario() {
        return horasTrabajadas * salarioPorHora;
    }

    // Responsabilidad 2: persistencia
    public void guardarEnBaseDeDatos() {
        System.out.println("[BD] Guardando empleado " + nombre + " en la base de datos...");
        // Aquí iría código JDBC, Hibernate, etc.
    }

    // Responsabilidad 3: presentación / reporte
    public String generarReporte() {
        return "Reporte -> Empleado: " + nombre + " | Salario: $" + calcularSalario();
    }
}

public class Malo {
    public static void demo() {
        System.out.println("== SRP: MAL EJEMPLO ==");
        List<EmpleadoMalo> empleados = new ArrayList<>();
        empleados.add(new EmpleadoMalo("Ana", 160, 10.5));

        for (EmpleadoMalo e : empleados) {
            System.out.println(e.generarReporte());
            e.guardarEnBaseDeDatos();
        }
    }
}
