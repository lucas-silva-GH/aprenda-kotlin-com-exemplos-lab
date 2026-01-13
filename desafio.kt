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
    TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
}
