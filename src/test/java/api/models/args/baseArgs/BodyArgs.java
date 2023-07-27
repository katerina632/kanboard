package api.models.args.baseArgs;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class BodyArgs<T> {
    @Builder.Default
    private String jsonrpc = "2.0";
    private String method;
    @Builder.Default
    private int id = 8981960;
    private T params;

}
