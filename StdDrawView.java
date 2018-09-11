package lab9;

import java.awt.Color;

import lab9.implementations.HonestFeedback;
import lab9.providers.ProvidesColor;
import lab9.providers.ProvidesFeedback;
import lab9.providers.ProvidesGuess;
import lab9.providers.ReceivesHistory;
import sedgewick.StdDraw;

/**
 * 
 * @author tiffanybalcarcel
 *
 */
public class StdDrawView implements ReceivesHistory {

	GameProperties gameProperties;
	ProvidesGuess codeMaker3;
	ProvidesColor pc;
	double i;

	/**
	 * 
	 * @param gameProperties
	 * @param codeMaker3
	 * @param pc
	 * return colors input as first four circles from the left and up to 4 more additional circles
	 * return red circle if there is a perfect match and yellow circle if there is a correct color that is not a perfect match
	 * when you win the game, 4 red circles will be present
	 */
	public StdDrawView(GameProperties gameProperties, ProvidesGuess codeMaker3, ProvidesColor pc) {
		this.gameProperties = gameProperties;
		this.codeMaker3=codeMaker3;
		this.pc=pc;
		this.i=0;
	}
	
	public void sendHistory(History history) {
		System.out.println(history.getHistoryAt(history.size() - 1));
	
		Guess myguess = history.getHistoryAt(history.size()-1);

			StdDraw.setPenColor(pc.getColorForPeg(myguess.getChoice(0)));
			StdDraw.filledCircle(0, (double)11/12 -(double)(i/12.0), (double)1/30);
			StdDraw.setPenColor(pc.getColorForPeg(myguess.getChoice(1)));
			StdDraw.filledCircle((double)1/8, (double)11/12 -(double)(i/12.0), (double)1/30);
			StdDraw.setPenColor(pc.getColorForPeg(myguess.getChoice(2)));
			StdDraw.filledCircle((double)1/4, (double)11/12 -(double)(i/12.0), (double)1/30);
			StdDraw.setPenColor(pc.getColorForPeg(myguess.getChoice(3)));
			StdDraw.filledCircle((double)3/8, (double)11/12 -(double)(i/12.0), (double)1/30);

			Guess code = codeMaker3.getGuess();
			ProvidesFeedback pf1 = new HonestFeedback(code);
			int numints = pf1.numIntersection(history.getHistoryAt(history.size()-1));
			int numsame = pf1.numSamePosition(history.getHistoryAt(history.size()-1));
			
			for (int j=0; j<numsame; j++) {
				StdDraw.setPenColor(Color.RED);
				StdDraw.filledCircle((double)1/2 + (double)(j/8.0), (double)11/12 -(double)(i/12.0), (double)1/30);
			}
			for (int j=numsame; j<numints; j++) {
				StdDraw.setPenColor(Color.YELLOW);
				StdDraw.filledCircle((double)1/2 + (double)(j/8.0), (double)11/12 -(double)(i/12.0), (double)1/30);
			}
			i++;
			StdDraw.show(100);
	}

}
