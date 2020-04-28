package com.chawla.tyre.utility;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Utility {

	/**
	 * Generate MD5 for the input data
	 *
	 * @param data Data to be masked
	 * @return String MD5 value for input data
	 */
	public String generateMD5(String data) {
		MessageDigest md;
		StringBuilder sb = new StringBuilder();
		try {
			md = MessageDigest.getInstance("MD5");
			byte[] hashInBytes = md.digest(data.getBytes(StandardCharsets.UTF_8));
			for (byte b : hashInBytes) {
				sb.append(String.format("%02x", b));
			}
		} catch (NoSuchAlgorithmException e) {
			log.error("Utility - NoSuchAlgorithmException in createMd5Hash() - {} - {}", e.getClass(), e.getMessage());
		}
		return sb.toString();
	}
}
