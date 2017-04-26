package com.xxx.bean;

/**
 * 封装User的信息
 * @author miao
 * @date 2017年4月23日
 */

public class User {
	/**
	 * 名字是否合法
	 * @param
	 * @return
	 */
	public static boolean validName(String name){
		return name!=null&&!name.equals("");
	}
	
	/**
	 * 密码是否合法
	 * @param passwd
	 * @return
	 */
	public static boolean validPasswd(String passwd){
		return passwd!=null&&passwd.equals("");
	}
	
	/**
	 * 名字和密码是否正确
	 * @param name
	 * @param password
	 * @return
	 */
	public static boolean valid(String name,String password){
		return validName(name)&& validPasswd(password);
	}
	
	private String user_id;
	private String username;
	private String password;
	private String confirPassword;
	private String phone;
	private String email;
	private String role;
	
	
	public User(){
		
	}
	public User(String user_id,String username,String password,String phone,String email){
		super();
		this.user_id=user_id;
		this.username=username;
		this.password=password;
		this.phone=phone;
		this.email=email;
	}
	
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getConfirPassword() {
		return confirPassword;
	}

	public void setConfirPassword(String confirPassword) {
		this.confirPassword = confirPassword;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString(){
		return String.format("user[user_id=%s,username=%s,password=%s,phone=%s,email=%s]", user_id,username,password,phone,email);
	}

}
