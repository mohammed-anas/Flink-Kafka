/**
 * 
 */
package com.network.analysis.pojo;

import java.io.Serializable;

/**
 * @author anas
 *
 */
public class Packet implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long sequenceId;
	private double time;
	private String srcIP;
	private String dstIP;
	private String protocol;
	private int length;
	private String info;
	
	
	public Packet() {
		super();
	}

	public Packet(long sequenceId, double time, String srcIP, String dstIP, String protocol, int length, String info) {
		super();
		this.sequenceId = sequenceId;
		this.time = time;
		this.srcIP = srcIP;
		this.dstIP = dstIP;
		this.protocol = protocol;
		this.length = length;
		this.info = info;
	}

	public long getSequenceId() {
		return sequenceId;
	}

	public void setSequenceId(long sequenceId) {
		this.sequenceId = sequenceId;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public String getSrcIP() {
		return srcIP;
	}

	public void setSrcIP(String srcIP) {
		this.srcIP = srcIP;
	}

	public String getDstIP() {
		return dstIP;
	}

	public void setDstIP(String dstIP) {
		this.dstIP = dstIP;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "Packet [sequenceId=" + sequenceId + ", time=" + time + ", srcIP=" + srcIP + ", dstIP=" + dstIP
				+ ", protocol=" + protocol + ", length=" + length + ", info=" + info + "]";
	}
	
	
	
	
	

}
