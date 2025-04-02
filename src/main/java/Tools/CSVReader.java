package Tools;

import Domain.Attraction;
import Domain.Cost;
import Domain.Sale;
import Domain.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVReader {
    public static ArrayList<User> readUserFileToArray(String filePath) throws FileNotFoundException {

        // Intanciar o Array de Users vazio
        ArrayList<User> usersArrayRead = new ArrayList<User>();

        // Instanciar Scanner para ler o ficheiro (caminho passado por parâmetro)
        Scanner sc = new Scanner(new File(filePath));

        // Ciclo que vai iterar para cada linha do ficheiro
        while (sc.hasNextLine()) {

            // Guardamos toda a linha na variável: linha
            String line = sc.nextLine();

            // Criamos um Array de Strings, onde cada posição terá uma coluna da lunha
            String[] splitedLine = line.split(",");

            //Criar objeto User
            User newUser = new User(splitedLine[0], splitedLine[1], splitedLine[2]);

            // Adicionar novo User ao Array
            usersArrayRead.add(newUser);
        }

        return usersArrayRead;
    }

    public static ArrayList<Sale> readSalesFileToArray(String filePath) throws FileNotFoundException {

        // Intanciar o Array de Sales vazio
        ArrayList<Sale> salesArrayRead = new ArrayList<Sale>();

        // Instanciar Scanner para ler o ficheiro (caminho passado por parâmetro)
        Scanner sc = new Scanner(new File(filePath));

        // Ignorar a primeira linha
        sc.nextLine();

        // Ciclo que vai iterar para cada linha do ficheiro
        while (sc.hasNextLine()) {

            // Guardamos toda a linha na variável: linha
            String line = sc.nextLine();

            // Criamos um Array de Strings, onde cada posição terá uma coluna da lunha
            String[] splitedLine = line.split(";");

            //Criar objeto Sale
            Sale newSale = new Sale(Integer.parseInt(splitedLine[0]), splitedLine[1], splitedLine[2]);

            // Adicionar nova Sale ao Array
            salesArrayRead.add(newSale);
        }

        return salesArrayRead;
    }

    public static ArrayList<Cost> readCostsFileToArray(String filePath) throws FileNotFoundException {

        // Intanciar o Array de Costs vazio
        ArrayList<Cost> costsArrayRead = new ArrayList<Cost>();

        // Instanciar Scanner para ler o ficheiro (caminho passado por parâmetro)
        Scanner sc = new Scanner(new File(filePath));

        // Ignorar a primeira linha
        sc.nextLine();

        // Ciclo que vai iterar para cada linha do ficheiro
        while (sc.hasNextLine()) {

            // Guardamos toda a linha na variável: linha
            String line = sc.nextLine();

            // Criamos um Array de Strings, onde cada posição terá uma coluna da lunha
            String[] splitedLine = line.split(";");

            //Criar objeto Cost
            Cost newCost = new Cost(Integer.parseInt(splitedLine[0]), Double.parseDouble(splitedLine[1]), Integer.parseInt(splitedLine[2]));

            // Adicionar novo Cost ao Array
            costsArrayRead.add(newCost);
        }

        return costsArrayRead;
    }

    public static ArrayList<Attraction> readAttractionsFileToArray(String filePath) throws FileNotFoundException {

        // Intanciar o Array de Attractions vazio
        ArrayList<Attraction> attractionsArrayRead = new ArrayList<Attraction>();

        // Instanciar Scanner para ler o ficheiro (caminho passado por parâmetro)
        Scanner sc = new Scanner(new File(filePath));

        // Ignorar a primeira linha
        sc.nextLine();

        // Ciclo que vai iterar para cada linha do ficheiro
        while (sc.hasNextLine()) {

            // Guardamos toda a linha na variável: linha
            String line = sc.nextLine();

            // Criamos um Array de Strings, onde cada posição terá uma coluna da lunha
            String[] splitedLine = line.split(";");

            //Criar objeto Attraction
            Attraction newAttraction = new Attraction(Integer.parseInt(splitedLine[0]), (splitedLine[1]), Double.parseDouble(splitedLine[2]), Double.parseDouble(splitedLine[3]), Integer.parseInt(splitedLine[4]));

            // Adicionar nova Attraction ao Array
            attractionsArrayRead.add(newAttraction);
        }

        return attractionsArrayRead;
    }
}
