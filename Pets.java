import tester.Tester;

//to represent a pet owner
class Person {
 String name;
 IPet pet;
 int age;

 Person(String name, IPet pet, int age) {
     this.name = name;
     this.pet = pet;
     this.age = age;
 }
 
//TEMPLATE
/*
Fields:
... this.name ...  -- String
... this.age ... -- int
*/

//Person -> boolean
//Determines if this Person is older than this person

 boolean isOlder(Person other) {
		return this.age  > other.age;
	}
 
}
//to represent a pet
interface IPet { }

//to represent a pet cat
class Cat implements IPet {
 String name;
 String kind;
 boolean longhaired;

 Cat(String name, String kind, boolean longhaired) {
     this.name = name;
     this.kind = kind;
     this.longhaired = longhaired;
 }
}

//to represent a pet dog
class Dog implements IPet {
 String name;
 String kind;
 boolean male;

 Dog(String name, String kind, boolean male) {
     this.name = name;
     this.kind = kind;
     this.male = male;
 }
}




class ExamplesPets{
	ExamplesPets(){
		
	}

	IPet Tom = new Cat("Tom", "Sphynx", false);
	IPet Jerry = new Cat("Jerry", "Bombay", true);
	IPet Pluto = new Dog("Pluto", "Eskimo", true);
	IPet Khaged = new Dog("Khaged", "Azkhal", false);
	
	Person John = new Person("John", Khaged, 18);
	Person Dan = new Person("Dan", Tom, 42);
	Person Ray = new Person ("Ray", Jerry, 18);
	Person Hilaga = new Person("Hilaga", Pluto, 25);
	
	boolean testIsOlder(Tester t) {
		return t.checkExpect(Dan.isOlder(John), true) && 
				t.checkExpect(John.isOlder(Ray), false) && 
				t.checkExpect(Hilaga.isOlder(Dan), false);
	}
}