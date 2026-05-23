package talentLMS.api_tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import talentlms.api.asserts.ApiAssert;
import talentlms.api.controllers.SystemController;
import talentlms.api.entity.SystemClass;

public class SystemTest extends BaseApiTest {
    SystemController systemController;

    @BeforeClass
    public void beforeClass () {
        systemController = application.getSystemController();
    }

    @Test
    public void getSystem () {
        SystemClass systemClass = systemController.getSystem();
        System.out.println(systemClass);
        ApiAssert.assertThat(systemController.getResponse())
                .isCorrectStatusCode(200);
    }
}
