import java.util.*;

public class Golfer{
	String name; 
	TreeMap scores = new TreeMap(); 
	double handicap;


	public double computeHandicap()
	{
		ArrayList<Double> testList = new ArrayList();
		Iterator i;
		int j; 
		double sum; 
		double avg;
		sum = 0;
		NavigableMap descending = scores.descendingMap();
		Collection values; 
		values = descending.values(); 
		i = values.iterator(); 
		j = 0;
		while(i.hasNext() && j<20)
		{
			avg = (Double) i.next();
			testList.add(avg); 
			j++; 
		}
		j = 0;
		Collections.sort(testList); 
		for(double tmp : testList)
		{
			if(j < 10)
			{
				sum += tmp; 
			}
			j++;
		}
		avg = sum / 10;
		handicap = .96 * avg; 
		return 0;		
	}

    static class HandicapComparator implements Comparator <Golfer> 
	{
		public int compare(Golfer g1, Golfer g2)
		{
			if(g1.handicap == g2.handicap)
				return 0;
			else if(g1.handicap > g2.handicap)
				return 1;
			else
				return -1;

		}
	}
}
