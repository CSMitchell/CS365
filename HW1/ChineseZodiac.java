public enum ChineseZodiac{
	GOAT(2015),
	HORSE(2014),
	SNAKE(2013),
	DRAGON(2012),
	RABBIT(2011),
	TIGER(2010),
	BULL(2009),
	RAT(2008),
	PIG(2007),
	DOG(2006),
	COCK(2005),
	MONKEY(2004);

	private final int lastYear;
	
	private ChineseZodiac(int lastYear){
		this.lastYear = lastYear;
	}

	public int getYear(){
		return lastYear;
	}
		

}
