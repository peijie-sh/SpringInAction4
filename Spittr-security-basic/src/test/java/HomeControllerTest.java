import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import spittr.web.HomeController;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Author LPJ
 * Date 2016/12/12
 */
public class HomeControllerTest {

    // 普通测试方法，测试方法返回值
    @Test
    public void testHomePage() throws Exception {
        HomeController homeController = new HomeController();
        assertEquals("home", homeController.home());
    }

    // Spring3.2新特性,测试控制器和返回的视图
    @Test
    public void testHomePage2() throws Exception {
        HomeController controller = new HomeController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/")).andExpect(view().name("home"));
    }

}
