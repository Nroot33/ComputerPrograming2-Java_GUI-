import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Lotto {
	private LinkedList<Integer> lottoBalls;
	private ArrayList<Integer> prizeNumber;
	
	public Lotto() {
		lottoBalls = new LinkedList<>();
		prizeNumber = new ArrayList<>(6);
		for(int i = 1; i<=45; i++)
			lottoBalls.add(i);
		Collections.shuffle(lottoBalls);
		for(int j = 0; j<6; j++)
			prizeNumber.add(lottoBalls.get(j));
	}
	
	public ArrayList<Integer> getPrize(){
		Collections.sort(this.prizeNumber);
		return this.prizeNumber;
	}
}
