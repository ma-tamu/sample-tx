package jp.co.project.demo.db.sample1.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

import jp.co.project.demo.db.sample1.entity.Sample1Entity;


@Mapper
public interface Sample1Mapper {

	@Select("select * from tx_sample")
	List<Sample1Entity> select(RowBounds bounds);

	@Insert("INSERT INTO tx_sample (id, name, created_user, created_date, updated_user, updated_date, is_delete)" +
			"VALUES (#{id}, #{name}, #{createdUser}, #{createdDate}, #{updatedUser}, #{updatedDate}, 0);")
	void insert(Sample1Entity entity);
}
