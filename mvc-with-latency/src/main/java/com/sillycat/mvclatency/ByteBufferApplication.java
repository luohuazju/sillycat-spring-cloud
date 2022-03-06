package com.sillycat.mvclatency;

import java.nio.ByteBuffer;

public class ByteBufferApplication {

	public static void main(String[] args) {
		ByteBuffer byteBuffer = ByteBuffer.allocate(10);
		byteBuffer.putInt(5); // int number use 4 bytes
		byteBuffer.put((byte) 1); // 1 byte
		byteBuffer.put((byte) 0); // 1 byte
		byteBuffer.put("abc".getBytes()); // 3 bytes
		printByteBuffer(byteBuffer);
		
		byteBuffer.flip();//set position to 0
		//read the byte, position will increase
		System.out.printf("read int value: %d\n", byteBuffer.getInt());//读int
		System.out.printf("read byte value: %d\n", byteBuffer.get());//读byte
		System.out.printf("read byte value: %d\n", byteBuffer.get());//读byte
		byte[] str = new byte[3];
		byteBuffer.get(str, 0, 3);//read 4 bytes
		System.out.println("read string =" + new String(str));
//		position: 9, limit: 10, capacity: 10
//		read int value: 5
//		read byte value: 1
//		read byte value: 0
//		read string =abc
	}

	private static void printByteBuffer(ByteBuffer byteBuffer) {
		System.out.printf("position: %d, limit: %d, capacity: %d\n", byteBuffer.position(), byteBuffer.limit(),
				byteBuffer.capacity());
	}
}
