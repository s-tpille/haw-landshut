/**
 * @author Tobias Piller
 *
 */

public class DEA {
	
	public static void main(String[] args) {
		
		// DEA Settings BEGIN
		String sigma = "abc";
		int[][][] tables = {{{0,1,1},
							 {3,2,2},
							 {3,2,2},
							 {0,1,1}},
							 
							{{1,2,3},
							 {4,1,1},
							 {2,4,2},
							 {3,3,4},
							 {4,4,4}}};
		
		int[][] ends = {{3},{4}};
		// DEA Settings END
		
		String usage = "Usage: java DEA "+sigma;
		
		// check DEA Settings
		if(tables.length==ends.length) {
			
			// only one argument accepted
			if(args.length == 1) {
				
				// check args' language
				int matchSum=0;
				for(int i=0; i<args[0].length(); i++) {
					int j=0;
					boolean match=false;
					while(!match && j!=sigma.length()) {
						if(args[0].charAt(i)==sigma.charAt(j)) {
							match=true;
							matchSum++;
						} else {
							j++;
						}
					}
				}
	
				// if matching was successful start algo
				if(matchSum==args[0].length()) {
					
					System.out.println("algo works here");
				} else {
					System.out.println(usage);
				}
			} else {
				System.out.println(usage);
			}
		} else {
			System.out.println("Check DEA Configuration!");
		}
	}
}