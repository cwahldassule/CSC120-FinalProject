public class FairyVillage extends Quest{

    public FairyVillage(String name){
        super("Fairy Village");
    }

    public void play(){
        throw new RuntimeException("Not set up yet");
    }
    
    public void intro(){
        System.out.println("Welcome to the Fairy Village!");
        System.out.println();
    }
}
