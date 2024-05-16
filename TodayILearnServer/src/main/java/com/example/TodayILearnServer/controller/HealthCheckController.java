package com.example.TodayILearnServer.controller;

import com.example.TodayILearnServer.dto.common.HealthCheckResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/health")
public class HealthCheckController {

    @GetMapping("/v1")
    public Map<String, String> healthCheck() {
        // response를 만드는 방식
        Map<String, String> response = new HashMap<>();
        response.put("status", "v1 OK");

        return response;
    }

    @GetMapping("/v2")
    public ResponseEntity<String> healthCheckV2() {
        return ResponseEntity.ok("v2 OK");
    }

    @GetMapping("/v3")
    public String healthCheckV3() {
        return "v3 OK"; // String을 return하는 경우 plain/text media type을 응답
    }

    @GetMapping("/v4")
    public String healthCheckV4() {
        Person person = new Person("HA", "JIEUN");
        Person person2 = Person.builder() // Builder 패턴 적용
                .lastName("HA")
                .firstName("JIEUN")
                .build();
        return "v4 ok";
    }

    @GetMapping("/v5")
    public ResponseEntity<Map<String, String>> healthCheckV5() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "v5 OK");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/v6")
    public ResponseEntity<HealthCheckResponse> healthCheckV6() {
        return ResponseEntity.ok(new HealthCheckResponse());
    }
}
