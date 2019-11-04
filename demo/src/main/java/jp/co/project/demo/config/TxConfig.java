package jp.co.project.demo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class TxConfig {

	@Bean(name = "chainedTransactionManager")
	public ChainedTransactionManager transactionManager(@Qualifier("transactionManager") PlatformTransactionManager ds1,
			@Qualifier("sample1TransactionManager") PlatformTransactionManager ds2) {
		return new ChainedTransactionManager(ds1, ds2);
	}
}
