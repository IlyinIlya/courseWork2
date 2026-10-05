package course2.examinerservice.controller;

import course2.examinerservice.domain.Question;
import course2.examinerservice.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/exam/java/add")
    public Question addQuestion(@RequestParam String question,
                                @RequestParam String answer) {
        return questionService.add(question, answer);
    }

    @DeleteMapping("/exam/java/remove")
    public Question removeQuestion(@RequestParam String question,
                                   @RequestParam String answer) {
        return questionService.remove(new Question(question, answer));
    }

    @GetMapping("/exam/java")
    public Collection<Question> getAllQuestions() {
        return questionService.getAll();
    }
}
