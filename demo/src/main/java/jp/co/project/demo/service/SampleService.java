package jp.co.project.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.project.demo.db.entity.Sample2Entity;
import jp.co.project.demo.db.repository.Sample2Repository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SampleService {

	private final Sample2Repository repository;
	private final jp.co.project.demo.db.repository.sample1.Sample1Repository sample1Repository;

	@Transactional(transactionManager = "chainedTransactionManager", rollbackFor = Exception.class)
	public void insert(String name) {
		insertSample2(name);
		insertSample1(name);
		throw new NullPointerException();
	}

	public void insertSample2(String name) {
		final var sampleBuilder = Sample2Entity.builder();
		sampleBuilder.name(name);
		repository.insert(sampleBuilder.build());
	}

	public void insertSample1(String name) {
		final var sampleBuilder = jp.co.project.demo.db.sample1.entity.Sample1Entity.builder();
		sampleBuilder.name(name);
		sample1Repository.insert(sampleBuilder.build());
	}
}
