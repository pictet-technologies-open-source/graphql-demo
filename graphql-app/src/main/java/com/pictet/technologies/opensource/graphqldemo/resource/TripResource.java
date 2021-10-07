package com.pictet.technologies.opensource.graphqldemo.resource;

import lombok.Data;

@Data
public class TripResource {
    private ClientResource client;
    private String name;

    @Data
    static class ClientResource {
        private String name;
        private Integer age;
    }
}
