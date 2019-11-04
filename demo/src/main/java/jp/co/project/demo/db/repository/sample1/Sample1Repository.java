package jp.co.project.demo.db.repository.sample1;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

import jp.co.project.demo.db.sample1.entity.Sample1Entity;
import jp.co.project.demo.db.sample1.mapper.Sample1Mapper;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Sample1Repository {

	private final Sample1Mapper sampleMapper;

	public List<Sample1Entity> select() {
		return sampleMapper.select(new RowBounds(RowBounds.NO_ROW_OFFSET, RowBounds.NO_ROW_LIMIT));
	}

	public void insert(Sample1Entity entity) {
		entity.setId(UUID.randomUUID().toString().replace("-", ""));
		entity.setCreatedUser("system");
		entity.setCreatedDate(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
		entity.setUpdatedUser("system");
		entity.setUpdatedDate(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
		sampleMapper.insert(entity);
	}
}
