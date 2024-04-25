package uz.shifotop.api.search.service;

import uz.shifotop.api.search.dto.SearchResultsDto;

public interface SearchService {
    SearchResultsDto search(String query);

}
