@file:JvmName("MeupetKt")

class Bixin(val nome: String) {
     var indiceFome = 50
     var nivelFelicidade = 50
     var indiceCansado = 0
     var idade = 0
     var nivelBixin = 0
     var irBanheiro = 0
     var sujeira = 0

    fun alimentar() {
        indiceFome += 10
        irBanheiro += 5
        print("\n---$nome foi alimentado. O nível de fome diminuiu.---\n\n")
    }

    fun brincar() {
        nivelFelicidade += 20
        indiceCansado += 5
        indiceFome -= 2
        sujeira += 4
        print("\n---$nome está brincando e se sentindo mais feliz.---\n\n")

    }

    fun verificarStatus() {
        print("\n--Status atual de $nome--\n")
        print("Nível de fome: $indiceFome\n")
        print("Nível de felicidade: $nivelFelicidade\n")
        print("Idade de $nome é: $idade\n")
        print("Nivel de $nome é: $nivelBixin\n")
        print("Nivel de sujeira é: $sujeira\n")
        print("Vontade de cagar: $irBanheiro\n")
        print("Nível de cansaço: $indiceCansado\n\n")
    }

    fun passarTempo() {
        nivelBixin += 1
        nivelFelicidade -= 15
        indiceFome -= 3
        indiceCansado += 5
        idade += 10

            if (indiceFome < 0 || indiceCansado == 100 || sujeira > 100 || irBanheiro > 100 || nivelFelicidade < 0) {
                println("--O pet $nome morreu, você perdeu!!!!--\n")
                main()
            }
                else if(nivelFelicidade < 10){
                    print("Seu bixinho está ficando depressivo! Brinque com ele(a)\n\n")
            }
                else if(idade == 50){
                    print("\nParabéns você chegou ao fim do jogo, seu bixin completou $idade anos!\n")
                    main()
                }
                    else if(sujeira == 50){
                        print("\nO bixin $nome está ficando sujo, limpe-o!\n")
                    }
                       else if(irBanheiro == 50){
                            print("\nO bixin $nome precisa ir ao banheiro!\n")
                        }

    }

    fun descancar(){
        indiceCansado -= 10
        val horasSono = indiceCansado/indiceCansado
        print("\n---$nome está descansando, o seu bixinho precisa descansar $horasSono vezes para estar 100% disposto.---\n\n")

    }

    fun banheiro(){
        irBanheiro -= 10
        print("\n---$nome está usando o banheiro.---\n\n")
    }

    fun chuveiro(){
        sujeira -= 5
        print("\n---$nome está se limpando.---\n\n")
    }
}

fun main() {
    print("Bem-vindo ao Simulador de Animal de Estimação Virtual!\n")
    println("Digite o nome do seu animal de estimação:")
    val nomePet = readln()
    val pet = Bixin(nomePet)

    while (true) {
        println("1. Alimentar $nomePet")
        println("2. Brincar com $nomePet")
        println("3. Descansar $nomePet")
        println("4. Verificar o status de $nomePet" +
                "\n5. Banheiro" +
                "\n6. Chuveiro")
        print("7. Sair" +
                "\nEscolha uma ação acima: ")

        val escolha = readln().toIntOrNull()?: continue

        when (escolha) {
            1 -> pet.alimentar()
            2 -> pet.brincar()
            3 -> pet.descancar()
            4 -> pet.verificarStatus()
            5 -> pet.banheiro()
            6 -> pet.chuveiro()
            7 -> {
            println("Saindo do Simulador de Animal de Estimação Virtual. Adeus!\n")
            return
        }
            else -> println("Escolha inválida. Tente novamente.\n")
        }

        pet.passarTempo() // Simula o tempo que passa após cada ação
    }
}
