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
 * 赫夫曼编码压缩/解压文件
 * @author P1314023
 *
 */
public class HuffmanCodeTest {

	public static void main(String[] args) throws UnsupportedEncodingException {
//		String msg = "can ca ca ca cannn a caner cancel";
//		byte[] bytes = msg.getBytes();
		
//		System.out.println(bytes.toString());
//		调用赫夫曼编码 
//		byte[] bs = huffmanZip(bytes);
//		压缩后长度
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
	 * 解压文件
	 * @param src
	 * @param dst
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static void unZipFile(String src,String dst) throws IOException, ClassNotFoundException {
		
//		创建输入流
		InputStream is = new FileInputStream(src);
		ObjectInputStream ois = new ObjectInputStream(is);
//		读取byte数组
		byte[] bs = (byte[])ois.readObject();
		
//		读取赫夫曼编码表
		Map<Byte, String> codes = (Map<Byte, String>) ois.readObject();
		ois.close();
		is.close();
//		解码
		byte[] bytes = huffmanDecode(codes, bs);
//		创建输出流
		OutputStream os = new FileOutputStream(dst);
//		写入数据
		os.write(bytes);
		os.close();
		
	}
	
	/**
	 * 文件压缩
	 * @param src
	 * @param dst
	 * @throws IOException
	 */
	public static void zipFile(String src,String dst) throws IOException {
//		创建输入流
		InputStream is = new FileInputStream(src);
//		创建一个与输入流指向文件大小一样的byte数组
		byte[] bs = new byte[is.available()];
//		读取文件内容
		is.read(bs);
		is.close();
//		使用赫夫曼编码进行编码
		byte[] byteZip = huffmanZip(bs);
//		输出流
		OutputStream os = new FileOutputStream(dst);
		ObjectOutputStream oos = new ObjectOutputStream(os);
//		将压缩后的byte数组存入文件
		oos.writeObject(byteZip);
//		将赫夫曼编码表存入数组
		oos.writeObject(huffCodes);
		oos.close();
		os.close();
	}


	/**
	 * 赫夫曼解码 
	 * @param huffCodes
	 * @param bs
	 * @return
	 */
	private static byte[] huffmanDecode(Map<Byte, String> huffCodes, byte[] bs) {
//		将byte数组转为二进制字符串
		StringBuilder sBuffer = new StringBuilder();
		for(int i=0;i<bs.length;i++) {
//			String s = Integer.toBinaryString(b); //取出来的都是32为长度的int,正数高位的0自动省略
//			System.out.println(s);
			byte b = bs[i];
//			判断最后 一个,不要补全8位
			boolean flag = (i==bs.length-1);
			sBuffer.append(byteToStr(!flag,b));
		}
//		System.out.println(sBuffer.toString());
//		将字符串通过指定赫夫曼编码表进行解码
//		将赫夫曼编码表的键值呼唤,通过二进制编码找字符
		Map<String, Byte> map = new HashMap<>();
		for(Map.Entry<Byte, String> entry : huffCodes.entrySet()) {
			map.put(entry.getValue(),	entry.getKey());
		}
		
//		将解码的值Byte暂存到该list
		List<Byte> list = new ArrayList<>();
		
//		处理字符串
		for(int i = 0;i<sBuffer.length();) {
			int  count = 1;
			boolean flag = true;
//				取出key
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
//		list转为数组
		byte[] b = new byte[list.size()];
		for (int i = 0; i < b.length; i++) {
			b[i] = list.get(i);
		}
		return b;
	}


	/**
	 * 获取二进制字符串的后8位
	 * @param flag 判断是否补全位数与截取
	 * @param b
	 * @return
	 */
	private static String byteToStr(boolean flag,byte b) {
		int tmp = b;
		if (flag) {
//			按位补全
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
	 * 赫夫曼编码压缩
	 * @param byte s
	 * @return
	 */
	private static byte[] huffmanZip(byte[] bytes) {
//		统计每个byte出现的次数并放入一个集合中
		List<Node> nodes = getNodes(bytes);
//		System.out.println(nodes);
//		创建一个赫夫曼树
		Node tree = createHuffmanTree(nodes);
//		创建一个赫夫曼编码表
		Map<Byte , String> huffCodes = getHuffCodes(tree);
//		System.out.println(huffCodes);
//		编码
		byte[] bs = zip(bytes,huffCodes);
		

		return bs;
	}

	
	/**
	 * 赫夫曼编码
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
		
//		定义长度
		int len;
		if(sBuffer.length()%8 == 0 ) {
			len = sBuffer.length()/8;
		}else {
			len = sBuffer.length()/8+1;
		}
//		用于存储压缩后的byte
		byte[] by = new byte[len];
//		记录新的byte的位置
		int index= 0;
		for(int i =0;i<sBuffer.length();i+=8) {
			String strByte;
			if (i+8>sBuffer.length()) {
				strByte = sBuffer.substring(i);
			}else {
				strByte = sBuffer.substring(i,i+8);
			}
//			转换为二进制int,再强转为byte
			byte b = (byte)Integer.parseInt(strByte,2);
			by[index] = b;
			index++;
		}
		return by;
	}

	/**
	 * 获取赫夫曼编码表
	 * @param tree
	 * @return
	 */
//	暂存编码
	static StringBuilder sBuffer = new StringBuilder();
//	暂存编码表
	static Map<Byte, String> huffCodes = new HashMap<>();
	private static Map<Byte, String> getHuffCodes(Node tree) {
		if (tree == null) {
			return null;
		}
//		左右子节点递归执行
		getCodes(tree.lNode,"0",sBuffer);
		getCodes(tree.rNode,"1",sBuffer);
//		返回编码表
		return huffCodes;
	}


	/**
	 * 递归获取叶子节点编码
	 * @param node
	 * @param string
	 * @param sBuffer2
	 */
	private static void getCodes(Node node, String string, StringBuilder sBuffer2) {
//		新建buffer暂存
		StringBuilder sBuffer = new StringBuilder(sBuffer2);
		sBuffer.append(string);
//		当node不为叶子节点,递归
		if (node.data == null) {
			getCodes(node.lNode,"0",sBuffer);
			getCodes(node.rNode,"1",sBuffer);
		}else {
//			node为叶子节点,对应编码插入全局map
			huffCodes.put(node.data, sBuffer.toString());
		}
	}

	/**
	 * 创建赫夫曼树
	 * @param nodes
	 * @return
	 */
	private static Node createHuffmanTree(List<Node> nodes) {
//		System.out.println(nodes);
		while (nodes.size() > 1) {
//			排序
			Collections.sort(nodes);
			Node lNode = nodes.get(0);
			Node rNode = nodes.get(1);
//			设置新节点
			Node root = new Node(null,lNode.weight+rNode.weight);
			root.lNode = lNode;
			root.rNode = rNode;
//			移除后刷新位置下标
			nodes.remove(0);
			nodes.remove(0);


//			新节点加入排序
			nodes.add(root);
			
		}
		
//		System.out.println(nodes);
		return nodes.get(0  );
	}

	/**
	 * byte数组转Node集合
	 * @param bytes
	 * @return
	 */
	private static List<Node> getNodes(byte[] bytes) {
		
		List<Node> nodes = new ArrayList<>();
//		统计每个byte次数,以map存储0
		Map<Byte, Integer> counts  = new HashMap<>();
//		遍历byte
		for(byte b :bytes) {
			Integer count = counts.get(b);
			if (count == null) {
				counts.put(b, 1);
			}else {
				counts.put(b, count+1);
			}
			
		}
//		System.out.println(counts);
//		将map转为list
		for(Map.Entry<Byte, Integer> entry : counts.entrySet()) {
			nodes.add(new Node(entry.getKey(), entry.getValue()));
		}
		return nodes;
	}
	
}
