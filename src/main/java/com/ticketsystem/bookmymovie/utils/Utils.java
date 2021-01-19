/*
This file contains various functions defined solely for the purpose of the DRY principle.
*/
package com.ticketsystem.bookmymovie.utils;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.*;

public class Utils {
    public static ResponseEntity<Object> badRequest(String message) {
        Map<String, String> response = new LinkedHashMap<>();
        response.put("message", message);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private static Map<String, Object> createJSON(String key, Object object) {
        Map<String, Object> map = new LinkedHashMap<>();
        map.put(key, object);
        return map;
    }

    public static ResponseEntity<Object> okResponse(String dataKey, Object responseData) {
        return new ResponseEntity<>(createJSON(dataKey, responseData), HttpStatus.OK);
    }

}
