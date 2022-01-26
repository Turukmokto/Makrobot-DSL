package csc.markobot.dsl

import csc.markobot.api.*

@MakroBotDsl
class BodyDSL {
    private var material: Material = Metal(thickness = 0)
    private val inscriptionDSL: InscriptionDSL = InscriptionDSL()

    fun inscription(function: InscriptionDSL.() -> Unit) {
        inscriptionDSL.function()
    }

    infix fun MaterialObjects.withThicknessOf(thickness: Int) {
        material = this mapToMaterial thickness
    }

    fun toBody(): Body = Body(material, inscriptionDSL.strings)
}