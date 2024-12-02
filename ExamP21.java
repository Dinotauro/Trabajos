

public class ExamP21 {
 public static void main(String[]args) {
int h = 1;
int suma = 0;
int j = 0;
for(int i = 0;i < 3;i++)
	{
	h = h + 1;
	suma = h + suma;
		
	for(j = 0;j < 9;j++)
		{
		suma = h + suma;
		h = h + 1;
	}
}
System.out.print(suma);
 }
}
