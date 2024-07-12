package cursojava.executavel;

public class Matriz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int notas[][] = new int[2][3];
		notas[0][0]=80;
		notas[0][1]=90;
		notas[0][2]=70;
		notas[1][0]=83;
		notas[1][1]=87;
		notas[1][2]=74;
		System.out.println(notas);
		for (int linha = 0; linha < notas.length; linha ++) {
			for (int coluna = 0; coluna < notas[linha].length; coluna++) {
				System.out.println(notas[linha][coluna]);
			}
		}
	}

}
