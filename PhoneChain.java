import tester.Tester;

interface PhoneChain {
// -> int
// Returns the number of players that is under this player including this player

    public int countPlayers();
    // -> int
// Returns the number of players that is under this player excluding this player

    public int countPlayersCalled();
    // String -> boolean
    // Returns true if this player will be able to call a given name

    public boolean willCall(String name);

    int longestChain();

    String getName();

    int longestChainCmp();
}



    class MtLoPhoneChain implements PhoneChain{
        MtLoPhoneChain(){}

        public int countPlayers() {
            return 0;
        }

        public int countPlayersCalled() {
            return 0;
        }

        public boolean willCall(String name) {
            return false;
        }

        public int longestChain() {
            return 0;
        }

        public String getName() {
            return "";
        }

        public int longestChainCmp() {
            return 0;
        }
    }


class ConsLoPhoneChain implements PhoneChain {
    String name;
    PhoneChain player;
    PhoneChain player1;

    ConsLoPhoneChain(String name,PhoneChain player, PhoneChain player1) {
        this.name = name;
        this.player = player;
        this.player1 = player1;
    }

 /* TEMPLATE
  *   Fields:
  *     ...this.name...       --> String
  *     ...this.player...      --> PhoneChain
  *     ...this.player1...      --> PhoneChain
  *   
  *   Methods:
  *     ...this.countPlayers()...    --> int
  *     ...this.countPlayersCalled()...   --> int
  *     ...this.willCall(String)...   --> boolean
  *     ...this.getName()...     --> String
  * 
  *   
  *   Methods on player:
  *     ...this.player.countPlayers() --> int
  *     ...this.player.countPlayersCalled()...   --> int
  *     ...this.player.willCall(String)...   --> boolean
  *     ...this.player.getName()     --> String
  *   
  *   Methods on player1:
  *     ...this.player1.countPlayers() --> int
  *     ...this.player1.countPlayersCalled()...   --> int
  *     ...this.player1.willCall(String)...   --> boolean
  *     ...this.player1.getName()     --> String
  *       
  */

    // -> String
    // Returns the name of this Player
    public String getName() {
        return this.name;
    }

    public int countPlayers() {
        return 1 + this.player.countPlayers() + this.player1.countPlayers();
    }


    public int countPlayersCalled() {
        return this.countPlayers() - 1;
    }


    public boolean willCall(String name) {
        return this.name.equals(name) || player.willCall(name) || player1.willCall(name);
    }

    public int longestChainCmp() {
        int temp;
        if (player.longestChainCmp() > player1.longestChainCmp()) {
            temp =  1 + player.longestChainCmp();
        } else {
            temp = 1 + player1.longestChainCmp();
        }
        return temp;
    }

    public int longestChain() {
        return longestChainCmp() - 1;
    }
}


class ExamplesPhoneChain {
    ExamplesPhoneChain() {
    }

    PhoneChain phoneChain = new MtLoPhoneChain();

    PhoneChain tay = new ConsLoPhoneChain("Tay", this.phoneChain, this.phoneChain);
    PhoneChain zoe = new ConsLoPhoneChain("Zoe", this.phoneChain, this.phoneChain);
    PhoneChain meg = new ConsLoPhoneChain("Meg", this.phoneChain, this.phoneChain);
    PhoneChain lou = new ConsLoPhoneChain("Lou", this.phoneChain, this.phoneChain);
    PhoneChain cam = new ConsLoPhoneChain("Cam", this.phoneChain, this.phoneChain);
    PhoneChain eve = new ConsLoPhoneChain("Eve", this.phoneChain, this.phoneChain);
    PhoneChain tam = new ConsLoPhoneChain("Tam", this.phoneChain, this.phoneChain);
    PhoneChain kim = new ConsLoPhoneChain("Kim", this.tay, this.zoe);
    PhoneChain pat = new ConsLoPhoneChain("Pat", this.meg, this.lou);
    PhoneChain ann = new ConsLoPhoneChain("Ann", this.cam, this.eve);
    PhoneChain joy = new ConsLoPhoneChain("Joy", this.tam, this.phoneChain);
    PhoneChain may = new ConsLoPhoneChain("May", this.kim, this.pat);
    PhoneChain bea = new ConsLoPhoneChain("Bea", this.ann, this.joy);
    PhoneChain jen = new ConsLoPhoneChain("Jen", this.may, this.bea);

    boolean testMtCountPlayers(Tester t) {
        return t.checkExpect(this.phoneChain.countPlayers(), 0);
    }

    boolean testCountPlayers(Tester t) {
        return t.checkExpect(jen.countPlayers(), 14) &&
                t.checkExpect(ann.countPlayers(), 3) &&
                t.checkExpect(zoe.countPlayers(), 1) &&
                t.checkExpect(bea.countPlayers(), 6);
    }

    boolean testConsPlayerCmp(Tester t) {
        return
                t.checkExpect(this.meg.countPlayers(), 1) &&
                        t.checkExpect(this.pat.countPlayers(), 3) &&
                        t.checkExpect(this.may.countPlayers(), 7) &&
                        t.checkExpect(this.jen.countPlayers(), 14);
    }

    boolean testConsPlayerCalledCmp(Tester t) {
        return
                t.checkExpect(this.meg.countPlayersCalled(), 0) &&
                        t.checkExpect(this.ann.countPlayersCalled(), 2) &&
                        t.checkExpect(this.bea.countPlayersCalled(), 5) &&
                        t.checkExpect(this.jen.countPlayersCalled(), 13);
    }

    boolean testlongestChain(Tester t) {
        return t.checkExpect(bea.longestChain(), 2) &&
                t.checkExpect(jen.longestChain(), 3) &&
                t.checkExpect(joy.longestChain(), 1) &&
                t.checkExpect(tay.longestChain(), 0);
    }
}




