package course2.examinerservice;

import course2.examinerservice.domain.Question;
import course2.examinerservice.service.ExaminerService;
import course2.examinerservice.service.ExaminerServiceImpl;
import course2.examinerservice.service.JavaQuestionService;
import course2.examinerservice.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class ExaminerServiceImplTest {
    private final QuestionService questionService = new JavaQuestionService();
    private final ExaminerService examinerService =
            new ExaminerServiceImpl(questionService);

    @Test
    void checkAmountIsZero() {
        Collection<Question> result = examinerService.getQuestions(0);
        assertTrue(result.isEmpty());
    }

    @Test
    void checkRequestedNumberOfUniqueQuestions() {
        questionService.add("Вопрос 1", "Ответ 1");
        questionService.add("Вопрос 2", "Ответ 2");
        questionService.add("Вопрос 3", "Ответ 3");
        Collection<Question> result = examinerService.getQuestions(2);
        assertEquals(2, result.size());
    }

    @Test
    void checkWhenAmountGreaterQuestions() {
        questionService.add("Вопрос 1", "Ответ 1");
        ResponseStatusException exception = assertThrows(ResponseStatusException.class,
                () -> examinerService.getQuestions(2));
        assertEquals(400, exception.getStatusCode().value());
    }

    @Test
    void checkDuplicates() {
        questionService.add("Вопрос 1", "Ответ 1");
        questionService.add("Вопрос 2", "Ответ 2");
        questionService.add("Вопрос 3", "Ответ 3");
        questionService.add("Вопрос 3", "Ответ 3");
        Collection<Question> result = examinerService.getQuestions(3);
        assertEquals(3, result.size());
    }


}
