import com.ruoyi.RuoYiApplication;
import com.ruoyi.project.oj.controller.QuestionController;
import com.ruoyi.project.oj.domain.Question;
import com.ruoyi.project.oj.service.IQuestionService;
import com.ruoyi.project.oj.service.impl.QuestionServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author lizhiwei
 * @date 2024/4/5 21:27
 * 注释：
 */
@SpringBootTest(classes = RuoYiApplication.class )
public class CommonTest {


    @Autowired
    private IQuestionService questionService;

    @Test
    void test01() {
        List<Question> list = questionService.list();
        System.out.println(list);
    }



}
