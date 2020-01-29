/**
 * 
 */
package com.network.analysis.util;

import com.network.analysis.pojo.Packet;

/**
 * @author anas
 *
 */
public class RowParser {

	public static Packet parseString(String record) {

		return toPacket(record);
	}

	private static Packet toPacket(String record) {
		String[] fields = record.split(" ");
		Packet packet = new Packet();
		packet.setSequenceId(Long.parseLong(fields[0]));
		packet.setTime(Double.parseDouble(fields[1]));
		packet.setSrcIP(fields[2]);
		packet.setDstIP(fields[3].substring(1, fields[3].length()));
		packet.setProtocol(fields[4]);
		packet.setLength(Integer.parseInt(fields[5]));
		packet.setInfo("Parse it later");
		return packet;
	}
}
