package com.company;

import java.nio.charset.Charset;

import static com.company.StringHelper.computeSha1OfString;
import static com.company.StringHelper.hexToBytes;
import static com.company.StringHelper.*;

public class Main {
    static final int blocksize = 64;
    static final char char0 = 0x00;
    static final char char36 = 0x36;
    static final char char5c = 0x5c;


//    For Testing
    static final String key = "673415867352186aef73652afa";
    static String data = "7a@b.com3abc3abc1012345678904123440EC8885DD06ECBDD7106F2E0714A93ADCADAFE6521007213447721420160922105636";

    public static void main(String[] args) {

    }

    public static String getHmac(String data){
        byte[] key_pack = hexToBytes(key);
        key_pack = strRepeat(key_pack, char0,blocksize);
        byte[] ipad = strRepeat(convertStringToByte(""), char36,blocksize);
        byte[] opad = strRepeat(convertStringToByte(""), char5c,blocksize);
        ipad = XOR(key_pack,ipad);
        opad = XOR(key_pack,opad);
        return (computeSha1OfString(convertBytesToString(concatenateBytes(opad,hexToBytes(computeSha1OfString(convertBytesToString(ipad)+data))))).toUpperCase());
    }
}
