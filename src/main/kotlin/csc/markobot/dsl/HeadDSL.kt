package csc.markobot.dsl

import csc.markobot.api.*

@MakroBotDsl
class HeadDSL {
    private var material: Material = Metal(0)
    private val eyeDSL: EyeDSL = EyeDSL()
    private val mouthDSL: MouthDSL = MouthDSL()

    fun eyes(function: EyeDSL.() -> Unit) {
        eyeDSL.function()
    }

    fun mouth(function: MouthDSL.() -> Unit) {
        mouthDSL.function()
    }

    infix fun MaterialObjects.withThicknessOf(thickness: Int) {
        material = this mapToMaterial thickness
    }

    fun toHead(): Head = Head(material, eyeDSL.toEyes(), mouthDSL.toMouth())
}