package api.models.args.projects;

import api.models.args.BaseModel;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectName extends BaseModel {
    private String name;
}
