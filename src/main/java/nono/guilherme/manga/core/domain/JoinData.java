package nono.guilherme.manga.core.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class JoinData {
    @JsonProperty(value = "serie_category")
    @JsonAlias({"id_serie_category"})
    long serieCategoryId;

    @JsonProperty(value = "serie")
    @JsonAlias({"id_serie"})
    long serieId;

    @JsonProperty(value = "category")
    @JsonAlias({"id_category"})
    long categoryId;
}
