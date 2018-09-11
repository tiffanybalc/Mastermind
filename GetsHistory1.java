package lab9;

import lab9.providers.ReceivesHistory;

public class GetsHistory1 implements ReceivesHistory {

	@Override
	public void sendHistory(History history) {
		Guess g = history.getHistoryAt(0);
		System.out.println("GetHistory1 remember first move? " + g);
		int size = history.size();
		Guess mostRecent = history.getHistoryAt(size - 1);
		System.out.println(" and your most recent move is " + mostRecent);
	}

}
