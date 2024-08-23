package maven.demo;
import java.util.*;

public class Principal
{

	public static void main (String [] args)
	{
		champDAO dao = new champDAO();
		Scanner scan = new Scanner (System.in);
		//Champ champ = new Champ ();
		
		dao.conectar();
		
//		Champ champ = new Champ(99, "kaisa", "adcarry", "6,300");
//		if(dao.inserirChamp(champ) == true)
//		{
//			System.out.println("Insercao com sucesso -> " + champ.toString());
//		}
		
		int x = 0;
		
		while (x != 5)
		{
			System.out.println("Menu:");
			System.out.println("1 - Inserir");
			System.out.println("2 - Listar");
			System.out.println("3 - Atualizar");
			System.out.println("4 - Excluir");
			System.out.println("5 - sair");
			System.out.println("Selecione uma opcao: ");
			x = scan.nextInt();
			scan.nextLine();
			
			switch(x)
			{
				case 1:
					System.out.println("id: ");
					int id = scan.nextInt();
					scan.nextLine();
					System.out.println("name: ");
					String name = scan.nextLine();
					System.out.println("classe: ");
					String classe = scan.nextLine();
					System.out.println("price: ");
					String price = scan.nextLine();
					Champ champ = new Champ(id, name, classe, price);
					if(dao.inserirChamp(champ))
					{
						System.out.println("Insercao com sucesso -> " + champ.toString());
					}
					break;
				
				case 2:
					System.out.println("Personagens listados: ");
					List<Champ> champs = dao.get("");
					for(Champ champ1 : champs)
					{
						System.out.println(champ1);
					}
					break;
					
				case 3:
				    System.out.print("Informe o ID do champ que deseja atualizar: ");
				    int idAtualizar = scan.nextInt();
				    scan.nextLine();
				    
				    System.out.print("Novo nome: ");
				    String novoName = scan.nextLine();
				    
				    System.out.print("Nova classe: ");
				    String novaClasse = scan.nextLine();
				    
				    System.out.print("Novo preço: ");
				    String novoPrice = scan.nextLine();
				    
				    Champ champAtualizado = new Champ(idAtualizar, novoName, novaClasse, novoPrice);
				    if (dao.updateChamp(champAtualizado))
				    {
				        System.out.println("Atualização realizada com sucesso!");
				    }
				    else 
				    {
				        System.out.println("Erro na atualização.");
				    }
					break;
					
				case 4:
					System.out.println("Digite o id para exluir:");
					int Id = scan.nextInt();
					dao.excluirChamp(Id);
					break;
					
				case 5:
					dao.close();
					break;
					
				default:
					System.out.println("Opcao invalida.");
					break;
			}
		}
		
	}
}
