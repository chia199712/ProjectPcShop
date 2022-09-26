package shopTestPackage;

import java.io.Serializable;

public class shopDB implements Serializable {
	
	private static Integer[] itNo;	 
	private static String[] itName;	 
	private static String[] itDetail;	 
	private static Integer[] itPrice;
	
	
	public static void setItNo(Integer[] pitNo) {
		itNo = pitNo;
	}
	
	public static void setItName(String[] pitName) {
		itName=pitName;
	}
	
	public static void setItDetail(String[] pitDetail) {
		itDetail=pitDetail;
	}
	
	public static void setItPrice(Integer[] pitPrice) {
		itPrice = pitPrice;
	}
		 
	/** Return the number of books in the database */
	public static int size() {
	       return itNo.length;
	}
		 
	/** Return the title of the given bookID */
	public static String getItName(int shopNO) {
	       return itName[shopNO];
	}
		 
	/** Return the author of the given bookID */
	public static String getItDetail(int shopNO) {
	      return itDetail[shopNO];
    }
		 
	/** Return the price of the given bookID */
    public static float getItPrice(int shopNO) {
	      return itPrice[shopNO];
    }

}