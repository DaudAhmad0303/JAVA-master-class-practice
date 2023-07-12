package dev.lpa;

import dev.lpa.game.GameConsole;
import dev.lpa.pirate.PirateGame;

//class SpecialGameConsole<T extends Game<? extends Player>>
//        extends GameConsole<Game<? extends Player>> {
//
//    public SpecialGameConsole(Game<? extends Player> game) {
//        super(game);
//    }
//}

// We cannot extend records or enum.
// If we do not want our class to be modified, we can make them final as for methods and variables.
// And making the constructor private. The class would behave like abstract.

// Making a parent class sealed means that each subclass extending it should have to be written in
// permit clause against parent.
// It means the parent is acknowledged of all the subclasses that are extending it through permit clause.
// For subclass to extend it by other subclasses, it should be listed by subclass in permit clause or make
// it final, if we do not want to extend it.
// A sealed class must have knowledge of its subclasses.

public class MainFinal {

    public static void main(String[] args) {

        GameConsole<PirateGame> game =
                new GameConsole<>(new PirateGame("Pirate Game"));

    }
}
