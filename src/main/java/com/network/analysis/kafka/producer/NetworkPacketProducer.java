/**
 * 
 */
package com.network.analysis.kafka.producer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.annotation.PostConstruct;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author anas
 *
 */
@Component
@PropertySource("classpath:application.properties")
public class NetworkPacketProducer {

	/**
	 * @param args
	 */

	@Autowired
	private KafkaProducer<String, String> producer;

	@Autowired
	private Environment env;

	private Logger logger = LoggerFactory.getLogger(NetworkPacketProducer.class);
	private static boolean flag = true;

	@PostConstruct
	public void init() {
		produce();
	}

	private void produce() {

		try (Socket socket = new Socket(env.getProperty("netcat-ip"), Integer.parseInt(env.getProperty("netcat-port")));
				InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
				BufferedReader reader = new BufferedReader(streamReader)) {

			while (flag) {
				ProducerRecord<String, String> records = new ProducerRecord<>("NetworkPackets", reader.readLine());
				producer.send(records);
				producer.flush();
			}

		} catch (UnknownHostException e1) {
			logger.debug(e1.getMessage());
		} catch (IOException e1) {
			logger.debug(e1.getMessage());
		}

	}

}
