package uz.shifotop.api.address.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public record AddressRequestDto(
        @Schema(name = "Chilanzar") @JsonProperty("region_name") String regionName,
        @Schema(name = "Tashkent")@JsonProperty("city_name") String cityName,
        @Schema(name = "12-dom, 24-uy")@JsonProperty("address_name") String addressName
) {
}
