package com.mysite.haru;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mysite.haru.answer.Answer;
import com.mysite.haru.answer.AnswerRepository;
import com.mysite.haru.question.Question;
import com.mysite.haru.question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import java.time.LocalDateTime;

@SpringBootTest
class HaruApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private AnswerRepository answerRepository;

	@Test
	void testJpa() {
		Optional<Question> oq = this.questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();

		Answer a = new Answer();
		a.setContent("hi~!");
		a.setQuestion(q);
		a.setCreateDate(LocalDateTime.now());
		this.answerRepository.save(a);
	}

}
