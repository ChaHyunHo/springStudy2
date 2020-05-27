package com.member.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.member.DataBaseConnectionInfo;

public class EMSInformationService {

	private String info;
	private String copyRight;
	private String ver;
	private int ssYear;
	private int ssMonth;
	private int ssDay;
	private int eeYear;
	private int eeMonth;
	private int eeDay;
	private List<String> developers;
	private Map<String, String> administrators;
	private Map<String, DataBaseConnectionInfo> dbInfos;
	
	public EMSInformationService() {

	}
	
	public void outputEMSInformation(){
		System.out.print("\n\n");
		String devPeriod = ssYear + "/" + ssMonth + "/" + ssDay + " ~ " + eeYear + "/" + eeMonth + "/" + eeDay;
		System.out.println(info + "(" + devPeriod + ")" + "\n" + copyRight + "\n" + ver);
		System.out.println("Developers : " + developers);
		System.out.println("Administrator : " + administrators);
		outputDataBaseInfo();
		System.out.print("\n\n");
	}

	private void outputDataBaseInfo() {
		Set<String> keys = dbInfos.keySet();
		Iterator<String> iterator = keys.iterator();
		
		while (iterator.hasNext()) {
			String key = iterator.next();
			DataBaseConnectionInfo info = dbInfos.get(key);
			System.out.println("[" + key + "]");
			System.out.print("jdbcUrl:" + info.getJdbcUrl() + "\t");
			System.out.print("userId:" + info.getUserId() + "\t");
			System.out.print("userPw:" + info.getUserPw() + "\n");
		}
	}
	
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getCopyRight() {
		return copyRight;
	}

	public void setCopyRight(String copyRight) {
		this.copyRight = copyRight;
	}

	public String getVer() {
		return ver;
	}

	public void setVer(String ver) {
		this.ver = ver;
	}


	public List<String> getDevelopers() {
		return developers;
	}

	public void setDevelopers(List<String> developers) {
		this.developers = developers;
	}
	
	public Map<String, String> getAdministrators() {
		return administrators;
	}

	public void setAdministrators(Map<String, String> administrators) {
		this.administrators = administrators;
	}

	public Map<String, DataBaseConnectionInfo> getDbInfos() {
		return dbInfos;
	}

	public void setDbInfos(Map<String, DataBaseConnectionInfo> dbInfos) {
		this.dbInfos = dbInfos;
	}
	
	public int getSsYear() {
		return ssYear;
	}

	public void setSsYear(int ssYear) {
		this.ssYear = ssYear;
	}

	public int getSsMonth() {
		return ssMonth;
	}

	public void setSsMonth(int ssMonth) {
		this.ssMonth = ssMonth;
	}

	public int getSsDay() {
		return ssDay;
	}

	public void setSsDay(int ssDay) {
		this.ssDay = ssDay;
	}

	public int getEeYear() {
		return eeYear;
	}

	public void setEeYear(int eeYear) {
		this.eeYear = eeYear;
	}

	public int getEeMonth() {
		return eeMonth;
	}

	public void setEeMonth(int eeMonth) {
		this.eeMonth = eeMonth;
	}

	public int getEeDay() {
		return eeDay;
	}

	public void setEeDay(int eeDay) {
		this.eeDay = eeDay;
	}


}
