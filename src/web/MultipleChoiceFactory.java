package web;

public class MultipleChoiceFactory extends QuestionsFactory {

	@Override
	public Question getQuestion() {
		return new MultipleChoiceQuestion();
	}

}
