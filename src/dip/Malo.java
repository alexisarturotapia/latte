package dip;

/**
 * ===================== MAL EJEMPLO (viola DIP) =====================
 *
 * NotificadorMalo depende DIRECTAMENTE de la clase concreta
 * EmailServiceMalo. Si quisiéramos enviar notificaciones por SMS en
 * lugar de email, tendríamos que MODIFICAR la clase NotificadorMalo.
 *
 * Esto viola el Principio de Inversión de Dependencias (Dependency
 * Inversion Principle): los módulos de alto nivel (NotificadorMalo) no
 * deberían depender de módulos de bajo nivel concretos
 * (EmailServiceMalo), sino de ABSTRACCIONES (interfaces).
 */
class EmailServiceMalo {
    public void enviarEmail(String mensaje) {
        System.out.println("Enviando EMAIL: " + mensaje);
    }
}

class NotificadorMalo {
    // Dependencia directa de una clase concreta: acoplamiento fuerte.
    private EmailServiceMalo emailService = new EmailServiceMalo();

    public void notificar(String mensaje) {
        emailService.enviarEmail(mensaje);
    }
}

public class Malo {
    public static void demo() {
        System.out.println("== DIP: MAL EJEMPLO ==");
        NotificadorMalo notificador = new NotificadorMalo();
        notificador.notificar("Tu pedido fue enviado.");
        // No hay forma de cambiar a SMS sin editar NotificadorMalo.
    }
}
