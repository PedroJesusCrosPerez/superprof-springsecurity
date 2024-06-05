package app.superprof.shared;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Setter
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class CustomError {

    @NonNull
    private HttpStatus status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime datetime = LocalDateTime.now();

    @NonNull
    private String message;

    private String field;
}
