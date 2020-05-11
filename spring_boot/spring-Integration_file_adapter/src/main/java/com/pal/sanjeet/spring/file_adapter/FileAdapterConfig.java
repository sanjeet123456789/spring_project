package com.pal.sanjeet.spring.file_adapter;

import java.io.File;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.file.FileReadingMessageSource;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.filters.CompositeFileListFilter;
import org.springframework.integration.file.filters.SimplePatternFileListFilter;

@Configuration
@EnableIntegration
public class FileAdapterConfig {
	
	@Bean
	@InboundChannelAdapter(value = "fileInputChannel", poller=@Poller(fixedDelay = "1000"))
	public FileReadingMessageSource fileReadingMessageSource() {
		//for filtering
		/*CompositeFileListFilter<File> filter=new CompositeFileListFilter<>();
		filter.addFilter(new SimplePatternFileListFilter(".png"));*/
		FileReadingMessageSource reader=new FileReadingMessageSource();
		reader.setDirectory(new File("/home/sanjeet/Downloads/utorrent-server-alpha-v3_3/"));
		//reader.setFilter(filter);
		return reader;
	}
	@Bean
	@ServiceActivator(inputChannel = "fileInputChannel")
	public FileWritingMessageHandler fileWritingMessageHandler() {
		FileWritingMessageHandler writer=new FileWritingMessageHandler(new File("/home/sanjeet/Downloads/desti"));
		writer.setAutoCreateDirectory(true);
		writer.setExpectReply(false);
		return writer;
		
	}
}
