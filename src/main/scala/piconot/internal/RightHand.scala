package piconot.internal

import scala.language.postfixOps

object RightHand extends Picobor("resources/maze.txt") {

  // A picobot program that can solve a maze, using the right-hand rule

  // State 0: moving north
  (0 `*x**`) → E(1) // we can go right (to the east)
  (0 `xE**`) → N(0) // we can't go right, try going forward (north)
  (0 `NE**`) → X(3) // we can't go right or forward, try south

  // State 1: moving east
  (1 `***x`) → S(3) // we can go right (to the south)
  (1 `*x*S`) → E(1) // we can't go right, try going forward (east)
  (1 `*E*S`) → X(2) // we can't go right or forward, try west

  // State 2: moving west
  (2 `x***`) → N(0) // we can go right (to the north)
  (2 `N*x*`) → W(2) // we can't go right, try going forward (west)
  (2 `N*W*`) → X(1) // we can't go right or forward, try east

  // State 3: moving south
  (3 `**x*`) → W(2) // we can go right (to the west)
  (3 `**Wx`) → S(3) // we can't go right, try going forward (south)
  (3 `**WS`) → X(0) // we can't go right or forward, try north

  run
}
