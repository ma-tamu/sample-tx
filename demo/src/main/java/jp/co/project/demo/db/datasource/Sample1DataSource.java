package jp.co.project.demo.db.datasource;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@MapperScan(basePackages = { "jp.co.project.demo.db.sample1.mapper" }, sqlSessionFactoryRef = "sample1SqlSessionFactory")
public class Sample1DataSource {

	@ConfigurationProperties("spring.sample.datasource")
	@Bean("sample1DataSourceProperties")
	public DataSourceProperties dataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean("dataSourceSample1")
	public DataSource dataSource(@Qualifier("sample1DataSourceProperties") DataSourceProperties dataSourceProperties) {
		return dataSourceProperties.initializeDataSourceBuilder().build();
	}

	@Bean("sample1TransactionManager")
	public PlatformTransactionManager transactionManager(@Qualifier("dataSourceSample1") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean("sample1SqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSourceSample1") DataSource dataSource) throws Exception {
		final var sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource);
		return sqlSessionFactory.getObject();
	}
}
