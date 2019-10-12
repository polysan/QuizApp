package model;

import java.io.Serializable;

public class QuizCount implements Serializable {
	private int quesCount;
	private int kaitoCount;
	public QuizCount() {	}


	public int getQuesCount() {
		return quesCount;
	}
	public void setQuesCount(int quescount) {
		this.quesCount = quescount;
	}
	public int getKaitoCount() {
		return kaitoCount;
	}
	public void setKaitoCount(int kaitocount) {
		this.kaitoCount = kaitocount;
	}
}