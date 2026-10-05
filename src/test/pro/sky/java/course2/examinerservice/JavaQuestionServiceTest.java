package course2.examinerservice;

import course2.examinerservice.domain.Question;
import course2.examinerservice.service.JavaQuestionService;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaQuestionServiceTest {
    private final JavaQuestionService service = new JavaQuestionService();

    @Test
    void checkAddQuestion() {
        Question question = service.add("Что такое JAVA?",
                "Это один из языков программирования");
        assertEquals("Что такое JAVA?", question.getQuestion());
        assertEquals("Это один из языков программирования", question.getAnswer());
    }

    @Test
    void checkAddQuestionObject() {
        Question question = new Question("А что такое JVM?",
                "Это виртуальная машина, которая запускает Java-программы");
        Question result = service.add(question);
        assertEquals(question, result);
        assertEquals(1, service.getAll().size());
    }

    @Test
    void checkRemoveExistingQuestion() {
        Question question = new Question("А что такое JVM?",
                "Это виртуальная машина, которая запускает Java-программы");
        service.add(question);
        Question result = service.remove(question);
        assertEquals(question, result);
        assertEquals(0, service.getAll().size());
    }

    @Test
    void checkWhenRemovingAbsentQuestion() {
        Question question = new Question("Что такое JAVA?",
                "Это один из языков программирования");
        Question result = service.remove(question);
        assertEquals(null, result);
        assertEquals(0, service.getAll().size());
    }

    @Test
    void checkReturnAllQuestions() {
        Question question1 = new Question("Что такое JAVA?",
                "Это один из языков программирования");
        Question question2 = new Question("А что такое JVM?",
                "то виртуальная машина, которая запускает Java-программы");
        service.add(question1);
        service.add(question2);
        Collection<Question> result = service.getAll();
        assertEquals(2, result.size());
        assertEquals(true, result.contains(question1));
        assertEquals(true, result.contains(question2));
    }

    @Test
    void checkEmptyCollection() {
        Collection<Question> result = service.getAll();
        assertEquals(0, result.size());
    }

    @Test
    void checkdReturnNullForEmptyCollection() {
        Question result = service.getRandomQuestion();
        assertEquals(null, result);
    }

    @Test
    void shouldReturnRandomQuestion() {
        Question question1 = new Question("Что такое JAVA?",
                "Это один из языков программирования");
        Question question2 = new Question("А что такое JVM?",
                "то виртуальная машина, которая запускает Java-программы");
        service.add(question1);
        service.add(question2);
        Question result = service.getRandomQuestion();
        assertEquals(true, result.equals(question1) || result.equals(question2));
    }
}
