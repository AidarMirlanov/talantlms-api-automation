package talentlms.api.controllers;

import lombok.Getter;
import talentlms.api.ApiRequest;
import talentlms.api.entity.BuyCategory;
import talentlms.api.entity.Categories;


import java.util.HashMap;

import static talentlms.api.TalentLMSEndpoints.*;

public class CategoriesController extends ApiRequest {
    public CategoriesController(String url) {
        super(url);
    }
    public Categories [] getCategory (){
        return super.get(getEndpoint(API,V1,CATEGORIES)).as(Categories[].class);

    }
    public Categories getCourseBy(CategoriesController.By by, String value) {
        HashMap<String, String> parameters = new HashMap<>() {{
            put(by.getKey(), value);
        }};
        return super.get(getEndpoint(API, V1, CATEGORIES
                ,formatParameter(parameters))).as(Categories.class);
    }

    public BuyCategory buyCategoryId (BuyCategory buyCategory) {
        return super.post(getEndpoint(API,V1, BUY_CATEGORY_COURSES),buyCategory.toJson()).as(BuyCategory.class);
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
