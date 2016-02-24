package web;

public class FillInBlankQuestion extends Question {
	
	public static final String BLANK = "__________";
	int questionNumber;
	String question;
	String[] questionInArray;
	int blankIndex;
	

	@Override
	public String getQuestion() {
		return question;
	}

	@Override
	public void setQuestion(String s) {
		question = s;
	}

	@Override
	public int getQuestionNumber() {
		return questionNumber;
	}

	@Override
	public void setQuestionNumber(int i) {
		questionNumber = i;
	}
	
	/*Method specific to Fill in the Blank Questions*/
	
	public void setQuestioninArray(String[] arr) {
		//TODO: think more about how to represent questions; how the user will get to create this type of question
		questionInArray = arr;
	}
	
	public String[] getQuestioninArray() {
		return questionInArray;
	}
	
	public int getBlankIndex() {
		return blankIndex;
	}

}
