package com.johan.calculadora

import kotlin.math.*

// CLASE BASE 
// Aqui va la clase principal Calculadora
// Tiene las operaciones basicas: sumar, restar, multiplicar y dividir
// Se usa "open" para que otra clase pueda heredar de ella
open class Calculadora {

    fun sumar(a: Double, b: Double): Double = a + b

    fun restar(a: Double, b: Double): Double = a - b

    fun multiplicar(a: Double, b: Double): Double = a * b

    fun dividir(a: Double, b: Double): Double {
        // Aqui se valida que no se divida por cero
        if (b == 0.0) throw ArithmeticException("No se puede dividir por cero")
        return a / b
    }
}

// CLASE CIENTIFICA 
// Esta clase hereda de Calculadora y agrega funciones avanzadas
// Aqui estan las funciones trigonometricas, potencias, logaritmos y conversiones
class CalculadoraCientifica : Calculadora() {

    fun seno(x: Double, enGrados: Boolean = true): Double {
        // Si el angulo esta en grados, se convierte a radianes
        val rad = if (enGrados) Math.toRadians(x) else x
        return sin(rad)
    }

    fun coseno(x: Double, enGrados: Boolean = true): Double {
        val rad = if (enGrados) Math.toRadians(x) else x
        return cos(rad)
    }

    fun tangente(x: Double, enGrados: Boolean = true): Double {
        val rad = if (enGrados) Math.toRadians(x) else x
        return tan(rad)
    }

    // Calcula potencias (base elevada a exponente)
    fun potencia(base: Double, exponente: Double): Double = base.pow(exponente)

    // Calcula la raiz con validacion para evitar numeros negativos con raices pares
    fun raiz(x: Double, indice: Double = 2.0): Double {
        if (x < 0 && indice % 2 == 0.0) throw ArithmeticException("No se puede sacar raiz par de numero negativo")
        return x.pow(1 / indice)
    }

    // Calcula logaritmo base 10, valida que x sea mayor que cero
    fun log10(x: Double): Double {
        if (x <= 0) throw ArithmeticException("El logaritmo base 10 solo se define para x > 0")
        return kotlin.math.log10(x)
    }

    // Calcula logaritmo natural (base e)
    fun ln(x: Double): Double {
        if (x <= 0) throw ArithmeticException("El logaritmo natural solo se define para x > 0")
        return kotlin.math.ln(x)
    }

    // Calcula la funcion exponencial e^x
    fun exp(x: Double): Double = kotlin.math.exp(x)

    // Convierte grados a radianes y viceversa
    fun gradosARadianes(g: Double): Double = Math.toRadians(g)
    fun radianesAGrados(r: Double): Double = Math.toDegrees(r)
}

// CLASE MEMORIA
// Esta clase guarda un valor en memoria como las calculadoras reales
// Se puede sumar, restar, ver o limpiar el valor guardado
class Memoria {
    private var valor: Double = 0.0 // variable privada, nadie fuera puede tocarla directamente

    fun mPlus(x: Double) {
        valor += x // suma un valor a la memoria
    }

    fun mMinus(x: Double) {
        valor -= x // resta un valor a la memoria
    }

    fun mr(): Double = valor // devuelve el valor guardado

    fun mClear() {
        valor = 0.0 // limpia la memoria
    }
}

// FUNCION PRINCIPAL
// Aqui va el menu principal del programa, donde el usuario elige que hacer
// Se usa readLine() en lugar de Scanner para evitar errores de entrada
fun main() {
    val calc = CalculadoraCientifica() // se crea una calculadora cientifica
    val memoria = Memoria() // se crea la memoria para guardar valores

    while (true) {
        println("\n===== CALCULADORA CIENTIFICA =====")
        println("1. Operaciones basicas (+, -, *, /)")
        println("2. Funciones trigonometricas (sin, cos, tan)")
        println("3. Potencias, raices y logaritmos")
        println("4. Memoria (M+, M-, MR, MC)")
        println("0. Salir")

        val opcion = leerEntero("Opcion: ") ?: run {
            println("Entrada finalizada. Saliendo...")
            break
        }

        when (opcion) {
            1 -> {
                val a = leerDouble("Primer numero: ") ?: continue
                val b = leerDouble("Segundo numero: ") ?: continue

                println("Suma: ${calc.sumar(a, b)}")
                println("Resta: ${calc.restar(a, b)}")
                println("Multiplicacion: ${calc.multiplicar(a, b)}")
                try {
                    println("Division: ${calc.dividir(a, b)}")
                } catch (e: Exception) {
                    println("Error: ${e.message}")
                }
            }

            2 -> {
                val ang = leerDouble("Angulo en grados: ") ?: continue
                println("Seno: ${calc.seno(ang)}")
                println("Coseno: ${calc.coseno(ang)}")
                println("Tangente: ${calc.tangente(ang)}")
            }

            3 -> {
                val base = leerDouble("Numero base: ") ?: continue
                val exp = leerDouble("Exponente: ") ?: continue

                println("Potencia: ${calc.potencia(base, exp)}")
                try {
                    println("Raiz cuadrada: ${calc.raiz(base)}")
                    println("Log10: ${calc.log10(base)}")
                    println("Ln: ${calc.ln(base)}")
                    println("Exponencial e^x: ${calc.exp(base)}")
                } catch (e: Exception) {
                    println("Error: ${e.message}")
                }
            }

            4 -> {
                println("1) M+  2) M-  3) MR  4) MC")
                when (leerEntero("Elige memoria: ") ?: continue) {
                    1 -> { val v = leerDouble("Valor: ") ?: continue; memoria.mPlus(v) }
                    2 -> { val v = leerDouble("Valor: ") ?: continue; memoria.mMinus(v) }
                    3 -> println("Memoria actual: ${memoria.mr()}")
                    4 -> { memoria.mClear(); println("Memoria borrada") }
                    else -> println("Opcion de memoria no valida")
                }
            }

            0 -> {
                println("Saliendo...")
                break
            }

            else -> println("Opcion no valida")
        }
    }
}

//  FUNCIONES DE APOYO 
// Estas funciones leen numeros desde consola sin romper el programa
// Si el usuario pone algo no valido, muestran mensaje y devuelven null

fun leerEntero(prompt: String): Int? {
    print(prompt)
    val line = readLine() ?: return null // si no hay entrada (EOF), sale
    val v = line.trim().toIntOrNull()
    if (v == null) {
        println("Entrada no valida, escribe un numero entero")
        return null
    }
    return v
}

fun leerDouble(prompt: String): Double? {
    print(prompt)
    val line = readLine() ?: return null
    val v = line.trim().replace(",", ".").toDoubleOrNull()
    if (v == null) {
        println("Entrada no valida, escribe un numero (usa punto decimal)")
        return null
    }
    return v
}
