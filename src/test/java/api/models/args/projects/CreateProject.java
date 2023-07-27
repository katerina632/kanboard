package api.models.args.projects;

import api.models.args.BaseModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateProject extends BaseModel {
    private String name;
    private String description ;
    private String owner_id ;
    private String identifier ;
    private String start_date ;
    private String end_date ;
}
