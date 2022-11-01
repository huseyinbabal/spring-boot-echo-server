package com.example.springbootechoserver;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/echo")
public class EchoController {

    private final ObjectMapper mapper;

    public EchoController(ObjectMapper mapper) {
        this.mapper = new ObjectMapper();
    }

    @GetMapping
    public Map<String, String> echo(HttpServletRequest request) {
        final Map<String, String> headers  = Collections.list(request.getHeaderNames()).stream()
            .collect(Collectors.toMap(Function.identity(), request::getHeader));
        return headers;
    }
}
