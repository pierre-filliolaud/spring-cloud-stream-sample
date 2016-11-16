package com.example;

import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;

import com.example.producer.domain.Item;

@SpringBootApplication
@EnableBinding(Source.class)
public class ProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}
	
	@InboundChannelAdapter(Source.OUTPUT)
	public Item senData() {
		Random random = new Random();
		return new Item(Long.valueOf(random.nextInt(10)), "name"+random.nextInt(100), "desc"+random.nextInt(1000));
		
	}
}
