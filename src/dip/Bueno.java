package dip;

/**
 * ===================== BUEN EJEMPLO (cumple DIP) =====================
 *
 * Ahora Notificador depende de la ABSTRACCIÓN ServicioMensaje, no de
 * una implementación concreta. EmailService y SmsService son detalles
 * de bajo nivel que implementan esa abstracción.
 *
 * La dependencia se "invierte": el módulo de alto nivel (Notificador)
 * ya no depende de los detalles; son los detalles los que dependen de
 * la abstracción. Podemos inyectar cualquier implementación (email,
 * SMS, push notification, etc.) sin tocar Notificador.
 */
interface ServicioMensaje {
    void enviar(String mensaje);
}

class EmailService implements ServicioMensaje {
    public void enviar(String mensaje) {
        System.out.println("Enviando EMAIL: " + mensaje);
    }
}

class SmsService implements ServicioMensaje {
    public void enviar(String mensaje) {
        System.out.println("Enviando SMS: " + mensaje);
    }
}

class Notificador {
    private final ServicioMensaje servicioMensaje;

    // Inyección de dependencias vía constructor: Notificador no sabe
    // (ni le importa) si es email, SMS o cualquier otra cosa.
    public Notificador(ServicioMensaje servicioMensaje) {
        this.servicioMensaje = servicioMensaje;
    }

    public void notificar(String mensaje) {
        servicioMensaje.enviar(mensaje);
    }
}

public class Bueno {
    public static void demo() {
        System.out.println("== DIP: BUEN EJEMPLO ==");

        Notificador notificadorEmail = new Notificador(new EmailService());
        notificadorEmail.notificar("Tu pedido fue enviado.");

        Notificador notificadorSms = new Notificador(new SmsService());
        notificadorSms.notificar("Tu pedido fue enviado.");
    }
}
