package csc.makrobot.dsl

import csc.markobot.api.*
import csc.markobot.dsl.*
import csc.markobot.dsl.MakroBotDSLClass.caterpillar
import org.junit.jupiter.api.Assertions

import org.junit.jupiter.api.Test

class TestsPositive {

    @Test
    fun testNonDSL() {
        val robot = MakroBot(
            "Wall-E",
            Head(Plastic(2), listOf(LampEye(10), LampEye(10), LedEye(3)), Mouth(Speaker(3))),
            Body(Metal(1), listOf("I don't want to survive.", "I want live.")),
            Hands(Plastic(3), LoadClass.Light, LoadClass.Medium),
            Chassis.Caterpillar(10)
        )
        verify(robot)
    }

    @Test
    fun testDSL() {
        val robot: MakroBot = robot("Wall-E") {
            head {
                plastic withThicknessOf 2

                eyes {
                    lamps {
                        count = 2
                        brightness = 10
                    }
                    diods {
                        count = 1
                        brightness = 3
                    }
                }

                mouth {
                    speaker {
                        power = 3
                    }
                }
            }

            body {
                metal withThicknessOf 1

                inscription {
                    +"I don't want to survive."
                    +"I want live."
                }
            }

            hands {
                plastic withThicknessOf 3
                load = light - medium
            }

            chassis = caterpillar withWidthOf 10
        }

        verify(robot)
    }

    @Test
    fun testDSLOtherChassis() {
        val robotOnWheels = robot("Wall-E") {
            head {
                plastic withThicknessOf 2

                eyes {
                    lamps {
                        count = 2
                        brightness = 10
                    }
                }

                mouth {
                    speaker {
                        power = 3
                    }
                }
            }

            body {
                metal withThicknessOf 1
            }

            hands {
                plastic withThicknessOf 3
                load = light - medium
            }
            chassis = wheels {
                diameter = 4
                count = 2
            }
        }

        Assertions.assertEquals(Chassis.Wheel(2, 4), robotOnWheels.chassis)

        val robotWithLegs = robot("Wall-E") {
            head {
                plastic withThicknessOf 2

                eyes {
                    lamps {
                        count = 2
                        brightness = 10
                    }
                }

                mouth {
                    speaker {
                        power = 3
                    }
                }
            }

            body {
                metal withThicknessOf 1
            }

            hands {
                plastic withThicknessOf 3
                load = light - medium
            }
            chassis = legs
        }

        Assertions.assertEquals(Chassis.Legs, robotWithLegs.chassis)
    }

    private fun verify(robot: MakroBot) {
        Assertions.assertEquals("Wall-E", robot.name)
        Assertions.assertEquals(Plastic(2), robot.head.material)
        Assertions.assertArrayEquals(arrayOf(LampEye(10), LampEye(10), LedEye(3)), robot.head.eyes.toTypedArray())
        Assertions.assertEquals(Mouth(Speaker(3)), robot.head.mouth)

        Assertions.assertEquals(Metal(1), robot.body.material)
        Assertions.assertArrayEquals(
            arrayOf("I don't want to survive.", "I want live."),
            robot.body.strings.toTypedArray()
        )

        Assertions.assertEquals(Plastic(3), robot.hands.material)
        Assertions.assertEquals(LoadClass.Light, robot.hands.minLoad)
        Assertions.assertEquals(LoadClass.Medium, robot.hands.maxLoad)

        Assertions.assertEquals(Chassis.Caterpillar(10), robot.chassis)
    }
}