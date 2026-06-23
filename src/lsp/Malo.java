package lsp;

/**
 * ===================== MAL EJEMPLO (viola LSP) =====================
 *
 * Ave tiene un método volar(). Pinguino HEREDA de Ave, pero los
 * pingüinos no vuelan, así que volar() lanza una excepción.
 *
 * Esto viola el Principio de Sustitución de Liskov (Liskov Substitution
 * Principle): si Pinguino es una subclase de Ave, en CUALQUIER lugar
 * donde se use un Ave, debería poder usarse un Pinguino sin que el
 * programa se rompa. Aquí, al sustituir Ave por Pinguino, el programa
 * explota con una excepción en tiempo de ejecución.
 */
class AveMala {
    public void volar() {
        System.out.println("El ave está volando...");
    }
}

class PinguinoMalo extends AveMala {
    @Override
    public void volar() {
        // Los pingüinos no vuelan: rompemos el contrato de la clase padre.
        throw new UnsupportedOperationException("¡Los pingüinos no pueden volar!");
    }
}

public class Malo {
    public static void demo() {
        System.out.println("== LSP: MAL EJEMPLO ==");
        AveMala[] aves = { new AveMala(), new PinguinoMalo() };
        for (AveMala ave : aves) {
            try {
                ave.volar();
            } catch (UnsupportedOperationException e) {
                System.out.println("ERROR al sustituir Ave por Pinguino: " + e.getMessage());
            }
        }
    }
}
