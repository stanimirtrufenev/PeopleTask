package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_mails database table.
 * 
 */
@Entity
@Table(name="t_mails")
@NamedQuery(name="TMail.findAll", query="SELECT t FROM TMail t")
public class TMail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String email;

	@Column(name="EMAIL_TYPE")
	private String emailType;

	//bi-directional many-to-one association to TPeople
	@ManyToOne
	@JoinColumn(name="T_PEOPLE_ID")
	private TPeople TPeople;

	public TMail() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailType() {
		return this.emailType;
	}

	public void setEmailType(String emailType) {
		this.emailType = emailType;
	}

	public TPeople getTPeople() {
		return this.TPeople;
	}

	public void setTPeople(TPeople TPeople) {
		this.TPeople = TPeople;
	}

}