package lab9;

import lab9.providers.ReceivesHistory;

public class GetsHistory3 implements ReceivesHistory {

	@Override
	public void sendHistory(History history) {
		Guess g1 = history.getHistoryAt(0);
		System.out.println("GetHistory3 first move: " + g1);
		int size = history.size();
		Guess mostRecent = history.getHistoryAt(size - 1);
		System.out.println(" and your most recent move is " + mostRecent);
	}

}
