package uz.shifotop.api.clinic.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;

@Slf4j
@Setter
@Getter
public class PageSettings {

    private int page = 0;

    private int pageSize = 10;

    private String direction = "asc";

    private String key;



    public Sort buildSort() {
        switch (direction) {
            case "desc":
                return Sort.by(key).descending();
            case "asc":
                return Sort.by(key).ascending();
            default:
                log.warn("Invalid direction provided in PageSettings, using descending direction as default value");
                return Sort.by(key).descending();
        }
    }
}