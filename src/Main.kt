fun main() {

    val set = setOf(1,2,3,4,5,6,7,8,9,10)
    println(set)
    println(splitSetIntoTwoCollectionsSoThatOneContainsEvenElementsAndOtherContainsOddElements(set))
    println()

    println(set)
    println(onlyElementsThatAreMultiplesOfFiveAfterMultiplicationAreIncludedInSet(set))
    println()

    val arrayOne = listOf(0, 6, 0, 0, 2, 0, 0, 0, 1, 0, 5, 0)
    println(arrayOne)
    println(removeDuplicates(arrayOne))
    val arrayTwo = setOf(0, 6, 0, 0, 2, 0, 0, 0, 1, 0, 5, 0)
    println(arrayTwo)
    println(removeDuplicates(arrayTwo))
    val arrayThree = mapOf("0" to 0, "1" to 6, "2" to 0, "3" to 0, "4" to 2, "5" to 0, "6" to 0,
        "7" to 0, "8" to 1, "9" to 0, "10" to 5, "11" to 0)
    println(arrayThree)
    println(removeDuplicates(arrayThree))
    println()

    val array = arrayOf(0, 6, 0, 0, 2, 0, 0, 0, 1, 0, 5, 0)
    println(array.contentDeepToString())
    println(moveAllZerosToEndOfArray(array).contentDeepToString())
}

/*
Разбить созданный набор на две коллекции, чтобы в одной содержались четные элементы, в другой – нечетные.
*/
data class Result(val evenSet: Set<Int>, val oddSet: Set<Int>)

fun splitSetIntoTwoCollectionsSoThatOneContainsEvenElementsAndOtherContainsOddElements(set: Set<Int>): Result {
    return Result(set.filter { it % 2 == 0 }.toSet(), set.filter { it % 2 != 0 }.toSet())
}

/*
Дан набор целых чисел.
Необходимо создать новое множество в который будут помещены элементы прежнего умноженные на два,
но с условием, что попадают в набор только элемент кратные пяти после умножения.
*/
fun onlyElementsThatAreMultiplesOfFiveAfterMultiplicationAreIncludedInSet(set: Set<Int>): Set<Int> {
    val result = mutableSetOf<Int>()
    set.forEach { a ->
        val b = a * 2
        if (b % 5 == 0) result.add(b)
    }
    return result
}

/*
Создать функцию removeDuplicates (collection: Collection<T>?), которая будет возвращать набор неповторяющихся элементов.
Обратите внимание, что в параметры функции передан элемент Collection параметризованного типа.
*/
fun <T> removeDuplicates (collection: Collection<T>?): List<T>? {
    return collection?.distinct()
}

fun <T, V> removeDuplicates (collection: Map<T, V>?): Map<T, V> {
    val temp = mutableSetOf<V>()
    val result = mutableMapOf<T, V>()
    collection?.keys!!.forEach { a ->
        if (!temp.contains(collection.getValue(a))) result.put(a, collection.getValue(a))
        temp.add(collection.getValue(a))
    }
    return result
}

/*
Дан массив целых чисел.
Нужно переместить все нули в конец массива, сохранив порядок остальных элементов.
Т.е. исходный массив 0, 6, 0, 0, 2, 0, 0, 0, 1, 0, 5, 0 Результат: 6, 2, 1, 5, 0, 0, 0, 0, 0, 0, 0, 0
*/
fun moveAllZerosToEndOfArray(array: Array<Int>): Array<Int> {
    return array.filter { it != 0 }
        .toTypedArray()
        .plus(array.filter { it == 0 })
}