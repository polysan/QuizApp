package model;

import java.io.Serializable;

//回答した問題数と正解した問題数を記録するクラス
public class QuizCount implements Serializable {
	private int quesCount;
	private int correctAnswerCount;
	public QuizCount() {	}


	public int getQuesCount() {
		return quesCount;
	}
	public void setQuesCount(int quescount) {
		this.quesCount = quescount;
	}
	public int getCorrectAnswerCount() {
		return correctAnswerCount;
	}
	public void setCorrectAnswerCount(int correctAnswerCount) {
		this.correctAnswerCount = correctAnswerCount;
	}
}