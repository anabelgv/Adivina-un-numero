//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val intentosmax = 8
    val numeroSecreto = generateNumeroSecreto()
    val intentos = mutableListOf<List<String>>()
    val contadorintentos = 0
    var finjuego = false


    while (!finjuego && contadorintentos < intentosmax) {
        println("1.Jugar")
        println("2.Ver traza de último intento")
        println("3.Salir")
        print("opción: ")
        val option = readln()

        when (option) {
            "1" -> {
                contadorintentos++
                println("Teclea un numero de 3 cifras usando solo numero del 1 al 6 sin ser repetidos.")
                val adivina = readln()

                if(adivina!= null && numerovalido(adivina)){
                    val(acierto,error) = validacion(adivina,numeroSecreto)
                    intentos.add(listOf(adivina,acierto.toString(),error.toString()))
                    if (acierto == 3){
                        println("Felicidades, adivinaste el numero secreto $numeroSecreto en $contadorintentos  intento/s!")

                        finjuego = true
                    }else{
                        println("Numero no válido.")
                    }
                    if (contadorintentos >= intentosmax && !finjuego){
                        println("No adivinaste el numero $numeroSecreto en $intentosmax intentos.")
                        finjuego=true
                    }
                }
            }
            "2"->{ //ARREGLAR
                if (intentos.isNotEmpty()){
                    println("Numero secreto:$numeroSecreto")
                    for ((index,intentos) in intentos.withIndex()){}
                }
            }
            "3" ->{
                println("Gracias por jugar")
                finjuego=true
            }else-> println("Opcion no valida.Vuelve a intentarlo")
        }
    }


}
//Arreglar

fun generateNumeroSecreto(): String {
    val digits = listOf(1, 2, 3, 4, 5, 6).shuffled().take(3)  // Obtiene 3 dígitos únicos entre 1 y 6
    return digits.joinToString("")


}

