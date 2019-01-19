/******************************************************************************
 *  Compilation:  javac BinarySearch.java
 *  Execution:    java BinarySearch
 *
 *  Prints "Is {number entered} inside of the array? {yes/no}".
 *
 *  Usecase:
 *  Java BinarySearch "0,1,2,3,4,5,6,7,8,9" 7
 *  Is 7 inside of the array? yes
 *
 *  Functions:
 *              ReadInput()  //Takes a string of integers, splits them into an
 *                           //int array and returns the array.
 *
 ******************************************************************************/

public class BinarySearch {

    public static void main(String[] args) {
        
        int[] intarr = readInput(args[0]);
        int count = intarr.length;
        int intsearch = Integer.parseInt(args[1]);
        BinarySearch search = new BinarySearch();
		Boolean result = search.BinarySearch(0, count - 1, intarr, intsearch);
        String resultstr = result ? "yes":"no";
        System.out.println("Is " + intsearch + " inside of the array? " + resultstr);
    }

	public static boolean BinarySearch(int left, int right, int[]intarr, int searchint) {
        if (left > right) {
            return false;
        }

        int mid = (right + left) / 2;

        if (intarr[mid] > searchint) {
            return BinarySearch(left, mid - 1, intarr, searchint);
        } else if (intarr[mid] < searchint) {
            return BinarySearch(mid +1, right, intarr, searchint);
        } else {
            return true;
        }
    }

    private static int[] readInput(String str){
        String[] tokens = str.split(",");
        int[] intarr = new int[tokens.length];
        for (int x = 0; x < tokens.length; x++)
        {
            intarr[x] = Integer.parseInt(tokens[x]);
        }
        return intarr;
    }
}