package com.candy.main;
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.HBaseAdmin;

public class SshHBase {
	public static void main(String[] args) {

		Configuration conf = HBaseConfiguration.create();
		conf.set("hbase.zookeeper.property.clientPort", "2181");
		conf.set("hbase.zookeeper.quorum", "192.168.185.13");
		conf.set("hbase.zookeeper.quorum", "192.168.185.8");
		conf.set("hbase.zookeeper.quorum", "192.168.185.3");
		conf.set("hbase.master", "192.168.185.14:60000");
		try {
			HBaseAdmin admin = new HBaseAdmin(conf);
			if (admin.tableExists("Agricultural")) {
				admin.disableTable("Agricultural");
				admin.deleteTable("Agricultural");
				System.out.println("Agricultural���Ѿ�����");
			}
			// HTable table=new HTable(conf, "wml");
			HTableDescriptor tableDescriptor = new HTableDescriptor("Agricultural");
			tableDescriptor.addFamily(new HColumnDescriptor("Info"));
			tableDescriptor.addFamily(new HColumnDescriptor("contact_info"));
			tableDescriptor.addFamily(new HColumnDescriptor("personal_info"));
			admin.createTable(tableDescriptor);

		} catch (MasterNotRunningException e) {
			e.printStackTrace();
		} catch (ZooKeeperConnectionException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
