package talentlms.api.controllers;

import lombok.Getter;

import org.testng.Assert;
import talentlms.api.ApiRequest;
import talentlms.api.asserts.ApiAssert;
import talentlms.api.entity.AddUserToCourse;
import talentlms.api.entity.Course;
import talentlms.api.entity.courses.DemoCourses;
import talentlms.api.enums.ResponseValidationMessage;

import java.util.HashMap;
import java.util.Map;

import static talentlms.api.TalentLMSEndpoints.*;

public class CourseController extends ApiRequest {

    public CourseController(String url) {
        super(url);
    }

    public Course[] getCourse() {
        return super.get(getEndpoint(API, V1, COURSES)).as(Course[].class);
    }

    public Course createCourse(Course course) {
        return super.post(getEndpoint(API, V1, CREATE_COURSE), course.toJson()).as(Course.class);
    }

    public AddUserToCourse[] addUserToCourse(AddUserToCourse user) {
        return super.post(getEndpoint(API, V1, ADD_USER_TO_COURSE), user.toJson()).as(AddUserToCourse[].class);
    }

    public DemoCourses getDemoCourse(String Id) {
        HashMap<String, String> params = new HashMap<>() {{
            put("id", Id);
        }};
        return super.get(getEndpoint(API, V1, COURSES, formatParameter(params))).as(DemoCourses.class);
    }

    public Course getCourseBy(By by, String value) {
        HashMap<String, String> parameters = new HashMap<>() {{
            put(by.getKey(), value);
        }};
        return super.get(getEndpoint(API, V1, COURSES
                , formatParameter(parameters))).as(Course.class);
    }

    public void deleteCourse(String courseId) {
        Map<String, String> params = new HashMap<>() {{
            put("course_id", courseId);
            put("delete_by_course_id", "1");
        }};
        String validationMessage = super.post(getEndpoint(API, V1, DELETE_COURSE), params).jsonPath().getString("message");

        ApiAssert.assertThat(response).isCorrectStatusCode(200);
        Assert.assertEquals(validationMessage, ResponseValidationMessage.SUCCESS_OPERATION_COURSE.getMessage());


    }

    @Getter
    public enum By {
        ID("id");
        public final String key;

        By(String key) {
            this.key = key;
        }
    }
}
