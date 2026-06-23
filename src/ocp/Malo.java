package ocp;

/**
 * ===================== MAL EJEMPLO (viola OCP) =====================
 *
 * CalculadoraDescuento usa un "if/else" gigante basado en un tipo de
 * cliente (String). Cada vez que aparece un NUEVO tipo de cliente,
 * hay que MODIFICAR esta clase agregando otro "else if".
 *
 * Esto viola el Principio de Abierto/Cerrado (Open/Closed Principle):
 * el código debería estar ABIERTO a la extensión (agregar nuevos
 * comportamientos) pero CERRADO a la modificación (no tocar el código
 * que ya funciona y ya fue probado).
 */
class CalculadoraDescuentoMala {
    public double calcularDescuento(String tipoCliente, double monto) {
        if (tipoCliente.equals("REGULAR")) {
            return monto * 0.0;
        } else if (tipoCliente.equals("VIP")) {
            return monto * 0.10;
        } else if (tipoCliente.equals("PREMIUM")) {
            return monto * 0.20;
        }
        // Si llega un nuevo tipo "SUPER_VIP", hay que volver a editar esta clase...
        return 0;
    }
}

public class Malo {
    public static void demo() {
        System.out.println("== OCP: MAL EJEMPLO ==");
        CalculadoraDescuentoMala calc = new CalculadoraDescuentoMala();
        System.out.println("Descuento REGULAR: " + calc.calcularDescuento("REGULAR", 100));
        System.out.println("Descuento VIP: " + calc.calcularDescuento("VIP", 100));
        System.out.println("Descuento PREMIUM: " + calc.calcularDescuento("PREMIUM", 100));
    }
}
