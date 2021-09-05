package com.blockchain.game.models;

import java.io.Serializable;
import java.nio.charset.Charset;

public class Transaction implements Serializable{

	/* 	Ablauf transparent
		Verhinderung von DoubleSpending
		Von A --> B (Absender, Empfänger)
	 * */
	
	private byte[] sender;
	private byte[] receiver;
	private double amount;
	private int nonce;
	private double transactionFeeBasisPreis;
	private double transactionFeeLimit;
	private transient byte[] txId;
	private transient int valueOfWallet; // bei Hash-Berechnung nicht berücksichtigt
	private transient double transactionFee;
	private transient int sizeInByte;
	private transient long receivedTimeStamp;
	private transient byte[] blockId;
	
	public Transaction(String sender, String receiver, double amount, 
			int nonce, double transactionFeeBasisPreis, 
			double transactionFeeLimit) {
		this.sender = sender.getBytes(Charset.forName("utf8"));
		this.receiver = receiver.getBytes(Charset.forName("utf8"));
		this.amount = amount;
		this.nonce = nonce;
		this.transactionFeeBasisPreis = transactionFeeBasisPreis;
		this.transactionFeeLimit = transactionFeeLimit;
		
		// Transaktions-ID
		//this.txId = SHA3Helper.hash256(this);
		initTxId();
	}	
	
	public Transaction(byte[] sender, byte[] receiver, double amount, 
				int nonce, double transactionFeeBasisPreis, 
				double transactionFeeLimit) {
		this.sender = sender;
		this.receiver = receiver;
		this.amount = amount;
		this.nonce = nonce;
		this.transactionFeeBasisPreis = transactionFeeBasisPreis;
		this.transactionFeeLimit = transactionFeeLimit;
		
		// Transaktions-ID
		//this.txId = SHA3Helper.hash256(this);
		initTxId();
	}
	
	public Transaction() {
		initTxId();
	}
	
	private void initTxId() {
		this.setTxId(SHA3Helper.hash256(this));
	}	
	
	
	
	
	
	public byte[] getSender() {
		return sender;
	}

	public void setSender(byte[] sender) {
		this.sender = sender;
	}

	public byte[] getReceiver() {
		return receiver;
	}

	public void setReceiver(byte[] receiver) {
		this.receiver = receiver;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getNonce() {
		return nonce;
	}

	public void setNonce(int nonce) {
		this.nonce = nonce;
	}

	public double getTransactionFeeBasisPreis() {
		return transactionFeeBasisPreis;
	}

	public void setTransactionFeeBasisPreis(double transactionFeeBasisPreis) {
		this.transactionFeeBasisPreis = transactionFeeBasisPreis;
	}

	public double getTransactionFeeLimit() {
		return transactionFeeLimit;
	}

	public void setTransactionFeeLimit(double transactionFeeLimit) {
		this.transactionFeeLimit = transactionFeeLimit;
	}

	@JsonConverter(HashConverter.class)
	public byte[] getTxId() {
		this.txId = SHA3Helper.hash256(this);
		return txId;
	}

	public void setTxId(byte[] txId) {
		this.txId = txId;
	}

	public int getValueOfWallet() {
		return valueOfWallet;
	}

	public void setValueOfWallet(int valueOfWallet) {
		this.valueOfWallet = valueOfWallet;
	}

	public double getTransactionFee() {
		return transactionFee;
	}

	public void setTransactionFee(double transactionFee) {
		this.transactionFee = transactionFee;
	}

	public int getSizeInByte() {
		return sizeInByte;
	}

	public void setSizeInByte(int sizeInByte) {
		this.sizeInByte = sizeInByte;
	}

	public long getReceivedTimeStamp() {
		return receivedTimeStamp;
	}

	public void setReceivedTimeStamp(long receivedTimeStamp) {
		this.receivedTimeStamp = receivedTimeStamp;
	}

	public byte[] getBlockId() {
		return blockId;
	}

	public void setBlockId(byte[] blockId) {
		this.blockId = blockId;
	}


}
