import acm.graphics.*;
import acm.program.GraphicsProgram;

import java.awt.*;
import java.util.Objects;

import svu.csc213.Dialog;

public class Hangman extends GraphicsProgram {

    //classes
    private Hang hang;
    private Man man;
    private Word word;

    //variables
    private int wrong, letterV, save, wins, losses;
    private String currentWord, letter;
    private double letX, letY, lineW, lineH, lineX, lineY;
    private boolean allThere, answer;

    //arrays
    private GRect[] lines;
    private char[] chars, letterA;
    private GLabel[] charsLbl;

    @Override
    public void init() {
        this.setSize(1000, 750);

        Dialog.showMessage("Welcome to Hangman: Programming Edition");

        //call the draw methods
        drawHanger();
        drawMan();
        drawLetterBox();
        newGame();
    }

    private void newGame() {
        //starts a fresh game
        wrong = 0;
        word.roll();
        generate();
        enter();
    }

    private void clearAll(){
        //clears all the things on the screen, then adds them back to start a new game
        this.removeAll();
        drawLetterBox();
        drawMan();
        drawHanger();
        newGame();
    }

    private void drawHanger() {
        //make a new instance of the hang class
        hang = new Hang();

        add(hang,0,0);
    }

    private void drawMan() {
        //make a new instance of the man class
        man = new Man();

        //make the head
        man.head = new GOval(20, 20);

        //set the x, y, width, and height of the head
        man.hX = hang.hX - man.head.getWidth() / 2;
        man.hY = hang.hY + hang.h.getHeight();

        //make the body's v, v1, v2, and v3
        man.body = new GLine(man.hX + man.head.getWidth() / 2, man.hY + man.head.getHeight(), man.hX + man.head.getWidth() / 2, man.hY + man.head.getHeight() + hang.h.getHeight() * .75);

        man.bX = man.hX + man.head.getWidth() / 2;
        man.bY = man.hY + man.head.getHeight();


        //make the arm's/leg's v, v1, v2, and v3
        man.arm1 = new GLine(man.bX - 15, man.bY + man.body.getHeight() * .25 - 15, man.bX, man.bY + man.body.getHeight() * .25);
        man.arm2 = new GLine(man.bX + 15, man.bY + man.body.getHeight() * .25 - 15, man.bX, man.bY + man.body.getHeight() * .25);
        man.leg1 = new GLine(man.bX - 15, man.bY + man.body.getHeight() + 15, man.bX, man.bY + man.body.getHeight());
        man.leg2 = new GLine(man.bX + 15, man.bY + man.body.getHeight() + 15, man.bX, man.bY + man.body.getHeight());

        //add the head, body, arms, and legs
        add(man.head, man.hX, man.hY);
        add(man.body, man.bX, man.bY);
        add(man.arm1);
        add(man.arm2);
        add(man.leg1);
        add(man.leg2);
    }

    private void drawLetterBox() {
        word = new Word();

        //make a letter box
        word.letterBox = new GRect(getWidth() * .4, getHeight() / 4);

        //add the letter box
        add(word.letterBox, getX() + 20, getY() + 20);

        //add the letters
        for (int i = 0; i < word.alph.length; i++) {
            letX = word.letterBox.getX() + word.letterBox.getWidth() / 6 - 10 * -i;
            letY = word.letterBox.getY() + word.letterBox.getHeight() / 2;
            word.alph[i].setColor(Color.BLACK);
            add(word.alph[i], letX, letY);
            pause(10);
        }
    }

    private void generate() {
        //generate a random word
        currentWord = word.wordBank[word.getRandomWord() - 1];

        //generate the lines for the word
        lines = new GRect[currentWord.length()];

        //make an array of chars for the letters
        chars = new char[currentWord.length()];

        //turn the letters into GLabels
        charsLbl = new GLabel[chars.length];

        //assign the chars and the char labels
        for (int j = 0; j < chars.length; j++) {
            chars[j] = currentWord.charAt(j);
            charsLbl[j] = new GLabel("" + chars[j]);
        }

        for (int i = 0; i < lines.length; i++) {

            //set the width and height of each line
            lineW = getWidth() / (currentWord.length() + 20);
            lineH = 1;
            lines[i] = new GRect(lineW, lineH);

            //set the x and y of each line
            lineX = 10 + i * (getWidth() / currentWord.length()) / 2 + 5;
            lineY = getHeight() * .75;

            //add the lines
            add(lines[i], lineX, lineY);

            //add the letters
            add(charsLbl[i], lines[i].getX() + lines[i].getWidth()/2, lineY - 10);
            charsLbl[i].setVisible(false);
        }
    }

    private void enter() {
        //have the user guess a letter
        letter = Dialog.getString("Guess a letter:");

        //check every letter to see if their guess matches
        checkGuess();
    }

    private void letterConverter() {
        if (Objects.equals(letter, "a")) {
            letterV = 0;
        } else if (Objects.equals(letter, "b")) {
            letterV = 1;
        } else if (Objects.equals(letter, "c")) {
            letterV = 2;
        } else if (Objects.equals(letter, "d")) {
            letterV = 3;
        } else if (Objects.equals(letter, "e")) {
            letterV = 4;
        } else if (Objects.equals(letter, "f")) {
            letterV = 5;
        } else if (Objects.equals(letter, "g")) {
            letterV = 6;
        } else if (Objects.equals(letter, "h")) {
            letterV = 7;
        } else if (Objects.equals(letter, "i")) {
            letterV = 8;
        } else if (Objects.equals(letter, "j")) {
            letterV = 9;
        } else if (Objects.equals(letter, "k")) {
            letterV = 10;
        } else if (Objects.equals(letter, "l")) {
            letterV = 11;
        } else if (Objects.equals(letter, "m")) {
            letterV = 12;
        } else if (Objects.equals(letter, "n")) {
            letterV = 13;
        } else if (Objects.equals(letter, "o")) {
            letterV = 14;
        } else if (Objects.equals(letter, "p")) {
            letterV = 15;
        } else if (Objects.equals(letter, "q")) {
            letterV = 16;
        } else if (Objects.equals(letter, "r")) {
            letterV = 17;
        } else if (Objects.equals(letter, "s")) {
            letterV = 18;
        } else if (Objects.equals(letter, "t")) {
            letterV = 19;
        } else if (Objects.equals(letter, "u")) {
            letterV = 20;
        } else if (Objects.equals(letter, "v")) {
            letterV = 21;
        } else if (Objects.equals(letter, "w")) {
            letterV = 22;
        } else if (Objects.equals(letter, "x")) {
            letterV = 23;
        } else if (Objects.equals(letter, "y")) {
            letterV = 24;
        } else if (Objects.equals(letter, "z")) {
            letterV = 25;
        }
    }

    private void checkAllThere(){
        //checks which of the char Labels are visible
        for (int i = 0; i < currentWord.length(); i++) {
            if (charsLbl[i].isVisible()) {
                save += 1;
            }
        }
        //set the boolean true or false
        if(save == currentWord.length()){
            allThere = true;
        }else if(save != currentWord.length()){
            allThere = false;
        }
        save = 0;
    }

    private void checkGuess() {
        letterConverter();

        if (currentWord.contains(letter)) {
            //if letter is present:
            //turn the letter green
            word.alph[letterV].setColor(Color.GREEN);

            letterA = letter.toCharArray();
            for (int i = 0; i < currentWord.length(); i++) {
                if (currentWord.charAt(i) == letterA[0]) {
                    //make the letters visible
                    charsLbl[i].setVisible(true);
                }
            }

            //if they have all the letters, they win
            checkAllThere();
            if(allThere){
                win();
            }else if(!allThere){
                enter();
            }

        } else if (!currentWord.contains(letter)) {
            //if letter is not present:
            wrong += 1;

            //turn the letter red
            word.alph[letterV].setColor(Color.RED);

            remove();
            enter();
        }
    }

    private void remove() {
        //if they get it wrong, remove the corresponding limb
        if (wrong == 1) {
            //remove the first leg
            man.leg1.setVisible(false);

        } else if (wrong == 2) {
            //remove the second leg
            man.leg2.setVisible(false);

        } else if (wrong == 3) {
            //remove the first arm
            man.arm1.setVisible(false);

        } else if (wrong == 4) {
            //remove the second arm
            man.arm2.setVisible(false);

        } else if (wrong == 5) {
            man.body.setVisible(false);
            man.head.setVisible(false);
            lose();
        }
    }

    private void lose() {
        losses += 1;
        //tell them they lost and what the word was
        Dialog.showMessage("You lose! The word was " + currentWord + ". Wins to losses: " + wins + ":" + losses);
        //ask if they want to play again
        answer = Dialog.getYesOrNo("Would you like to play again? Enter yes or no:");
        //if yes, clear the screen to start a new level
        if(answer){
            clearAll();
        }else {
            //else end the game
            System.exit(0);
        }
    }

    private void win() {
        //add a win
        wins += 1;
        //tell them they won, what the word was, and how many wins they currently have
        Dialog.showMessage("You win! The word was " + currentWord + ". Wins to losses: " + wins + ":" + losses);
        //ask if they want to play again
        answer = Dialog.getYesOrNo("Would you like to continue? Enter yes or no:");
        //if they say yes, clear the screen to start a new level
        if(answer){
            clearAll();
        }else{
            //if no, end the game
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Hangman().start();
    }
}