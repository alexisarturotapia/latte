package lsp;

/**
 * ===================== BUEN EJEMPLO (cumple LSP) =====================
 *
 * En vez de forzar que TODAS las aves vuelen, separamos el
 * comportamiento en una jerarquía más honesta:
 *   - Ave: comportamiento común a todas las aves (comer, etc.)
 *   - AveQueVuela: interfaz adicional solo para aves que vuelan.
 *
 * Pinguino extiende Ave (que no exige volar), y Gorrion implementa
 * además AveQueVuela. Así, cualquier subtipo puede sustituir a su
 * tipo base sin romper el comportamiento esperado.
 */
abstract class Ave {
    public void comer() {
        System.out.println("El ave está comiendo...");
    }
}

interface AveQueVuela {
    void volar();
}

class Gorrion extends Ave implements AveQueVuela {
    @Override
    public void volar() {
        System.out.println("El gorrión está volando...");
    }
}

class Pinguino extends Ave {
    public void nadar() {
        System.out.println("El pingüino está nadando...");
    }
}

public class Bueno {
    public static void demo() {
        System.out.println("== LSP: BUEN EJEMPLO ==");

        Ave[] aves = { new Gorrion(), new Pinguino() };
        for (Ave ave : aves) {
            ave.comer(); // Funciona para CUALQUIER Ave, sin excepciones.
        }

        // Solo las aves que realmente vuelan exponen ese comportamiento.
        AveQueVuela voladora = new Gorrion();
        voladora.volar();

        Pinguino pinguino = new Pinguino();
        pinguino.nadar();
    }
}
