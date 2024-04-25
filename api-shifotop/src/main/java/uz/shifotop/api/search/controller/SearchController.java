package uz.shifotop.api.search.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.shifotop.api.search.dto.SearchResultsDto;
import uz.shifotop.api.search.service.SearchService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class SearchController {
    private final SearchService searchService;



    @GetMapping("/search")
    public ResponseEntity<SearchResultsDto> search(@RequestParam String term) {
        SearchResultsDto results = searchService.search(term);
        return ResponseEntity.ok(results);
    }
}
