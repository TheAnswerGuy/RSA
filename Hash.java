/*
 * Copyright (C) 2016 TheAnswerGuy
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package rsa;
import java.security.MessageDigest;
import java.util.Random;
public final class Hash {
    private final int c;
    public Hash(String text){
        int[] carray = t2b(text);
        int res = 0;
    	for(int i = 0;i < carray.length;i++)
            res += Integer.parseInt(String.valueOf(carray[i]),16);
    	c = String.valueOf(res*128).hashCode();
    }
    public int getCypher(){
    	return c;
    }
    public static String sha256(String text){
        StringBuffer hexString;
    	try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
    	    md.update(text.getBytes());
    	    byte byteData[] = md.digest();
    	    StringBuilder sb = new StringBuilder();
    	    for (int i = 0; i < byteData.length; i++)
    	      	sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
    	    hexString = new StringBuffer();
    	    for (int i=0;i<byteData.length;i++) {
    	       	String hex=Integer.toHexString(0xff & byteData[i]);
    	       	if(hex.length()==1) hexString.append('0');
    	       	hexString.append(hex);
    	    }
            return hexString.toString();
    	}
    	catch(Exception e){
            System.out.println(e.getMessage());
            return "";
        }
    }
    public static int random(int min,int max){
    	Random r = new Random();
    	if(min >= 0 && max > min){
            int tmp = r.nextInt((max - min) + 1) + min;
            return tmp;
    	}
    	else
            return -1;
    }
    private int[] t2b(String text){
    	int len = text.length();
    	int[] b = new int[len];
    	for(int i = 0;i < len;i++){
            int curr = (int)text.charAt(i);
            curr = (curr-curr/2)%255;
            String binary = Integer.toBinaryString(Integer.reverse(curr));
            int blength = binary.length();
            if(blength != 8){
        		if(blength < 8)
                    binary = binary.concat(binary).substring(0, 7);
        		else if(blength > 8)
                    binary = binary.substring(0, 7);
            }
            b[i] = Integer.parseInt(binary,2);
	    }
	    return b;
    }
}
