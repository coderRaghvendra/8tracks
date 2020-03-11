package com.swiggy.tracks.util;

import java.nio.ByteBuffer;
import java.util.UUID;

/**
 * 
 * @author Raghvendra.Mishra
 *
 */
public abstract class UUIDUtility {
	/**
	 * http://stackoverflow.com/questions/17893609/convert-uuid-to-byte-that-
	 * works-when-using-uuid-nameuuidfrombytesb
	 * 
	 * @param bytes
	 * @return
	 */
	public static UUID fromBytes(byte[] bytes) {
		ByteBuffer bb = ByteBuffer.wrap(bytes);
		long firstLong = bb.getLong();
		long secondLong = bb.getLong();
		return new UUID(firstLong, secondLong);
	}

	/**
	 * http://stackoverflow.com/questions/17893609/convert-uuid-to-byte-that-
	 * works-when-using-uuid-nameuuidfrombytesb
	 * 
	 * @param uuid
	 * @return
	 */
	public static byte[] toBytes(UUID uuid) {
		ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
		bb.putLong(uuid.getMostSignificantBits());
		bb.putLong(uuid.getLeastSignificantBits());
		return bb.array();
	}
}
