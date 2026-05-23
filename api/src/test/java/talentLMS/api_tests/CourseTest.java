package talentLMS.api_tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import talentlms.api.asserts.ApiAssert;
import talentlms.api.controllers.CourseController;
import talentlms.api.controllers.UserController;
import talentlms.api.entity.AddUserToCourse;
import talentlms.api.entity.Course;
import talentlms.api.entity.User;
import talentlms.api.entity.courses.DemoCourses;
import talentlms.api.utils.EntityManager;

import java.util.Arrays;

public class CourseTest extends BaseApiTest {
    User user;
    Course course;
    UserController userController;
    CourseController courseController;


    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        userController = application.getUserController();
        courseController = application.getCourseController();

    }
    @Test
    public User createUser () {
        User expectedUser = EntityManager.generateUser();
        User actual = userController.createUser(expectedUser);
        return actual;
    }

    @Test
    public Course createCourseWithCategory () {
        Course expectedCourse = EntityManager.generateCourseWithCategoryId("4");
        Course actual = courseController.createCourse(expectedCourse);
        return actual;
    }

    @Test
    public void getAllCourseTest() {
        Course[] courses = courseController.getCourse();
        System.out.println(Arrays.toString(courses));
        ApiAssert.assertThat(courseController.getResponse())
                .isCorrectStatusCode(200);
    }

    @Test
    public void getCourseById() {
        courseController.getCourseBy(CourseController.By.ID, "127");

    }

    @Test
    public void addUserToCourseWithCategory4() {
        course = createCourseWithCategory();


        user = createUser();


        AddUserToCourse addUserToCourse = AddUserToCourse.builder()
                .user_id(user.getId())
                .course_id(course.getId())
                .role("learner")  // Роль всегда "learner"
                .build();



        AddUserToCourse[] actual = courseController.addUserToCourse(addUserToCourse);
        Assert.assertEquals(actual[0].getUser_id(), user.getId());
        Assert.assertEquals(actual[0].getCourse_id(), course.getId());
        Assert.assertEquals(actual[0].getRole(), addUserToCourse.getRole());
    }
    @Test
    public void getDemoCourse (){
        DemoCourses demoCourses = courseController.getDemoCourse("127");
        System.out.println(demoCourses.getUsers());
    }


}



