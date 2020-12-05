package Archive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Conversation {

    ArrayList<String> like = new ArrayList<>();
    ArrayList<String> know = new ArrayList<>();
    ArrayList<String> habit = new ArrayList<>();


    public String userAskQuestion(String question){
        ArrayList<String> q = splitOnSpace(question);
        if (q.contains("reading") || spellCheckReading(question)){
            Answers r = new Reading();
            return differentQuestions(question,r);
        }
        else if (q.contains("basketball") || spellCheckBasketball(question)){
            Answers b = new Basketball();
            return differentQuestions(question,b);
        }
        else if (q.contains("cooking") || spellCheckCooking(question)){
            Answers c = new Cooking();
            return differentQuestions(question,c);
        }
        else if (q.contains("painting") || spellCheckPainting(question)){
            Answers p = new Painting();
            return differentQuestions(question,p);
        }
        else if (q.contains("movies") || spellCheckMovies(question)){
            Answers m = new Movies();
            return differentQuestions(question,m);
        }
        else if (q.contains("swimming") || spellCheckSwimming(question)){
            Answers s = new Swimming();
            return differentQuestions(question,s);
        }
        else if (q.contains("singing") || spellCheckSinging(question)){
            Answers sing = new Singing();
            return differentQuestions(question, sing);
        }
        else {
            if (question.contains("like")) {
                return "Sorry, I haven't tried it before. Do you want to introduce it for me?";

            }
            else if (question.contains("bye")){
                return "It's nice talking to you. Bye.";

            }
            else if(question.contains("hi") || question.contains("hello")) {
                return "Hi! Nice to meet you!";
            }

            else if (!question.contains(" ")){
                return "I'm sorry I don't understand. Could we talk about something else?";
            }
            else{
                return "That's interesting!";

            }
        }
    }

    public ArrayList<String> input(){
        Scanner input = new Scanner(System.in);
        String inputQuestion = input.nextLine();
        ArrayList<String> q = splitOnSpace(inputQuestion);

        return q;
    }

    public ArrayList<String> splitOnSpace(String line){
        String[] splits = line.split("\\W+");
        return new ArrayList<>(Arrays.asList(splits));
    }

    public String differentQuestions(String q, Answers a){
        ArrayList<String> qw =splitOnSpace(q);

        WordNet w = new WordNet();
        like = w.synonym("love");
        like.retainAll(qw);
        know = w.synonym("know");
        like.retainAll(qw);
        habit = w.synonym("habit");
        habit.retainAll(qw);

        if (like.size()>= 1){
            return a.like();
        }
        else if (know.size()>= 1){
            return a.knowAbout();
        }
        else if (habit.size()>= 1){
            return a.habit();
        }
        else{
            return "I'm sorry I don't understand. Could we talk about something else?";
        }
    }
    public boolean spellCheckReading(String str) {
        return acceptableSpelling(str, "reading");
    }

    public boolean spellCheckBasketball(String str) {
        return acceptableSpelling(str, "basketball");
    }

    public boolean spellCheckCooking(String str) {
        return acceptableSpelling(str, "cooking");
    }

    public boolean spellCheckMovies(String str) {
        return acceptableSpelling(str, "movies");
    }

    public boolean spellCheckPainting(String str) {
        return acceptableSpelling(str, "painting");
    }

    public boolean spellCheckSinging(String str) {
        return acceptableSpelling(str, "singing");
    }

    public boolean spellCheckSwimming(String str) {
        return acceptableSpelling(str, "swimming");
    }

    public static boolean acceptableSpelling(String str, String strGiven) {
        ArrayList<Character> given = new ArrayList<>();
        for (int i = 0; i < strGiven.length(); i++) {
            given.add(strGiven.charAt(i));
        }

        int numNeedCorrect = given.size()/2+2;
        ArrayList<Character> input = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            input.add(str.charAt(i));
        }

        int indexOfLastWord = 0;
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i)==' ')
                indexOfLastWord = i;
        }

        ArrayList<Character> split = new ArrayList<>();
        for (int i = indexOfLastWord; i < input.size(); i++) {
            split.add(input.get(i));
        }

        int correct = 0;
        for(int i = 0; i < given.size(); i++) {
            if (split.contains(given.get(i))) {
                correct++;
                int index = split.indexOf(given.get(i));
                split.remove(index);
            }
        }

        if ( numNeedCorrect <= correct)
            return true;
        else
            return false;
    }


}