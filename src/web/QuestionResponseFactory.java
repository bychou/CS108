package web;

public class QuestionResponseFactory extends QuestionsFactory {

	@Override
	public Question getQuestion() {
		return new QuestionResponseQuestion();
	}

}
