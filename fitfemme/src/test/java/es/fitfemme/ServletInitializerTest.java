package es.fitfemme;

import org.junit.jupiter.api.Test;
import org.springframework.boot.builder.SpringApplicationBuilder;

import static org.junit.jupiter.api.Assertions.*;

public class ServletInitializerTest {

    @Test
    public void configureTest() {
        // Arrange
        ServletInitializer servletInitializer = new ServletInitializer();

        // Act
        SpringApplicationBuilder builder = servletInitializer.configure(new SpringApplicationBuilder());

        // Assert
        assertNotNull(builder, "SpringApplicationBuilder should not be null");
    }
}
