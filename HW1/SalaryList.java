class SalaryList{
	private Person top; 
	private Person p; 
	private int listCount; 
	public SalaryList(String args[]){
		//test input args
		if(args.length >= 1){ 
			if(args.length % 2 != 0){
				System.err.println("Error: incorrect input args");
				System.exit(1);		
			}
		}
		else
		{
			
				System.err.println("Error: incorrect input args");
				System.exit(1);		
		}
		top = createList(args);
	
	
		
		//declare variables
		int i = 0;
		double averageSal = 0;
		

		//find average salary
		p = top; 
		averageSal += top.getSal();
		i = 1; 
		while(p.next!=null){
			p = p.next;
			averageSal += p.getSal(); 
			i++; 
		}
		averageSal = averageSal / i;

		//output
		System.out.printf("average salary = %,10.2f %n %n", averageSal);	
		System.out.printf("%-15s %,10.2f %b %n", top.getName(), top.getSal(), compSal(averageSal, top.getSal()));
		while(top.next != null)
		{
			top = top.next; 
			System.out.printf("%-15s %,10.2f %b %n", top.getName(), top.getSal(), compSal(averageSal, top.getSal()));
		}
	
	}
		private	class Person{
		Person next;
		Person last; 
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


	public Person createList(String args[]){
		Person head;
		head = new Person(); 
		Person nextPerson;
		Person newPerson; 
		int i; 
		for(i = 0; i < args.length; i++)
		{
		
			if (i==0)
			{
				head.storeName(args[i]); 
				i++; 
				head.storeSal(Double.parseDouble(args[i]));
				newPerson = head; 
			}
			else
			{
				newPerson = head; 
				nextPerson = new Person(); 
				nextPerson.storeName(args[i]); 
				i++; 
				nextPerson.storeSal(Double.parseDouble(args[i])); 
				if(nextPerson.getSal() > newPerson.getSal())
				{
					while((nextPerson.getSal() > newPerson.getSal()) && (newPerson.next!=null))
					{
						
						newPerson = newPerson.next; 
					}
					if(nextPerson.getSal() < newPerson.getSal())
					{		
						newPerson.last.next = nextPerson;
						nextPerson.last = newPerson.last; 
						newPerson.last = nextPerson; 
						nextPerson.next = newPerson;
					}
					else
					{
						newPerson.next = nextPerson; 
						nextPerson.last = newPerson;
					}

				}
				else
				{
					newPerson.last = nextPerson; 
					nextPerson.next = newPerson;
					head = nextPerson;
				}


			}
			

		}
		return head; 
	}

	public boolean compSal(double avgSal, double perSal){
		if(perSal <= avgSal) return false;
		else return true;
	}


	static public void main(String args[]){
		new SalaryList(args);
	}
}
