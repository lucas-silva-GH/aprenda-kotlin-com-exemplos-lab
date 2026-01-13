// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario (val matricula: Int, val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int, val nivel: Nivel)

data class Formacao(val nome: String, private val conteudos: MutableList<ConteudoEducacional> = mutableListOf(), 
                    val nivel: Nivel) {
	
    private val inscritos = mutableListOf<Usuario>()
    
    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        conteudos.add(conteudo)
    }
    
    fun matricular(usuario: Usuario) {
        if (inscritos.contains(usuario)) {
            println("O usuário ${usuario.nome} já está matriculado na formação '$nome'.")
        } else {
            inscritos.add(usuario)
            println("Usuário ${usuario.nome} matriculado com sucesso na formação '$nome'.")
        }
    }
    
    fun listarInscritos() {
        println("\nAlunos inscritos em '$nome':")
        inscritos.forEachIndexed { i, u ->
            println("${i + 1}. ${u.nome} (${u.matricula})")
        }
    }

    fun listarConteudos() {
        println("\nConteúdos da formação '$nome':")
        conteudos.forEachIndexed { i, c ->
            println("${i + 1}. ${c.nome} - ${c.duracao}min - Nível: ${c.nivel}")
        }
    }
}


fun main() {

    // Criando usuários
    val user1 = Usuario(1512, "Lucas Silva")
    val user2 = Usuario(1513, "João Pereira")
    val user3 = Usuario(1513, "Lucas Silva")
    val user4 = Usuario(1512, "Lucas Silva")

    // Criando formação
    val formacaoKotlin = Formacao(
        nome = "Formação Kotlin Developer",
        nivel = Nivel.INTERMEDIARIO
    )
    
    val formacaoFlutter = Formacao(
        nome = "Formação em Flutter/Dart",
        nivel = Nivel.DIFICIL
    )

    // Adicionando conteúdos
    formacaoKotlin.adicionarConteudo(
        ConteudoEducacional("Introdução ao Kotlin", 50, Nivel.BASICO)
    )
    formacaoKotlin.adicionarConteudo(
        ConteudoEducacional("POO com Kotlin", 80, Nivel.INTERMEDIARIO)
    )
    formacaoKotlin.adicionarConteudo(
        ConteudoEducacional("Kotlin Avançado", 120, Nivel.DIFICIL)
    )

    // Listando conteúdos
    formacaoKotlin.listarConteudos()

    // Matriculando usuários
    formacaoKotlin.matricular(user1)
    formacaoFlutter.matricular(user1)
    formacaoKotlin.matricular(user2)
    formacaoKotlin.matricular(user1) // tentativa duplicada
    formacaoKotlin.matricular(user3)
    formacaoKotlin.matricular(user4)

    // Listando inscritos
    formacaoKotlin.listarInscritos()
    formacaoFlutter.listarInscritos()
}
