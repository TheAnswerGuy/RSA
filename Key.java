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
public class Key{
    private final BigInteger value,n;
    public Key(BigInteger value,BigInteger n){
        this.value = value;
        this.n = n;
    }
    public BigInteger getValue(){
        return value;
    }
    public BigInteger getMod(){
        return n;
    }
    public boolean isSetup(){
        return value != null && n != null;
    }
}
