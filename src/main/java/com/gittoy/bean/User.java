package com.gittoy.bean;

/**
 * ��USER���Ӧ��ʵ����
 * @author GaoYu
 */
public class User {

	// ID�����ݿ������ֶ�
	private int id;
	// �û���
	private String username;
	// ����
	private String password;
	// ����
	private String name;
	// �ֻ�
	private String mobile;
	// ��������
	private String email;
	// ���֤��
	private String idcard;
	// �߼�ɾ����ʶ
	private String delflg;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getDelflg() {
		return delflg;
	}

	public void setDelflg(String delflg) {
		this.delflg = delflg;
	}
}
