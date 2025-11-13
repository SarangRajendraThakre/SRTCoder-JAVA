package com.srt.DBConnection;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Dbconn {

	// Simple String literals
	@Value("jdbc:mysql://localhost:3306/p1")
	private String url;
	@Value("root")
	private String password;

	// Properties using ${...}
	@Value("${db.username}")
	private String username;
	@Value("${db.port.number}")
	private int port;
	
	// Properties from the different properites file 
//	        aws.db.port=1111
//			aws.db.url=srtcoder
//			aws.db.user=yadnesh
//			aws.db.password=thakre
	
	@Value("${aws.db.port}")
	private int awsPort;
	@Value("${aws.db.url}")
	private String awsUrl;
	@Value("${aws.db.user}")
	private String awsuserName;
	@Value("${aws.db.password}")
	private String  awsPassword;
		

	
// # means If you are injecting collections like List, Set, or Map from a property file,
//	using the hash symbol (#) to activate SpEL(Spring Expression Language (SpEL).) is mandatory 
//	to properly parse the complex data structure.
	@Value("#{'${org.deptName.List}'}")
	private List<String> departmentNameList;

	@Value("#{'${org.deptName.Set}'}")
	private Set<String> departmentSet;

	@Value("#{${org.deptName.Map}}")
	private Map<String, String> coursesAndTrainer;

	@Value("#{'papaya, apple, apple, banana'}")
	private List<String> fruitsList;

	@Value("#{'pune, pune, mumbai, wardha, nagpur'}")
	private Set<String> citySet;

	@Value("#{{'10':'80', '12':'70', 'Btech':'80'}}")
	private Map<String, String> percetageMap;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getAwsPort() {
		return awsPort;
	}

	public void setAwsPort(int awsPort) {
		this.awsPort = awsPort;
	}

	public String getAwsUrl() {
		return awsUrl;
	}

	public void setAwsUrl(String awsUrl) {
		this.awsUrl = awsUrl;
	}

	public String getAwsuserName() {
		return awsuserName;
	}

	public void setAwsuserName(String awsuserName) {
		this.awsuserName = awsuserName;
	}

	public String getAwsPassword() {
		return awsPassword;
	}

	public void setAwsPassword(String awsPassword) {
		this.awsPassword = awsPassword;
	}

	public List<String> getDepartmentNameList() {
		return departmentNameList;
	}

	public void setDepartmentNameList(List<String> departmentNameList) {
		this.departmentNameList = departmentNameList;
	}

	public Set<String> getDepartmentSet() {
		return departmentSet;
	}

	public void setDepartmentSet(Set<String> departmentSet) {
		this.departmentSet = departmentSet;
	}

	public Map<String, String> getCoursesAndTrainer() {
		return coursesAndTrainer;
	}

	public void setCoursesAndTrainer(Map<String, String> coursesAndTrainer) {
		this.coursesAndTrainer = coursesAndTrainer;
	}

	public List<String> getFruitsList() {
		return fruitsList;
	}

	public void setFruitsList(List<String> fruitsList) {
		this.fruitsList = fruitsList;
	}

	public Set<String> getCitySet() {
		return citySet;
	}

	public void setCitySet(Set<String> citySet) {
		this.citySet = citySet;
	}

	public Map<String, String> getPercetageMap() {
		return percetageMap;
	}

	public void setPercetageMap(Map<String, String> percetageMap) {
		this.percetageMap = percetageMap;
	}

	
	
	
	
	
} 