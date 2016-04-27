=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=
CIS 120 Game Project README
PennKey: aff
=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:=

===================
=: Core Concepts :=
===================

# List the four core concepts, the features they implement, and why each feature
  is an appropriate use of the concept. You may copy and paste from your
  proposal document if you did not change the features you are implementing.

  1. 2D Array
     Multiple 2D arrays are used to hold data. A 2D char array is our map, our
     floor layout is a 2D array of FloorTile objects. 

  2. Inherance & Subtyping
     The PlayerCharacter and EnemyCharacter classes extend the Character class,
     and the different floor tiles have a parent class.

  3. Novel Recursive Data Structure
     This was changed. While originally I hoped to implement a map making 
     algorithm, that proved to be extremely challenging. I used a implementation
     I found on github of a recursive map maker. Instead of a map maker, I 
     created a recursive map solver I incorporated into my JUnit tests. The 
     code is based off an algorithm outline I found online.

  4. Testable Components
     JUnit tests were implemented for the map, as it is a very 


=========================
=: Your Implementation :=
=========================

# Provide an overview of each of the classes in your code, and what their
  function is in the overall game.
  Character.java - Main generic class for character
    PlayerCharacter.java - the controllable character
    EnemyCharacter.java - A generic enemy character
  FloorTile.java - a Generic Floor tile
    LavaTile.java a type of tile that hurts the player.
    DirtTile.java - a walkable safe tile
    StairTile.java - A tile marking the beginning and end of a level.
  MapGenerator.java - A maze genorating algorithm wrapped into a map generator
  FloorGrid.java - Takes the data from the map genration and places floor tiles accordingly
  MapTests.java - Tests for the map 
  MazeSolver.java - Recursive maze solving algorithm to test the map for solvability.


# Revisit your proposal document. What components of your plan did you end up
  keeping? What did you have to change? Why?
  Most parts of the plan were kept. I had to change my unique recursive algoritm
  from the generator to the solver, as I had too much trouble figuring it out.
  Other than that, some things were scaled back, but the document was fairly
  exhaustive.


# Were there any significant stumbling blocks while you were implementing your
  game (related to your design, or otherwise)?
- The recursive maze solving algorithm was really tough to implement, and took
  quite a bit of tinkering. Other than that, there was a lot of fiddling to get
  the 2D array to translate well onto an isometric grid.

- Evaluate your design. Is there a good separation of functionality? How well is
  private state encapsulated? What would you refactor, if given the chance?
  I think my implementation is okay, but a little messy. There is some spagetti
  code that could definitely be cleaned up. I think the implementation of the 
  map generation is also fairly messy - the floor grid and map generator could
  probably be wrapped into one.
  Finally, the isometric grid implementation is a little awkward, and could use
  some cleaning up.



========================
=: External Resources :=
========================

# Cite any external resources (libraries, images, tutorials, etc.) that you may
  have used while implementing your game.
- Level generation using recursive back-tracing:
  http://weblog.jamisbuck.org/2010/12/27/maze-generation-recursive-backtracking
- Game textures for floor tiles: https://sftextures.com/
- Help for maze solver: https://www.cs.bu.edu/teaching/alg/maze/
