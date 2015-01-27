class Min { 
	public Min(String args[]) {
		String minS = args[0];
		
		for(String s : args){
			if(minS.compareTo(s) > 0){
				minS = s;
			}
		}
		System.out.println(minS);
	} 

	public static void main(String args[]) { 
		new Min(args);
	}
}

