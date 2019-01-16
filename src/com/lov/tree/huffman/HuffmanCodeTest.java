package com.lov.tree.huffman;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * �շ�������ѹ��/��ѹ�ļ�
 * @author P1314023
 *
 */
public class HuffmanCodeTest {

	public static void main(String[] args) throws UnsupportedEncodingException {
//		String msg = "can ca ca ca cannn a caner cancel";
//		byte[] bytes = msg.getBytes();
		
//		System.out.println(bytes.toString());
//		���úշ������� 
//		byte[] bs = huffmanZip(bytes);
//		ѹ���󳤶�
//		System.out.println(bs.length);
//		System.out.println(bytes.length);
		
		/*byte[] newByte = huffmanDecode(huffCodes,bs);
		System.out.println(Arrays.toString(bytes));
		System.out.println(Arrays.toString(newByte));
		System.out.println(new String(newByte));*/
		
		/*try {
			zipFile("1.png", "1.zip");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		try {
			unZipFile("1.zip", "2.png");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 	}
	
	/**
	 * ��ѹ�ļ�
	 * @param src
	 * @param dst
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void unZipFile(String src,String dst) throws IOException, ClassNotFoundException {
		
//		����������
		InputStream is = new FileInputStream(src);
		ObjectInputStream ois = new ObjectInputStream(is);
//		��ȡbyte����
		byte[] bs = (byte[])ois.readObject();
		
//		��ȡ�շ��������
		Map<Byte, String> codes = (Map<Byte, String>) ois.readObject();
		ois.close();
		is.close();
//		����
		byte[] bytes = huffmanDecode(codes, bs);
//		���������
		OutputStream os = new FileOutputStream(dst);
//		д������
		os.write(bytes);
		os.close();
		
	}
	
	/**
	 * �ļ�ѹ��
	 * @param src
	 * @param dst
	 * @throws IOException
	 */
	public static void zipFile(String src,String dst) throws IOException {
//		����������
		InputStream is = new FileInputStream(src);
//		����һ����������ָ���ļ���Сһ����byte����
		byte[] bs = new byte[is.available()];
//		��ȡ�ļ�����
		is.read(bs);
		is.close();
//		ʹ�úշ���������б���
		byte[] byteZip = huffmanZip(bs);
//		�����
		OutputStream os = new FileOutputStream(dst);
		ObjectOutputStream oos = new ObjectOutputStream(os);
//		��ѹ�����byte��������ļ�
		oos.writeObject(byteZip);
//		���շ���������������
		oos.writeObject(huffCodes);
		oos.close();
		os.close();
	}


	/**
	 * �շ������� 
	 * @param huffCodes
	 * @param bs
	 * @return
	 */
	private static byte[] huffmanDecode(Map<Byte, String> huffCodes, byte[] bs) {
//		��byte����תΪ�������ַ���
		StringBuilder sBuffer = new StringBuilder();
		for(int i=0;i<bs.length;i++) {
//			String s = Integer.toBinaryString(b); //ȡ�����Ķ���32Ϊ���ȵ�int,������λ��0�Զ�ʡ��
//			System.out.println(s);
			byte b = bs[i];
//			�ж���� һ��,��Ҫ��ȫ8λ
			boolean flag = (i==bs.length-1);
			sBuffer.append(byteToStr(!flag,b));
		}
//		System.out.println(sBuffer.toString());
//		���ַ���ͨ��ָ���շ����������н���
//		���շ��������ļ�ֵ����,ͨ�������Ʊ������ַ�
		Map<String, Byte> map = new HashMap<>();
		for(Map.Entry<Byte, String> entry : huffCodes.entrySet()) {
			map.put(entry.getValue(),	entry.getKey());
		}
		
//		�������ֵByte�ݴ浽��list
		List<Byte> list = new ArrayList<>();
		
//		�����ַ���
		for(int i = 0;i<sBuffer.length();) {
			int  count = 1;
			boolean flag = true;
//				ȡ��key
			while (flag) {
				String key = sBuffer.substring(i,i+count);
				Byte b = map.get(key);
				if (b==null) {
					count++;
				}else {
					list.add(b);
					flag = false;
				}
			}
			i += count;
		}
//		listתΪ����
		byte[] b = new byte[list.size()];
		for (int i = 0; i < b.length; i++) {
			b[i] = list.get(i);
		}
		return b;
	}


	/**
	 * ��ȡ�������ַ����ĺ�8λ
	 * @param flag �ж��Ƿ�ȫλ�����ȡ
	 * @param b
	 * @return
	 */
	private static String byteToStr(boolean flag,byte b) {
		int tmp = b;
		if (flag) {
//			��λ��ȫ
			tmp |= 256;		
		}
		String str = Integer.toBinaryString(tmp);
		if (flag) {
			
			return str.substring(str.length()-8);
		}else {
			return str;
		}
	}
	
	/**
	 * �շ�������ѹ��
	 * @param byte s
	 * @return
	 */
	private static byte[] huffmanZip(byte[] bytes) {
//		ͳ��ÿ��byte���ֵĴ���������һ��������
		List<Node> nodes = getNodes(bytes);
//		System.out.println(nodes);
//		����һ���շ�����
		Node tree = createHuffmanTree(nodes);
//		����һ���շ��������
		Map<Byte , String> huffCodes = getHuffCodes(tree);
//		System.out.println(huffCodes);
//		����
		byte[] bs = zip(bytes,huffCodes);
		

		return bs;
	}

	
	/**
	 * �շ�������
	 * @param bytes
	 * @param huffCodes
	 * @return
	 */
	private static byte[] zip(byte[] bytes, Map<Byte, String> huffCodes) {
		StringBuilder sBuffer = new StringBuilder();
		for(byte b : bytes) {
			sBuffer.append(huffCodes.get(b));
		}
		
//		System.out.println(sBuffer.toString());
		
//		���峤��
		int len;
		if(sBuffer.length()%8 == 0 ) {
			len = sBuffer.length()/8;
		}else {
			len = sBuffer.length()/8+1;
		}
//		���ڴ洢ѹ�����byte
		byte[] by = new byte[len];
//		��¼�µ�byte��λ��
		int index= 0;
		for(int i =0;i<sBuffer.length();i+=8) {
			String strByte;
			if (i+8>sBuffer.length()) {
				strByte = sBuffer.substring(i);
			}else {
				strByte = sBuffer.substring(i,i+8);
			}
//			ת��Ϊ������int,��ǿתΪbyte
			byte b = (byte)Integer.parseInt(strByte,2);
			by[index] = b;
			index++;
		}
		return by;
	}

	/**
	 * ��ȡ�շ��������
	 * @param tree
	 * @return
	 */
//	�ݴ����
	static StringBuilder sBuffer = new StringBuilder();
//	�ݴ�����
	static Map<Byte, String> huffCodes = new HashMap<>();
	private static Map<Byte, String> getHuffCodes(Node tree) {
		if (tree == null) {
			return null;
		}
//		�����ӽڵ�ݹ�ִ��
		getCodes(tree.lNode,"0",sBuffer);
		getCodes(tree.rNode,"1",sBuffer);
//		���ر����
		return huffCodes;
	}


	/**
	 * �ݹ��ȡҶ�ӽڵ����
	 * @param node
	 * @param string
	 * @param sBuffer2
	 */
	private static void getCodes(Node node, String string, StringBuilder sBuffer2) {
//		�½�buffer�ݴ�
		StringBuilder sBuffer = new StringBuilder(sBuffer2);
		sBuffer.append(string);
//		��node��ΪҶ�ӽڵ�,�ݹ�
		if (node.data == null) {
			getCodes(node.lNode,"0",sBuffer);
			getCodes(node.rNode,"1",sBuffer);
		}else {
//			nodeΪҶ�ӽڵ�,��Ӧ�������ȫ��map
			huffCodes.put(node.data, sBuffer.toString());
		}
	}

	/**
	 * �����շ�����
	 * @param nodes
	 * @return
	 */
	private static Node createHuffmanTree(List<Node> nodes) {
//		System.out.println(nodes);
		while (nodes.size() > 1) {
//			����
			Collections.sort(nodes);
			Node lNode = nodes.get(0);
			Node rNode = nodes.get(1);
//			�����½ڵ�
			Node root = new Node(null,lNode.weight+rNode.weight);
			root.lNode = lNode;
			root.rNode = rNode;
//			�Ƴ���ˢ��λ���±�
			nodes.remove(0);
			nodes.remove(0);


//			�½ڵ��������
			nodes.add(root);
			
		}
		
//		System.out.println(nodes);
		return nodes.get(0  );
	}

	/**
	 * byte����תNode����
	 * @param bytes
	 * @return
	 */
	private static List<Node> getNodes(byte[] bytes) {
		
		List<Node> nodes = new ArrayList<>();
//		ͳ��ÿ��byte����,��map�洢0
		Map<Byte, Integer> counts  = new HashMap<>();
//		����byte
		for(byte b :bytes) {
			Integer count = counts.get(b);
			if (count == null) {
				counts.put(b, 1);
			}else {
				counts.put(b, count+1);
			}
			
		}
//		System.out.println(counts);
//		��mapתΪlist
		for(Map.Entry<Byte, Integer> entry : counts.entrySet()) {
			nodes.add(new Node(entry.getKey(), entry.getValue()));
		}
		return nodes;
	}
	
}
