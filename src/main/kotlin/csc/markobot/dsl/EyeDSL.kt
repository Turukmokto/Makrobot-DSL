package csc.markobot.dsl

import csc.markobot.api.*

@MakroBotDsl
class EyeDSL {
    private var lampDSL: LampDSL = LampDSL()
    private var ledDSL: DiodsDSL = DiodsDSL()

    fun lamps(function: LampDSL.() -> Unit) {
        lampDSL.function()
    }

    fun diods(function: DiodsDSL.() -> Unit) {
        ledDSL.function()
    }

    fun toEyes(): List<Eye> = lampDSL.toEyes() + ledDSL.toEyes()
}