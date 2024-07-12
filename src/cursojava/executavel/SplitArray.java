package cursojava.executavel;

import java.util.Arrays;
import java.util.List;

public class SplitArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String texto = "Carlos,Curso Java,80,70,90,89";
		

		String[] valoresArray = texto.split(",");
	
		/* Converte array para lista: */
		List<String> list = Arrays.asList(valoresArray);
		for (int i = 0; i < valoresArray.length; i++) {
			System.out.println(i+" "+valoresArray[i]);
		}
		System.out.println("=============================================");
		System.out.println(list);
		System.out.println("=============================================");
		for (String valorString : list) {
			System.out.println(valorString);
		}
		System.out.println("=============================================");
		/* Converte lista para array: */
		String[] conversaoArray = list.toArray(new String[6]);
		for (String elementos : conversaoArray) {
			System.out.println(elementos);
		}
	}

}
