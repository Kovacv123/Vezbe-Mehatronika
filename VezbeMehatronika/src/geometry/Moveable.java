package geometry;

public interface Moveable {

	
	//Svi atributi su konstante sa podrazumevanim public static final kljucnim recima
	//int BROJ = 55;
	
	
	//Sve metode u interfejsu su apstraktne i uvek su public, stoga te dve kljucne reci ne moraju biti navedene
	void moveTo(int x, int y);
	void moveBy(int byX, int byY);
}
