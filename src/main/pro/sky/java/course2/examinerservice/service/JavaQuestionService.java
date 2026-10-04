package course2.examinerservice.service;

import course2.examinerservice.domain.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JavaQuestionService implements QuestionService{
    private final Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        return null;
    }

    @Override
    public Question add(Question question) {
        return null;
    }

    @Override
    public Question remove(Question question) {
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return List.of();
    }

    @Override
    public Question getRandomQuestion() {
        return null;
    }
}
