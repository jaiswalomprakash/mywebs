package com.webservices.modal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The Class BaseEntity.
 */
@EntityListeners(org.springframework.data.jpa.domain.support.AuditingEntityListener.class)
@MappedSuperclass
public abstract class BaseEntity {

	/** The date created. */
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	//@JsonIgnore
	@Column(name="date_created",updatable=true)
	private Date dateCreated;

	/** The date updated. */
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	@JsonIgnore
	@Column(name="date_updated")
	private Date dateUpdated;

	/** The deleted flag. */
	@Column(name="deleted_flag")
	private Byte deletedFlag;

	/** The author id. */
	@Column(name="author_id")
	private String authorID;


	/**
	 * Gets the author id.
	 *
	 * @return the author id
	 */
	public String getAuthorID() {
		return this.authorID;
	}


	/**
	 * Sets the author id.
	 *
	 * @param authorID the new author id
	 */
	public void setAuthorID(String authorID) {
		this.authorID = authorID;
	}

	/**
	 * Gets the date created.
	 *
	 * @return the date created
	 */
	public Date getDateCreated() {
		return this.dateCreated;
	}

	/**
	 * Sets the date created.
	 *
	 * @param dateCreated the new date created
	 */
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	/**
	 * Gets the date updated.
	 *
	 * @return the date updated
	 */
	public Date getDateUpdated() {
		return this.dateUpdated;
	}

	/**
	 * Sets the date updated.
	 *
	 * @param dateUpdated the new date updated
	 */
	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	/**
	 * Gets the deleted flag.
	 *
	 * @return the deleted flag
	 */
	public Byte getDeletedFlag() {
		return this.deletedFlag;
	}

	/**
	 * Sets the deleted flag.
	 *
	 * @param deletedFlag the new deleted flag
	 */
	public void setDeletedFlag(Byte deletedFlag) {
		this.deletedFlag = deletedFlag;
	}

	@PrePersist
    public void prePersist() {
		setDateCreated(new Date());
		setDateUpdated(new Date());
    }

	@PreUpdate
	public void preUpdate(){
		setDateUpdated(new Date());
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((authorID == null) ? 0 : authorID.hashCode());
		result = prime * result
				+ ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result
				+ ((dateUpdated == null) ? 0 : dateUpdated.hashCode());
		result = prime * result
				+ ((deletedFlag == null) ? 0 : deletedFlag.hashCode());
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
		BaseEntity other = (BaseEntity) obj;
		if (authorID == null) {
			if (other.authorID != null)
				return false;
		} else if (!authorID.equals(other.authorID))
			return false;
		if (dateCreated == null) {
			if (other.dateCreated != null)
				return false;
		} else if (!dateCreated.equals(other.dateCreated))
			return false;
		if (dateUpdated == null) {
			if (other.dateUpdated != null)
				return false;
		} else if (!dateUpdated.equals(other.dateUpdated))
			return false;
		if (deletedFlag == null) {
			if (other.deletedFlag != null)
				return false;
		} else if (!deletedFlag.equals(other.deletedFlag))
			return false;
		return true;
	}


}
