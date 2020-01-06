package model;

public class QuizOneSet {
//	問題文格納変数
	private String question;
//	回答群格納変数
	private String [] answers = new String [4];
//	正解の回答格納変数
	private String correctAnswer;

//	選択肢のシャッフル
	public static void ArrayOrderRandom(String[] ary ) {
		for ( int i = 0; i < ary.length; ++ i ) {
			int rnd = (int)( Math.random() * (double)ary.length );
			String w = ary[ i ];
			ary[ i ] = ary[ rnd ];
			ary[ rnd ] = w;
		}
	}
//	全問題のシャッフル
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
	public String getcorrectAnswer() {
		return correctAnswer;
	}
	public void setcorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
}
