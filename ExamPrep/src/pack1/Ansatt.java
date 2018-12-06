/**
 * 
 */
package pack1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 */

public class Ansatt {
private String fornavn;
private String etternavn;
private String gender;
private String stilling;
private double aarslonn;
private Function<Double, Double> f;

public static void main(String[] args) {
	
	List<Ansatt> list = Arrays.asList(
			new Ansatt( "navn1",  "etternavn1",  "m", "", 12),
			new Ansatt( "navn2",  "etternavn2",  "m", "sjef", 123),
			new Ansatt( "navn3",  "etternavn3",  "k", "", 1234),
			new Ansatt( "navn4",  "etternavn4",  "k", "sjef", 12345),
			new Ansatt( "navn5",  "etternavn5",  "u", "", 123456)
			);

	
}
public Ansatt(String fornavn, String etternavn, String gender, String stilling, double aarslonn) {
	this.fornavn = fornavn;
	this.etternavn = etternavn;
	this.gender = gender;
	this.stilling = stilling;
	this.aarslonn = aarslonn;
	f = funksjon(23);
}

@Override
public String toString() {
	return "Ansatt [fornavn=" + fornavn + ", etternavn=" + etternavn + ", gender=" + gender + ", stilling=" + stilling
			+ ", aarslonn=" + aarslonn + "]";
}

public Ansatt() {
	this.fornavn = null;
	this.etternavn = null;
	this.gender = null;
	this.stilling = null;
	this.aarslonn = 0;
}

public static Function<Double, Double> funksjon(int inc){ 
	return (x -> x*inc);
}
public double endreLonn(Function<Double,Double> f) {
	setAarslonn(f.apply(aarslonn));

	return getAarslonn();
}

public String getFornavn() {
	return fornavn;
}

public void setFornavn(String fornavn) {
	this.fornavn = fornavn;
}

public String getEtternavn() {
	return etternavn;
}

public void setEtternavn(String etternavn) {
	this.etternavn = etternavn;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public String getStilling() {
	return stilling;
}

public void setStilling(String stilling) {
	this.stilling = stilling;
}

public double getAarslonn() {
	return aarslonn;
}

public void setAarslonn(double aarslonn) {
	this.aarslonn = aarslonn;
}

}
