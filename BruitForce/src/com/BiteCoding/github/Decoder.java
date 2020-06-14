package com.BiteCoding.github;

public class Decoder {

    private char[] possibleChars;

    public Decoder() {
        possibleChars = new char[]{ 'a','b','c','d','e','f','g','h','i','j','k','l',
                'm','n','o','p','q','r','s','t','u','v','w', 'x',
                'y','z' };
    }

    public String decode(int n){
        return Character.toString(possibleChars[n]);
    }

}
