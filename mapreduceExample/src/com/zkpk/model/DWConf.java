package com.zkpk.model;

public class DWConf {

	private int jobID;//以第几个指数名加上第几个指标名的序号为jobid，例如组织堡垒指数为第二个指数名，组织堡垒指数下的地一个指标名为三会一课，那个jobid就为201
	
	private String zsm;//指数名
	
	private String zbm;//指标名
	
	private int zbzb;//指标占比
	
	private String filename;//文件名
	
	private int regionCode;//区域码位置
	
	private int regionName;//区域名位置
	
	private int postTime;//发布时间位置
	
	private int updateTime;//更新时间位置
	
	private int addTime;//添加时间位置
	
	private int fieldsNum;

	public DWConf() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

	public DWConf(int jobID, String zsm, String zbm, int zbzb, String filename, int regionCode, int regionName,
			int postTime, int updateTime, int addTime, int fieldsNum) {
		super();
		this.jobID = jobID;
		this.zsm = zsm;
		this.zbm = zbm;
		this.zbzb = zbzb;
		this.filename = filename;
		this.regionCode = regionCode;
		this.regionName = regionName;
		this.postTime = postTime;
		this.updateTime = updateTime;
		this.addTime = addTime;
		this.fieldsNum = fieldsNum;
	}




	@Override
	public String toString() {
		return "DWConf [jobID=" + jobID + ", zsm=" + zsm + ", zbm=" + zbm + ", zbzb=" + zbzb + ", filename=" + filename
				+ ", regionCode=" + regionCode + ", regionName=" + regionName + ", postTime=" + postTime
				+ ", updateTime=" + updateTime + ", addTime=" + addTime + ", fieldsNum=" + fieldsNum + "]";
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + addTime;
		result = prime * result + fieldsNum;
		result = prime * result + ((filename == null) ? 0 : filename.hashCode());
		result = prime * result + jobID;
		result = prime * result + postTime;
		result = prime * result + regionCode;
		result = prime * result + regionName;
		result = prime * result + updateTime;
		result = prime * result + ((zbm == null) ? 0 : zbm.hashCode());
		result = prime * result + zbzb;
		result = prime * result + ((zsm == null) ? 0 : zsm.hashCode());
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DWConf other = (DWConf) obj;
		if (addTime != other.addTime)
			return false;
		if (fieldsNum != other.fieldsNum)
			return false;
		if (filename == null) {
			if (other.filename != null)
				return false;
		} else if (!filename.equals(other.filename))
			return false;
		if (jobID != other.jobID)
			return false;
		if (postTime != other.postTime)
			return false;
		if (regionCode != other.regionCode)
			return false;
		if (regionName != other.regionName)
			return false;
		if (updateTime != other.updateTime)
			return false;
		if (zbm == null) {
			if (other.zbm != null)
				return false;
		} else if (!zbm.equals(other.zbm))
			return false;
		if (zbzb != other.zbzb)
			return false;
		if (zsm == null) {
			if (other.zsm != null)
				return false;
		} else if (!zsm.equals(other.zsm))
			return false;
		return true;
	}




	public int getJobID() {
		return jobID;
	}

	public void setJobID(int jobID) {
		this.jobID = jobID;
	}

	public String getZsm() {
		return zsm;
	}

	public void setZsm(String zsm) {
		this.zsm = zsm;
	}

	public String getZbm() {
		return zbm;
	}

	public void setZbm(String zbm) {
		this.zbm = zbm;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getRegionCode() {
		return regionCode;
	}

	public void setRegionCode(int regionCode) {
		this.regionCode = regionCode;
	}

	public int getRegionName() {
		return regionName;
	}

	public void setRegionName(int regionName) {
		this.regionName = regionName;
	}

	public int getPostTime() {
		return postTime;
	}

	public void setPostTime(int postTime) {
		this.postTime = postTime;
	}

	public int getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(int updateTime) {
		this.updateTime = updateTime;
	}

	public int getAddTime() {
		return addTime;
	}

	public void setAddTime(int addTime) {
		this.addTime = addTime;
	}

	public int getZbzb() {
		return zbzb;
	}

	public void setZbzb(int zbzb) {
		this.zbzb = zbzb;
	}


	public int getFieldsNum() {
		return fieldsNum;
	}


	public void setFieldsNum(int fieldsNum) {
		this.fieldsNum = fieldsNum;
	}
	
	
	
	
	
}
