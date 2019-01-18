package com.pls.bean;

public class GasConnection {
	public int getConnectionId() {
		return connectionId;
	}
	public void setConnectionId(int connectionId) {
		this.connectionId = connectionId;
	}
	public String getConnectionHolderName() {
		return connectionHolderName;
	}
	public void setConnectionHolderName(String connectionHolderName) {
		this.connectionHolderName = connectionHolderName;
	}
	public String getConnectionHolderNumber() {
		return connectionHolderNumber;
	}
	public void setConnectionHolderNumber(String connectionHolderNumber) {
		this.connectionHolderNumber = connectionHolderNumber;
	}
	private int connectionId;
	public GasConnection(int connectionId, String connectionHolderName,
			String connectionHolderNumber) {
		super();
		this.connectionId = connectionId;
		this.connectionHolderName = connectionHolderName;
		this.connectionHolderNumber = connectionHolderNumber;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((connectionHolderName == null) ? 0 : connectionHolderName
						.hashCode());
		result = prime
				* result
				+ ((connectionHolderNumber == null) ? 0
						: connectionHolderNumber.hashCode());
		result = prime * result + connectionId;
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
		GasConnection other = (GasConnection) obj;
		if (connectionHolderName == null) {
			if (other.connectionHolderName != null)
				return false;
		} else if (!connectionHolderName.equals(other.connectionHolderName))
			return false;
		if (connectionHolderNumber == null) {
			if (other.connectionHolderNumber != null)
				return false;
		} else if (!connectionHolderNumber.equals(other.connectionHolderNumber))
			return false;
		if (connectionId != other.connectionId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "\nGasConnection [connectionId=" + connectionId
				+ ", connectionHolderName=" + connectionHolderName
				+ ", connectionHolderNumber=" + connectionHolderNumber + "]";
	}
	private String connectionHolderName;
	private String connectionHolderNumber;
	
	
}
