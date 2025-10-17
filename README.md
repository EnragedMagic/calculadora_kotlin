# Informe — Calculadora Cientifica en Kotlin - Johan Steven Galeano Gonzalez

## Introduccion
Este proyecto desarrolla una **Calculadora Cientifica** en **Kotlin**, utilizando los principios de la **Programacion Orientada a Objetos (POO)**.  
El objetivo es crear un programa modular y claro que permita realizar operaciones basicas y funciones cientificas como trigonometria, potencias, raices, logaritmos y funciones exponenciales.  

En esta version se mantiene una estructura sencilla, sin manejo de excepciones, centrada unicamente en los conceptos principales de la POO: **encapsulamiento**, **herencia** y **polimorfismo**.

---

## Encapsulamiento
El **encapsulamiento** se aplica al restringir el acceso directo a los atributos internos de las clases.  
Por ejemplo, en la clase `Memoria`, el atributo `valor` es **privado** (`private var valor: Double`), lo que impide modificarlo directamente desde fuera.  
Esto garantiza que solo los metodos `mPlus()`, `mMinus()`, `mr()` y `mClear()` puedan cambiar su estado.

Tambien se observa encapsulamiento en las clases `Calculadora` y `CalculadoraCientifica`, donde las operaciones se agrupan como metodos que pueden ser reutilizados, evitando exponer logica interna o pasos intermedios al usuario.

---

## Herencia
La **herencia** se utiliza para extender las funcionalidades de la clase base `Calculadora`.  
Esta clase contiene las operaciones aritmeticas fundamentales: suma, resta, multiplicacion y division.  

A partir de ella se crea la clase `CalculadoraCientifica`, que **hereda** todos los metodos de la clase padre y agrega nuevas funciones:  
`seno()`, `coseno()`, `tangente()`, `potencia()`, `raiz()`, `log10()`, `ln()` y `exp()`.  

Esto demuestra herencia porque la calculadora cientifica conserva las caracteristicas de la calculadora normal, pero incluye operaciones mas avanzadas sin duplicar codigo.

---

## Polimorfismo
El **polimorfismo** se aplica mediante **sobrecarga de metodos**.  
Esto significa que un mismo metodo puede trabajar con diferentes tipos de datos.  
Por ejemplo, las operaciones `sumar()`, `restar()` o `multiplicar()` podrian adaptarse tanto a enteros como a decimales si se implementaran versiones adicionales.  

Gracias al polimorfismo, el comportamiento del metodo se ajusta segun los parametros que recibe, haciendo el codigo mas flexible y reutilizable.

---

## Estructura del Programa
El programa se organiza en tres partes principales:

1. **Clase `Calculadora`**  
   Contiene las operaciones basicas (+, −, ×, ÷).  
   Define la estructura base que sera extendida por las clases derivadas.

2. **Clase `CalculadoraCientifica`**  
   Hereda de `Calculadora` y agrega funciones matematicas avanzadas.  
   Representa el uso de la herencia y la reutilizacion de codigo.

3. **Clase `Memoria`**  
   Implementa una memoria simple para guardar y recuperar resultados.  
   Aplica encapsulamiento al proteger su atributo `valor`.

4. **Funcion principal (`main`)**  
   Ofrece un menu por consola donde el usuario puede elegir entre operaciones basicas, funciones cientificas y manejo de memoria.

---

## Diagrama UML — Explicacion
El siguiente diagrama representa la relacion entre las clases de la aplicacion:

- **Calculadora** es la clase base con las operaciones aritmeticas.  
- **CalculadoraCientifica** hereda de `Calculadora` e incluye funciones trigonométricas, potencias, logaritmos y raices.  
- **Memoria** se usa de forma independiente y encapsula un valor numerico para guardar resultados.  
- **main()** representa el punto de entrada que coordina la interaccion entre el usuario y las clases.

El diagrama refleja los tres pilares de la POO:
- **Encapsulamiento:** Atributos privados y metodos controlados.
- **Herencia:** Relacion de especializacion entre `Calculadora` y `CalculadoraCientifica`.
- **Polimorfismo:** Metodos reutilizables con diferentes tipos de datos.

---

## Conclusiones
El desarrollo de esta calculadora demuestra la aplicacion practica de la **Programacion Orientada a Objetos**.  
El **encapsulamiento** garantiza la seguridad de los datos,  
la **herencia** facilita la expansion del sistema sin repetir codigo,  
y el **polimorfismo** aporta flexibilidad al permitir que los metodos trabajen con distintos tipos de valores.  

En conjunto, estos principios permiten construir una aplicacion simple, estructurada y lista para ser extendida en futuras versiones.
