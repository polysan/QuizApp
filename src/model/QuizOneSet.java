package model;

public class QuizOneSet {
	private String question;
	private String [] answers = new String [4];

	public static void ArrayOrderRandom(String[] ary ) {
		for ( int i = 0; i < ary.length; ++ i ) {
			int rnd = (int)( Math.random() * (double)ary.length );
			String w = ary[ i ];
			ary[ i ] = ary[ rnd ];
			ary[ rnd ] = w;
		}
	}
	public static void ArrayOrderRandom(QuizOneSet[] ary ) {
		for ( int i = 0; i < ary.length; ++ i ) {
			int rnd = (int)( Math.random() * (double)ary.length );
			QuizOneSet w = ary[ i ];
			ary[ i ] = ary[ rnd ];
			ary[ rnd ] = w;
		}
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String [] getAnswers() {
		return answers;
	}
	public void setAnswers(String [] answers) {
		this.answers = answers;
	}
}
