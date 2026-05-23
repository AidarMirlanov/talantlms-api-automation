package talentlms.api.application;

import lombok.Data;
import talentlms.api.controllers.CategoriesController;
import talentlms.api.controllers.CourseController;
import talentlms.api.controllers.SystemController;
import talentlms.api.controllers.UserController;


@Data
public class TalentLMSApplication {


    private UserController userController;
    private CourseController courseController;
    private SystemController systemController;
    private CategoriesController categoriesController;

    public TalentLMSApplication(String url) {

        this.userController = new UserController(url);
        this.courseController = new CourseController(url);
        this.systemController = new SystemController(url);
        this.categoriesController = new CategoriesController(url);
    }
}