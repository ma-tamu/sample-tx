package jp.co.project.demo.db.repository;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

import jp.co.project.demo.db.entity.Sample2Entity;
import jp.co.project.demo.db.mapper.Sample2Mapper;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Sample2Repository {

	private final Sample2Mapper sampleMapper;

	public List<Sample2Entity> select() {
		return sampleMapper.select(new RowBounds(RowBounds.NO_ROW_OFFSET, RowBounds.NO_ROW_LIMIT));
	}

	public void insert(Sample2Entity entity) {
		entity.setId(UUID.randomUUID().toString().replace("-", ""));
		entity.setCreatedUser("system");
		entity.setCreatedDate(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
		entity.setUpdatedUser("system");
		entity.setUpdatedDate(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
		sampleMapper.insert(entity);
	}
}
