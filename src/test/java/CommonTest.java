import com.txing.TxingApplication;
import com.txing.project.oj.domain.Question;
import com.txing.project.oj.service.IQuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author lizhiwei
 * @date 2024/4/5 21:27
 * 注释：
 */
@SpringBootTest(classes = TxingApplication.class )
public class CommonTest {


    @Autowired
    private IQuestionService questionService;

    @Test
    void test01() {
        List<Question> list = questionService.list();
        System.out.println(list);
    }



}
