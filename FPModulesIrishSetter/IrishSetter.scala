import java.awt.Color

trait Animal

abstract class AnimalWithTail(tailColor: Color)
    extends Animal

trait DogTailServices {
    this: AnimalWithTail =>
        def wagTail = println("wagging tail")
        def lowerTail = println("lowering tail")
        def raiseTail = println("raising tail")
}

trait DogMouthServices {
    this: AnimalWithTail =>
        def bark = println("bark!")
        def lick = println("licking")
}

object IrishSetter
    extends AnimalWithTail(Color.red)
        with DogTailServices
        with DogMouthServices






