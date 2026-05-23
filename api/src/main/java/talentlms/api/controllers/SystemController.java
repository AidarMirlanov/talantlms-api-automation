package talentlms.api.controllers;

import talentlms.api.ApiRequest;
import talentlms.api.entity.SystemClass;

import static talentlms.api.TalentLMSEndpoints.*;

public class SystemController extends ApiRequest {

    public SystemController(String url) {
        super(url);
    }

    public SystemClass getSystem () {
        return super.get(getEndpoint(API, V1, SITE_INFO)).as(SystemClass.class);
    }
}
