package com.applicastertest.alecmedina.mylocalposts.models.autoValue;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.TYPE;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by alec.medina on 8/1/17.
 */

@Target(TYPE)
@Retention(RUNTIME)
public @interface AutoGson {
}
