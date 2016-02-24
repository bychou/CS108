package web;

public class FillInBlankFactory extends QuestionsFactory {

	@Override
	public Question getQuestion() {
		return new FillInBlankQuestion();
	}

}
