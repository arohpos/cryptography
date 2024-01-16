package cryptography.test.caesar;


import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

import cryptography.main.caesar.Caesar;

/**
 * 
 * @author arohpos
 *
 */
//@RunWith(JUnit4.class)
public class CaesarTest{
	
//	@RunWith(Theory.class)
//	public static class check{
		
		/*
		@DataPoints
		public static Ch[] chTest = {
			new ch('a', 'b');
			new ch('a', 'b');
		}
		*/	
	
		//与えられた小文字のアルファベットに対し、右隣のアルファベットを出力することができること
		@Test
		public void testShiftOnce() {
			Caesar caesar = new Caesar();
			assertThat('b', is(caesar.shift_once('a')));	
		}
	//}

	//与えられた小文字のアルファベットに対して、決まった数右隣のアルファベットを出力することができること
	@Test
	public void testShiftTimes() {
		Caesar caesar = new Caesar();
		assertThat('c', is(caesar.shift_times('a', 2)));
	}
	
	//与えられた平文に対して、暗号化鍵に従って、暗号文を出力できること
	@Test
	public void testEnc() {
		Caesar caesar = new Caesar();
		assertThat("ifmmp xpsme", is(caesar.enc("hello world", 1)));	
	}
	
	//暗号化鍵に対して、適切に復号化鍵を出力できること
	@Test
	public void testGenKey() {
		Caesar caesar = new Caesar();
		assertThat(-1, is(caesar.gen_key(1)));
	}
	
	
	//暗号文に対して、復号化鍵に従って、平文を出力できること。
	@Test
	public void testDec() {
		Caesar caesar = new Caesar();
		assertThat("hello world", is(caesar.enc("ifmmp xpsme", -1)));	
	}
	
	/*
	static class Ch{
		char ch;
		char expected;
		
		public Ch(char ch, char expected) {
			this.ch = ch;
			this.expected = expected;
		}
		
	}
	*/
	
}