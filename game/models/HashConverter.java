package com.blockchain.game.models;

import com.owlike.genson.Context;
import com.owlike.genson.Converter;
import com.owlike.genson.stream.ObjectReader;
import com.owlike.genson.stream.ObjectWriter;

public class HashConverter implements Converter<byte[]>{

	@Override
	public void serialize(byte[] object, ObjectWriter writer, Context ctx) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public byte[] deserialize(ObjectReader reader, Context ctx) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
