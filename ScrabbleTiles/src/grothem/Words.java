package grothem;

import java.util.Vector;

public class Words {
	private String[] arr;
	String finalAns = "";

	public Words(String str) {
		// makes the string an array
		arr = str.split("");
	}

	public String scramble(int X) {
		String[] ml = arr;
		int length = arr.length;
		// This generates all combinations with every possible size
		// but here we are only interested in combinations of length X
		for (int z = 0; z < X - 1; z++) {
			Vector<String> tmp = new Vector<String>();
			for (int i = 0; i < arr.length; i++) {
				for (int k = 0; k < ml.length; k++) {
					if (arr[i] != ml[k]) {
						tmp.add(ml[k] + arr[i]);
					}
				}
			}
			// adding combinations to our answer to return
			for (int i = 0; i < tmp.size(); i++) {
				// take out this if statement to get combinations of
				// any size, not just of size X
				if (tmp.get(i).length() == length) {
					finalAns += tmp.get(i) + " ";
				}
			}
			ml = tmp.toArray(new String[tmp.size()]);
		}
		return finalAns;
	}
}
