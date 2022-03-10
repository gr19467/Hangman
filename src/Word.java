import acm.graphics.GLabel;
import acm.graphics.GRect;
import acm.util.RandomGenerator;
import svu.csc213.Dialog;

import java.util.Objects;

public class Word {

    public int randomWord;
    public GRect letterBox;
    public String chosenMode;
    public String[] wordBank;

    //make the letters
    public GLabel[] alph = {new GLabel("a"), new GLabel("b"), new GLabel("c"), new GLabel("d"), new GLabel("e"), new GLabel("f"), new GLabel("g"), new GLabel("h"), new GLabel("i"), new GLabel("j"), new GLabel("k"), new GLabel("l"), new GLabel("m"), new GLabel("n"), new GLabel("o"), new GLabel("p"), new GLabel("q"), new GLabel("r"), new GLabel("s"), new GLabel("t"), new GLabel("u"), new GLabel("v"), new GLabel("w"), new GLabel("x"), new GLabel("y"), new GLabel("z")};

    //have a word bank to randomly select from
    public String[] programmingMode = {"public", "static", "void", "class", "method", "variable", "java", "private" , "instance", "global" , "local", "import", "logic", "runtime", "break"};
    public String[] animalMode = {"giraffe", "elephant", "dog", "cat", "hamster", "goat", "cheetah", "tiger", "rat", "mouse", "lion", "whale", "shark", "moose", "horse", "deer", "chicken", "salmon"};
    public String[] foodMode = {"pizza", "cheese", "banana", "cake", "bacon", "fries", "lemon", "pretzel", "chicken", "garlic", "bread", "caviar", "salmon", "cracker", "ham", "kiwi", "pasta", "bat", "sheep"};


    public void roll(){
        chosenMode = Dialog.getString("Enter your mode of choice: animals, programming, or food");

        if(Objects.equals(chosenMode, "animals")){
            //set the bank to animal mode
            wordBank = animalMode;
        }else if(Objects.equals(chosenMode, "programming")){
            //set the bank to programming mode
            wordBank = programmingMode;
        }else if(Objects.equals(chosenMode, "food")){
            //set the bank to food mode
            wordBank = foodMode;
        }

        //generate which index will be chosen
        randomWord = RandomGenerator.getInstance().nextInt(1, wordBank.length);

    }

    public int getRandomWord(){
        return randomWord;
    }
}