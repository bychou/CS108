package web;

public class PictureResponseFactory extends QuestionsFactory {

	@Override
	public Question getQuestion() {
		return new PictureResponseQuestion();
	}

}
