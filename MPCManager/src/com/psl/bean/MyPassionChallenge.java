package com.psl.bean;

public class MyPassionChallenge {
	private int hiringID;
	private Domain domain;
	private int objectiveScore;
	private int subjectiveScore;
	private Student student;
	private Result result;
	private PassedIn passedin;

	public int getHiringID() {
		return hiringID;
	}

	public void setHiringID(int hiringID) {
		this.hiringID = hiringID;
	}

	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}

	public int getObjectiveScore() {
		return objectiveScore;
	}

	public void setObjectiveScore(int objectiveScore) {
		this.objectiveScore = objectiveScore;
	}

	public int getSubjectiveScore() {
		return subjectiveScore;
	}

	public void setSubjectiveScore(int subjectiveScore) {
		this.subjectiveScore = subjectiveScore;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public PassedIn getMpc() {
		return passedin;
	}

	public void setMpc(PassedIn passedin) {
		this.passedin = passedin;
	}

}
