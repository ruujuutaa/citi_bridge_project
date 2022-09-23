package com.citibridge;
import java.util.Comparator;

import com.citibridge.entities.StockWrapper;

public class StockComparator implements Comparator<StockWrapper> {

	@Override
	public int compare(StockWrapper o1, StockWrapper o2) {
		// TODO Auto-generated method stub
		if(o1.getGain().compareTo(o2.getGain())==-1)
		{
			return 1;
		}
		else if(o1.getGain().compareTo(o2.getGain())==1)
			return -1;
		else
			return 0;
	}

}
