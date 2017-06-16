import com.imory.App;
import com.imory.bean.UserDemo;
import com.imory.service.UserDemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/6/16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class ApplicationTests {

    @Resource
    private UserDemoService userDemoService;

    @Test
    public void testSave()
    {
        UserDemo userDemo = new UserDemo();
        userDemo.setUserName("测试用户3");
        userDemoService.save(userDemo);
    }
}
