package jp.co.project.demo.db.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sample2Entity {

	private String id;
	private String name;
	private String createdUser;
	private Date createdDate;
	private String updatedUser;
	private Date updatedDate;
	private Boolean isDelete;
}
