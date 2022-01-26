package csc.markobot.dsl

import csc.markobot.api.*

@MakroBotDsl
class WheelDSL {
    var count: Int = 0
    var diameter: Int = 0

    fun toWheel(): Chassis.Wheel = Chassis.Wheel(count, diameter)
}