/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.4.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package ch.bbw.m226.openapi.generated.controller;

import ch.bbw.m226.openapi.generated.dto.DriverDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Validated
@Tag(name = "driver", description = "the driver API")
public interface DriverApi {

    /**
     * GET /driver : List all drivers (funktioniert noch nicht)
     *
     * @param limit How many items to return at one time (optional)
     * @return An paged array of drivers (status code 200)
     */
    @Operation(
        operationId = "driverGet",
        summary = "List all drivers (funktioniert noch nicht)",
        responses = {
            @ApiResponse(responseCode = "200", description = "An paged array of drivers", content = @Content(mediaType = "application/json", schema = @Schema(implementation =  DriverDto.class)))
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/driver",
        produces = { "application/json" }
    )
    ResponseEntity<List<DriverDto>> driverGet(
        @Parameter(name = "limit", description = "How many items to return at one time", schema = @Schema(description = "")) @Valid @RequestParam(value = "limit", required = false) Integer limit
    );

}
