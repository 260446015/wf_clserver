package com.zkjl.wf_clserver;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.spring4all.mongodb.EnableMongoPlus;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.MultipartConfigElement;
import java.net.InetAddress;
import java.util.concurrent.*;

@SpringBootApplication
@EnableAutoConfiguration
@EnableSwagger2
@ComponentScan(basePackages = "com.zkjl.wf_clserver")
@EnableAspectJAutoProxy
@EnableMongoPlus
public class WfClserverApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(WfClserverApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(WfClserverApplication.class);
	}
	/**
	 * 文件上传配置
	 * @return
	 */
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		//文件最大
		factory.setMaxFileSize("102400KB"); //KB,MB
		/// 设置总上传数据总大小
		factory.setMaxRequestSize("102400KB");
		return factory.createMultipartConfig();
	}

	@Bean
	public Client client() throws Exception {
		Settings settings = Settings.builder().put("cluster.name", "elasticsearch").build();
		TransportClient client = new PreBuiltTransportClient(settings)
				.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("10.52.219.8"), 9300));
		return client;
	}

	@Bean
	public ExecutorService executorService(){
		ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
				.setNameFormat("demo-pool-file-upload").build();
		ExecutorService singleThreadPool = new ThreadPoolExecutor(30, 70,
				0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<>(), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
		return singleThreadPool;
	}

}
