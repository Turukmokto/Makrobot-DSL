package csc.markobot.dsl

@MakroBotDsl
class InscriptionDSL {
    val strings: MutableList<String> = mutableListOf()

    operator fun String.unaryPlus() {
        strings.add(this)
    }
}
