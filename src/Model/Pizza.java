package Model;
/**
 * @author Rasmus
 * @author Mia
 * @author Andreas
 * @author Emilie
 */

// Klassen der indeholder pizzaernes egenskaber
public class Pizza {
        // Atributter:
    int nr;
    String name;
    String ingrediens;
    int price;

    // Kontruktor

    public Pizza(int nr, String name, String ingrediens, int price) {
        this.nr = nr;
        this.name = name;
        this.ingrediens = ingrediens;
        this.price = price;
    }

// Getter og setter for MenuNumber

    public int getNr() {
        return nr;
    }

    public String getName() {
        return name;
    }

    public String getIngrediens() {
        return ingrediens;
    }

    public int getPrice() {
        return price;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIngrediens(String ingrediens) {
        this.ingrediens = ingrediens;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    

// toString bruges når ordrene skal vises i terminalen    
   // @Override
  //  public String toString() {
  //      return "No." + menuNumber + ", " + name + ", " + price + " kr.";
   // }
}
