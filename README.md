# Proyecto SOLID en Java

Este proyecto contiene un ejemplo **malo** (que viola el principio) y un ejemplo **bueno**
(que lo cumple) para cada una de las 5 letras de **SOLID**.

Estructura:

```
src/
 ├─ srp/   -> Single Responsibility Principle
 ├─ ocp/   -> Open/Closed Principle
 ├─ lsp/   -> Liskov Substitution Principle
 ├─ isp/   -> Interface Segregation Principle
 └─ dip/   -> Dependency Inversion Principle
```

Cada paquete tiene:
- `Malo.java` (o varias clases) con el código que viola el principio.
- `Bueno.java` (o varias clases) con el código corregido.
- Un comentario al inicio explicando el problema y la solución.

## Cómo compilar y ejecutar

```bash
cd src
javac srp/*.java ocp/*.java lsp/*.java isp/*.java dip/*.java
java srp.Main
java ocp.Main
java lsp.Main
java isp.Main
java dip.Main
```

## Resumen rápido de cada principio

| Letra | Nombre | Idea central |
|-------|--------|---------------|
| S | Single Responsibility | Una clase debe tener una sola razón para cambiar. |
| O | Open/Closed | El código debe poder extenderse sin modificar lo existente. |
| L | Liskov Substitution | Las subclases deben poder sustituir a su clase base sin romper el comportamiento. |
| I | Interface Segregation | Es mejor tener interfaces pequeñas y específicas que una grande y general. |
| D | Dependency Inversion | Depender de abstracciones, no de implementaciones concretas. |
