import java.util.*;

class Salary{
	private double averageSal = 0;

	public Salary(String args[]){

		//initialize
		int i = 0;
		List<Person> personList = new ArrayList<Person>();
		Scanner console = new Scanner(System.in);
		
		//get input
		while(console.hasNextLine()){
			Person p = new Person();
			Scanner lineTokenizer = new Scanner(console.nextLine());
			p.storeName(lineTokenizer.next());
			p.storeSal(lineTokenizer.nextDouble());
			personList.add(p);
			lineTokenizer.close();
		}
	
		//get average salary	
		i = 0;
		for(Person P : personList){
		averageSal += P.getSal();
		i++;
		}
		averageSal = averageSal / i;

		//output
		System.out.printf("average salary = %,10.2f %n %n", averageSal);	
		for(Person P : personList){
			P.printInfo();
		}	
	}

	class Person{
		private String name;
		private double sal;
		
		//constructors	
		public Person(){}
		public Person(String n){name = n;}
		public Person(String n, double d){name = n; sal = d;}

		public void storeName(String s){name = s;}
		public void storeSal(double d){sal = d;}
		public String getName(){return name;}
		public double getSal(){return sal;}

		public void printInfo(){
			System.out.printf("Name: %-15s Salary: %,10.2f ", this.name, this.sal);
			System.out.printf("     Above Average: %b%n", sal >= averageSal);
		}
	}


	static public void main(String args[]){
		new Salary(args);
	}
}
