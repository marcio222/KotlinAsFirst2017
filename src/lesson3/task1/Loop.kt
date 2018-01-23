@file:Suppress("UNUSED_PARAMETER")
package lesson3.task1

import lesson1.task1.sqr
import java.lang.Math.*

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    for (m in 2..Math.sqrt(n.toDouble()).toInt()) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n/2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
        when {
            n == m -> 1
            n < 10 -> 0
            else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
        }

/**
 * Тривиальная
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 */
fun digitNumber(n: Int): Int {
    var count = 0
    var number = n
    while (number > 0) {
        if (n == number % 10) {
            count++

        }
        number / 10

    }
    return count
}




/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    var fib1 = 1
    var fib2 = 1
    if (n == 1) return 1
    if (n == 2) return 1
    for (i in 3..n) {
        var fib3 = fib1 + fib2
        fib1 = fib2
        fib2 = fib3
    }
    return fib2
}

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun gcd(m: Int, n: Int): Int {
    var max = maxOf(m, n)
    var min = minOf(m, n)
    while (max % min != 0) {
        val mn = min
        min = max % min
        max = mn
    }
    return min
}

fun lcm(m: Int, n: Int): Int = m / gcd(m, n) * n

/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    var result = 1
    for (i in 2..n) {
        if (n % i == 0) {
            result = i
            break

        }
    }
    return result
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    var result = 1
    for (i in n / 2 downTo 2) {
        if (n % i == 0) {
            if (n % i == 0) {
                result = i
                break
            }

        }
    }
    return result
}

/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean = gcd(m, n) == 1

/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    var result = true
    var k: Double
    val m1 = Math.sqrt(max(m, n).toDouble()).toInt()
    val n1 = sqrt(min(m, n).toDouble()).toInt()
    for (i in n1..m1) {
        k = i.toDouble()
        result = ((sqr(k) >= min(m, n)) && (sqr(k) <= max(m, n)))
    }
    return result
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun sin(x: Double, eps: Double): Double {
    val num = x % (2 * Math.PI)
    var result = num
    var count = 3
    var member = 0.0
    while (Math.abs(member) > eps) {
        member = Math.pow(num, count.toDouble()) / factorial(count)
        if ((count - 1) % 4 == 0) {
            result += member
        } else {
            result -= member
        }
        count += 2
    }
    return result
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun cos(x: Double, eps: Double): Double {
    val num = x % (2 * Math.PI)
    var result = 1.0
    var member = 1.0
    var count = 2
    while (Math.abs(member) > eps) {
        member = Math.pow(num, count.toDouble()) / factorial(count)
        if (count % 4 == 0) {
            result += member
        } else {
            result -= member
        }
        count += 2
    }
    return result
}

/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 * Не использовать строки при решении задачи.
 */
fun revert(n: Int): Int {
    var a = 0
    var b: Int
    var m = n
    while (m > 0) {
        b = m % 10
        a = 10 * a + b + b
        m /= 10
    }
    return a
}




/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 */
fun isPalindrome(n: Int): Boolean {
    if (n.toString() == n.toString().reversed()) return true
    return false
}

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 */
fun hasDifferentDigits(n: Int): Boolean {
    val d = n % 10
    var m = n / 10
    while (m > 0) {
        if (m % 10 != d) return true
    }
    return false
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 */
fun squareSequenceDigit(n: Int): Int {
    var num = n
    var count = 0
    while (num > 0) {
        count++
        num -= digitNumber(count * count)
    }
    num = Math.abs(num)
    return count * count / Math.pow(10.0, num.toDouble()).toInt() % 10
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см.ф ункцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 */
fun fibSequenceDigit(n: Int): Int {
    var result = 1.0
    var x = 1
    var number = n.toDouble()
    while (number > 0) {
        var m = Math.pow(10.0, digitNumber(f) - number)
        if ((number - digitNumber(f)) <= 0)
            result = (f % (m * 10)) / m
        number -= digitNumber(f)
        x++
        f = fib(x)

    }
    return result.toInt()
}
