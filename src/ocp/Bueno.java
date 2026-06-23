package ocp;

/**
 * ===================== BUEN EJEMPLO (cumple OCP) =====================
 *
 * Se define una interfaz Descuento con un método calcular(). Cada tipo
 * de cliente implementa su propia clase. Para agregar un nuevo tipo de
 * cliente (ej. SUPER_VIP) solo se CREA una nueva clase que implemente
 * Descuento, SIN modificar ninguna clase existente.
 *
 * El código está "cerrado" a la modificación pero "abierto" a la
 * extensión: exactamente lo que pide OCP.
 */
interface Descuento {
    double calcular(double monto);
}

class DescuentoRegular implements Descuento {
    public double calcular(double monto) { return monto * 0.0; }
}

class DescuentoVip implements Descuento {
    public double calcular(double monto) { return monto * 0.10; }
}

class DescuentoPremium implements Descuento {
    public double calcular(double monto) { return monto * 0.20; }
}

// Nuevo tipo de cliente: se EXTIENDE sin tocar código existente.
class DescuentoSuperVip implements Descuento {
    public double calcular(double monto) { return monto * 0.30; }
}

class CalculadoraDescuentoBuena {
    public double calcularDescuento(Descuento estrategia, double monto) {
        return estrategia.calcular(monto);
    }
}

public class Bueno {
    public static void demo() {
        System.out.println("== OCP: BUEN EJEMPLO ==");
        CalculadoraDescuentoBuena calc = new CalculadoraDescuentoBuena();
        System.out.println("Descuento REGULAR: " + calc.calcularDescuento(new DescuentoRegular(), 100));
        System.out.println("Descuento VIP: " + calc.calcularDescuento(new DescuentoVip(), 100));
        System.out.println("Descuento PREMIUM: " + calc.calcularDescuento(new DescuentoPremium(), 100));
        System.out.println("Descuento SUPER_VIP (nuevo, sin modificar nada): "
                + calc.calcularDescuento(new DescuentoSuperVip(), 100));
    }
}
