import tester.Tester;

//GWAPO MI
//to represent a pet owner
class Person implements IPet{
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
    Fields for Person:
    ... this,pet...        -- Pet
    ... this.name ...  -- String
    ... this.age ... -- int
    */
    //Person -> boolean
    // Determines if this Person is older than this person

    boolean isOlder(Person other) {
        return   this.age> other.age;
    }

    @Override
    public boolean sameNamePet(String that) {
        return this.name.equals(that);
    }

    //TEMPLATE
    /*
     Fields for Person:
     ...this.name ...   ---String
     ...this.age...     --- int
     ...this.pet...    --- Pet

     Methods for perish"
     ...noPet() ...     --- Person
     ... sameNamePet(String)...     --- boolean
     */
    // -> Person
    // Returns this person who's pet has perished
    Person perish(){
        Person temp = new Person(this.name, new noPet(), this.age);
        return temp;
    }
}



//to represent a pet
interface IPet {
    //TEMPLATE
    /**Fields for Cat:
     * ...      this,name ..    .---    String
     * ...       this.kind ...      ---     String
     *...        this.longhaired    ---  boolean
     * Fields for Dog:
     * ...      this.name ...       --- String
     * ...      this.kind ...           --- String
     * ...this.male..            --- boolean
     */

    //  String ----> boolean
    // Check whether this pet’s name matches the given name
    boolean sameNamePet(String that);
}

class noPet implements IPet{
    noPet(){

    };
    @Override
    public boolean sameNamePet(String that) {
        return false;
    }
}


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

    public boolean sameNamePet(String that){
        return this.name.equals(that);
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
    public boolean sameNamePet(String that){
        return this.name.equals(that);
    }
}



class ExamplesPets{
    ExamplesPets(){}
    IPet Tom = new Cat("Tom", "Sphynx", false);
    IPet Jerry = new Cat("Jerry", "Bombay", true);
    IPet Pluto = new Dog("Pluto", "Eskimo", true);
    IPet Khaged = new Dog("Khaged", "Azkhal", false);
    IPet Dudoy = new Dog("Dudoy", "Shitzu", true);
    IPet Luoy = new noPet();

    Person John = new Person("John", Khaged, 18);
    Person Dan = new Person("Dan", Tom, 42);
    Person Ray = new Person ("Ray", Jerry, 18);
    Person Hilaga = new Person("Hilaga", Pluto, 25);
    Person Dalaota = new Person("Dalaota", Dudoy, 99);
    Person Marcos = new Person("Marcos", Luoy, 123);
    Person Imelduh = new Person("Imelduh", Luoy, 341);

    boolean testIsOlder(Tester t) {
        return t.checkExpect(Dan.isOlder(John), true) &&
                t.checkExpect(John.isOlder(Ray), false) &&
                t.checkExpect(Hilaga.isOlder(Dan), false) &&
                t.checkExpect(Dalaota.isOlder(John), true) &&
                t.checkExpect(Marcos.isOlder(Imelduh), false);
    }

    boolean testSameNamePet(Tester t){
        return t.checkExpect(Tom.sameNamePet("Tom"), true) &&
                t.checkExpect(Dudoy.sameNamePet("Duday"), false) &&
                t.checkExpect(Khaged.sameNamePet("Khaged"), true) &&
                t.checkExpect(Pluto.sameNamePet("Pluto"), true);
    }

    boolean testPerish(Tester t){
        return t.checkExpect(Marcos.perish(), Marcos) &&
                t.checkExpect(Imelduh.perish(), Imelduh);
    }
}