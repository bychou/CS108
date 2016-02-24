package web;

public class AbstractFactory {
	
	public QuestionsFactory getQuestionFactory(String type) {

		if("FillInBlank".equals(type)) {
			return new FillInBlankFactory();
		}
		
		else if("QuestionResponse".equals(type)) {
			return new QuestionResponseFactory();
		}
		
		else if("MultipleChoice".equals(type)) {
			return new MultipleChoiceFactory();
		}
		
		else if("PictureResponse".equals(type)) {
			return new PictureResponseFactory();
		}
		return null;
	}

}
