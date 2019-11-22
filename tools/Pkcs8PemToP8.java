package com.wjj.application.utils.umfsdk.tools;

import org.bouncycastle.util.encoders.Base64;
 import javax.crypto.EncryptedPrivateKeyInfo;
 import javax.crypto.SecretKeyFactory;
 import javax.crypto.spec.PBEKeySpec;
 import java.io.IOException;
 import java.nio.file.Files;
 import java.nio.file.Paths;
 import java.security.InvalidKeyException;
 import java.security.KeyFactory;
 import java.security.NoSuchAlgorithmException;
 import java.security.PrivateKey;
 import java.security.spec.InvalidKeySpecException;
 import java.security.spec.PKCS8EncodedKeySpec;

/**
 * 联动密钥转换工具
 * @author hank
 */
public class Pkcs8PemToP8 {

   public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException {

     String encrypted = new String(Files.readAllBytes(Paths.get("G:\\rsa_private_key_pkcs8.pem")));
     String unencrypted = new String(Files.readAllBytes(Paths.get("G:\\rsa_private_key_pkcs8.pem")));

     //Create object from unencrypted private key
     unencrypted = unencrypted.replace("-----BEGIN PRIVATE KEY-----", "");
     unencrypted = unencrypted.replace("-----END PRIVATE KEY-----", "");
     byte[] encoded = Base64.decode(unencrypted);
     Files.write(Paths.get("G:\\rsa_private_key_pkcs8.p8"), encoded);
     PKCS8EncodedKeySpec kspec = new PKCS8EncodedKeySpec(encoded);
     KeyFactory kf = KeyFactory.getInstance("RSA");
     PrivateKey unencryptedPrivateKey = kf.generatePrivate(kspec);

     //Create object from encrypted private key
//     encrypted = encrypted.replace("-----BEGIN ENCRYPTED PRIVATE KEY-----", "");
//     encrypted = encrypted.replace("-----END ENCRYPTED PRIVATE KEY-----", "");
//     EncryptedPrivateKeyInfo pkInfo = new EncryptedPrivateKeyInfo(Base64.decode(encrypted));
//     PBEKeySpec keySpec = new PBEKeySpec("abcde".toCharArray()); // password
//     SecretKeyFactory pbeKeyFactory = SecretKeyFactory.getInstance(pkInfo.getAlgName());
//     PKCS8EncodedKeySpec encodedKeySpec = pkInfo.getKeySpec(pbeKeyFactory.generateSecret(keySpec));
//     KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//     PrivateKey encryptedPrivateKey = keyFactory.generatePrivate(encodedKeySpec);

     //comparing both private key for equality
     System.out.println(unencryptedPrivateKey);
   }
 }