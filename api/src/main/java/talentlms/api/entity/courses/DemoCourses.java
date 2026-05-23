package talentlms.api.entity.courses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;
import talentlms.api.entity.BaseEntity;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class DemoCourses extends BaseEntity {
    String id;
    String name;
    String code;
    @JsonProperty(value = "category_id")
    String categoryId;
    String description;
    String price;
    String status;
    List<DemoUser> users;

}
