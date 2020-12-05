import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Conversation {

	public String userAskQuestion(ArrayList<String> question) {
		if (question.contains("reading")) {
			Answers r = new Reading();
			return differentQuestions(question, r);
		} else if (question.contains("basketball")) {
			Answers b = new Basketball();
			return differentQuestions(question, b);
		} else if (question.contains("cooking")) {
			Answers c = new Cooking();
			return differentQuestions(question, c);
		} else if (question.contains("painting")) {
			Answers p = new Painting();
			return differentQuestions(question, p);
		} else if (question.contains("movies")) {
			Answers m = new Movies();
			return differentQuestions(question, m);
		} else if (question.contains("swimming")) {
			Answers s = new Swimming();
			return differentQuestions(question, s);
		} else if (question.contains("singing")) {
			Answers sing = new Singing();
			return differentQuestions(question, sing);
		} else {
			if (question.contains("like")) {
				return "Sorry, I haven't tried it before. Do you want to introduce it for me?";
			} else if (question.contains("bye")) {
				return "It's nice talking to you. Bye.";
			} else if (question.contains("hi") || question.contains("hello")) {
				return "Hi! Nice to meet you!";
			} else if (question.size() == 0) {
				return "That's interesting!";
			}
			return "I'm sorry I don't understand. Could we talk about something else?";
		}
	}

	public ArrayList<String> input() {
		Scanner input = new Scanner(System.in);
		String inputQuestion = input.nextLine();
		ArrayList<String> q = splitOnSpace(inputQuestion);
		input.close();
		return q;
	}

	public ArrayList<String> splitOnSpace(String line) {
		String[] splits = line.split("\\W+");
		return new ArrayList<>(Arrays.asList(splits));
	}

	public String differentQuestions(ArrayList<String> q, Answers a) {
		if (q.contains("like")) {
			return a.like();
		} else if (q.contains("know") && q.contains("about")) {
			return a.knowAbout();
		} else if (q.contains("habit")) {
			return a.habit();
		}
		return "That's interesting!";
	}

	public boolean acceptableSpelling(String str) {

		return true;
	}
}