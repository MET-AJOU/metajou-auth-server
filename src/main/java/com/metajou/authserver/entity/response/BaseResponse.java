package com.metajou.authserver.entity.response;

import com.metajou.authserver.exception.ExceptionCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

@Builder
@AllArgsConstructor
public class BaseResponse {

    private Object body;
    private MediaType contentType = MediaType.APPLICATION_JSON;
    private ExceptionCode except = null;

    public Mono<ResponseEntity> toMonoEntity() {
        return Mono.just(this.toEntity());
    }

    public ResponseEntity toEntity() {
        if(except == null) {
            return ResponseEntity.ok()
                    .contentType(contentType)
                    .body(new ResponseWrapper(body));
        }
        return ResponseEntity.status(except.build().getStatus())
                .contentType(contentType)
                .body(new ResponseWrapper(body, except));
    }
}
