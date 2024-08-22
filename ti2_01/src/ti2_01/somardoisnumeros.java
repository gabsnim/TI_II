/**
 * Atividade 01 TI2_backend - Somar dois numeros 
 * Gabriel Xavier Borges - 805347
 */

package ti2_01;
import java.util.*;

class somardoisnumeros
{
	public static void main (String [] args)
	{
		Scanner scan = new Scanner (System.in);
		
		System.out.println("Digite o primeiro numero:");
		int x = scan.nextInt();
		
		System.out.println("Digite o segundo numero:");
		int y = scan.nextInt();
		
		System.out.println("soma = " + (x+y));
	}
}
