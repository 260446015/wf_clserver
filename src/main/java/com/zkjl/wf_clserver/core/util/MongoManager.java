package com.zkjl.wf_clserver.core.util;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.List;

public class MongoManager {

	private final static MongoManager instance = new MongoManager();

	private static MongoClient mg = null;
	
	private static MongoDatabase mongoDatabase;

	public static MongoManager getInstance() {
		return instance;
	}
	public static MongoDatabase getMongoDatabase() {
		return mongoDatabase;
	}

	public static void setMongoDatabase(MongoDatabase mongoDatabase) {
		MongoManager.mongoDatabase = mongoDatabase;
	}

	public MongoManager() {
		// 链接池数量
		String connectionsPerHost = ResourceUtil.getString("mongo.connectionsPerHost");
		// 最大等待时间
		String maxWaitTime = ResourceUtil.getString("mongo.maxWaitTime");
		// scoket超时时间
		String socketTimeout = ResourceUtil.getString("mongo.socketTimeout");
		// 设置连接池最长生命时间
		String maxConnectionLifeTime = ResourceUtil.getString("mongo.maxConnectionLifeTime");
		// 连接超时时间
		String connectTimeout = ResourceUtil.getString("mongo.connectTimeout");

		MongoClientOptions options = MongoClientOptions.builder().connectionsPerHost(Integer.parseInt(connectionsPerHost))
				.maxWaitTime(Integer.parseInt(maxWaitTime)).socketTimeout(Integer.parseInt(socketTimeout))
				.maxConnectionLifeTime(Integer.parseInt(maxConnectionLifeTime)).connectTimeout(Integer.parseInt(connectTimeout)).build();

		// 所有主机
		List<ServerAddress> hosts = new ArrayList<ServerAddress>();
		String host = ResourceUtil.getString("mongo.host");
		int port = Integer.parseInt(ResourceUtil.getString("mongo.port"));
		hosts.add(new ServerAddress(host, port));
		mg = new MongoClient(hosts, options);
		mongoDatabase = mg.getDatabase(ResourceUtil.getString("mongo.dbname"));
	}
	
}
