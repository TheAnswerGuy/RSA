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
import java.math.BigInteger;
import java.security.SecureRandom;
public abstract class RSA {
    private BigInteger n, d, e;
    public synchronized void generateKeys(int bufferSize) {
        SecureRandom r = new SecureRandom();
        BigInteger p = new BigInteger(bufferSize / 2, 100, r);
        BigInteger q = new BigInteger(bufferSize / 2, 100, r);
        n = p.multiply(q);
        BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        e = generateE(r,phi,bufferSize);
        d = e.modInverse(phi);
    }
    private BigInteger generateE(SecureRandom r,BigInteger phi,int bufferSize){
        do
            e = new BigInteger(2 * bufferSize, r);
        while((e.compareTo(phi) != 1) || (e.gcd(phi).compareTo(BigInteger.valueOf(1)) != 0));
        return e;
    }
    public synchronized BigInteger getN(){
        return n;
    }
    public synchronized BigInteger getE(){
        return e;
    }
    public synchronized BigInteger getD(){
        return d;
    }
}
