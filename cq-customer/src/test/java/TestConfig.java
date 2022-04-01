import com.ali.cq.CQCustomerApplication;
import com.ali.cq.testCompletable.service.ICompletableService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest(classes = CQCustomerApplication.class)
@RunWith(SpringRunner.class)
public class TestConfig {
    @Resource
    private ICompletableService completableService;

    @Test
    public void test1() {
        try {
            completableService.testCompletableMethod();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(1);
    }
}
