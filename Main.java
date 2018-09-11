package lab9;

import cse131.ArgsProcessor;
import lab9.implementations.RandomColorProvider;
import lab9.implementations.RandomGuessProvider;
import lab9.implementations.StaticGuessProvider;
import lab9.providers.ProvidesColor;
import lab9.providers.ProvidesGuess;
import lab9.viz.ColorChooser;

public class Main {

	public static void main(String[] args) {
		
		ArgsProcessor ap = new ArgsProcessor(args);
		
		//
		// Random guessing version, likely not to win
		//
//		GameProperties randomGame = new GameProperties("Random guesser");
//		ProvidesGuess codeMaker2 = new StaticGuessProvider(randomGame);
//		ProvidesGuess randCodeBreaker = new RandomGuessProvider(randomGame);
//		Controller rcontroller = new Controller(randomGame, codeMaker2, randCodeBreaker);
//		rcontroller.getHistory().addObserver(gh1);
//		rcontroller.getHistory().addObserver(new GetsHistory2());
//		rcontroller.run();
//		ap.nextString("Press enter to continue");
				
		
		//
		// Interactive version
		//
		
		GameProperties interactive = new GameProperties("Interactive");
		ProvidesGuess codeMaker3 = new StaticGuessProvider(interactive);
		//
		// interactive breaker needs color provider
		//
		ProvidesColor pc = new RandomColorProvider(interactive);
		ProvidesGuess interactiveBreaker = ColorChooser.launchChooser(interactive, pc);
		Controller c = new Controller(interactive, codeMaker3, interactiveBreaker);

		StdDrawView sdv = new StdDrawView(c.getGameProperties(), codeMaker3, pc);
		c.getHistory().addObserver(sdv);
		c.run();
		ap.nextString("Press enter to continue");
	}

}
