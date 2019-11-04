package jp.co.project.demo.db.sample1.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sample1Entity {

	private String id;
	private String name;
	private String createdUser;
	private Date createdDate;
	private String updatedUser;
	private Date updatedDate;
	private Boolean isDelete;
}
