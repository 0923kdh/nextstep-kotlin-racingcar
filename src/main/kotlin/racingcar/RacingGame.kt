package racingcar

import racingcar.io.OutputView

object RacingGame {
    fun play(numberOfCars: Int, numberOfAttempts: Int, moveType: MoveType) {
        val participatingCars = loadCar(numberOfCars)
        start(participatingCars, numberOfAttempts, moveType)
    }

    private fun loadCar(numberOfCars: Int): List<Car> = List(numberOfCars) { Car(it) }

    private fun start(cars: List<Car>, numberOfAttempts: Int, moveType: MoveType) {
        repeat(numberOfAttempts) {
            cars.forEach {
                it.move(moveType)
                OutputView.showCarMoveResult(it.currentPosition)
            }
            OutputView.nextTurn()
        }
    }
}
