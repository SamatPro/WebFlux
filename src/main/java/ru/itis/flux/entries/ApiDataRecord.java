package ru.itis.flux.entries;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ApiDataRecord {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("albumId")
    private Long albumId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("url")
    private String url;
    @JsonProperty("thumbnailUrl")
    private String otherUrl;

}
