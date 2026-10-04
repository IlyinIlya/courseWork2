package course2.examinerservice.service;

import course2.examinerservice.domain.Question;

import java.util.*;

public class JavaQuestionService implements QuestionService{
    private final Set<Question> questions = new HashSet<>();
    private final Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        Question questionN = new Question(question, answer);
        questions.add(questionN);
        return questionN;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (questions.remove(question)) {
            return question;
        }
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return new HashSet<>(questions);
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            return null;
        }
        int index = random.nextInt(questions.size());
        return new ArrayList<>(questions).get(index);
    }
}
