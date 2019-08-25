package model;

import java.io.Serializable;

public class Quiz_count implements Serializable {
	private int ques_count;
	private int kaito_count;
	public Quiz_count() {	}


	public int getQues_count() {
		return ques_count;
	}
	public void setQues_count(int ques_count) {
		this.ques_count = ques_count;
	}
	public int getKaito_count() {
		return kaito_count;
	}
	public void setKaito_count(int kaito_count) {
		this.kaito_count = kaito_count;
	}
}