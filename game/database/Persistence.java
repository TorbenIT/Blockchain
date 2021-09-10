package com.blockchain.game.database;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;

import com.blockchain.game.models.Block;
import com.blockchain.game.models.Chain;
import com.blockchain.game.models.SHA3Helper;
import com.owlike.genson.Genson;

public class Persistence {

	private String encoding;

	public void writeChain(Chain chain) throws IOException{
		for (Block block : chain.getBlocks()) {
			String id = SHA3Helper.digestToHex(block.getBlockHash());
			
			writeBlock(block, chain.getNetworkId(), id);
		}
	}

	private void writeBlock(Block block, Object networkId, String id) {
		
		File file = new File(getPathToBlock(networkId, id));
		OutputStreamWriter outputStream;
		try {
			outputStream = new OutputStreamWriter(new FileOutputStream(file), encoding);
		
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		Genson genson = new Genson();
		
		genson.serialize(block, outputStream);
	}

	private String getPathToBlock(Object networkId, String id) {
		// TODO Auto-generated method stub
		return null;
	}
}
