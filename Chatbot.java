import java.util.Scanner;
import java.util.Arrays;

public class Chatbot {
    static Scanner in;
    String name;
    
    public Chatbot(String name){
        in = new Scanner(System.in);
        this.name = name;
    }

    public void printRes(String[] npc){
        int num = Item.randNum(npc.length);
        System.out.println(name+": "+npc[num]);
    }

    public void play(String[] npc){
        System.out.println(name+": Hi there! How are you today?");
        while(true){
            String og_input = in.nextLine().toUpperCase();
            String[] input_array = og_input.split(" ");
            String[] input = input_array;

            if(input[0].equals("LEAVE")){
                System.out.println("you said Leave so you are now exiting the conversation");
                break;
            }
            for(int i = 0; i<input.length; i++){

                if(input[i].equals("I")){
                    input[i] = input[i].replace("I", "YOU");
                }
                else if(input[i].equals("ME")){
                    input[i] = input[i].replace("ME", "YOU");
                }
                else if(input[i].equals("AM")){
                    input[i] = input[i].replace("AM", "ARE");
                }
                else if(input[i].equals("YOU")){
                    input[i] = input[i].replace("YOU", "I");
                }
                else if(input[i].equals("MY")){
                    input[i] = input[i].replace("MY", "YOUR");
                }
                else if(input[i].equals("YOUR")){
                    input[i] = input[i].replace("YOUR", "MY");
                }
                else if(input[i].equals("I'M")){
                    input[i] = input[i].replace("I'M", "YOU'RE");
                }
                else if(input[i].equals("YOU'RE")){
                    input[i] = input[i].replace("YOU'RE", "I'M");
                }
    
            }
            String res = Arrays.toString(input);
            res = res.replace("[", "").replace("]","").replace(",","");
            
            if(res.equals(og_input)){
                this.printRes(npc);
            }
            else{
                res = res.toLowerCase();
                System.out.println(name+": "+res+"?");
            }
        }
    }
    public static void main(String[] args) {
        Chatbot myBot = new Chatbot("Mirabel");
        String [] Mirabel = new String[]{"OOps, my muffins are burning", "I like flowers  :p", "Oh dear :0", "You have really shiny hair"};
        myBot.play(Mirabel);
    }
}
