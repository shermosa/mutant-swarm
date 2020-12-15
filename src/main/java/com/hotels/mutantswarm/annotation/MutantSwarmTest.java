package com.hotels.mutantswarm.annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestTemplate;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Tag("mutantswarm")
@TestTemplate
public @interface MutantSwarmTest {
}
