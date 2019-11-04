package jp.co.project.demo.emuns;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApiVersionEnum {

	V1("v1"),
	V2("v2");

	private final String version;
}
