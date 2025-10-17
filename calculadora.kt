package com.johan.calculadora

import kotlin.math.*

//  CLASE BASE 
// Aqui va la clase principal Calculadora
// Tiene las operaciones basicas: sumar, restar, multiplicar y dividir
open class Calculadora {

    fun sumar(a: Double, b: Double): Double = a + b

    fun restar(a: Double, b: Double): Double = a - b

    fun multiplicar(a: Double, b: Double): Double = a * b

    fun dividir(a: Double, b: Double): Double {
        // Si b es cero, devuelve 0 para evitar errores
        if (b == 0.0) {
            println("No se puede dividir por cero. Resultado = 0")
            return 0.0
        }
        return a / b
    }
}

//  CLASE CIENTIFICA 
// Esta clase hereda de Calculadora y agrega funciones mas avanzadas
class CalculadoraCientifica : Calculadora() {

    fun seno(x: Double, enGrados: Boolean = true): Double {
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

    fun potencia(base: Double, exponente: Double): Double = base.pow(exponente)

    fun raiz(x: Double, indice: Double = 2.0): Double = x.pow(1 / indice)

    fun log10(x: Double): Double = kotlin.math.log10(x)

    fun ln(x: Double): Double = kotlin.math.ln(x)

    fun exp(x: Double): Double = kotlin.math.exp(x)
}

//  CLASE MEMORIA 
// Clase simple que guarda un valor en memoria como una calculadora real
class Memoria {
    private var valor: Double = 0.0

    fun mPlus(x: Double) {
        valor += x
    }

    fun mMinus(x: Double) {
        valor -= x
    }

    fun mr(): Double = valor

    fun mClear() {
        valor = 0.0
    }
}

// FUNCIONES DE ENTRADA 
// Estas funciones leen valores desde consola de manera sencilla
fun leerEntero(prompt: String): Int? {
    print(prompt)
    val entrada = readLine()
    return entrada?.trim()?.toIntOrNull()
}

fun leerDouble(prompt: String): Double? {
    print(prompt)
    val entrada = readLine()
    return entrada?.trim()?.replace(",", ".")?.toDoubleOrNull()
}

//  FUNCION PRINCIPAL (MAIN) 
// Menu principal donde el usuario elige las operaciones
fun main() {
    val calc = CalculadoraCientifica()
    val memoria = Memoria()

    while (true) {
        println("\n===== CALCULADORA CIENTIFICA =====")
        println("1. Operaciones basicas (+, -, *, /)")
        println("2. Funciones trigonometricas (sin, cos, tan)")
        println("3. Potencias, raices y logaritmos")
        println("4. Memoria (M+, M-, MR, MC)")
        println("0. Salir")

        val opcion = leerEntero("Opcion: ") ?: break

        when (opcion) {
            1 -> {
                val a = leerDouble("Primer numero: ") ?: 0.0
                val b = leerDouble("Segundo numero: ") ?: 0.0
                println("Suma: ${calc.sumar(a, b)}")
                println("Resta: ${calc.restar(a, b)}")
                println("Multiplicacion: ${calc.multiplicar(a, b)}")
                println("Division: ${calc.dividir(a, b)}")
            }

            2 -> {
                val ang = leerDouble("Angulo en grados: ") ?: 0.0
                println("Seno: ${calc.seno(ang)}")
                println("Coseno: ${calc.coseno(ang)}")
                println("Tangente: ${calc.tangente(ang)}")
            }

            3 -> {
                val base = leerDouble("Numero base: ") ?: 0.0
                val exp = leerDouble("Exponente: ") ?: 0.0
                println("Potencia: ${calc.potencia(base, exp)}")
                println("Raiz cuadrada: ${calc.raiz(base)}")
                println("Log10: ${calc.log10(base)}")
                println("Ln: ${calc.ln(base)}")
                println("Exponencial e^x: ${calc.exp(base)}")
            }

            4 -> {
                println("1) M+  2) M-  3) MR  4) MC")
                val opMem = leerEntero("Elige una opcion: ") ?: 0
                when (opMem) {
                    1 -> {
                        val valor = leerDouble("Valor: ") ?: 0.0
                        memoria.mPlus(valor)
                    }
                    2 -> {
                        val valor = leerDouble("Valor: ") ?: 0.0
                        memoria.mMinus(valor)
                    }
                    3 -> println("Memoria actual: ${memoria.mr()}")
                    4 -> {
                        memoria.mClear()
                        println("Memoria borrada")
                    }
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

