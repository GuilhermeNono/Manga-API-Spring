package nono.guilherme.manga.entrypoint.http.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import nono.guilherme.manga.core.domain.MangaInfo;
import nono.guilherme.manga.core.usecase.GetSerieByQuery;
import nono.guilherme.manga.entrypoint.http.request.MangaQueryRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/manga")
public class MangaScrapController {

    private final GetSerieByQuery getSerieByQuery;

    @PostMapping(value = "/search")
    public ResponseEntity<MangaInfo> getSeriesByQuery(@RequestBody MangaQueryRequest manga) throws JsonProcessingException {
        var teste = getSerieByQuery.process(manga);
        return ResponseEntity.ok(teste);
    }

}

