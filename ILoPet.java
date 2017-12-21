import tester.Tester;


interface ILoPet{

  // String -> boolean
  // Returns true if a given name is in the list of pets
  boolean sameNamePet(String name);
}

class MtLoPet implements ILoPet {

  MtLoPet() {}

  public boolean sameNamePet(String name) {
    return false;
  }
}

class ConsLoPet implements ILoPet {
  IPet first;
  ILoPet rest;

  ConsLoPet(IPet first, ILoPet rest) {
    this.first = first;
    this.rest = rest;
  }

  public boolean sameNamePet(String name) {
    if (this.first.sameNamePet(name)) {
      return true;
    } else {
      return this.rest.sameNamePet(name);
    }
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





//GWAPO MI
//to represent a pet owner
class Person{
    String name;
    ILoPet pet;
    int age;

    Person(String name, ILoPet pet, int age) {
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

    public boolean sameNamePet(String that) {
        return this.name.equals(that);
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
    ILoPet mt = new MtLoPet();
    ILoPet dogs = new ConsLoPet(Pluto, new ConsLoPet(Khaged, mt));
    ILoPet cats = new ConsLoPet(Tom, new ConsLoPet(Jerry, mt));
     Person Dan = new Person("Dan", dogs, 18);

    // Person Ray = new Person ("Ray", Jerry, 18);
    // Person Hilaga = new Person("Hilaga", Pluto, 25);
    // Person Dalaota = new Person("Dalaota", Dudoy, 99);
    // Person Marcos = new Person("Marcos", Tom, 123);
    // Person Imelduh = new Person("Imelduh", Pluto, 341);

    // boolean testIsOlder(Tester t) {
    //     return t.checkExpect(Dan.isOlder(John), true) &&
    //             t.checkExpect(John.isOlder(Ray), false) &&
    //             t.checkExpect(Hilaga.isOlder(Dan), false) &&
    //             t.checkExpect(Dalaota.isOlder(John), true) &&
    //             t.checkExpect(Marcos.isOlder(Imelduh), false);
    // }

    boolean testSameNamePet(Tester t){
        return t.checkExpect(cats.sameNamePet("Tom"), true) &&
                t.checkExpect(dogs.sameNamePet("Duday"), false) &&
                t.checkExpect(dogs.sameNamePet("Khaged"), true) &&
                t.checkExpect(cats.sameNamePet("Jerry"), true);
    }

    // boolean testPerish(Tester t){
    //     return t.checkExpect(Marcos.perish(), Marcos) &&
    //             t.checkExpect(Imelduh.perish(), Imelduh);
    // }
}
