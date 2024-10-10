class DRIVER
{
	String d_name = "Max Verstappen";
	int d_wins = 60;
	
}

class RACE
{
	String r_name = "Monza GP";
	String r_country = "Italy";
}
 	
class F1
{
	int season = 2024;
	public static void main(String args[])
	{
		DRIVER obj1 = new DRIVER();
		RACE obj2 = new RACE();
		F1 obj3 = new F1();

		System.out.println(obj1.d_name);
		System.out.println(obj1.d_wins);
		System.out.println(obj2.r_country);
		System.out.println(obj3.season);
	}	
}