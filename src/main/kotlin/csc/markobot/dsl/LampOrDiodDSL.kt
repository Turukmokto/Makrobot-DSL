package csc.markobot.dsl

import csc.markobot.api.Eye
import csc.markobot.api.LampEye
import csc.markobot.api.LedEye

@MakroBotDsl
sealed class LampOrDiodDSL {
    var count: Int = 0
    var brightness: Int = 0

    fun toEyes(): List<Eye> = List(count) { makeEye() }

    protected abstract fun makeEye(): Eye
}

class LampDSL : LampOrDiodDSL() {
    override fun makeEye(): Eye = LampEye(brightness)
}

class DiodsDSL : LampOrDiodDSL() {
    override fun makeEye(): Eye = LedEye(brightness)
}