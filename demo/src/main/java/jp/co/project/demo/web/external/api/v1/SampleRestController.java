package jp.co.project.demo.web.external.api.v1;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jp.co.project.demo.annotation.ApiVersion;
import jp.co.project.demo.emuns.ApiVersionEnum;
import jp.co.project.demo.service.SampleService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("sample")
@RequiredArgsConstructor
@ApiVersion(version = ApiVersionEnum.V1)
public class SampleRestController {

	private final SampleService service;

	@PostMapping
	public String post(@RequestParam String name) {
		service.insert(name);
		return "ok";
	}
}
