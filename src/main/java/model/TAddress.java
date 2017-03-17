package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_addresses database table.
 * 
 */
@Entity
@Table(name="t_addresses")
@NamedQuery(name="TAddress.findAll", query="SELECT t FROM TAddress t")
public class TAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="ADDR_INFO")
	private String addrInfo;

	@Column(name="ADDR_TYPE")
	private String addrType;

	//bi-directional many-to-one association to TPeople
	@ManyToOne
	@JoinColumn(name="T_PEOPLE_ID")
	private TPeople TPeople;

	public TAddress() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddrInfo() {
		return this.addrInfo;
	}

	public void setAddrInfo(String addrInfo) {
		this.addrInfo = addrInfo;
	}

	public String getAddrType() {
		return this.addrType;
	}

	public void setAddrType(String addrType) {
		this.addrType = addrType;
	}

	public TPeople getTPeople() {
		return this.TPeople;
	}

	public void setTPeople(TPeople TPeople) {
		this.TPeople = TPeople;
	}

}