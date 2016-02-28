package web;

public class QuestionsFactory {
	
	public Question getQuestion(String quesType) {
		if (quesType.equals("question-response")) {
			return new QuestionResponseQuestion();
		} else if (quesType.equals("fill-in-blank")) {
			return new FillInBlankQuestion();
		} else if (quesType.equals("multiple-choice")) {
			return new MultipleChoiceQuestion();
		} else if (quesType.equals("picture-response")) {
			return new PictureResponseQuestion();
		} else if (quesType.equals("multiple-choice-multiple-answer")) {
			return new MultipleChoiceAnswerQuestion();
		} else if (quesType.equals("multiple-answer-ordered")) {
			return new MultipleAnswerOrderedQuestion();
		} else if (quesType.equals("multiple-answer-unordered")) {
			return new MultipleAnswerUnOrderedQuestion();
		} else if (quesType.equals("matching")) {
			return new MatchingQuestion();
		}
		return null;
	}
}
