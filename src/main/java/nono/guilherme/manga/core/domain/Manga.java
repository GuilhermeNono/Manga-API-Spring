package nono.guilherme.manga.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({ "id" })
public class Manga {

    @JsonProperty(value = "id_serie")
    private long id;
    private String name;
    private String label;
    private String value;
    private String author;
    private String score;
    private String artist;
    private List<Category> categories;
    private String cover;
    @JsonProperty(value = "cover_thumb")
    private String coverThumb;
    @JsonProperty(value = "cover_avif")
    private String coverAvif;
    @JsonProperty(value = "cover_thumb_avif")
    private String coverThumbAvif;
    private String link;
    @JsonProperty(value = "is_complete")
    private boolean isComplete;

}
