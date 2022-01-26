package csc.markobot.dsl

import csc.markobot.api.*

@MakroBotDsl
class HandsDSL {
    private var material: Material = Metal(thickness = 0)
    private var minLoad: LoadClass = LoadClass.VeryLight
    private var maxLoad: LoadClass = LoadClass.VeryLight
    var load: Any = minLoad to maxLoad

    infix fun MaterialObjects.withThicknessOf(thickness: Int) {
        material = this mapToMaterial thickness
    }

    operator fun LoadObjects.minus(maxLoadArg: LoadObjects) {
        minLoad = mapToLoadClass(this)
        maxLoad = mapToLoadClass(maxLoadArg)
    }

    fun toHands(): Hands = Hands(material, minLoad, maxLoad)
}
