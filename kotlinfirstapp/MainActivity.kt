package com.example.kotlinfirstapp

fun helloWorld(){
    println("Hello, world!")
}

fun variables(){
    // mutable var
    var user: String? = "user"
    user = "Alterado"
    println(user)

    val imutableVar: String = "user"
    println(imutableVar)

    val numDouble: Double = 3.3
    println(numDouble)

    val numFloat: Float = 3.4f
    println(numFloat)

    val numLong: Long = 333L
    println(numLong)

    val numInteger: Int = 3
    println(numInteger)

    val valBool: Boolean = true
    println(valBool)

    // string interpol
    println("Hello, $numFloat")

    var a = 3
    if (a.equals(numInteger)){
        println("OK")
    }

    print("Info: ")
    var info: String? = readLine()
    println("Info: $info")

}

fun sumValues(a: Int, b: Int): Int{
    return a.plus(b)
}

fun subValues(a: Int, b: Int) = (a.minus(b))

fun defaultValue(a: Boolean = true, b: Boolean): Boolean{
    return a.equals(b)
}

fun various(vararg many: Int){
    for(i in many){
        print("$i ")
    }
}

fun <T> mediaGeneric(vararg n: T){
    for(i in n){
        print(i)
    }
}

// lambda function by param
fun lambda(lamb: (integer: Int) -> Unit, int: Int){
    lamb(int)
}

fun condition(){
    var x = if(3 > 4){
        3 - 4
    }else{
        4 - 3
    }
    println(x)

    if(1 in (1  .. 3)){
        println("OK")
    }

    //switch
    val y = when(1){
        0 -> 100
        1, 10, 2 -> 4
        in (2..9) -> -2
        else -> -4
    }
    println(y)

}

fun checkCPF(num: String){
    if(num.length < 11 || !num.matches(Regex("\\d{9}-\\d{2}"))){
        println("Invalido")
    }
    val parts = num.split("-")
    val partOne = parts[0]
    val partTwo = parts[1]
    var sum = 0
    var index = 10
    for(digit in partOne){
        sum += digit.digitToInt() * index
        index = index.minus(1)
    }
    var firstDigit = when(sum % 11){
        in (0..1) -> 0
        else -> 11 - (sum % 11)
    }
    index = 11
    sum = 0
    for(digit in partOne.plus(partTwo[0])){
        sum += digit.digitToInt() * index
        index = index.minus(1)
    }
    var secondDigit = when(sum % 11){
        in (0..1) -> 0
        else -> 11 - (sum % 11)
    }
    println("First digit ${firstDigit} ${partTwo[0]::class.simpleName}")
    println("Second digit $secondDigit type ${secondDigit.toChar()::class.simpleName}")
    if(firstDigit == partTwo[0].digitToInt() && secondDigit == partTwo[1].digitToInt()){
        println("Valid")
    }
}

fun main(){
    helloWorld()
    variables()
    println("The sum inner 4 and 5 is ${sumValues(4, 5)}")
    println("The sub inner 4 and 5 is ${subValues(4, 5)}")
    println("There is default value? ${defaultValue(b=true)}")
    various(2, 2, 3, 4, 5)
    mediaGeneric(1, 2.3, 4, true)
    println()
    val x = {a: Int -> print(a * a)} //lambda function
    lambda(x, 4)
    println()
    condition()
    checkCPF("445632830-45")
}
