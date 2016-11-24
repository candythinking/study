package hbase.api;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HBaseDemo {
	Configuration conf;
	@Before
	public void init(){
		conf=HBaseConfiguration.create();
		conf.set("hbase.zookeeper.quorum","candythinking:2181");
	}
	
	
	@Test //insert row
	public static void testPut(Configuration conf) throws IOException{
		HTable table =new HTable(conf, "people");
		for(int i = 0 ; i <10000;i++){
			Put put =new Put(Bytes.toBytes("kr000"+i));
			put.add(Bytes.toBytes("info"), Bytes.toBytes("name"), Bytes.toBytes("zhangsanfeng"+i));
			put.add(Bytes.toBytes("info"), Bytes.toBytes("age"), Bytes.toBytes("111"+i));
			put.add(Bytes.toBytes("info"), Bytes.toBytes("money"), Bytes.toBytes(300000+i));
			table.put(put);
		}
		table.close();
		
	}
	
	
	@Test //select row
	public void testGet() throws IOException{
		HTable table=new HTable(conf, "auto");
		Get get=new Get(Bytes.toBytes("kr0001"));
		Result result = table.get(get);
		byte[] value = result.getValue(Bytes.toBytes("info"), Bytes.toBytes("age"));
		System.out.println(Bytes.toString(value));
		table.close();
		
	}
	@Test
	public void testScan() throws IOException{
		HTable table =new HTable(conf,"people");
		Scan san=new Scan();//begin end 左闭右开
		ResultScanner scanner = table.getScanner(san);
		for(Result r:scanner){
			byte[] value = r.getValue(Bytes.toBytes("info"), Bytes.toBytes("age"));
			System.out.println(Bytes.toString(value));
		}
		table.close();
	}
	@Test
	public void testDelete() throws IOException{
		HTable table = new HTable(conf, "people");
		Delete delete = new Delete(Bytes.toBytes("kr0001"));
		table.delete(delete);
		table.close();
	}

    public static List getAllTables(HBaseAdmin admin) {
        List<String> tables = null;
        if (admin != null) {
            try {
                HTableDescriptor[] allTable = admin.listTables();
                if (allTable.length > 0)
                    tables = new ArrayList<String>();
                for (HTableDescriptor hTableDescriptor : allTable) {
                    tables.add(hTableDescriptor.getNameAsString());
                    System.out.println(hTableDescriptor.getNameAsString());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return tables;
    }

    public static void createTable(HBaseAdmin admin){
        HTableDescriptor htd=new HTableDescriptor(TableName.valueOf("people"));
        HColumnDescriptor hcDescriptor=new HColumnDescriptor("info");
        hcDescriptor.setMaxVersions(1);
        htd.addFamily(hcDescriptor);
//        admin.createTable(htd);
//        admin.close();
    }
	
	//create table
	public static void main(String[] args) throws MasterNotRunningException, ZooKeeperConnectionException, IOException {
		Configuration 	conf=HBaseConfiguration.create();
		conf.set("hbase.zookeeper.quorum","candythinking");
        conf.set("hbase.zookeeper.property.clientPort","2181");
		conf.set("hbase.master","candythinking:60000");
		HBaseAdmin admin=new HBaseAdmin(conf);
		getAllTables(admin);

//		testPut(conf);
	}
}
