/*
Taking Notice of : Liskov Replacement Princeple.
	SuperClass instantiation = new subClass1();
	SuperClass instantiation = new subClass2();  
	Does the varable instantiation has the permition for accessing all the methods in subClass1 AND subClass2?
		No 	(Probably)
	
*/


public class Inheritance_OR_Implements__test_{
	public static void main(String []args){
		//Depend on Concrete Class 
		SuperClass instantiation = new SubClass();
		instantiation.output_num(1);		// The first output_num(int i) invoked is in subClass.
		//instantiation.output_num(1,2);	// When inheritance used for subclass additional method invoked, cannot do that. Coz you can't invoke the method in subClass but not in Super Class.
		
		
		//Depend on Interface; 
		Class_I instantiation_I_ = new SuperClass_Imp_I();
		instantiation_I_.test();
		instantiation_I_ = new SubClass_Imp_I();
		instantiation_I_.test();
		instantiation_I_.output_num(1);
		System.out.println("-----------------------------.");
		instantiation_I_.output_num(1,2);
		
		
	}
}

class SuperClass{
	SuperClass(){}
	protected void test(){
		System.out.println("Md 'test()' in __Super Class Invoked.");
	}
	protected void output_num(int i){
		System.out.println("\n**"+ i +"**\nMd 'output_num( int i )' in __Super Class Invoked.");
	}
}
class SubClass extends SuperClass {
	SubClass(){}
	protected void test(){			// test() in super class is overrided in sub class.
		System.out.println("Md 'test()' in __SubClass__ Invoked.");
	}
	protected void output_num(int i){	// override
		System.out.println("subClass output_num(int i) Invoked.");
	}
	protected void output_num(int i, int j){
		System.out.println("\n**"+ i +" \t __"+ j + "***_\n" +"**\nMd 'output_num( int i )' in __Super Class Invoked.");
	}
}

interface Class_I{
	void test();
	void output_num(int i);
	void output_num(int i, int j);	// output_num Method overloaded.
}

class SuperClass_Imp_I implements Class_I{
	public void test(){
		System.out.println("Super Class implemented by Class_I was invoked! ");
	}
	public void output_num(int i){
		System.out.println("\n**"+ i +"**\nMd 'output_num( int i )' in __Super Class Invoked.");
	}
	public void output_num(int i, int j){	
		
	}
}

class SubClass_Imp_I extends SuperClass_Imp_I { // Needn't implements Class_I Again.
	public void test(){
		System.out.println("__SubClass__ implemented by Class_I was invoked! ");
	}	
	public void output_num(int i, int j){		// superclass's output_num(int i , int j) is overrided.
		System.out.println("\n**"+ i +" \t __"+ j + "***_\n" +"**\nMd 'output_num( int i )' in SUB-Class Invoked.");
	}
}



