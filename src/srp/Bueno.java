package srp;

/**
 * ===================== BUEN EJEMPLO (cumple SRP) =====================
 *
 * Ahora cada clase tiene UNA sola responsabilidad:
 *   - Empleado: solo guarda los datos del empleado.
 *   - CalculadoraSalario: solo calcula el salario.
 *   - RepositorioEmpleado: solo persiste el empleado.
 *   - ReporteEmpleado: solo genera el reporte/presentación.
 *
 * Si cambia la forma de calcular el salario, solo se modifica
 * CalculadoraSalario. Si cambia la BD, solo se modifica
 * RepositorioEmpleado. Cada clase tiene una única razón para cambiar.
 */
class Empleado {
    private final String nombre;
    private final double horasTrabajadas;
    private final double salarioPorHora;

    public Empleado(String nombre, double horasTrabajadas, double salarioPorHora) {
        this.nombre = nombre;
        this.horasTrabajadas = horasTrabajadas;
        this.salarioPorHora = salarioPorHora;
    }

    public String getNombre() { return nombre; }
    public double getHorasTrabajadas() { return horasTrabajadas; }
    public double getSalarioPorHora() { return salarioPorHora; }
}

class CalculadoraSalario {
    public double calcular(Empleado empleado) {
        return empleado.getHorasTrabajadas() * empleado.getSalarioPorHora();
    }
}

class RepositorioEmpleado {
    public void guardar(Empleado empleado) {
        System.out.println("[BD] Guardando empleado " + empleado.getNombre() + " en la base de datos...");
    }
}

class ReporteEmpleado {
    private final CalculadoraSalario calculadora;

    public ReporteEmpleado(CalculadoraSalario calculadora) {
        this.calculadora = calculadora;
    }

    public String generar(Empleado empleado) {
        return "Reporte -> Empleado: " + empleado.getNombre()
                + " | Salario: $" + calculadora.calcular(empleado);
    }
}

public class Bueno {
    public static void demo() {
        System.out.println("== SRP: BUEN EJEMPLO ==");
        Empleado empleado = new Empleado("Ana", 160, 10.5);

        CalculadoraSalario calculadora = new CalculadoraSalario();
        RepositorioEmpleado repositorio = new RepositorioEmpleado();
        ReporteEmpleado reporte = new ReporteEmpleado(calculadora);

        System.out.println(reporte.generar(empleado));
        repositorio.guardar(empleado);
    }
}
