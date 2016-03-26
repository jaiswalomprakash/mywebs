package com.webservices.modal;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the my_service database table.
 * 
 */
@Entity
@Table(name="my_service")
@NamedQuery(name="MyService.findAll", query="SELECT m FROM MyService m")
public class MyService extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=1)
	private String active;

	@Column(length=255)
	private String field1;

	@Column(length=255)
	private String field10;

	@Column(name="field11_600", length=600)
	private String field11600;

	@Column(name="field12_600", length=600)
	private String field12600;

	@Column(name="field13_600", length=600)
	private String field13600;

	@Column(name="field14_600", length=600)
	private String field14600;

	@Column(length=255)
	private String field2;

	@Column(length=255)
	private String field3;

	@Column(length=255)
	private String field4;

	@Column(length=255)
	private String field5;

	@Column(length=255)
	private String field6;

	@Column(length=255)
	private String field7;

	@Column(length=255)
	private String field8;

	@Column(length=255)
	private String field9;

	private float floatfield1;

	private float floatfield2;

	private float floatfield3;

	private int intfield1;

	private int intfield2;

	private int intfield3;

	private int intfield4;

	private int intfield5;

	private int intfield6;

	private int intfield8;

	private String keyword;

	private String textfield1;

	private String textfield2;

	private String textfield3;

	//bi-directional many-to-one association to Service
	@ManyToOne
	@JoinColumn(name="service_id", nullable=false)
	private Service service;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private User user;

	public MyService() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getActive() {
		return this.active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getField1() {
		return this.field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField10() {
		return this.field10;
	}

	public void setField10(String field10) {
		this.field10 = field10;
	}

	public String getField11600() {
		return this.field11600;
	}

	public void setField11600(String field11600) {
		this.field11600 = field11600;
	}

	public String getField12600() {
		return this.field12600;
	}

	public void setField12600(String field12600) {
		this.field12600 = field12600;
	}

	public String getField13600() {
		return this.field13600;
	}

	public void setField13600(String field13600) {
		this.field13600 = field13600;
	}

	public String getField14600() {
		return this.field14600;
	}

	public void setField14600(String field14600) {
		this.field14600 = field14600;
	}

	public String getField2() {
		return this.field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	public String getField3() {
		return this.field3;
	}

	public void setField3(String field3) {
		this.field3 = field3;
	}

	public String getField4() {
		return this.field4;
	}

	public void setField4(String field4) {
		this.field4 = field4;
	}

	public String getField5() {
		return this.field5;
	}

	public void setField5(String field5) {
		this.field5 = field5;
	}

	public String getField6() {
		return this.field6;
	}

	public void setField6(String field6) {
		this.field6 = field6;
	}

	public String getField7() {
		return this.field7;
	}

	public void setField7(String field7) {
		this.field7 = field7;
	}

	public String getField8() {
		return this.field8;
	}

	public void setField8(String field8) {
		this.field8 = field8;
	}

	public String getField9() {
		return this.field9;
	}

	public void setField9(String field9) {
		this.field9 = field9;
	}

	public float getFloatfield1() {
		return this.floatfield1;
	}

	public void setFloatfield1(float floatfield1) {
		this.floatfield1 = floatfield1;
	}

	public float getFloatfield2() {
		return this.floatfield2;
	}

	public void setFloatfield2(float floatfield2) {
		this.floatfield2 = floatfield2;
	}

	public float getFloatfield3() {
		return this.floatfield3;
	}

	public void setFloatfield3(float floatfield3) {
		this.floatfield3 = floatfield3;
	}

	public int getIntfield1() {
		return this.intfield1;
	}

	public void setIntfield1(int intfield1) {
		this.intfield1 = intfield1;
	}

	public int getIntfield2() {
		return this.intfield2;
	}

	public void setIntfield2(int intfield2) {
		this.intfield2 = intfield2;
	}

	public int getIntfield3() {
		return this.intfield3;
	}

	public void setIntfield3(int intfield3) {
		this.intfield3 = intfield3;
	}

	public int getIntfield4() {
		return this.intfield4;
	}

	public void setIntfield4(int intfield4) {
		this.intfield4 = intfield4;
	}

	public int getIntfield5() {
		return this.intfield5;
	}

	public void setIntfield5(int intfield5) {
		this.intfield5 = intfield5;
	}

	public int getIntfield6() {
		return this.intfield6;
	}

	public void setIntfield6(int intfield6) {
		this.intfield6 = intfield6;
	}

	public int getIntfield8() {
		return this.intfield8;
	}

	public void setIntfield8(int intfield8) {
		this.intfield8 = intfield8;
	}

	public Object getKeyword() {
		return this.keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getTextfield1() {
		return this.textfield1;
	}

	public void setTextfield1(String textfield1) {
		this.textfield1 = textfield1;
	}

	public Object getTextfield2() {
		return this.textfield2;
	}

	public void setTextfield2(String textfield2) {
		this.textfield2 = textfield2;
	}

	public String getTextfield3() {
		return this.textfield3;
	}

	public void setTextfield3(String textfield3) {
		this.textfield3 = textfield3;
	}

	public Service getService() {
		return this.service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}