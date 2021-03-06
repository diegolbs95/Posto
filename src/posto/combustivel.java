package posto;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;


import entidades.empregado;


public class combustivel {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		List<empregado> list= new ArrayList<>();
		
		System.out.println("Quantos funcionários serão registrados? ");
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			System.out.println();
			System.out.println("Funcionario # "+(i+1)+":");
			System.out.print("Id: ");
			 Integer id = sc.nextInt();
			 while (hasId(list, id)) {
				 System.out.println("Esse Id ja existe tente novamente: ");
				 id = sc.nextInt();	
				
			}
			 
			 
			System.out.print("Nome: ");
			 sc.nextLine();
			 String nome = sc.nextLine();
			System.out.print("Salario: ");
			  Double salario = sc.nextDouble();	
			  
			empregado emp = new empregado(id, nome, salario);
			
			list.add(emp);
		}
		
		System.out.print("Forneça a identificação do empregador que terá aumento de salário: ");
			int idSalario = sc.nextInt();
		  
			empregado emp = list.stream().filter(x -> x.getId() == idSalario).findFirst().orElse(null);
		    
			if ( emp == null ) {
				System.out.println("Esse id nao existe! ");	
				}
			else {
				System.out.print("Qual porcentagem: ");
				double porcentagem = sc.nextDouble();
				emp.aumentoSalario(porcentagem);
			}
		System.out.println("Lista de funcionario: ");
		for(empregado e : list) {
			System.out.println(e);
		}
		
		
		
		sc.close();		
		}
	public static boolean hasId(List<empregado>list,int id) {
		empregado emp = list.stream().filter(x -> x.getId()== id ).findFirst().orElse(null);
		return emp != null;
	}
	
		}
		
		
		
		
		
		
		
	


