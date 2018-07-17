package com.zkjl.wf_clserver.core.entity;

import java.util.ArrayList;
import java.util.List;

public class JobBean {
	
	private String word;
	private String wordtype;
	private int jobtype;
	private String jobid;
	private List<String> resources =new ArrayList<String>();
	private String hash;
	private String username;
	private String ip;
	private String isCache;

	public String getIsCache() {
		return isCache;
	}

	public void setIsCache(String isCache) {
		this.isCache = isCache;
	}

	private long exetime;
	
	
	/**
	 * @return the word
	 */
	public String getWord() {
		return word;
	}
	/**
	 * @param word the word to set
	 */
	public void setWord(String word) {
		this.word = word;
	}
	/**
	 * @return the wordtype
	 */
	public String getWordtype() {
		return wordtype;
	}
	/**
	 * @param wordtype the wordtype to set
	 */
	public void setWordtype(String wordtype) {
		this.wordtype = wordtype;
	}
	/**
	 * @return the jobtype
	 */
	public int getJobtype() {
		return jobtype;
	}
	/**
	 * @param jobtype the jobtype to set
	 */
	public void setJobtype(int jobtype) {
		this.jobtype = jobtype;
	}
	/**
	 * @return the jobid
	 */
	public String getJobid() {
		return jobid;
	}
	/**
	 * @param jobid the jobid to set
	 */
	public void setJobid(String jobid) {
		this.jobid = jobid;
	}
	/**
	 * @return the resources
	 */
	public List<String> getResources() {
		return resources;
	}
	/**
	 * @param resources the resources to set
	 */
	public void setResources(List<String> resources) {
		this.resources = resources;
	}
	/**
	 * @return the hash
	 */
	public String getHash() {
		return hash;
	}
	/**
	 * @param hash the hash to set
	 */
	public void setHash(String hash) {
		this.hash = hash;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}
	/**
	 * @param ip the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}
	/**
	 * @return the exetime
	 */
	public long getExetime() {
		return exetime;
	}
	/**
	 * @param exetime the exetime to set
	 */
	public void setExetime(long exetime) {
		this.exetime = exetime;
	}
	
}
