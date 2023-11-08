package net.celloscope.vision.getPostById.model;

import com.google.gson.GsonBuilder;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private String id;
    private String title;
    private String content;
    private String metaDataJson;
    private String status;
    private String createdAt;
    private String updatedAt;
    private String version;

    @Override
    public String toString() {
        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
    }
}
