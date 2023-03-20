package com.springdream.app.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
//@NoArgsConstructor
@RequiredArgsConstructor
public class PointDTO {
    private long currentPoint;
    private long totalPoint;
    private long memberNumber;
}
