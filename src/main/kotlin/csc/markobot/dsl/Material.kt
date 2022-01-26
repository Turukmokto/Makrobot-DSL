package csc.markobot.dsl

import csc.markobot.api.Material
import csc.markobot.api.Metal
import csc.markobot.api.Plastic

sealed class MaterialObjects
object plastic : MaterialObjects()
object metal : MaterialObjects()

infix fun MaterialObjects.mapToMaterial(thickness: Int): Material = when (this) {
    plastic -> Plastic(thickness)
    metal -> Metal(thickness)
}