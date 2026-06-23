package isp;

/**
 * ===================== MAL EJEMPLO (viola ISP) =====================
 *
 * La interfaz Trabajador obliga a TODAS las clases que la implementan
 * a definir tanto trabajar() como comer(). Pero un RobotMalo no come,
 * así que se ve forzado a implementar un método que no necesita y que
 * no tiene sentido para él (lanza una excepción o queda vacío).
 *
 * Esto viola el Principio de Segregación de Interfaces (Interface
 * Segregation Principle): una clase no debería verse forzada a
 * implementar métodos que no usa.
 */
interface TrabajadorMalo {
    void trabajar();
    void comer();
}

class HumanoMalo implements TrabajadorMalo {
    public void trabajar() { System.out.println("El humano está trabajando..."); }
    public void comer() { System.out.println("El humano está comiendo..."); }
}

class RobotMalo implements TrabajadorMalo {
    public void trabajar() { System.out.println("El robot está trabajando..."); }

    @Override
    public void comer() {
        // El robot no come, pero la interfaz lo obliga a tener este método.
        throw new UnsupportedOperationException("¡Un robot no puede comer!");
    }
}

public class Malo {
    public static void demo() {
        System.out.println("== ISP: MAL EJEMPLO ==");
        TrabajadorMalo humano = new HumanoMalo();
        TrabajadorMalo robot = new RobotMalo();

        humano.trabajar();
        humano.comer();

        robot.trabajar();
        try {
            robot.comer();
        } catch (UnsupportedOperationException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
