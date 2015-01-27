
import java.io.*; 
import java.util.*; 


class Handicap
{
	TreeMap golfers; 
	HashMap courses; 
	public Handicap(String args[]) throws IOException
	{
		String scoreFile = args[0]; 
		String courseFile = args[1]; 
		readCourse(courseFile); 
		readScore(scoreFile); 

		
	}


	static public void main(String args[]) throws IOException
	{
		new Handicap(args); 
	}

	public int readScore(String fileName) throws IOException
	{
		golfers = new TreeMap(); 
		BufferedReader scoreFile = new BufferedReader(new FileReader(fileName)); 
		String line, name, courseName;
		int month, day, year, score; 
		double differential; 
		Golfer tmp; 
		Scanner lineTokenizer; 
		GregorianCalendar date; 
		Course course; 
		List <Golfer>handicaps = new ArrayList(); 
		while((line = scoreFile.readLine()) != null)
		{
			lineTokenizer = new Scanner(line); 
			
			/*build date*/
			month = lineTokenizer.nextInt(); 
			day = lineTokenizer.nextInt(); 
			year = lineTokenizer.nextInt();
			date = new GregorianCalendar(year, (month-1), day); 
			
			name = lineTokenizer.next(); 
			score = lineTokenizer.nextInt(); 
			courseName = lineTokenizer.next();

			while(lineTokenizer.hasNext()) /*build course name*/
			{
				courseName = courseName.concat(" ");
				courseName = courseName.concat(lineTokenizer.next()); 
			}
			

			lineTokenizer.close(); 
			course = (Course) courses.get(courseName);
			differential = (((score - course.rating)*113)/course.slope);
			if(golfers.containsKey(name))
			{
				tmp = (Golfer)golfers.get(name); 
				tmp.scores.put(date, differential); 
			}
			else
			{
				Golfer g = new Golfer(); 
				g.name = name;
				g.scores.put(date, differential);
				golfers.put(name, g); 
			}
		}
		scoreFile.close();
		Set golferSet = golfers.entrySet(); 
		Iterator i = golferSet.iterator(); 
		while(i.hasNext())
		{
			Map.Entry me = (Map.Entry)i.next(); 
			Golfer golfer = (Golfer) me.getValue();
			golfer.computeHandicap(); 
			handicaps.add(golfer); 

		}
		Collections.sort(handicaps, new Golfer.HandicapComparator());
		for(Golfer temp: handicaps)
		{
			System.out.printf("%5.2f %s%n", temp.handicap, temp.name);
		}
		return 1; 

	}
	public int readCourse(String fileName) throws IOException
	{
		courses = new HashMap(); 
		BufferedReader courseFile = new BufferedReader(new FileReader(fileName)); 
		String line, name, first;
		double rating;
		int slope; 
		Scanner lineTokenizer; 
		name = "";
		first = ""; 
		while((line = courseFile.readLine()) != null)
		{

			lineTokenizer = new Scanner(line); 
			if(lineTokenizer.hasNext())
			{
				first = lineTokenizer.next(); 
				if(first.equals("Course"))
				{
					name = lineTokenizer.next(); 
					while(lineTokenizer.hasNext())
					{
						name = name.concat(" "); 
						name = name.concat(lineTokenizer.next()); 
					}
				}
				if(first.equals("Rating"))
				{
					rating = lineTokenizer.nextDouble(); 
					lineTokenizer.next(); 
					slope = lineTokenizer.nextInt();

					Course course = new Course(); 
					course.rating = rating;
					course.slope = slope;
					course.name = name; 

					courses.put(name, course); 
				}
			}
			lineTokenizer.close();
		}
		Set courseSet = courses.entrySet(); 
		Iterator i = courseSet.iterator(); 
		while(i.hasNext())
		{
			Map.Entry me = (Map.Entry)i.next(); 
			Course course  = (Course) me.getValue(); 
		//	System.out.printf("Course: %s Rating: %f Slope: %d%n", course.name, course.rating, course.slope); 
		}

		
		courseFile.close();
		return 0;
	}
}
