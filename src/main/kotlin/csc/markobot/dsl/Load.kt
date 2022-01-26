package csc.markobot.dsl

import csc.markobot.api.LoadClass

sealed class LoadObjects
object veryLight : LoadObjects()
object light : LoadObjects()
object medium : LoadObjects()
object heavy : LoadObjects()
object veryHeavy : LoadObjects()
object enormous : LoadObjects()

fun mapToLoadClass(maxLoadArg: LoadObjects): LoadClass = when (maxLoadArg) {
    veryLight -> LoadClass.VeryLight
    light -> LoadClass.Light
    medium -> LoadClass.Medium
    heavy -> LoadClass.Heavy
    veryHeavy -> LoadClass.VeryHeavy
    enormous -> LoadClass.Enormous
}