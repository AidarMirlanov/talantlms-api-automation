package talentlms.api.entity.courses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;
import talentlms.api.entity.BaseEntity;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class DemoUser extends BaseEntity {

    String id;
    String name;
    String role;
    @JsonProperty(value = "enrolled_on")
    String enrolledOn;
    @JsonProperty(value = "enrolled_on_timestamp")
    String enrolledOnTimestamp;
    @JsonProperty(value = "completed_on")
    String completedOn;
    @JsonProperty(value = "completed_on_timestamp")
    Object completedOnTimestamp;
    @JsonProperty(value = "completion_percentage")
    String completionPercentage;
    @JsonProperty(value = "expired_on")
    String expiredOn;
    @JsonProperty(value = "expired_on_timestamp")
    String expiredOnTimestamp;
    @JsonProperty(value = "total_time")
    String totalTime;
    @JsonProperty(value = "total_time_seconds")
    int totalTimeSeconds;
}
