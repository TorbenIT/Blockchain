package com.blockchain.game.models;

import java.util.ArrayList;

public class Block {

	private int blockSize;
	private ArrayList transactions;
	private int transactionCount;
	private BlockHeader blockHeader;

	public Block(byte[] previousHash) {
		
		this.blockSize = 92;
		this.transactions = new ArrayList<>();
		this.transactionCount = this.transactions.size();
		this.blockHeader = 
				new BlockHeader(System.currentTimeMillis(), previousHash);
	}
	
	public void addTransation(Transaction transaction) {
		this.transactions.add(transaction);
		this.transactionCount++;
		this.blockHeader.setTransactionListHash(getTransactionHash());
		
	}
	
	

	private Object getTransactionHash() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}

	public ArrayList getTransactions() {
		return transactions;
	}

	public void setTransactions(ArrayList transactions) {
		this.transactions = transactions;
	}

	public Object getTransactionCount() {
		return transactionCount;
	}

	public void setTransactionCount(int transactionCount) {
		this.transactionCount = transactionCount;
	}

	public BlockHeader getBlockHeader() {
		return blockHeader;
	}

	public void setBlockHeader(BlockHeader blockHeader) {
		this.blockHeader = blockHeader;
	}

	public byte[] getBlockHash() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	//GET---SET
	
	
}
