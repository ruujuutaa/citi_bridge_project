import java.util.Comparator;

import com.citibridge.entities.StockWrapper;

public class PEComparator implements Comparator<StockWrapper> {

	@Override
	public int compare(StockWrapper o1, StockWrapper o2) {
		// TODO Auto-generated method stub
		if(o1.getPe().compareTo(o2.getPe())==-1)
		{
			return 1;
		}
		else if(o1.getPe().compareTo(o2.getPe())==1)
			return -1;
		else
			return 0;
	}

}
