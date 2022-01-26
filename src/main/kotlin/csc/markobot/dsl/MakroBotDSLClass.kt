package csc.markobot.dsl

import csc.markobot.api.*

@MakroBotDsl
class MakroBotDSLClass(private val name: String) {
    private val headDSL: HeadDSL = HeadDSL()
    private val bodyDSL: BodyDSL = BodyDSL()
    private val handsDSL: HandsDSL = HandsDSL()
    var chassis: Chassis = Chassis.Legs
    val legs: Chassis.Legs = Chassis.Legs

    object caterpillar

    fun head(function: HeadDSL.() -> Unit) {
        headDSL.function()
    }

    fun body(function: BodyDSL.() -> Unit) {
        bodyDSL.function()
    }

    fun hands(function: HandsDSL.() -> Unit) {
        handsDSL.function()
    }

    fun toMakroBot(): MakroBot =
        MakroBot(name, headDSL.toHead(), bodyDSL.toBody(), handsDSL.toHands(), chassis)

    infix fun caterpillar.withWidthOf(width: Int): Chassis =
        Chassis.Caterpillar(width)

    fun wheels(function: WheelDSL.() -> Unit): Chassis =
        WheelDSL().apply(function).toWheel()
}

fun robot(name: String, operations: MakroBotDSLClass.() -> Unit): MakroBot =
    MakroBotDSLClass(name).apply(operations).toMakroBot()