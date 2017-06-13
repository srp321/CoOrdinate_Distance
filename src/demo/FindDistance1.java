package demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FindDistance1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double[] x = {0,10.1,-12.2,38.3,79.99};		// Get the X Coordinates separately
		double[] y = {0,-10.1,12.2,-38.3,179.99};	// Get the X Coordinates separately
		
		LinkedHashMap<Double, ArrayList<Double>> test = new LinkedHashMap<>();
		
		for (int i = 0; i < x.length; i++) {
			ArrayList<Double> al = new ArrayList<>();
			for (int j = 0; j < x.length; j++) {
				double distance1 =  Math.sqrt(((x[i] - x[j]) * (x[i] - x[j])) 
						+ ((y[i] - y[j]) * (y[i] - y[j])));
				al.add(distance1);	
			}
			test.put((double) i+1, al);
		}
		
		Iterator<Entry<Double, ArrayList<Double>>> itr = test.entrySet().iterator();
		
		while (itr.hasNext()) {
			Map.Entry<Double, ArrayList<Double>>  val =  itr.next();

			ArrayList<Double> unSortedVal = new ArrayList<Double>(val.getValue()); 
			Collections.sort(val.getValue());
			int[] indexes = new int[val.getValue().size()];
			for (int k = 0; k < val.getValue().size(); k++){
			    indexes[k] = unSortedVal.indexOf(val.getValue().get(k))+1;
			}
			System.out.println(indexes[0]+" : "+indexes[1]+", "+
					indexes[2]+", "+indexes[3]+", "+indexes[4]);
		}
	}
}
