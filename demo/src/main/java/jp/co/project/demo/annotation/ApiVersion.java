package jp.co.project.demo.annotation;

import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import jp.co.project.demo.emuns.ApiVersionEnum;


@Documented
@Retention(CLASS)
public @interface ApiVersion {

	ApiVersionEnum version();
}
