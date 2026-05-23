package talentLMS.api_tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import talentlms.api.controllers.CategoriesController;
import talentlms.api.entity.BuyCategory;
import talentlms.api.entity.Categories;

public class CategoryTest extends BaseApiTest {

    CategoriesController categoriesController;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        categoriesController = application.getCategoriesController();
    }
    @Test
    public void getCategory () {
        Categories [] categories = categoriesController.getCategory();
    }

    @Test
    public void getCategoryId () {
        categoriesController.getCourseBy(CategoriesController.By.ID, "4");
    }

    @Test
    public void buyCategory () {
        BuyCategory buyCategory = categoriesController.buyCategoryId(BuyCategory.builder().user_id("1").category_id("4").build());
    }
}
