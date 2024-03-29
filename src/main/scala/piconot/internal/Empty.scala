package piconot.internal

// A Picobot program that can fill an empty room
object EmptyBot extends Picobor("resources/empty.txt") {

  // States 0 and 1: move to the top left

  // State 0: move left
  (0 `**x*`) → W(0) // go all the way to the left
  (0 `**W*`) → X(1) // can't go left anymore, so try to go up

  // State 1: move up
  (1 `x***`) → N(1) // go all the way to the top
  (1 `N**x`) → S(2) // can't go up any more, so try to go down

  // States 2 and 3: fill from top to bottom, left to right

  // State 2: fill this column to the bottom
  (2 `***x`) → S(2) // go all the way to the bottom
  (2 `*x*S`) → E(3) // can't go down anymore, so try to go right

  // State 3: fill this column to the top
  (3 `x***`) → N(3) // go all the way to the top
  (3 `Nx**`) → E(2) // can't go up anymore, so try to go right

  run
}
