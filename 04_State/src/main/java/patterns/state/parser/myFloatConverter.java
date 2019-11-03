package patterns.state.parser;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class myFloatConverter{

	public static void main(String[] args) throws Exception {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		String s = r.readLine();
		while (s != null && s.length() > 0) {
			try {
				double d = parseFloat(s);
				System.out.println(d);
			} catch (IllegalArgumentException e) {
				System.out.println("Illegal Format");
			}
			s = r.readLine();
		}
	}

	private static boolean isDigit(char ch) {
		return Character.isDigit(ch);
	}

	private static int getNumericValue(char ch) {
		return Character.getNumericValue(ch);
	}



	private static double parseFloat(String str) {


		State s = State.S0;
		double m = 0, quo = 10;
		int exp = 0, exp_sign = 1;
		int pos = 0;
		while (s != State.ERROR && pos < str.length()) {
			char ch = str.charAt(pos++);
			switch (s) {
			case S0:
				if(isDigit(ch)) { m = getNumericValue(ch); s = State.S1; }
				else if(ch == '.') { s = State.S2; }
				else s = State.ERROR;
				break;
			case S1:
				if(isDigit(ch)) { m = 10 * m + getNumericValue(ch); }
				else if(ch == '.') { s = State.S3; }
				else if(ch == 'e') { s = State.S4; }
				else if(ch == 'E') { s = State.S4; }
				else s = State.ERROR;
				break;
			case S2:
				if(isDigit(ch)) { m = m + getNumericValue(ch)/quo; quo = quo*10; s = State.S3; }
				else s = State.ERROR;
				break;
			case S3:
				if(isDigit(ch)) { m = m + getNumericValue(ch)/quo; quo = quo*10; }
				else if(ch == 'e') { s = State.S4; }
				else if(ch == 'E') { s = State.S4; }
				else s = State.ERROR;
				break;
			case S4:
				if(ch == '+') s = State.S5;
				else if(ch == '-') { exp_sign = -1; s = State.S5; }
				else if(isDigit(ch)) { exp = getNumericValue(ch); s = State.S6; }
				else s = State.ERROR;
				break;
			case S5:
				if(isDigit(ch)) { exp = getNumericValue(ch); s = State.S6; }
				else s = State.ERROR;
				break;
			case S6:
				if(isDigit(ch)) { exp = 10*exp + getNumericValue(ch); }
				else s = State.ERROR;
				break;
			default:
				throw new IllegalStateException();
			}
		}

		if (s == State.S3 || s == State.S6) {
			return m * Math.pow(10, exp_sign * exp);
		} else {
			throw new IllegalArgumentException();
		}
	}



	private enum State {
		S0, S1, S2, S3, S4, S5, S6, ERROR
	}
}


abstract class Utilies{

	double m = 0, quo = 10;
	int exp = 0, exp_sign = 1;
	int pos = 0;

	static boolean isDigit(char ch) {
		return Character.isDigit(ch);
	}

	static int getNumericValue(char ch) {
		return Character.getNumericValue(ch);
	}

}



interface State{
	public void operate();
}

class S0 implements State{
	private final Context context;
	private char ch;

	private State nextState;
	public S0(Context context, String str) {
		this.context = context;
		this.ch = str.charAt(pos++);
	}

	public void operate() {
		System.out.println("ConcreteState1");
		if(isDigit(ch)) { m = getNumericValue(ch); nextState = context.getS1(); }
		else if(ch == '.') { nextState = context.getS1(); }
		else nextState = context.getS1();

		context.setState(nextState);
	}
}
class S2 extends Utilies  implements State{
	private final Context context;

	public S2(Context context, String str) {
		this.context = context;
	}

	public void operate() {
		System.out.println("ConcreteState2");
		context.setState(context.getS2());
	}
}

// Context der State-Handler
class Context{
	private State currentState;

	private String currentStr;

	//Setter zum Setzen des aktuellen Zustands
	public void setState(State state){
		currentState = state;
	}
	public void setStr(String str){
		currentStr = str;
	}

	//Context hält alle möglichen Zustände vor
	private State S0;
	private State S1;
	private State S2;

	//Getter für die möglichen Zustände
	public State getS0() {
		return S0;
	}
	public State getS1() {
		return S1;
	}
	public State getS2() {
		return S2;
	}

	//Initialisierung in Konstruktor
	public Context(){
		S0 = new S0(this, currentStr);
		S1 = new S2(this, currentStr);
		currentState = S0;
	}
}
