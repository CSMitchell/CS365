class Salary{
	public Salary(String args[]){
		//test input args
		if(args.length >= 1){ 
			if(args.length % 2 != 0){
				System.err.println("Error: incorrect input args");
				System.exit(1);		
			}
		}

		//declare variables
		int i = 0; int j = 0;
		double averageSal = 0;
		Person personList[] = new Person[args.length / 2];
		
		//input args into personList
		while(j < (args.length / 2)){
			personList[j] = new Person();
			personList[j].storeName(args[i]);
			i++;
			personList[j].storeSal(Double.parseDouble(args[i]));
			i++; j++;
		}

		//find average salary
		for(i = 0; i < personList.length; i++){
			averageSal += personList[i].getSal();
		}
		averageSal = averageSal / personList.length;
//		System.out.printf("averageSal: %f %n", averageSal);

		//output
		System.out.printf("average salary = %,10.2f %n %n", averageSal);	
		for(i = 0; i < personList.length; i++){
			System.out.printf("%-15s %,10.2f %b %n", personList[i].getName(), personList[i].getSal(), compSal(averageSal, personList[i].getSal()));
		}	
	}

	public boolean compSal(double avgSal, double perSal){
		if(perSal <= avgSal) return false;
		else return true;
	}

	class Person{
		private String name;
		private double sal;
		
		//constructors	
		public Person(){}
		public Person(String n){
			name = n;
		}
		public Person(String n, double d){
			name = n;
			sal = d;
		}

		public void storeName(String s){
			name = s;
		}
		public void storeSal(double d){
			sal = d;
		}
		public String getName(){
			return name;
		}
		public double getSal(){
			return sal;
		}
	}


	static public void main(String args[]){
		new Salary(args);
	}
}
