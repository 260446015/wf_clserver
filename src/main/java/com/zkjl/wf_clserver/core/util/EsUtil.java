package com.zkjl.wf_clserver.core.util;


import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetSocketAddress;


public class EsUtil {
	 private static Client client = null;
	  
	    public static Client getTransportClient(){
	        if (client == null  
	                || ((TransportClient) client).connectedNodes().isEmpty()) {
	            synchronized (EsUtil.class) {  
	                if (client == null  
	                        || ((TransportClient) client).connectedNodes()
	                                .isEmpty()) {  
	                    Settings settings = Settings.builder()
	                            .put("cluster.name", "elasticsearch")
	                            .build();
	                    client = new PreBuiltTransportClient(settings)
	                            .addTransportAddresses(
	                                    new InetSocketTransportAddress(new InetSocketAddress(ResourceUtil.getString("es.hosts"), 44336)));
	                }  
	            }  
	        }  
	        return client;  
	    }  
	  
	    public static void close(Client client) {
	        if (client != null) {  
	            client.close();  
	        }  
	    }  
}
