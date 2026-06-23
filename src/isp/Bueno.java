package isp;

/**
 * ===================== BUEN EJEMPLO (cumple ISP) =====================
 *
 * En vez de una sola interfaz gigante, dividimos el comportamiento en
 * interfaces pequeñas y específicas: Trabajable y Comestible (en este
 * caso, "puede comer"). Cada clase implementa SOLO las interfaces que
 * tienen sentido para ella.
 *
 * Humano implementa ambas, Robot implementa solo Trabajable. Nadie se
 * ve forzado a implementar métodos que no necesita.
 */
interface Trabajable {
    void trabajar();
}

interface Alimentable {
    void comer();
}

class Humano implements Trabajable, Alimentable {
    public void trabajar() { System.out.println("El humano está trabajando..."); }
    public void comer() { System.out.println("El humano está comiendo..."); }
}

class Robot implements Trabajable {
    public void trabajar() { System.out.println("El robot está trabajando..."); }
    // Robot NO implementa Alimentable: no necesita comer() y no está obligado a tenerlo.
}

public class Bueno {
    public static void demo() {
        System.out.println("== ISP: BUEN EJEMPLO ==");
        Humano humano = new Humano();
        Robot robot = new Robot();

        humano.trabajar();
        humano.comer();

        robot.trabajar(); // No hay método comer() que implementar a la fuerza.
        System.out.println("El robot no tiene comer(), y eso está perfecto.");
    }
}
