package com.blockchain.game.models;

import java.io.*;

import org.bouncycastle.jcajce.provider.digest.SHA3;
import org.bouncycastle.util.encoders.Hex;

public class SHA3Helper {

	public static String digestToHex(byte[] digest) {
		return Hex.toHexString(digest);
	}

	public static byte[] hash256(Serializable o) {
		// Hashberechnungen innerhalb der Blockchain
		
		byte[] digest = new byte[0];
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		try {
			
			ObjectOutputStream writer = new ObjectOutputStream(stream);
			
			writer.writeObject(o);
			
			writer.flush();
			
			digest = hash256(stream.toByteArray());
		
		} catch (IOException e) {
			
			System.out.println("java error " + e.getClass() + ": " + e.getMessage());
		}
		
		return digest;
	}
	
	public static byte[] hash256(byte[] bytes) {
		SHA3.Digest256 digestSHA3 = new SHA3.Digest256();
		return digestSHA3.digest(bytes);
	}
}
