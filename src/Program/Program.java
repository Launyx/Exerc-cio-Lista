package Program;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import javax.swing.text.Position;

import Entities.Employee;

public class Program {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        Scanner tec = new Scanner(System.in);

        System.out.printf("Enter the number of employees: ");
        int numEmployee = Integer.parseInt(tec.nextLine());
        List<Employee> lista = new ArrayList<>();

        for (int i=1; i <= numEmployee; i++){
            System.out.printf("\nEmployee: #" + i);
            
            System.out.printf("\nID: ");
            int id = Integer.parseInt(tec.nextLine());

            while(hasId(lista, id)){
                System.out.println("Id already taken! try again: ");
                id = Integer.parseInt(tec.nextLine());
            }
            
            System.out.printf("Name: ");
            String name = tec.nextLine();

            System.out.printf("Salary: ");
            Double salary = Double.parseDouble(tec.nextLine());

            Employee emp = new Employee(id, name, salary);

            lista.add(emp);
        }

        System.out.printf("\nEnter the employee id that will have salary increase: ");
        int idAum = Integer.parseInt(tec.nextLine());

        // .stream() transforma lista em um stream, que é um tipo especial do java que aceita funções de alta ordem (lambda)
        //  .filter() filtra a lista a só elementos que atenderem a um predicado
        // predicado: só quero os elementos x "tal que"(->) x.getid() seja igual ao idAum e "findfirst()" pegue o primeiro
        // No caso emp está recebendo um objeto completo, como se fosse uma instanciação do employee que corresponde ao id fornecido
        Employee emp = lista.stream().filter(x -> x.getId() == idAum).findFirst().orElse(null);

        //Integer pos = position(lista, idAum);
        if (emp == null){
            System.out.println("This id does not exist!");
        }else{
            System.out.printf("Enter the percentage: ");
            Double percAum = Double.parseDouble(tec.nextLine());

            emp.increaseSalary(percAum); // get() acessa uma posição da arraylist assim como [x] para vetores
        }

        

        System.out.println("\nList of employees: ");

        
        // Para cada employee emp na list lista, simprimir emp, que já tem tostring na própria classe
        for (Employee x: lista){
            System.out.println(x);
        }

        tec.close();
    }

    public static Integer position(List<Employee> list, int id){
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getId() == id ){    // get() pega o elemento do indice e o .getid() pega o id do elemento que o get() pegou
                return i;
            }
        }
        return null;
    }

    public static boolean hasId(List<Employee> list, int id){
        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        // Condição que verifica se emp é diferente de nulo
        return emp != null;
    }
}