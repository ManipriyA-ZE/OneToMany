package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Question {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int qId;
	private String qDesc;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="question")
	private List<Answer> answers;
	public int getqId() {
		return qId;
	}
	public void setqId(int qId) {
		this.qId = qId;
	}
	public String getqDesc() {
		return qDesc;
	}
	public void setqDesc(String qDesc) {
		this.qDesc = qDesc;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	public Question(int qId, String qDesc, List<Answer> answers) {
		super();
		this.qId = qId;
		this.qDesc = qDesc;
		this.answers = answers;
	}
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Question [qId=" + qId + ", qDesc=" + qDesc + ", answers=" + answers + "]";
	}
	

}
