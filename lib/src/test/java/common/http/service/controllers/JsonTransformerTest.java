package common.http.service.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonTransformerTest {
    private JsonTransformer transformer;

    @BeforeEach
    void setup() {
        transformer = new JsonTransformer();
    }

    @Test
    void givenNullObjectShouldReturnsStringJson() {
        String result = transformer.render(null);

        String expectedResult = "null";
        assertEquals(expectedResult, result);
    }

    @Test
    void givenEmptyObjectShouldReturnsStringJson() {
        Object object = new Object();
        String result = transformer.render(object);

        String expectedResult = "{}";
        assertEquals(expectedResult, result);
    }
}
