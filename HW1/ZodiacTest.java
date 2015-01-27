public class ZodiacTest{
	public ZodiacTest(String args[]){
		ChineseZodiac year = ChineseZodiac.RABBIT;
		System.out.println("The last year of the " + year + " occured in " + year.getYear());

		for(ChineseZodiac z : ChineseZodiac.values()){
			System.out.println("The year of the " + z + " last occured in " + z.getYear());
		}

	}
	
	public static void main(String args[]){
		new ZodiacTest(args);
	} 

}
